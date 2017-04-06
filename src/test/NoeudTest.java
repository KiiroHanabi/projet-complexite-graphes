package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.LinkedList;

import listeAdjacence.Arc;
import listeAdjacence.Noeud;

import org.junit.Before;
import org.junit.Test;

public class NoeudTest {

	private Arc arc;
	private Noeud init, suc2, suc3;

	@Before
	public void setUp() throws Exception {
		init = new Noeud(1);
		suc2 = new Noeud(2);
		suc3 = new Noeud(3);
		arc = new Arc(init, suc2, 1.5);
	}

	@Test
	public void testAjouterArc() {
		init.ajouterArc(suc2, 1.5);
		LinkedList<Arc> arcs = new LinkedList<Arc>();
		arcs.add(new Arc(init, suc2, 1.5));
		assertTrue(init.getArcs().get(0).equals(new Arc(init, suc2, 1.5)));
		assertFalse(init.ajouterArc(suc2, 2.5));
	}

	@Test
	public void testAjouterArc2() {
		init.ajouterArc(arc);
		LinkedList<Arc> arcs = new LinkedList<Arc>();
		arcs.add(arc);
		assertTrue(init.getArcs().get(0).equals(arc));
		assertFalse(init.ajouterArc(arc));
	}

	@Test
	public void testSuccesseurs() {
		init.ajouterArc(arc);
		init.ajouterArc(suc3, 2.5);
		suc2.ajouterArc(init, 1);
		LinkedList<Noeud> list = new LinkedList<Noeud>();
		list.add(suc2);
		list.add(suc3);
		list.add(init);
		assertSame(init.successeurs().get(0), list.get(0));
		assertSame(init.successeurs().get(1), list.get(1));
		assertSame(suc2.successeurs().get(0), list.get(2));
		assertTrue(list.size() == 3);
	}

	@Test
	public void testGetArcByTerm() {
		init.ajouterArc(arc);
		assertSame(arc, init.getArcByTerm(suc2));
	}

}
