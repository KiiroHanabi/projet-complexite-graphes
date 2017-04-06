package voyageurDeCommerce;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		TSP tsp = new TSP();
		tsp.ensemblePoints(10);
		System.out.println(TSP.longueurCircuit(tsp.getPoints()));
		ArrayList<Point> glo = tsp.glouton();
		System.out.println(TSP.longueurCircuit(glo));
		ArrayList<Point> rec = TSP.recuitSimule(glo);
		System.out.println(TSP.longueurCircuit(rec));

	}

}
