package dijkstra;

import java.time.Duration;
import java.time.Instant;
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
	private HashMap<Integer,Noeud> M;
	
	/**
	 * Liste des noeuds marqués.
	 */
	private HashMap<Integer,Noeud> F;
	
	/**
	 * Identifiant du noeud source.
	 */
	private int s;
	
	/**
	 * 
	 * @param graphe Le graphe à analyser.
	 * @param source L'identifiant du noeud source de l'algorithme.
	 */
	public DijkstraV1(Graphe graphe, int source){
		
		if(graphe == null)
		{
			System.err.println("Le graphe sélectionné est null. Veuillez recommencer l'opération.");
		}
		else if(graphe.getNoeuds().containsKey(source))
		{
			g = graphe;
			ppc = new HashMap<Integer, PlusCourtChemin>();
			Noeud[] noeuds = Graphe.mapToArray(g.getNoeuds());
			for(int i = 0; i < noeuds.length; i++)
			{
				ppc.put(noeuds[i].getId(), new PlusCourtChemin());
			}
			M = new HashMap<Integer,Noeud>();
			F = new HashMap<Integer,Noeud>();
			s = source;
		}
		else 
		{
			System.err.println("Le noeud source n'est pas présent dans le graphe.");
		}
	}
	
	/** Démarre le calcul de l'algorithme.
	 * 
	 * @throws Exception Lance une exception si la construction de la classe s'est mal passée.
	 */
	public void start() throws Exception
	{
		if(g == null || ppc == null || M == null)
		{
			System.err.println("Le graphe inséré ou le noeud source ont causé une erreur, veuillez vérifier le code.");
			throw(new NullPointerException());
		}
		Instant i = Instant.now();
		init();
		loop();
		Instant i2 = Instant.now();
		Duration d = Duration.between(i, i2);
		System.out.println(d.toMillis());
	}
	
	/** Phase d'initialisation de l'algorithme, remplit la liste des noeuds non marqués en calculant leur coût et noeud père initiaux.
	 * 
	 */
	public void init()
	{
		for(int i=1; i < g.getNoeuds().size()+1; i++){
			ppc.get(i).setPerePPC(g.getNoeuds().get(s));
			ppc.get(i).setCoutPPC(cout(s,g.getNoeuds().get(i).getId()));
			M.put(g.getNoeuds().get(i).getId(),g.getNoeuds().get(i));
		}
		F.put(g.getNoeuds().get(s).getId(),g.getNoeuds().get(s));
		M.remove(g.getNoeuds().get(s).getId());
	}
	
	/** Phase itérative de l'algorithme, vérifie de le cout des successeurs et met les valeurs à jour si elles sont améliorables. Après cette phase l'algorithme est terminé.
	 * 
	 */
	public void loop()
	{
		while(!M.isEmpty())
		{
//			for(int v = 1; v <= ppc.size(); v++)
//				System.out.print(v+" : "+ppc.get(v).getCoutPPC()+"|"+ppc.get(v).getPerePPC().getId()+";\t");
//			System.out.println();
//			Permet de montrer les itérations
			int m = selecDmin();
			if(ppc.get(M.get(m).getId()).getCoutPPC() == Double.POSITIVE_INFINITY)
			{
				break;
			}
			F.put(M.get(m).getId(),M.get(m));
			M.remove(m);
			LinkedList<Noeud> successeurs = g.getNoeuds().get(F.get(m).getId()).successeurs();
			for (int y = 0; y < successeurs.size(); y++)
			{	
				if(M.containsValue(successeurs.get(y)))
				{
					if(ppc.get(F.get(m).getId()).getCoutPPC()+cout(F.get(m).getId(),successeurs.get(y).getId()) <= ppc.get(successeurs.get(y).getId()).getCoutPPC())
					{
						ppc.get(successeurs.get(y).getId()).setCoutPPC(ppc.get(F.get(m).getId()).getCoutPPC()+cout(F.get(m).getId(),successeurs.get(y).getId()));
						ppc.get(successeurs.get(y).getId()).setPerePPC(g.getNoeuds().get(F.get(m).getId()));
					}
				}
			}
		}
	}
	
	/** Calcule le coût entre deux noeuds du graphe.
	 * 
	 * @param source Le noeud de départ.
	 * @param fin Le noeud de fin.
	 * @return Le coût de l'arc situé entre les deux noeuds s'il y en a un, sinon renvoie la valeur <strong>Double.POSITIVE_INFINITY</strong>.
	 */
	public double cout(int source, int fin)
	{
		if(source == fin) return 0;
		Arc arc = g.getNoeuds().get(source).getArcByTerm(g.getNoeuds().get(fin));
		if(arc == null) return Double.POSITIVE_INFINITY;
		else return arc.getPoids();
	}
	
	/** Détermine le noeud non marqué dont le coût est le plus petit depuis la source.
	 * 
	 * @return L'identifiant du noeud au coût minimal.
	 */
	public int selecDmin()
	{
		int min = 0;
		Noeud[] arrayM = Graphe.mapToArray(M);
		for(int i = 0; i < arrayM.length; i++)
		{
			if(ppc.get(arrayM[i].getId()).getCoutPPC() < ppc.get(arrayM[min].getId()).getCoutPPC())
				min = i;
		}
		return arrayM[min].getId();
	}

	/** Vérifie que le noeud demandé existe dans le graphe et appelle <i>afficherChemin()</i> pour l'afficher.
	 * 
	 * @param destination L'identifiant du noeud dont on veut connaître le plus court chemin depuis la source.
	 */
	public void afficherPlusCourtChemin(int destination) {
		if(ppc.containsKey(destination)){
				System.out.print("Cout : "+ppc.get(destination).getCoutPPC()+", Chemin : "+destination+" ");
				afficherChemin(ppc.get(destination));
		}
		else {
			System.err.println("Le noeud destination n'est pas présent dans le graphe.");
		}
	}
	
	/** Remonte le chemin depuis le noeud choisi vers la source en l'affichant dans la console.
	 * 
	 * @param ch Le <strong>PlusCourtChemin</strong> à remonter.
	 */
	public void afficherChemin(PlusCourtChemin ch)
	{
		if(ch.getPerePPC().equals(g.getNoeuds().get(s))){
			System.out.print("--> "+s);
			System.out.println();
			return;
		}
		System.out.print("--> "+ch.getPerePPC().getId()+" ");
		afficherChemin(ppc.get(ch.getPerePPC().getId()));
	}

	public Graphe getG() {
		return g;
	}

	public HashMap<Integer,Noeud> getM() {
		return M;
	}

	public int getS() {
		return s;
	}

	public HashMap<Integer, PlusCourtChemin> getPpc() {
		return ppc;
	}
	
}
