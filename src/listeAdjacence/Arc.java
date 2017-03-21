package listeAdjacence;

public class Arc {

	private Noeud init;
	private Noeud term;
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
