import java.util.Scanner;
import java.sql.*;
public class student {
	Connection con = null;
	Scanner sc=new Scanner(System.in);
	public Connection getConnect()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
//			System.out.println("hello");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_3a","root","password");
		}
		catch(Exception e){
			System.out.println(e);
		}
		return con;
	}
	public void insert()
	{
		try {
			String usn,name,address;
			
			System.out.print("Enter Student USN : ");
			usn = sc.next();
			
			System.out.print("Enter Student Name : ");
			name = sc.next();
			
			System.out.print("Enter Student Address : ");
			address = sc.next();
			
			con = getConnect();
			Statement st = con.createStatement();
			String query = "insert into STUDENT_TB values('" + usn + "','" + name + "','" + address + "')";
			st.executeUpdate(query);
			
			con.close();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public void update()
	{
		try {
			con=getConnect();
			Statement st = con.createStatement();
			String query = null;
			
			System.out.print("Enter the USN : ");
			String usn = sc.next();
			
			System.out.println("----MENU----");
			System.out.println("1. Name");
			System.out.println("2. Address");
			System.out.println("Enter your choice : ");
			int ch1 = sc.nextInt();
			if(ch1==1)
			{
				System.out.print("Enter the New Name : ");
				String name = sc.next();
				query = "update STUDENT_TB set Name = '"+name+"' where USN='"+usn+"'";
			}
			else if (ch1==2)
			{
				System.out.println("Enter the New Address");
				String address = sc.next();
				query = "update STUDENT_TB set Address = '"+address+"' where USN='"+usn+"'";
				
			}
			st.executeUpdate(query);
			con.close();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public void delete()
	{
		try {
			System.out.print("Enter the USN to delete the Record : ");
			String usn = sc.next();
			
			con = getConnect();
			Statement st=con.createStatement();

			String query = "delete from STUDENT_TB where USN='"+usn+"'";
			st.executeUpdate(query);
			
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public void display()
	{
		try {
			con=getConnect();
			Statement st=con.createStatement();
			String query = "select * from STUDENT_TB";
			ResultSet rs = st.executeQuery(query);
			System.out.println("USN \t NAME \t ADDRESS");
			while(rs.next())
			{
				System.out.println(rs.getString(1)+" \t "+rs.getString(2)+" \t "+rs.getString(3));
			}
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		student s1 = new student();
		System.out.println("-----MENU------");
		System.out.println("1. Insert");
		System.out.println("2. Update");
		System.out.println("3. Delete");
		System.out.println("4. Display");
		System.out.println("5. EXit");
		
		while(true)
		{
			System.out.println("Enter the Choice : ");
			int ch = sc.nextInt();
			
			if(ch==1)
			{
				s1.insert();
			}
			else if(ch==2)
			{
				s1.update();
			}
			else if(ch==3)
			{
				s1.delete();
			}
			else if(ch==4)
			{
				s1.display();
			}
			else if(ch==5)
				System.exit(0);
			else
				System.out.println("Invalid Choice");
		}
		
	}

}
