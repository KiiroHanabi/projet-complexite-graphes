package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import voyageurDeCommerce.Point;
import voyageurDeCommerce.TSP;

public class TSPTest {
	TSP tsp;

	@Before
	public void setUp() throws Exception {
		tsp = new TSP();
	}

	@Test
	public void testPointAleatoire() {
		Point p = TSP.pointAleatoire();
		assertTrue(p.getX() <= 1);
		assertTrue(p.getY() <= 1);
		assertTrue(p.getX() >= 0);
		assertTrue(p.getY() >= 0);
	}

	@Test
	public void testEnsemblePoints() {
		tsp.ensemblePoints(10);
		assertFalse(tsp.getPoints().isEmpty());
		for (int i = 0; i < tsp.getPoints().size(); i++) {
			assertTrue(tsp.getPoints().get(i).getX() <= 1);
			assertTrue(tsp.getPoints().get(i).getY() <= 1);
			assertTrue(tsp.getPoints().get(i).getX() >= 0);
			assertTrue(tsp.getPoints().get(i).getY() >= 0);
		}
	}

	@Test
	public void testLongueurCircuit() {
		tsp.ensemblePoints(10);
		assertTrue(TSP.longueurCircuit(tsp.getPoints()) > 0);

	}

}
