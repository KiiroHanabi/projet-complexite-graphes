package listeAdjacence;

import java.util.LinkedList;

public class Noeud {

	/**
	 *  Identifiant du noeud.
	 */
	private int id;
	
	/**
	 *  Liste chaînée d'arcs vers les successeurs du noeud.
	 */
	private LinkedList<Arc> arcs;

	public Noeud(int id)
	{
		this.id = id;
		arcs = new LinkedList<Arc>();
	}

	/**
	 * Ajoute un nouvel arc vers un noeud successeur, en vérifiant qu'il n'y en a pas déjà un.
	 * @param suc : Noeud successeur.
	 * @param poids : Poids de l'arc.
	 * @return <strong>false</strong> si il y a déjà un arc, <strong>true</strong> si l'ajout s'est bien passé.
	 */
	public boolean ajouterArc(Noeud suc, double poids)
	{
		for(int i = 0; i < arcs.size(); i++)
		{
			if (arcs.get(i).getTerm().getId() ==  suc.getId())
				return false;
		}
		arcs.add(new Arc(this,suc,poids));
		return true;
	}
	
	/**
	 * Ajoute un nouvel arc vers un noeud successeur, en vérifiant qu'il n'y en a pas déjà un.
	 * @param arc : L'arc à ajouter.
	 * @return <strong>false</strong> si il y a déjà un arc, <strong>true</strong> si l'ajout s'est bien passé.
	 */
	public boolean ajouterArc(Arc arc)
	{
		if(arc.getInit().getId() != this.id)
			return false;
		
		for(int i = 0; i < arcs.size(); i++)
		{
			if (arcs.get(i).getTerm().getId() ==  arc.getTerm().getId())
				return false;
		}
		arcs.add(arc);
		return true;
		
	}

	/**
	 * Récupère les noeuds successeurs de celui-ci à partir de la liste d'arcs.
	 * @return La liste des noeuds successeurs.
	 */
	public LinkedList<Noeud> successeurs()
	{
		LinkedList<Noeud> list = new LinkedList<Noeud>();
		for(int i = 0; i < arcs.size(); i++)
		{
				list.add(arcs.get(i).getTerm());
		}
		return list;
	}
	
	/**
	 * Recherche un arc dans la liste dont le successeur est <strong>term</strong>.
	 * @param term : le successeur de l'arc à rechercher.
	 * @return l'arc recherché s'il existe, <strong>null</strong> dans le cas contraire.
	 */
	public Arc getArcByTerm(Noeud term)
		{
			for(int i = 0; i < arcs.size(); i++)
			{
				if(arcs.get(i).getTerm().getId() == term.getId())
					return arcs.get(i);
			}
			return null;
		}
	
	public LinkedList<Arc> getArcs() {
		return arcs;
	}
	
	public int getId() {
		return id;
	}
	
}
