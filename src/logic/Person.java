package logic;

import java.awt.Point;

public class Person {
	Point position = new Point();

	public Person() {

	}

	public Person(int x, int y) {
		position.x = x;
		position.y = y;
	}

	public Person(Point position) {
		position = new Point(position);
	}
}
