package Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Assesment3 {
	public static void main(String[] args) throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Abc","root","Mriganka");
		
		PreparedStatement pst1 = con.prepareStatement("select workerID,firstname,lastname from Worker_Table");
		PreparedStatement pst2 = con.prepareStatement("select distinct dept from Worker_Table");
		PreparedStatement pst3 = con.prepareStatement("select instr(firstname, binary'a') from Worker_Table where firstname = 'Amitabh'");
		
		ResultSet rs1 = pst1.executeQuery();
		ResultSet rs2 = pst2.executeQuery();
		ResultSet rs3 = pst3.executeQuery();
		
		while(rs1.next()) {
			System.out.println(rs1.getString(2).toUpperCase()+" "+rs1.getString(3).toUpperCase());
		}
		pst1.execute();
		System.out.println("");
		System.out.println("");
		
		while(rs2.next()) {
			System.out.println("Department: "+rs2.getString(1));
		}
		pst2.execute();
		System.out.println("");
		System.out.println("");
		
		while(rs3.next()) {
			System.out.println("Postion of a is: "+rs3.getInt(1));
		}
		pst3.execute();
		System.out.println("");
		System.out.println("");
		
		con.close();

	}

}

