package voyageurDeCommerce;

import java.util.ArrayList;

public class TSP {

	/**
	 * Les points du circuit.
	 */
	private ArrayList<Point> points;

	public TSP() {
		points = new ArrayList<Point>();
	}

	/**
	 * Génère un point aléatoire dont les coordonnées sont situées entre 0 et 1.
	 * 
	 * @return Le point.
	 */
	public static Point pointAleatoire() {
		float x = (float) Math.random();
		float y = (float) Math.random();
		return new Point(x, y);
	}

	/**
	 * Remplit la liste du TSP avec un ensemple de points aléatoires.
	 * 
	 * @param n
	 *            Le nombre de points du circuit.
	 */
	public void ensemblePoints(int n) {
		points.clear();
		for (int i = 0; i < n; i++) {
			Point p = pointAleatoire();
			points.add(p);
		}
	}

	/**
	 * Mesure la longueur totale du circuit.
	 * 
	 * @param list
	 *            Le circuit dont on veut calculer la distance.
	 * @return La distance du circuit.
	 */
	public static float longueurCircuit(ArrayList<Point> list) {
		float res = 0;
		for (int i = 0; i < list.size() - 1; i++)
			res += list.get(i).distance(list.get(i + 1));
		return res;
	}

	/**
	 * Implémente l'algorithme glouton.
	 * 
	 * @return Le circuit amélioré.
	 */
	public ArrayList<Point> glouton() {
		ArrayList<Point> circuit = new ArrayList<Point>();
		circuit.add(points.get(0));
		for (int i = 0; i < circuit.size(); i++) {
			int min = 0;
			boolean find = false;
			float distMin = Float.POSITIVE_INFINITY;
			for (int j = 0; j < points.size(); j++) {
				if (!circuit.contains(points.get(j))) {
					if (circuit.get(i).distance(points.get(j)) < distMin) {
						find = true;
						distMin = circuit.get(i).distance(points.get(j));
						min = j;
					}
				}
			}
			if (find)
				circuit.add(points.get(min));
		}

		return circuit;
	}

	/**
	 * Estime le gain issu de la transformation 2-opt.
	 *
	 * @return Le gain, positif ou négatif.
	 */
	public static float voisinage(Point p1, Point p2, Point p3, Point p4) {
		return p1.distance(p2) + p3.distance(p4)
				- (p1.distance(p3) + p2.distance(p4));
	}

	/**
	 * Implément l'algorithme de recuit simulé.
	 * 
	 * @param list
	 *            Le circuit à améliorer.
	 * @return Le circuit amélioré.
	 */
	public static ArrayList<Point> recuitSimule(ArrayList<Point> list) {
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = 0; j < list.size() - 1; j++) {
				if (j != i - 1 && j != i && j != i + 1) {
					if (voisinage(list.get(i), list.get(i + 1), list.get(j),
							list.get(j + 1)) > 0) {
						list = reverseSegment(i, j + 1, list);
					}
				}
			}
		}
		return list;
	}

	/**
	 * Inverse une portion de liste.
	 * 
	 * @param a
	 *            L'index du début du segment.
	 * @param b
	 *            L'index de la fin du segment.
	 * @param list
	 *            Le circuit à améliorer.
	 * @return Le circuit amélioré.
	 */
	public static ArrayList<Point> reverseSegment(int a, int b,
			ArrayList<Point> list) {
		for (int i = 0; i < (int) ((b - a) / 2); i++) {
			Point tmp = list.get(b - i);
			list.get(b - i).setX(list.get(i + a).getX());
			list.get(b - i).setY(list.get(i + a).getY());
			list.get(i + a).setX(tmp.getX());
			list.get(i + a).setY(tmp.getY());

		}
		return list;
	}

	public ArrayList<Point> getPoints() {
		return points;
	}

}
