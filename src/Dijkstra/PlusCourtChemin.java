package dijkstra;

import listeAdjacence.Noeud;

public class PlusCourtChemin {
	
	/** 
	 * Le cout entre la source et le noeud.
	 */
	private double coutPPC;
	
	/**
	 * Le père du noeud.
	 */
	private Noeud perePPC;
	
	public PlusCourtChemin(){}
	
	public double getCoutPPC() {
		return coutPPC;
	}
	
	public void setCoutPPC(double coutPPC) {
		this.coutPPC = coutPPC;
	}
	
	public Noeud getPerePPC() {
		return perePPC;
	}
	
	public void setPerePPC(Noeud perePPC) {
		this.perePPC = perePPC;
	}
}
