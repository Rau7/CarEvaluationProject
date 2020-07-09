import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

public class LevelOnePrint {
	
	ConnectionOfDB ct;
	HashMap<String, String> tree;
	HashMap<String, String[]> attrs;
	public String root="";
	
	public double max = 0;
	public String atts = "";
	public LevelOnePrint(ConnectionOfDB connection,HashMap<String, String[]> attrs, HashMap<String, String> tree) {
		this.ct = connection;
		this.tree = tree;
		this.attrs = attrs;
	}
	
	public void printLevelOne() throws SQLException {
		LevelOne levelone = new LevelOne(ct,tree);
		
		
		
		HashMap<String,Double> leveloneHash = new HashMap();
		HashMap<String,String> levelonePrint = new HashMap();
		
		leveloneHash.put("buying", levelone.buyingInfoGain);
		leveloneHash.put("maint", levelone.maintInfoGain);
		leveloneHash.put("doors", levelone.doorsInfoGain);
		leveloneHash.put("persons", levelone.personInfoGain);
		leveloneHash.put("lvg_boot", levelone.lvg_bootInfoGain);
		leveloneHash.put("safety", levelone.safetyInfoGain);
		
		double maxValueInMap=(Collections.max(leveloneHash.values()));  
        for (Entry<String, Double> entry : leveloneHash.entrySet()) {  
            if (entry.getValue()==maxValueInMap) {
               root = entry.getKey();    
            }
        }
        
        tree.put("safety", "root");
        
        leveloneHash.entrySet().forEach(entry->{
			
		    System.out.println(entry.getKey() + " " + entry.getValue());  
		 });
		
		
		
		
		
		
		
		
	}

}
