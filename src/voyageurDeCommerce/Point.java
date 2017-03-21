package voyageurDeCommerce;

public class Point {
	
	private float x,y;

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}
	
	public float distance(Point p)
	{
		return (Math.sqrt((p.getY()-y)*(p.getY()-y)+(p.getX()-x)*(p.getX()-x)));
	}

}
