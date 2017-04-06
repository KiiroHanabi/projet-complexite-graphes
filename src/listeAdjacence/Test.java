package listeAdjacence;

import dijkstra.DijkstraV1;

public class Test {

	public static void main(String[] args) {
		Graphe g = new Graphe("src/listeAdjacence/graph1.csv");
//		System.out.println(g);
//		System.out.println();
		DijkstraV1 dv1 = new DijkstraV1(g,1);
//		try {
//			dv1.start();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		System.out.println();
//		dv1.afficherPlusCourtChemin(6);
//		System.out.println();
		
		for(float j = 0; j < 1.1; j+=.1){
			for(int i = 1; i <= 101; i+=10){	
				g.randomizeGraphe(i,(int)(i*(i-1)*j));
//				System.out.println(g);
				dv1 = new DijkstraV1(g,1);
				try {
					dv1.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}

}
