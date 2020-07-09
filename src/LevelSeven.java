import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LevelSeven {
	
	ConnectionOfDB connection;
	
	Connection con;
	Statement stmt;
	ResultSet rs;
	
	String safety;
	String person;
	String buying;
	String maint;
	String lvg_boot;
	String doors;
	
	

	public LevelSeven(ConnectionOfDB connection,String safety, String person, String buying, String maint, String lvg_boot,String doors) throws SQLException {
		
		this.safety = safety;
		this.person = person;
		this.buying = buying;
		this.maint = maint;
		this.lvg_boot = lvg_boot;
		this.doors = doors;
		
		
		this.connection = connection;
		rs = this.connection.rs;
		stmt = this.connection.stmt;
		

		
	}
	
	
	public String getResult(String string, String string2, String string3, String string4, String string5,String string6) throws SQLException {
		
		String result = "";
		rs = stmt.executeQuery("select class from carevaluation where safety='"+string+"' and persons='"+string2+"' and buying='"+string3+"' and maint='"+string4+"' and lvg_boot='"+string5+"' and doors='"+string6+"'");
		while(rs.next())
		{
		   result=rs.getString(1);
		} 
		
		
		
		return result;
	}

}

