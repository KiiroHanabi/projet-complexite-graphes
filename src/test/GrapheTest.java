package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import listeAdjacence.Arc;
import listeAdjacence.Graphe;
import listeAdjacence.Noeud;

import org.junit.Before;
import org.junit.Test;

public class GrapheTest {
	
	private Noeud n1, n2, n3;
	private Graphe g;

	@Before
	public void setUp() throws Exception {
		g = new Graphe();
		n1 = new Noeud(1);
		n2 = new Noeud(2);
		n3 = new Noeud(3);
	}
	
	@Test
	public void testGraphe()
	{
		g.ajouterArc(n1, n2, 10);
		g.ajouterArc(n1, n3, 3);
		g.ajouterArc(n2, n1, 0);
		g.ajouterArc(n3, n2, 4);
		g.ajouterArc(n3, n1, 2);
		Graphe g2 = new Graphe("src/test/graphTest.csv");
		assertEquals(g.toString(),g2.toString());
	}

	@Test
	public void testAjouterNoeud() {
		g.ajouterNoeud(n1);
		g.ajouterNoeud(n2);
		assertTrue(g.getNoeuds().get(1).equals(n1));
		assertTrue(g.getNoeuds().get(2).equals(n2));
		assertFalse(g.ajouterNoeud(n1));
	}
	
	@Test
	public void testAjouterArc()
	{
		g.ajouterArc(n1, n2, 2.5);
		Arc arc = new Arc(n1, n2, 2.5);
		assertTrue(n1.getArcs().get(0).equals(arc));
		assertFalse(g.ajouterArc(n1,n2,1.5));
	}
	
	@Test
	public void testToString()
	{
		g.ajouterArc(n1,n2,1.2);
		g.ajouterArc(n1,n3,1.8);
		g.ajouterArc(n2,n1,1);
		g.ajouterArc(n3,n2,1.7);
		String aff = "Noeud 1 :\n\t1 --1.2--> 2\n\t1 --1.8--> 3\nNoeud 2 :\n\t2 --1.0--> 1\nNoeud 3 :\n\t3 --1.7--> 2";
		assertEquals(g.toString(), aff);
	}

}
