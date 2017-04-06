package test;

import static org.junit.Assert.*;
import listeAdjacence.Graphe;

import org.junit.Before;
import org.junit.Test;

import dijkstra.DijkstraV1;

public class DijkstraV1Test {
	Graphe g;
	DijkstraV1 d;

	@Before
	public void setUp() throws Exception {
		g = new Graphe("src/listeAdjacence/graph1.csv");
		d = new DijkstraV1(g, 1);
	}

	@Test
	public void testDijkstraV1() {
		DijkstraV1 dv1 = new DijkstraV1(g, 2);

		assertSame(g, dv1.getG());
		assertEquals(2, dv1.getS());
		assertNotNull(dv1.getM());
	}

	@Test
	public void testInit() {
		d.init();

		for (int i = 1; i < g.getNoeuds().size() + 1; i++) {
			assertEquals(g.getNoeuds().get(d.getS()), d.getPpc().get(i)
					.getPerePPC());
			assertTrue(d.cout(d.getS(), g.getNoeuds().get(i).getId()) == d
					.getPpc().get(i).getCoutPPC());
			if (i != d.getS())
				assertTrue(d.getM().containsValue(g.getNoeuds().get(i)));
		}
		assertFalse(d.getM().containsValue(g.getNoeuds().get(d.getS())));
	}

	@Test(timeout = 5000)
	public void testLoop() {
		d.init();
		d.loop();
		assertFalse(d.getM().isEmpty());
	}

	@Test
	public void testSelecDmin() {
		int m;
		int[] res = new int[] { 3, 5, 2 }; // Pour le graphe graph1.csv avec
											// source = 1
		d.init();
		for (int i = 0; i < d.getM().size(); i++) {
			m = d.selecDmin();
			assertTrue(d.getM().get(m).getId() == res[i]);
			d.getM().remove(m);
		}
	}

	@Test
	public void testCout() {
		assertTrue(4.0 == d.cout(4, 3));
		assertTrue(Double.POSITIVE_INFINITY == d.cout(5, 3));
	}

	@Test
	public void testStart() {
		DijkstraV1 d2 = new DijkstraV1(null, 1);
		try {
			d2.start();
			fail("L'exception ne s'est pas levée.");
		} catch (Exception e) {
		}
	}

}
