package pl.wit.jj.lab01;

public class Point {

	private float x ;
	private float y ;

	public Point(float x, float y) {
		this.x = x;
		this.y = y;

	}
	public void moveX(float shift)
	{
		this.x +=shift;
	}
	public void moveY(float shift)
	{
		this.y +=shift;
	}
	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}
	public void add(Point p2) 
	{
		if (p2 == null)
		{
		return;
				
		}
		moveX(p2.x);
		moveY(p2.y);
		
	}
	public void sub(Point p2) 
	{
		if (p2 == null)
		{
		return;
				
		}
		moveX(-p2.x);
		moveY(-p2.y);
		
	}
	public Point addAndCreate(Point p2) 
	{
		if (p2 == null)
			return null;
		Point pt1=new Point(this.x,this.y);
		pt1.add(p2);
		return pt1;		
	}
	
	
	
}
