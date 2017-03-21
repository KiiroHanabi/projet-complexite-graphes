import java.util.ArrayList;
import java.util.LinkedList;

public class Graphe {

	ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
	int taille;

	public Graphe(int taille) {
		this.taille = taille;
		for (int i = 0; i < taille; i++) {
			list.add(new ArrayList<Integer>());
		}
	}

	public void ajouterArete(int x, int y) {
		list.get(x).add(y);
	}

	public void supprimerArete(int x, int y) {
		list.get(x).remove(y);
	}

	public void ajouterSommet() {
		list.add(new ArrayList<Integer>());
	}

	public void supprimerSommet(int x) {
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.get(i).size(); j++) {
				if (list.get(i).get(j) == x && x != i)
					supprimerArete(i, x);
			}
		}
		list.remove(x);
		for (int i = x; i < list.size(); i++) {
			for (int j = 0; j < list.get(i).size(); j++) {
				if (list.get(i).get(j) > x) {
					list.get(i).remove(j);
					list.get(i).add(j);
				}
			}
		}
	}

	public void afficher() {
		for (int i = 0; i < list.size(); i++) {
			System.out.print(i + " : ");
			for (int j = 0; j < list.get(i).size(); j++) {
				System.out.print(list.get(i).get(j) + " | ");
			}
			System.out.println();
		}
	}

	// TODO Pas bon
	// public ArrayList<Integer> listeDesc(int x, ArrayList<Integer> liste) {
	// if (liste.contains(x))
	// return liste;
	// else {
	// for (int i = 0; i < list.get(x).size(); i++) {
	// if (!liste.contains(list.get(x).get(i))) {
	// liste.add(list.get(x).get(i));
	// return listeDesc(list.get(x).get(i), liste);
	// }
	// }
	// }
	// return null;
	//
	// }

	// TODO pas encore complet
	public ArrayList<Integer> listePred(int x) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.get(i).size(); j++) {
				if (list.get(i).get(j) == x)
					res.add(i);
			}
		}

		return res;
	}

	public int degre(int x) {
		return list.get(x).size();
	}

	public boolean cheminExiste(int a, int b) {
		return list.get(a).contains(b) && list.get(b).contains(a);
	}

	public ArrayList<Integer> parcoursLargeur(int a) {
		ArrayList<Integer> chemin = new ArrayList<Integer>();
		LinkedList<Integer> file = new LinkedList<Integer>();
		boolean[] marqueur = new boolean[taille];
		marqueur[a] = true;
		file.add(a);
		int s = a;

		while (!file.isEmpty()) {
			file.removeFirst();

			for (int i = 0; i < list.get(s).size(); i++) {
				if (!marqueur[list.get(s).get(i)]) {
					marqueur[list.get(s).get(i)] = true;
					chemin.add(list.get(s).get(i));
					file.addFirst(list.get(s).get(i));
				}
			}
			if (!file.isEmpty()) {
				s = file.getFirst();
			}

		}

		return chemin;
	}

	// marche pas encore
	public ArrayList<Integer> parcoursProfondeur(int a) {
		ArrayList<Integer> chemin = new ArrayList<Integer>();
		LinkedList<Integer> pile = new LinkedList<Integer>();
		boolean[] marqueur = new boolean[taille];
		marqueur[a] = true;
		pile.add(a);
		int s = a;

		while (!pile.isEmpty()) {
			chemin.add(pile.removeLast());

			for (int i = 0; i < list.get(s).size(); i++) {
				if (!marqueur[list.get(s).get(i)]) {
					marqueur[list.get(s).get(i)] = true;
					pile.addFirst(list.get(s).get(i));
				}
			}
			if (!pile.isEmpty()) {
				s = pile.getLast();
			}

		}

		return chemin;
	}

	// TODO tester si le graphe est complet
	// Créer un graphe à partir d"un fichier décrivant le jeu de données
}
