import java.sql.SQLException;
import java.util.HashMap;

public class LevelTwoPrint {
	
	ConnectionOfDB ct;
	HashMap<String, String[]> attrs;

	
	
	public LevelTwoPrint(ConnectionOfDB connection, HashMap<String, String[]> attrs) {
		this.ct = connection;
		this.attrs = attrs;
	}

	public void printLevelTwo() {
		HashMap<String,String> leveltwoHash = new HashMap();
		
		attrs.entrySet().forEach(entry->{
			if(entry.getKey().equals("safety")) {
					for (int i = 0; i < entry.getValue().length; i++) {
						try {
							
							LevelTwo leveltwo= new LevelTwo(ct,entry.getValue()[i].toString());
							if(leveltwo.buyingInfoGain == 0) {
								leveltwoHash.put(entry.getValue()[i]+" "+entry.getKey()+" buying", leveltwo.getResult(entry.getValue()[i]));
							}
							else {
								leveltwoHash.put(entry.getValue()[i]+" "+entry.getKey()+" buying", Double.toString(leveltwo.buyingInfoGain));
							}
							if(leveltwo.maintInfoGain == 0) {
								leveltwoHash.put(entry.getValue()[i]+" "+entry.getKey()+" maint", leveltwo.getResult(entry.getValue()[i]));
							}
							else {
								leveltwoHash.put(entry.getValue()[i]+" "+entry.getKey()+" maint", Double.toString(leveltwo.maintInfoGain));
							}
							if(leveltwo.doorsInfoGain == 0) {
								leveltwoHash.put(entry.getValue()[i]+" "+entry.getKey()+" doors", leveltwo.getResult(entry.getValue()[i]));
							}
							else {
								leveltwoHash.put(entry.getValue()[i]+" "+entry.getKey()+" doors", Double.toString(leveltwo.doorsInfoGain));
							}
							if(leveltwo.personInfoGain == 0) {
								leveltwoHash.put(entry.getValue()[i]+" "+entry.getKey()+" persons", leveltwo.getResult(entry.getValue()[i]));
							}
							else {
								leveltwoHash.put(entry.getValue()[i]+" "+entry.getKey()+" persons", Double.toString(leveltwo.personInfoGain));
							}
							if(leveltwo.lvg_bootInfoGain == 0) {
								leveltwoHash.put(entry.getValue()[i]+" "+entry.getKey()+" lvg_boot", leveltwo.getResult(entry.getValue()[i]));
							}
							else {
								leveltwoHash.put(entry.getValue()[i]+" "+entry.getKey()+" lvg_boot", Double.toString(leveltwo.lvg_bootInfoGain));
							}
					
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				 
			}
			
		 });
		
		
		leveltwoHash.entrySet().forEach(entry->{
		    System.out.println(entry.getKey() + " " + entry.getValue());  
		 });
	}

}
