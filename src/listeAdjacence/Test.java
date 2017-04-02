package listeAdjacence;

import dijkstra.DijkstraV1;

public class Test {

	public static void main(String[] args) {
		Graphe g = new Graphe("src/listeAdjacence/graph1.csv");
		System.out.println(g);
		DijkstraV1 dv1 = new DijkstraV1(g,1);
		try {
			dv1.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
		dv1.getPlusCourtChemin(6).afficherChemin();
	}

}
