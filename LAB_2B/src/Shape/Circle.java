package Shape;

public class Circle {
	float radius;
	private double ans;
	public Circle(float radius)
	{
		this.radius =radius; 
	}
	public void circumference()
	{
		ans = 2 * 3.14 * this.radius;
		System.out.println("The Perimeter of a Square is : "+ans);
	}
	
	public double area()
	{
		ans = 3.14 * this.radius * this.radius;
		return ans;		
	}
}
