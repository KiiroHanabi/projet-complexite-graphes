package dijkstra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import listeAdjacence.Arc;
import listeAdjacence.Graphe;
import listeAdjacence.Noeud;

public class DijkstraV1 {

	private Graphe g;
	
	/**
	 * Plus court chemins par noeud.
	 */
	private HashMap<Integer, PlusCourtChemin> ppc;
	
	/**
	 * Liste des noeuds non marqués.
	 */
	private ArrayList<Noeud> M;
	
	/**
	 * Identifiant du noeud source.
	 */
	private int s;
	
	public DijkstraV1(Graphe graphe, int source){
		
		if(graphe == null)
		{
			System.err.println("Le graphe sélectionné est null. Veuillez recommencer l'opération.");
		}
		else if(graphe.getNoeuds().containsKey(source))
		{
			g = graphe;
			ppc = new HashMap<Integer, PlusCourtChemin>();
			Noeud[] noeuds = g.getNoeuds().values().toArray(new Noeud[0]);
			for(int i = 0; i < noeuds.length; i++)
			{
				ppc.put(noeuds[i].getId(), new PlusCourtChemin());
			}
			M = new ArrayList<Noeud>();
			s = source;
		}
		else 
		{
			System.err.println("Le noeud source n'est pas présent dans le graphe.");
		}
	}
	
	public void start() throws Exception
	{
		if(g == null || ppc == null || M == null)
		{
			System.err.println("Le graphe inséré ou le noeud source ont causé une erreur, veuillez vérifier le code.");
			throw(new NullPointerException());
		}
		init();
		loop();
	}
	
	public void init()
	{
		for(int i=1; i < g.getNoeuds().size()+1; i++){
			ppc.get(i).setPerePPC(g.getNoeuds().get(s));
			ppc.get(i).setCoutPPC(cout(s,g.getNoeuds().get(i).getId()));
			M.add(g.getNoeuds().get(i));
		}
		M.remove(g.getNoeuds().get(s));
	}
	
	public void loop()
	{
		while(!M.isEmpty())
		{
			int m = selecDmin();
			System.out.println(ppc.get(M.get(m).getId()).getCoutPPC());
			if(ppc.get(M.get(m).getId()).getCoutPPC() == Double.POSITIVE_INFINITY)
			{
				break;
			}
			M.remove(m);
			LinkedList<Noeud> successeurs = g.getNoeuds().get(M.get(m).getId()).successeurs();
			for (int y = 0; y < successeurs.size(); y++)
			{
				if(M.contains(successeurs.get(y)))
				{
					if(ppc.get(M.get(m).getId()).getCoutPPC()+cout(M.get(m).getId(),successeurs.get(y).getId()) < ppc.get(successeurs.get(y).getId()).getCoutPPC())
					{
						ppc.get(successeurs.get(y).getId()).setCoutPPC(ppc.get(M.get(m).getId()).getCoutPPC()+cout(M.get(m).getId(),successeurs.get(y).getId()));
						ppc.get(successeurs.get(y).getId()).setPerePPC(g.getNoeuds().get(M.get(m).getId()));
					}
				}
			}
		}
	}
	
	public double cout(int source, int fin)
	{
		if(source == fin) return 0;
		Arc arc = g.getNoeuds().get(source).getArcByTerm(g.getNoeuds().get(fin));
		if(arc == null) return Double.POSITIVE_INFINITY;
		else return arc.getPoids();
	}
	
	public int selecDmin()
	{
		int min = 0;
		for(int i = 0; i < M.size(); i++)
		{
			if(ppc.get(M.get(i).getId()).getCoutPPC() < ppc.get(M.get(min).getId()).getCoutPPC())
				min = i;
		}
		return min;
	}

	public PlusCourtChemin getPlusCourtChemin(int destination) {
		if(ppc.containsKey(destination))
				return ppc.get(destination);
		else {
			System.err.println("Le noeud destination n'est pas présent dans le graphe.");
			return null;
		}
	}

	public Graphe getG() {
		return g;
	}

	public ArrayList<Noeud> getM() {
		return M;
	}

	public int getS() {
		return s;
	}

	public HashMap<Integer, PlusCourtChemin> getPpc() {
		return ppc;
	}
	
}
