package TEST;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.*;
public class Test {
	public static void main(String[] args) {
		int re=1;
		Scanner sc=new Scanner(System.in);
		while(re==1)
		{
			System.out.println("1 : Insert student data");
			System.out.println("2 : Update student data");
			System.out.println("3 : Delate student data");
			System.out.println("4 : List of all student data");
			System.out.println("5 : Show one student data");
			System.out.println("6 : Stop the program\n");
			int j=sc.nextInt();
			switch(j) {
			case 1:
			{
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
			        Connection con=DriverManager.getConnection("jdbc:mysql://localhost/test","root","P@ssword123");
			        System.out.println("connected");
				    System.out.println("Inserting records into the table..."); 
				    System.out.println("enter student no");
					int no=sc.nextInt();
				    System.out.println("enter student name");
					String name=sc.next(); 
					System.out.println("enter student dob");
					String dob=sc.next();
					System.out.println("enter student doj");
					String doj=sc.next();
					String sqlq = "INSERT INTO STUDENT(STUDENT_NO,STUDENT_DOB,STUDENT_DOJ,STUDENT_NAME) values (?, ?, ?, ?)";
		            PreparedStatement st = con.prepareStatement(sqlq);
		            st.setInt(1,no);
		            st.setString(2,dob);
		            st.setString(3,doj);
		            st.setString(4,name);
		            st.executeUpdate();
		            System.out.println("Record inserted successfully.");
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
				System.out.println();
				break;
			}
			case 2:
			{
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
				    Connection con=DriverManager.getConnection("jdbc:mysql://localhost/test","root","P@ssword123");
				    System.out.println("connected");
				    System.out.println("Inserting records  for the update"); 
				    System.out.println("enter student no");
					int no=sc.nextInt();
				    System.out.println("update enter student name");
					String name=sc.next(); 
					System.out.println("update enter student dob");
					String dob=sc.next();
					System.out.println("update enter student doj");
					String doj=sc.next();
					String sqlq = "UPDATE STUDENT SET STUDENT_DOB=?,STUDENT_DOJ=?,STUDENT_NAME=? WHERE STUDENT_NO=?";
		            PreparedStatement st = con.prepareStatement(sqlq);
		            st.setString(1,dob);
		            st.setString(2,doj);
		            st.setString(3,name);
		            st.setInt(4,no);
		            st.executeUpdate();
		            System.out.println("Record updated successfully.");
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
				System.out.println();
				break;
			}
			case 3:
			{
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
				    Connection con=DriverManager.getConnection("jdbc:mysql://localhost/test","root","P@ssword123");
				    System.out.println("connected");
				   
				    
				    System.out.println("Inserting records  for the delete"); 
				    System.out.println("enter student no");
					int no=sc.nextInt();
					String sqlq = "DELETE FROM STUDENT WHERE STUDENT_NO=?";
		            PreparedStatement st = con.prepareStatement(sqlq);
		            st.setInt(1,no);
		            st.executeUpdate();
		            System.out.println("Record delete successfully.");
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
				System.out.println();
				break;
				
			}
			case 4:
			{
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
				    Connection con=DriverManager.getConnection("jdbc:mysql://localhost/test","root","P@ssword123");
				    System.out.println("connected");
				    Statement selectStmt = con.createStatement();
				    ResultSet rs = selectStmt.executeQuery("SELECT * FROM STUDENT");
				    System.out.println("NO           DOB                DOJ           NAME");
				    while(rs.next())
			    	{
			    	    System.out.print(rs.getInt(1));
			    	    System.out.print("        ");
			    	    System.out.print(rs.getString(2));
			    	    System.out.print("        ");
			    	    System.out.print(rs.getString(3)); 
			    	    System.out.print("        ");
			    	    System.out.print(rs.getString(4)); 
			    	    System.out.println();
			    	}
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
				System.out.println();
				break;
			}
			case 5:
			{
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
				    Connection con=DriverManager.getConnection("jdbc:mysql://localhost/test","root","P@ssword123");
				    System.out.println("connected");
				    Statement selectStmt = con.createStatement();
				    System.out.println("enter student no");
					int no=sc.nextInt();
					String sqlq =("SELECT * FROM STUDENT WHERE STUDENT_NO=?");
					PreparedStatement st= con.prepareStatement(sqlq);
					st.setInt(1,no);
					ResultSet rs = st.executeQuery(); 
					System.out.println("NO           DOB                DOJ           NAME");
				    while(rs.next())
			    	{
			    	    System.out.print(rs.getInt(1));
			    	    System.out.print("        ");
			    	    System.out.print(rs.getString(2));
			    	    System.out.print("        ");
			    	    System.out.print(rs.getString(3)); 
			    	    System.out.print("        ");
			    	    System.out.print(rs.getString(4)); 
			    	    System.out.println();
			    	}
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
				System.out.println();
				break;
			}
			case 6:
				{re=2;
				System.out.println("end");
				}System.out.println();
			break;
			default:System.out.println("number is invalid ");
			}
			
		}
		
		
		
	}
  
    

}
