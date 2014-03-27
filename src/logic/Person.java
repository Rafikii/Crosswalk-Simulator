package logic;

import java.awt.geom.Point2D;
import java.util.Vector;

public class Person {
	public Point2D.Double position = new Point2D.Double();
	public int radius = 10;
	public Point2D.Double speed = new Point2D.Double();

	public boolean showTrail = false;
	public Vector<Point2D.Double> trail = new Vector<Point2D.Double>();
	public int trailPrecision = 5;

	public Person(int x, int y, int radius) {
		position.x = x;
		position.y = y;
		this.radius = radius;
	}

	public Person(Point2D.Double position, int radius) {
		position = new Point2D.Double(position.x, position.y);
		this.radius = radius;
	}

	public void update() {
		position.x += speed.x;
		position.y += speed.y;
		trail.add(new Point2D.Double(position.x, position.y));
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public void incSpeed() {
		speed.x++;
		speed.y++;
	}

	public void showHideTrail() {
		showTrail = !showTrail;
	}
}
