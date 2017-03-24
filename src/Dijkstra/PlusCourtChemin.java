package dijkstra;

import listeAdjacence.Noeud;

public class PlusCourtChemin {
	
	private double coutPPC;
	private Noeud perePPC;
	private boolean pereMarque;
	
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
	
	public boolean isPereMarque() {
		return pereMarque;
	}
	
	public void setPereMarque(boolean pereMarque) {
		this.pereMarque = pereMarque;
	}
}
