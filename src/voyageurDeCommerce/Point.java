package voyageurDeCommerce;

public class Point {

	/**
	 * Les coordonnées des points.
	 */
	private float x, y;

	public Point(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	/**
	 * Mesure la distance euclidienne entre deux points.
	 * 
	 * @param p
	 *            Le point distant.
	 * @return La distance.
	 */
	public float distance(Point p) {
		return (float) (Math.sqrt((p.getY() - y) * (p.getY() - y)
				+ (p.getX() - x) * (p.getX() - x)));
	}

	public void setX(float x) {
		this.x = x;
	}

	public void setY(float y) {
		this.y = y;
	}

}
