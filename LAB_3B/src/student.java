import java.util.Scanner;
import java.sql.*;

class MyException extends Exception
{
	//private static final long serialVersionUID = 254947356867821302L;

	MyException(String MyException)
	{
		System.out.println(MyException);
	}
}

public class student {
	Connection con = null;
	Scanner sc =new Scanner(System.in);
	public Connection getConnect() throws SQLException, Exception
	{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/java_3a","root","password");
		return con;
	}
	public void insert()
	{
		try
		{
			System.out.println("Enter Student USN : ");
			String usn = sc.next();
			if(usn.equalsIgnoreCase("1")) {
				throw new MyException("usn is empty");
			}
			
			System.out.println("Enter student Name : ");
			String name = sc.next();
			
			System.out.println("Enter student Address : ");
			String addr = sc.next();
			
			con=getConnect();
			String query = "insert into stud values(?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, usn);
			ps.setString(2, name);
			ps.setString(3, addr);
			int status = ps.executeUpdate();
			System.out.println(status);
			con.close();
			
		}
		catch(SQLException e)
		{
			System.out.println("1 : "+e);
		}
		catch(Exception e)
		{
			System.out.println("2 : "+e);
		}
		finally
		{
			try {
				con.close();
			}
			catch(Exception e)
			{
				System.out.println("3 : "+e);
			}
		}
		
	}
	
	public void update()
	{
		try
		{
			String query=null;
			String edit=null;
			
			System.out.println("Enter Student USN : ");
			String usn = sc.next();
			
			System.out.println("----MENU----");
			System.out.println("1. Name");
			System.out.println("2. Address");
			System.out.println("Enter your choice to update : ");
			int ch1 = sc.nextInt();
			if(ch1==1)
			{
				System.out.print("Enter the New Name : ");
				edit = sc.next();
				query = "update stud set name = ? where USN=?";
			}
			else if (ch1==2)
			{
				System.out.println("Enter the New Address");
				edit = sc.next();
				query = "update stud set address = ? where USN=?";
				
			}
			
			
			con=getConnect();
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, edit);
			ps.setString(2, usn);
			
			int status = ps.executeUpdate();
			System.out.println(status);
			con.close();
			
		}
		catch(SQLException e)
		{
			System.out.println("1 : "+e);
		}
		catch(Exception e)
		{
			System.out.println("2 : "+e);
		}
		finally
		{
			try {
				con.close();
			}
			catch(Exception e)
			{
				System.out.println("3 : "+e);
			}
		}
		
	}
	
	
	public void delete()
	{
		try
		{
			
			System.out.println("Enter Student USN to delete : ");
			String usn = sc.next();
			
			String query = "delete from stud where USN=?";
				
			
			
			
			con=getConnect();
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, usn);
			
			int status = ps.executeUpdate();
			System.out.println(status);
			con.close();
			
		}
		catch(SQLException e)
		{
			System.out.println("1 : "+e);
		}
		catch(Exception e)
		{
			System.out.println("2 : "+e);
		}
		finally
		{
			try {
				con.close();
			}
			catch(Exception e)
			{
				System.out.println("3 : "+e);
			}
		}
		
	}
	
	public void display()
	{
		try
		{
			con=getConnect();
			Statement st = con.createStatement();
			String query = "select * from stud";
			
			ResultSet rs=st.executeQuery(query);
			
			System.out.println("USN \t NAME \t ADDRESS");
			while(rs.next())
			{
				System.out.println(rs.getString(1)+" \t "+rs.getString(2)+" \t "+rs.getString(3));
			}
				
			
	
			con.close();
			
		}
		catch(SQLException e)
		{
			System.out.println("1 : "+e);
		}
		catch(Exception e)
		{
			System.out.println("2 : "+e);
		}
		finally
		{
			try {
				con.close();
			}
			catch(Exception e)
			{
				System.out.println("3 : "+e);
			}
		}
		
	}
	
	public static void main(String args[])
	{
		Scanner sc= new Scanner(System.in);
		System.out.println("---MENU---");
		System.out.println("1. INSERT");
		System.out.println("2. UPDATE");
		System.out.println("3. DELETE");
		System.out.println("4. DISPLAY");
		System.out.println("5. EXIT");
		
		student stud = new student();
		
		while(true)
		{
			System.out.println("Enter your choice : ");
			int ch = sc.nextInt();
			
			if(ch==1)
			{
				stud.insert();
			}
			else if(ch==2)
			{
				stud.update();
			}
			else if(ch==3)
			{
				stud.delete();
			}
			else if(ch==4)
			{
				stud.display();
			}
			else if(ch==5)
				break;
			else
				System.out.println("Invalid Choice");
				
		}
		
	}
}
