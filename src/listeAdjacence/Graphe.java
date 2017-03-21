package listeAdjacence;

import java.util.Collection;
import java.util.HashMap;

public class Graphe {

	HashMap<Integer,Noeud> noeuds;

	public Graphe()
	{
		noeuds = new HashMap<Integer,Noeud>();
	}

	public boolean ajouterNoeud(Noeud n)
	{
		if(noeuds.containsKey(n.getId()))
			{
			System.err.println("L'identifiant du nouveau noeud est déjà utilisé.");
			return false;
			}
		else
			{
			noeuds.put(n.getId(), n);
			return true;
			}
	}

	public void ajouterArc(Noeud n1, Noeud n2, float poids)
	{
		if(!noeuds.containsKey(n1.getId()))
			ajouterNoeud(n1);
		if(!noeuds.containsKey(n2.getId()))
			ajouterNoeud(n2);
		n1.ajouterArc(n2, poids);
	}

	public void afficher()
	{
		Noeud[] list = (Noeud[])noeuds.values().toArray();
		for(int i = 0; i < list.length; i++)
		{
			System.out.println("Noeud "+list[i].getId()+" :");
			for(int j = 0; j < list[i].successeurs().size(); j++){
				//TODO affichage  de type "2 --1.2--> 3"
			}
		}
	}

}
