package listeAdjacence;

import java.util.LinkedList;

public class Noeud {

	private int id;
	private LinkedList<Arc> arcs;

	public Noeud(int id)
	{
		this.id = id;
	}

	public boolean ajouterArc(Noeud suc, float poids)
	{
		for(int i = 0; i < arcs.size(); i++)
		{
			if (arcs.get(i).getTerm().equals(suc))
				return false;
		}
		arcs.add(new Arc(this,suc,poids));
		suc.ajouterArc(this, poids);
		return true;
	}

	public LinkedList<Noeud> successeurs()
	{
		LinkedList<Noeud> list = new LinkedList<Noeud>();
		for(int i = 0; i < arcs.size(); i++)
		{
			if(arcs.get(i).getInit().getId() == id)
				list.add(arcs.get(i).getTerm());
		}
		return list;
	}

	public int getId() {
		return id;
	}

}
