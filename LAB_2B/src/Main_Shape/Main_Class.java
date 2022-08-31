package Main_Shape;
import java.util.Scanner;
import Shape.Square;
import Shape.Triangle;
import Shape.Circle;

public class Main_Class extends Square {
	

	public Main_Class(float side) {
		super(side);
		// TODO Auto-generated constructor stub
	}

	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("-----MENU-----");
		System.out.println("1. Square");
		System.out.println("2. Triangle");
		System.out.println("3. Circle");
		System.out.println("4. Exit");
		
		while(true)
		{
			System.out.print("Enter your choice : ");
			int ch = sc.nextInt();
			
			if(ch==1)
			{
				System.out.print("Enter the side for a Square : ");
				float side = sc.nextFloat();
				Square s1 = new Square(side);
				Square.perimeter(side);
				s1.area();
				
			}
			else if(ch==2)
			{
				System.out.print("Enter the side1 for a Triangle : ");
				float side1 = sc.nextFloat();
				
				System.out.print("Enter the side2 for a Triangle : ");
				float side2 = sc.nextFloat();
				
				System.out.print("Enter the base for a Triangle : ");
				float base = sc.nextFloat();
				
				System.out.print("Enter the height for a Triangle : ");
				float height = sc.nextFloat();
				
				Triangle t1 = new Triangle(side1, side2, base, height);
				
				t1.perimeter();
				t1.area();
			}
			else if(ch==3)
			{
				System.out.print("Enter the Radius for a Circle : ");
				float radius = sc.nextFloat();
				Circle c1 = new Circle(radius);
				c1.circumference();
				double ans = c1.area();
				System.out.println("The Area of a Square is : "+ans);
			}
			else if(ch==4)
				break;
			else
				System.out.println("Invalid Choice");
		}
	}
}
