package listeAdjacence;

public class Arc {

	/**
	 * Noeud intitial et noeud terminal.
	 */
	private Noeud init, term;
	
	/**
	 *  Poids de l'arc.
	 */
	private float poids;


	public Arc(Noeud init, Noeud term, float poids) {
		this.init = init;
		this.term = term;
		this.poids = poids;
	}


	public Noeud getInit() {
		return init;
	}


	public Noeud getTerm() {
		return term;
	}


	public float getPoids() {
		return poids;
	}

}
