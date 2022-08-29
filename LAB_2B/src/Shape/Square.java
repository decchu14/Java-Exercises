package Shape;


public class Square {
	float side,ans;
	public Square(float side)
	{
		this.side = side;
	}
	protected static void perimeter(float side)
	{
		float ans = side*4;
		System.out.println("The Perimeter of a Square is : "+ans);
	}
	
	public void area()
	{
		ans = this.side*this.side;
		System.out.println("The Area of a Square is : "+ans);
	}
	
	

}
