package dijkstra;

import java.util.ArrayList;
import java.util.HashMap;

import listeAdjacence.Arc;
import listeAdjacence.Graphe;
import listeAdjacence.Noeud;

public class DijkstraV1 {

	private Graphe g;
	private HashMap<Integer, PlusCourtChemin> ppc;
	private ArrayList<Noeud> nonMarques;
	private int[] p;
	private double[] d;
	private int s;
	
	public DijkstraV1(Graphe graphe, int source){	

		if(graphe.getNoeuds().get(s) != null)
		{
			g = graphe;
			ppc = new HashMap<Integer, PlusCourtChemin>();
			nonMarques = new ArrayList<Noeud>();
			p = new int[g.getNoeuds().size()];
			d = new double[g.getNoeuds().size()];
			s = source;
			init();
			loop();
		}
		else 
		{
			System.err.println("Le noeud source n'est pas présent dans le graphe.");
		}
	}
	
	public void init()
	{
		for(int i=0; i< g.getNoeuds().size(); i++){
			p[i] = s;
			d[i] = cout(s,g.getNoeuds().get(i).getId());
			nonMarques.add(g.getNoeuds().get(i));
		}
		nonMarques.remove(g.getNoeuds().get(s));
	}
	
	public void loop()
	{
		//TODO reste de l'algo de Dijkstra ici !
	}
	
	public double cout(int source, int fin)
	{
		if(source == fin) return 0;
		Arc arc = g.getNoeuds().get(source).getArcByTerm(g.getNoeuds().get(fin));
		if(arc == null) return Double.POSITIVE_INFINITY;
		else return arc.getPoids();
	}
}
