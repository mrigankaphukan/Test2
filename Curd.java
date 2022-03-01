package Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.xdevapi.Statement;

public class Curd {
	public static void main(String[] args) throws Exception{
		boolean flag, flag2;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","Mriganka");
		
		PreparedStatement pst1 = con.prepareStatement("select id, name, email from users");
		ResultSet rs1 = pst1.executeQuery();
		while(rs1.next()) {
			System.out.println(rs1.getInt(1)+"  "+rs1.getString(2)+" "+rs1.getString(3));
		}
		
		System.out.println("******************************************");
		
		String cmd= "update users set name= 'Mriganka' where id='1'";
		
		PreparedStatement pst2 = con.prepareStatement("select id, name, email from users");
		
		flag = pst2.executeUpdate(cmd)>0 ? true : false;
		
		if(flag==true)
	    {
		System.out.println("Update Sussesfull..... New table is:");
		
		PreparedStatement pst3 = con.prepareStatement("select id, name, email from users");
	     ResultSet rs2 = pst3.executeQuery();
		while(rs2.next()) {
			System.out.println(rs2.getInt(1)+"  "+rs2.getString(2)+" "+rs2.getString(3));
		}
	    }
	    else
	   {
		System.out.println("unsussesfull");
	    }
		
		System.out.println("******************************************");
		
      String cmd2= "delete from users where id='3'";
		
		PreparedStatement pst4 = con.prepareStatement("select id, name, email from users");
		
		flag = pst4.executeUpdate(cmd2)>0 ? true : false;
		
		if(flag==true)
	    {
		System.out.println("Delete Sussesfull..... New table is:");
		
		PreparedStatement pst5 = con.prepareStatement("select id, name, email from users");
	     ResultSet rs3 = pst5.executeQuery();
		while(rs3.next()) {
			System.out.println(rs3.getInt(1)+"  "+rs3.getString(2)+" "+rs3.getString(3));
		}
	    }
	
		con.close();

	}
}


