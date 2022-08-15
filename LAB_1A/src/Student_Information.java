import java.util.*;

public class Student_Information {
	String usn,name,address,email,branch;
	Double ad_fees, tution_fees, branch_fees, internet_fees;
	
	private void Student_Details(String usn, String name, String address, String email, String branch)
	{
		this.usn = usn;
		this.name = name;
		this.address = address;
		this.email = email;
		this.branch = branch;	
	}
	
	public Double calculate_fees(Double ad_fees,Double tution_fees,Double branch_fees,Double internet_fees)
	{
		this.ad_fees = ad_fees;
		this.tution_fees = tution_fees;
		this.branch_fees = branch_fees;
		this.internet_fees = internet_fees;
		
		Double total_fees = this.tution_fees + this.branch_fees + this.internet_fees;
		
		return total_fees;
		
	}
	
	public static void main(String args[])
	{
		Student_Information si = new Student_Information();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter Student USN : ");
        String usn = sc.next();
		 
        System.out.print("Enter Student Name : ");
        String name = sc.next();
        
        System.out.print("Enter Student Address : ");
        String address = sc.next();
        
        System.out.print("Enter Student EmailId : ");
        String email = sc.next();
        
        System.out.print("Enter Branch (CS,E&C,E&E) : ");
        String branch = sc.next();
        
        si.Student_Details(usn,name,address,email,branch);
        
        System.out.print("Enter Admission Fees : ");
        Double ad_fees = sc.nextDouble();
        
        System.out.print("Enter Tution Fees : ");
        Double tution_fees = sc.nextDouble();
        
        System.out.print("Enter Branch Fees : ");
        Double branch_fees = sc.nextDouble();
        
        System.out.print("Enter Internet Fees : ");
        Double internet_fees = sc.nextDouble();
        
        Double total_fee = si.calculate_fees(ad_fees, tution_fees, branch_fees, internet_fees);
        
        System.out.println("Total Fees : " + total_fee);
	}
}
