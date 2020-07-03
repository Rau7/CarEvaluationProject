import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LevelOne {
	
	ConnectionOfDB connection;
	
	Connection con;
	Statement stmt;
	ResultSet rs;
	
	
	double totalEntry;
	
	double systemEntropy;
	double buyingInfoGain;
	double maintInfoGain;
	double doorsInfoGain;
	double personInfoGain;
	double lvg_bootInfoGain;
	double safetyInfoGain;

	public LevelOne(ConnectionOfDB connection) throws SQLException {
		
		this.connection = connection;
		rs = this.connection.rs;
		stmt = this.connection.stmt;
		
		totalEntry = getEntryNumber(true, "", "", "", "", "", "","");
		systemEntropy = getEntropy(true, "", "", "", "","","","");
		buyingInfoGain = getBuyingInfoGain();
		maintInfoGain = getMaintInfoGain();
		doorsInfoGain = getDoorsInfoGain();
		personInfoGain = getPersonInfoGain();
		lvg_bootInfoGain = getLvgBootInfoGain();
		safetyInfoGain = getSafetyInfoGain();
		
		
		
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
		
		double vhighratio = getEntryNumber(false, "vhigh", "", "", "", "", "", "") / totalEntry;
		double highratio = getEntryNumber(false, "high", "", "", "", "", "", "") / totalEntry;
		double medratio = getEntryNumber(false, "med", "", "", "", "", "", "") / totalEntry;
		double lowratio = getEntryNumber(false, "low", "", "", "", "", "", "") / totalEntry;
		
		
		
		double vhigh = vhighratio * getEntropy(false, "vhigh", "", "", "", "", "", "");
		double high = highratio * getEntropy(false, "high", "", "", "", "", "", "");
		double med = medratio * getEntropy(false, "med", "", "", "", "", "", "");
		double low = lowratio * getEntropy(false, "low", "", "", "", "", "", "");
		
		
		return systemEntropy - (vhigh + high + med + low);
	}
	
	public double getMaintInfoGain() throws SQLException {
		double vhighratio = getEntryNumber(false, "", "vhigh", "", "", "", "", "") / totalEntry;
		double highratio = getEntryNumber(false, "", "high", "", "", "", "", "") / totalEntry;
		double medratio = getEntryNumber(false, "", "med", "", "", "", "", "") / totalEntry;
		double lowratio = getEntryNumber(false, "", "low", "", "", "", "", "") / totalEntry;
		
		
		
		double vhigh = vhighratio * getEntropy(false, "", "vhigh", "", "", "", "", "");
		double high = highratio * getEntropy(false, "", "high", "", "", "", "", "");
		double med = medratio * getEntropy(false, "", "med", "", "", "", "", "");
		double low = lowratio * getEntropy(false, "", "low", "", "", "", "", "");
		
		
		return systemEntropy - (vhigh + high + med + low);
	}
	
	public double getDoorsInfoGain() throws SQLException {
		double tworatio = getEntryNumber(false, "", "", "2", "", "", "", "") / totalEntry;
		double threeratio = getEntryNumber(false, "", "", "3", "", "", "", "") / totalEntry;
		double fourratio = getEntryNumber(false, "", "", "4", "", "", "", "") / totalEntry;
		double moreratio = getEntryNumber(false, "", "", "0", "", "", "", "") / totalEntry;
		
		
		
		double vhigh = tworatio * getEntropy(false, "", "", "2", "", "", "", "");
		double high = threeratio * getEntropy(false, "", "", "3", "", "", "", "");
		double med = fourratio * getEntropy(false, "", "", "4", "", "", "", "");
		double low = moreratio * getEntropy(false, "", "", "0", "", "", "", "");
		
		
		return systemEntropy - (vhigh + high + med + low);
	}
	
	public double getPersonInfoGain() throws SQLException {
		double tworatio = getEntryNumber(false, "", "", "", "2", "", "", "") / totalEntry;
		double fourratio = getEntryNumber(false, "", "", "", "4", "", "", "") / totalEntry;
		double moreratio = getEntryNumber(false, "", "", "", "0", "", "", "") / totalEntry;
		
		
		
		double vhigh = tworatio * getEntropy(false, "", "", "", "2", "", "", "");
		double med = fourratio * getEntropy(false, "", "", "", "4", "", "", "");
		double low = moreratio * getEntropy(false, "", "", "", "0", "", "", "");
		
		
		return systemEntropy - (vhigh + med + low);
	}
	
	public double getLvgBootInfoGain() throws SQLException {
		double bigratio = getEntryNumber(false, "", "", "", "", "big", "", "") / totalEntry;
		double medratio = getEntryNumber(false, "", "", "", "", "med", "", "") / totalEntry;
		double smallratio = getEntryNumber(false, "", "", "", "", "small", "", "") / totalEntry;
		
		
		
		double vhigh = bigratio * getEntropy(false, "", "", "", "", "big", "", "");
		double med = medratio * getEntropy(false, "", "", "", "", "med", "", "");
		double low = smallratio * getEntropy(false, "", "", "", "", "small", "", "");
		
		
		return systemEntropy - (vhigh + med + low);
	}
	
	public double getSafetyInfoGain() throws SQLException {
		double bigratio = getEntryNumber(false, "", "", "", "", "", "high", "") / totalEntry;
		double medratio = getEntryNumber(false, "", "", "", "", "", "med", "") / totalEntry;
		double smallratio = getEntryNumber(false, "", "", "", "", "", "low", "") / totalEntry;
		
		
		
		double vhigh = bigratio * getEntropy(false, "", "", "", "", "", "high", "");
		double med = medratio * getEntropy(false, "", "", "", "", "", "med", "");
		double low = smallratio * getEntropy(false, "", "", "", "", "", "low", "");
		
		
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
	
	

	public double log2(double N) 
    { 
        return (Math.log(N) / Math.log(2)); 
    }

}
