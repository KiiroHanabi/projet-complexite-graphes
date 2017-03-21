import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		Graphe g = new Graphe(3);
		g.ajouterArete(0, 1);
		g.ajouterArete(0, 2);
		g.ajouterArete(0, 0);
		g.ajouterArete(1, 1);
		g.ajouterArete(2, 0);
		g.ajouterArete(2, 2);
		g.afficher();
		System.out.println();
		g.supprimerSommet(1);
		g.afficher();
		System.out.println('\n');
		
		Graphe g2 = new Graphe(8);
		
		g2.ajouterArete(0, 1);
		g2.ajouterArete(0, 2);
		g2.ajouterArete(1, 3);
		g2.ajouterArete(1, 4);
		g2.ajouterArete(2, 3);
		g2.ajouterArete(3, 4);
		g2.ajouterArete(4, 5);
		g2.ajouterArete(4, 6);
		g2.ajouterArete(5, 6);
		g2.ajouterArete(6, 7);
		
		g2.ajouterArete(1, 0);
		g2.ajouterArete(2, 0);
		g2.ajouterArete(3, 1);
		g2.ajouterArete(4, 1);
		g2.ajouterArete(3, 2);
		g2.ajouterArete(4, 3);
		g2.ajouterArete(5, 4);
		g2.ajouterArete(6, 4);
		g2.ajouterArete(6, 5);
		g2.ajouterArete(7, 6);
		
		g2.afficher();
		System.out.println('\n');

		ArrayList<Integer> l = g2.parcoursProfondeur(1);
		for(int i = 0; i < l.size(); i++)
		{
			System.out.print(l.get(i)+" | ");
		}

	}

}
