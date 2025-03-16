package pl.wit.jj.lab01;
/**
* @author Mateusz Wiśniewski
* 
*  Klasa reprezentująca punkt w przestrzeni dwuwymiarowej.
* Umożliwia przesuwanie punktu oraz wykonywanie operacji na współrzędnych.
*
*
*/
public class Point {

	private float x ;
	private float y ;

	/**
     * Konstruktor klasy Point inicjalizujący współrzędne punktu.
     * 
     * @param x wspsółrzędna X
     * @param y współrzędna Y
     */
	
	public Point(float x, float y) {
		this.x = x;
		this.y = y;

	}
  /**
     * Przesuwa punkt wzdłuż osi X o podaną wartość.
     * 
     * @param shift wartość przesunięcia
     */
	public void moveX(float shift)
	{
		this.x +=shift;
	}
  /**
     * Przesuwa punkt wzdłuż osi Y o podaną wartość.
     * 
     * @param shift wartość przesunięcia
     */
	public void moveY(float shift)
	{
		this.y +=shift;
	}
	 /**
     * Zwraca współrzędną X punktu.
     * 
     * @return współrzędna X
     */
	public float getX() {
		return x;
	}
	 /**
     * Ustawia współrzędną X punktu.
     * 
     * @param x nowa wartość współrzędnej X
     */
	public void setX(float x) {
		this.x = x;
	}
	  /**
     * Zwraca współrzędną Y punktu.
     * 
     * @return współrzędna Y
     */
	public float getY() {
		return y;
	}
	   /**
     * Ustawia współrzędną Y punktu.
     * 
     * @param y nowa wartość współrzędnej Y
     */
	public void setY(float y) {
		this.y = y;
	}
	 /**
     * Dodaje współrzędne innego punktu do bieżącego punktu.
     * 
     * @param p2 punkt, którego współrzędne mają zostać dodane
     */
	public void add(Point p2) 
	{
		if (p2 == null)
		{
		return;
				
		}
		moveX(p2.x);
		moveY(p2.y);
		
	}
	  /**
     * Odejmuje współrzędne innego punktu od bieżącego punktu.
     * 
     * @param p2 punkt, którego współrzędne mają zostać odjęte
     */
	public void sub(Point p2) 
	{
		if (p2 == null)
		{
		return;
				
		}
		moveX(-p2.x);
		moveY(-p2.y);
		
	}
	  /**
     * Tworzy nowy punkt będący sumą bieżącego punktu i podanego punktu.
     * 
     * @param p2 punkt do dodania
     * @return nowy punkt reprezentujący sumę współrzędnych
     */
	public Point addAndCreate(Point p2) 
	{
		if (p2 == null)
			return null;
		Point pt1=new Point(this.x,this.y);
		pt1.add(p2);
		return pt1;		
	}
	
	
	
}
