package voyageurDeCommerce;

public class TSP {
	
	private ArrayList<Point> points;
	
	public Point pointAleatoire(){
		float x = Math.random();
		float y = Math.random();
		Point p = new Point(x, y);
		return p;
	}
	
	public ArrayList<Point> ensemblePoints(int n){
		for(int i = 0; i<n; i++){
			Point p = pointAleatoire();
			points.add(p);
		}
	}
	
	public glouton(){
		
	}
	
	public mst(){
		
	}
	
	public voisinnage(){
		
	}
	
}
