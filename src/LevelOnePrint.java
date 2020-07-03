import java.sql.SQLException;
import java.util.HashMap;

public class LevelOnePrint {
	
	ConnectionOfDB ct;

	public LevelOnePrint(ConnectionOfDB connection) {
		this.ct = connection;
	}
	
	public void printLevelOne() throws SQLException {
		LevelOne levelone = new LevelOne(ct);
		
		
		HashMap<String,Double> leveloneHash = new HashMap();
		
		leveloneHash.put("buying", levelone.buyingInfoGain);
		leveloneHash.put("maint", levelone.maintInfoGain);
		leveloneHash.put("doors", levelone.doorsInfoGain);
		leveloneHash.put("persons", levelone.personInfoGain);
		leveloneHash.put("lvg_boot", levelone.lvg_bootInfoGain);
		leveloneHash.put("safety", levelone.safetyInfoGain);
		
		
		leveloneHash.entrySet().forEach(entry->{
		    System.out.println(entry.getKey() + " " + entry.getValue());  
		 });
	}

}
