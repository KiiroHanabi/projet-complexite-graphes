package listeAdjacence;

public class Arc {

	/**
	 * Noeud intitial et noeud terminal.
	 */
	private Noeud init, term;

	/**
	 * Poids de l'arc.
	 */
	private double poids;

	public Arc(Noeud init, Noeud term, double poids) {
		this.init = init;
		this.term = term;
		this.poids = poids;
	}

	public boolean equals(Arc arc) {
		return init.getId() == arc.getInit().getId()
				&& term.getId() == arc.getTerm().getId()
				&& poids == arc.getPoids();
	}

	public Noeud getInit() {
		return init;
	}

	public Noeud getTerm() {
		return term;
	}

	public double getPoids() {
		return poids;
	}

}
