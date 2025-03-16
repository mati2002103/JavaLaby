package pl.wit.jj.lab01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PointTest {

	@Test
	void moveXTest() {
		Point pt = new Point(5.31f,8.72f);
		float  k = -3.5445674867f;
		pt.moveX(k);
		assertEquals(2f,pt.getX());
	}
	void moveYTest() {
		Point pt = new Point(5.31f,8.72f);
		float  k = -3.31f;
		pt.moveY(k);
		assertEquals(5.41f,pt.getY());
	}
}
