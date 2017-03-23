package listeAdjacence;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class Graphe {

	/**
	 * Map contenant les noeuds, stockés par identifiant.
	 */
	private HashMap<Integer, Noeud> noeuds;

	public Graphe() {
		noeuds = new HashMap<Integer, Noeud>();
	}

	/**
	 * Importe un graphe depuis un ficher CSV.
	 * 
	 * @param filepath
	 *            : Le chemin du fichier à importer
	 */
	public Graphe(String filepath) {
		noeuds = new HashMap<Integer, Noeud>();
		Reader in;
		Iterable<CSVRecord> records;
		try {
			in = new FileReader(filepath);
			records = CSVFormat.RFC4180.parse(in);
			for (CSVRecord record : records)
			{
				System.out.println(Integer.valueOf(record.get(0))+" --"+Double.valueOf(record.get(2))+
				"--> "+Integer.valueOf(record.get(1)));
				ajouterArc(new Noeud(Integer.valueOf(record.get(0))),
						new Noeud(Integer.valueOf(record.get(1))),
						Double.valueOf(record.get(2)));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Ajoute en un noeud au graphe si son identifiant n'est pas déjà utilisé.
	 * 
	 * @param n
	 *            : Noeud à ajouter.
	 * @return <strong>false</strong> si un noeud de même identifiant existe
	 *         déjà dans le graphe, <strong>true</strong> si l'ajout s'est bien
	 *         passé.
	 */
	public boolean ajouterNoeud(Noeud n) {
		if (noeuds.containsKey(n.getId())) {
			System.err
					.println("L'identifiant du nouveau noeud est déjà utilisé.");
			return false;
		} else {
			noeuds.put(n.getId(), n);
			return true;
		}
	}

	/**
	 * Ajoute un arc entre deux noeuds du graphe si c'est possible, et ajoute
	 * les noeuds au graphe s'ils n'y sont pas déjà.
	 * 
	 * @param n1
	 *            : Noeud initial de l'arc.
	 * @param n2
	 *            : Noeud terminal de l'arc.
	 * @param poids
	 *            : Poids de l'arc.
	 * @return <strong>false</strong> si le noeud terminal est déjà un
	 *         successeur du noeud initial, <strong>true</strong> si l'ajout de
	 *         l'arc s'est bien passé.
	 */
	public boolean ajouterArc(Noeud n1, Noeud n2, double poids) {
		if (n1.successeurs().contains(n2))
		{
			return false;
		}
		if (!noeuds.containsKey(n1.getId()))
		{
			ajouterNoeud(n1);
		}
		if (!noeuds.containsKey(n2.getId()))
		{
			ajouterNoeud(n2);
		}
		n1.ajouterArc(n2, poids);
		return true;
	}

	/**
	 * Affiche le graphe noeud par noeud selon l'affichage suivant :
	 * <strong></br>Noeud 2 : </br>2 --1.2--> 3</strong>
	 */
	public String toString() {
		Noeud[] list = noeuds.values().toArray(new Noeud[0]);
		String res = "";
		for (int i = 0; i < list.length; i++) {
			res += "Noeud " + list[i].getId() + " :\n";
			for (int j = 0; j < list[i].successeurs().size(); j++) {
				res += "\t" + list[i].getId() + " --" + list[i].getArcByTerm(list[i].successeurs().get(j)).getPoids() + "--> " + list[i].successeurs().get(j).getId();
				if (i < list.length - 1 || j < list[i].successeurs().size()-1)
					res += "\n";
			}
		}
		return res;
	}

	public HashMap<Integer, Noeud> getNoeuds() {
		return noeuds;
	}

}
