package Shape;

public class Triangle {
	float side1,side2,base,height;
	float ans;
	public Triangle(float side1, float side2, float base, float height)
	{
		this.side1 = side1;
		this.side2 = side2;
		this.base = base;
		this.height = height;
	}
	
	public void perimeter()
	{
		ans = this.side1+this.side2+this.base;
		System.out.println("The Perimeter of a Square is : "+ans);
	}
	
	public void area()
	{
		ans = (this.height * this.base)/2;
		System.out.println("The Area of a Square is : "+ans);
	}

}
