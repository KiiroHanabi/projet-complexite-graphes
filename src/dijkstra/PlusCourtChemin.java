package dijkstra;

import listeAdjacence.Noeud;

public class PlusCourtChemin {
	
	private double coutPPC;
	private Noeud perePPC;
	private boolean marque;
	
	public void afficherChemin()
	{
		System.out.print("<--"+coutPPC+"-- "+perePPC.getId()+" ");
		afficherChemin(perePPC);
	}
	
	public void afficherChemin(Noeud pere)
	{
		if(pere.equals(perePPC)){
			System.out.println();
			return;
		}
		System.out.print("--"+coutPPC+"--> "+perePPC.getId()+" ");
		afficherChemin(perePPC);
	}
	
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
	
	public boolean isMarque() {
		return marque;
	}
	
	public void setMarque(boolean marque) {
		this.marque = marque;
	}
}
