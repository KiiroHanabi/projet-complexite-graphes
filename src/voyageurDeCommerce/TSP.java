package voyageurDeCommerce;

import java.util.ArrayList;

public class TSP {
	
	private ArrayList<Point> points;
	
	public TSP(){
		points = new ArrayList<Point>();
	}
	
	public Point pointAleatoire(){
		float x = (float)Math.random();
		float y = (float)Math.random();
		Point p = new Point(x, y);
		return p;
	}
	
	public void ensemblePoints(int n){
		for(int i = 0; i<n; i++){
			Point p = pointAleatoire();
			points.add(p);
		}
	}
	
	public static float longueurCircuit(ArrayList<Point> list){
		float res = 0;
		for(int i = 0; i < list.size()-1; i++)
			res += list.get(i).distance(list.get(i+1));
		return res;
	}
	
	public ArrayList<Point> glouton(){
		ArrayList<Point> circuit = new ArrayList<Point>();
		circuit.add(points.get(0));
		for(int i = 0; i < circuit.size(); i++)
		{
			int min = 0;
			boolean find = false;
			float distMin = Float.POSITIVE_INFINITY;
			for(int j = 0; j < points.size(); j++)
			{
				if(!circuit.contains(points.get(j)))
				{
					if(circuit.get(i).distance(points.get(j)) < distMin)
					{
						find = true;
						distMin = circuit.get(i).distance(points.get(j));
						min = j;
					}
				}
			}
			if(find) circuit.add(points.get(min));
		}

		return circuit;
	}
	
	public static float voisinage(Point p1, Point p2, Point p3, Point p4){
		return p1.distance(p2)+p3.distance(p4) - (p1.distance(p3)+p2.distance(p4));
	}
	
	public static ArrayList<Point> recuitSimule(ArrayList<Point> list)
	{
		for(int i = 0; i < list.size()-1; i++)
		{
			for(int j = 0; j < list.size()-1; j++)
			{
				if(j != i-1 && j != i && j != i+1)
				{
					if(voisinage(list.get(i),list.get(i+1),list.get(j),list.get(j+1)) > 0)
					{
						Point tmp = list.get(i+1);
						list.get(i+1).setX(list.get(j).getX());
						list.get(i+1).setY(list.get(j).getY());
						list.get(j).setX(tmp.getX());
						list.get(j).setY(tmp.getY());
					}
				}
			}
		}
		return list;
	}

	public ArrayList<Point> getPoints() {
		return points;
	}
	
}
