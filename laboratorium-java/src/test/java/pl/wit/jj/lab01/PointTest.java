package pl.wit.jj.lab01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PointTest {

	@Test
	void moveXTest() {
		Point pt = new Point(5.31f,8.72f);
		float  k = -0.31f;
		pt.moveX(k);
		assertEquals(5f,pt.getX());
	}
	@Test
	void moveYTest() {
		Point pt = new Point(5.31f,8.70f);
		float  k = -3.30f;
		pt.moveY(k);
		assertEquals(5.3999996f,pt.getY());
	}
	@Test
	void addTest() {
		
		Point pt1 = new Point(5.31f,8.72f);
		Point pt2 = new Point(4.69f,1.28f);
		pt1.add(pt2);
		assertEquals(10.f,pt1.getX());
		assertEquals(10.f,pt1.getY());
		
	}
	@Test
	void NullAddTest() 
	{
		Point pt1 = new Point(5.31f,8.72f);
		Point pt2 = null;
		pt1.add(pt2);
		assertEquals(5.31f,pt1.getX());
		assertEquals(8.72f,pt1.getY());
		
	}
	@Test 
	void subTest(){
		Point pt1 = new Point(5.31f,8.72f);
		Point pt2 = new Point(4.69f,1.28f);
		pt1.sub(pt2);
		assertEquals(0.6199999f,pt1.getX());
		assertEquals(7.4400005f,pt1.getY());
	}
	
	@Test
	void NullsubTest(){
		Point pt1 = new Point(5.31f,8.72f);
		Point pt2 = null;
		pt1.sub(pt2);
		assertEquals(5.31f,pt1.getX());
		assertEquals(8.72f,pt1.getY());
	}
	@Test
	void addAndCreateTest(){
		Point pt1 = new Point(5.31f,8.72f);
		Point pt2 = new Point(4.69f,1.28f);
		Point pt3 =  pt1.addAndCreate(pt2);
		assertEquals(pt3.getX(),pt1.getX()+pt2.getX());
		assertEquals(pt3.getY(),pt1.getY()+pt2.getY());
	}
	@Test
	void NullAddAndCreateTest(){
		Point pt1 = new Point(5.31f,8.72f);
		Point pt2 = null;
		
		Point pt3 =  pt1.addAndCreate(pt2);
		assertEquals(pt3,null);
	
	}
	
	
}
