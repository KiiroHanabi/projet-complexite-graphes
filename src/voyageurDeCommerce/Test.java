package voyageurDeCommerce;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		TSP tsp = new TSP();
		long debut;
		long fin;

		for (int i = 1; i <= 101; i += 10) {
			tsp.ensemblePoints(i);
			System.out
					.println(TSP.longueurCircuit(tsp.getPoints()) + " | " + 0);
			debut = System.nanoTime();
			ArrayList<Point> glo = tsp.glouton();
			fin = System.nanoTime();
			System.out
					.println(TSP.longueurCircuit(glo) + " | " + (fin - debut));
			debut = System.nanoTime();
			ArrayList<Point> rec = TSP.recuitSimule(tsp.getPoints());
			fin = System.nanoTime();
			System.out
					.println(TSP.longueurCircuit(rec) + " | " + (fin - debut));
			System.out.println();
		}

	}

}
