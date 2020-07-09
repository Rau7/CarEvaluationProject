import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LevelTwo {
	
	ConnectionOfDB connection;
	
	Connection con;
	Statement stmt;
	ResultSet rs;
	
	String safety;
	
	
	double totalEntry;
	
	double systemEntropy;
	double buyingInfoGain;
	double maintInfoGain;
	double doorsInfoGain;
	double personInfoGain;
	double lvg_bootInfoGain;

	public LevelTwo(ConnectionOfDB connection,String safety) throws SQLException {
		
		this.safety = safety;
		
		this.connection = connection;
		rs = this.connection.rs;
		stmt = this.connection.stmt;
		
		totalEntry = getEntryNumber(false, "", "", "", "", "",this.safety ,"");
		systemEntropy = getEntropy(false, "", "", "", "","",this.safety,"");
		buyingInfoGain = getBuyingInfoGain();
		maintInfoGain = getMaintInfoGain();
		doorsInfoGain = getDoorsInfoGain();
		personInfoGain = getPersonInfoGain();
		lvg_bootInfoGain = getLvgBootInfoGain();
		
		
		
	}
	
	
	public double  getEntropy(boolean system, String buying, String maint, String doors,String persons, String lvg_boot, String safety, String class_value) throws SQLException {
		
		double totalNumberOfEntry = 0;
		double totalVGoodEntry = 0;
		double totalGoodEntry = 0;
		double totalAccEntry = 0;
		double totalUnaccEntry = 0;
		
		double probOfVgood = 0;
		double probOfGood = 0;
		double probOfAcc = 0;
		double probOfUnacc = 0;
		
		double vgood = 0;
		double good = 0;
		double acc = 0;
		double unacc = 0;
		
		double result = 0;
		
		
			
		totalNumberOfEntry = getEntryNumber(system, buying, maint, doors,persons, lvg_boot, safety, class_value);
			
		totalVGoodEntry = getEntryNumber(false, buying, maint, doors,persons, lvg_boot, safety, "vgood");
		
		totalGoodEntry = getEntryNumber(false, buying, maint, doors,persons, lvg_boot, safety, "good");
		
		totalAccEntry = getEntryNumber(false, buying, maint, doors,persons, lvg_boot, safety, "acc");
		
		totalUnaccEntry = getEntryNumber(false, buying, maint, doors,persons, lvg_boot, safety, "unacc");
			
		
		
		probOfVgood = totalVGoodEntry / totalNumberOfEntry;
		
		probOfGood = totalGoodEntry / totalNumberOfEntry;
		
		probOfAcc = totalAccEntry / totalNumberOfEntry;
		
		probOfUnacc = totalUnaccEntry / totalNumberOfEntry;
		
		
		if(probOfVgood == 0) {
			vgood = 0;
		}
		else {
			vgood = probOfVgood * log2(probOfVgood);
		}
		if(probOfGood == 0) {
			good = 0;
		}
		else {
			good = probOfGood * log2(probOfGood);
		}
		if(probOfAcc == 0) {
			acc = 0;
		}
		else {
			acc = probOfAcc * log2(probOfAcc);
		}
		if(probOfUnacc == 0) {
			unacc = 0;
		}
		else {
			unacc = probOfUnacc * log2(probOfUnacc);
		}

		result = -vgood - good - acc - unacc;

		
		return result;
	}
	
	public double getBuyingInfoGain() throws SQLException {
		
		double vhighratio = getEntryNumber(false, "vhigh", "", "", "", "", safety, "") / totalEntry;
		double highratio = getEntryNumber(false, "high", "", "", "", "", safety, "") / totalEntry;
		double medratio = getEntryNumber(false, "med", "", "", "", "", safety, "") / totalEntry;
		double lowratio = getEntryNumber(false, "low", "", "", "", "", safety, "") / totalEntry;
		
		
		
		double vhigh = vhighratio * getEntropy(false, "vhigh", "", "", "", "", safety, "");
		double high = highratio * getEntropy(false, "high", "", "", "", "", safety, "");
		double med = medratio * getEntropy(false, "med", "", "", "", "", safety, "");
		double low = lowratio * getEntropy(false, "low", "", "", "", "", safety, "");
		
		
		return systemEntropy - (vhigh + high + med + low);
	}
	
	public double getMaintInfoGain() throws SQLException {
		double vhighratio = getEntryNumber(false, "", "vhigh", "", "", "", safety, "") / totalEntry;
		double highratio = getEntryNumber(false, "", "high", "", "", "", safety, "") / totalEntry;
		double medratio = getEntryNumber(false, "", "med", "", "", "", safety, "") / totalEntry;
		double lowratio = getEntryNumber(false, "", "low", "", "", "", safety, "") / totalEntry;
		
		
		
		double vhigh = vhighratio * getEntropy(false, "", "vhigh", "", "", "", safety, "");
		double high = highratio * getEntropy(false, "", "high", "", "", "", safety, "");
		double med = medratio * getEntropy(false, "", "med", "", "", "", safety, "");
		double low = lowratio * getEntropy(false, "", "low", "", "", "", safety, "");
		
		
		return systemEntropy - (vhigh + high + med + low);
	}
	
	public double getDoorsInfoGain() throws SQLException {
		double tworatio = getEntryNumber(false, "", "", "2", "", "", safety, "") / totalEntry;
		double threeratio = getEntryNumber(false, "", "", "3", "", "", safety, "") / totalEntry;
		double fourratio = getEntryNumber(false, "", "", "4", "", "", safety, "") / totalEntry;
		double moreratio = getEntryNumber(false, "", "", "0", "", "", safety, "") / totalEntry;
		
		
		
		double vhigh = tworatio * getEntropy(false, "", "", "2", "", "", safety, "");
		double high = threeratio * getEntropy(false, "", "", "3", "", "", safety, "");
		double med = fourratio * getEntropy(false, "", "", "4", "", "", safety, "");
		double low = moreratio * getEntropy(false, "", "", "0", "", "", safety, "");
		
		
		return systemEntropy - (vhigh + high + med + low);
	}
	
	public double getPersonInfoGain() throws SQLException {
		double tworatio = getEntryNumber(false, "", "", "", "2", "", safety, "") / totalEntry;
		double fourratio = getEntryNumber(false, "", "", "", "4", "", safety, "") / totalEntry;
		double moreratio = getEntryNumber(false, "", "", "", "0", "", safety, "") / totalEntry;
		
		
		
		double vhigh = tworatio * getEntropy(false, "", "", "", "2", "", safety, "");
		double med = fourratio * getEntropy(false, "", "", "", "4", "", safety, "");
		double low = moreratio * getEntropy(false, "", "", "", "0", "", safety, "");
		
		
		return systemEntropy - (vhigh + med + low);
	}
	
	public double getLvgBootInfoGain() throws SQLException {
		double bigratio = getEntryNumber(false, "", "", "", "", "big", safety, "") / totalEntry;
		double medratio = getEntryNumber(false, "", "", "", "", "med", safety, "") / totalEntry;
		double smallratio = getEntryNumber(false, "", "", "", "", "small", safety, "") / totalEntry;
		
		
		
		double vhigh = bigratio * getEntropy(false, "", "", "", "", "big", safety, "");
		double med = medratio * getEntropy(false, "", "", "", "", "med", safety, "");
		double low = smallratio * getEntropy(false, "", "", "", "", "small", safety, "");
		
		
		return systemEntropy - (vhigh + med + low);
	}
	
	

	
	
	public double getEntryNumber(boolean system, String buying, String maint, String doors,String persons, String lvg_boot, String safety, String class_value) throws SQLException {
		double totalNumber = 0;
		
		
		String query = "select count(*) from carevaluation";
		
		StringBuilder sb = new StringBuilder(query);
		
		if(system) {
			query = "select count(*) from carevaluation";
		}
		else {
			
			if(buying.equals("") && maint.equals("") && doors.equals("")&& persons.equals("") && lvg_boot.equals("") && safety.equals("") && class_value.equals("")) {
				query = "select count(*) from carevaluation";
			}
			else {
				sb.append(" where");
				
				if(buying.equals("")) {
					sb.append("");
				}
				else {
					sb.append(" buying = '"+buying+"'");
					sb.append(" and");
				}
				
				if(maint.equals("")) {
					sb.append("");
				}
				else {
					sb.append(" maint = '"+maint+"'");
					sb.append(" and");
				}
				
				if(doors.equals("")) {
					sb.append("");
				}
				else {
					sb.append(" doors = '"+doors+"'");
					sb.append(" and");
				}
				
				if(persons.equals("")) {
					sb.append("");
				}
				else {
					sb.append(" persons = '"+persons+"'");
					sb.append(" and");
				}
				
				if(lvg_boot.equals("")) {
					sb.append("");
				}
				else {
					sb.append(" lvg_boot = '"+lvg_boot+"'");
					sb.append(" and");
				}
				
				if(safety.equals("")) {
					sb.append("");
				}
				else {
					sb.append(" safety = '"+safety+"'");
					sb.append(" and");
				}
				
				if(class_value.equals("")) {
					sb.append("");
				}
				else {
					sb.append(" class = '"+class_value+"'");
					sb.append(" and");
				}
				query = sb.toString();
				query = query.substring(0, query.length()-4);
			}
			
		}
		
		
		rs = stmt.executeQuery(query);
		while(rs.next())
		{
		   totalNumber=Double.parseDouble(rs.getString(1));
		} 
		
		return totalNumber;
	}
	
	public String getResult(String string) throws SQLException {
		
		String result = "";
		rs = stmt.executeQuery("select class from carevaluation where safety='"+string+"'");
		while(rs.next())
		{
		   result=rs.getString(1);
		} 
		
		
		
		return result;
	}
	
	public String getResult(String string, String string2) throws SQLException {
		
		String result = "";
		rs = stmt.executeQuery("select class from carevaluation where safety='"+string+"' and persons='"+string2+"'");
		while(rs.next())
		{
		   result=rs.getString(1);
		} 
		
		
		
		return result;
	}

	public double log2(double N) 
    { 
        return (Math.log(N) / Math.log(2)); 
    }

}
