import java.sql.SQLException;
import java.util.HashMap;

public class LevelThreePrint {
	
	ConnectionOfDB ct;
	HashMap<String, String[]> attrs;

	
	
	public LevelThreePrint(ConnectionOfDB connection, HashMap<String, String[]> attrs) {
		this.ct = connection;
		this.attrs = attrs;
	}
	
	public void printLevelThree() {
		HashMap<String,String> levelThreeHash = new HashMap();
				
				attrs.entrySet().forEach(entry->{
					if(entry.getKey().equals("safety")) {
						try {
							for (int i = 0; i < entry.getValue().length; i++) {
							
								int ctr = i;
									attrs.entrySet().forEach(entry2->{
										   if(entry2.getKey().equals("persons")) {
											   for (int j = 0; j < entry.getValue().length; j++) {
												   
												  
												try {
													LevelThree levelthree;
													levelthree = new LevelThree(ct,entry.getValue()[ctr].toString(),entry2.getValue()[j].toString());
													
													if(levelthree.buyingInfoGain == 0) {
														levelThreeHash.put(entry2.getKey()+" "+entry2.getValue()[j]+" "+entry.getKey()+" "+entry.getValue()[ctr]+" buying", levelthree.getResult(entry.getValue()[ctr], entry2.getValue()[j]));
													}
													else {
														levelThreeHash.put(entry2.getKey()+" "+entry2.getValue()[j]+" "+entry.getKey()+" "+entry.getValue()[ctr]+" buying", Double.toString(levelthree.buyingInfoGain));
													}
													if(levelthree.maintInfoGain == 0) {
														levelThreeHash.put(entry2.getKey()+" "+entry2.getValue()[j]+" "+entry.getKey()+" "+entry.getValue()[ctr]+" maint", levelthree.getResult(entry.getValue()[ctr], entry2.getValue()[j]));
													}
													else {
														levelThreeHash.put(entry2.getKey()+" "+entry2.getValue()[j]+" "+entry.getKey()+" "+entry.getValue()[ctr]+" maint", Double.toString(levelthree.maintInfoGain));
													}
													if(levelthree.doorsInfoGain == 0) {
														levelThreeHash.put(entry2.getKey()+" "+entry2.getValue()[j]+" "+entry.getKey()+" "+entry.getValue()[ctr]+" doors", levelthree.getResult(entry.getValue()[ctr], entry2.getValue()[j]));
													}
													else {
														levelThreeHash.put(entry2.getKey()+" "+entry2.getValue()[j]+" "+entry.getKey()+" "+entry.getValue()[ctr]+" doors", Double.toString(levelthree.doorsInfoGain));
													}
													if(levelthree.lvg_bootInfoGain == 0) {
														levelThreeHash.put(entry2.getKey()+" "+entry2.getValue()[j]+" "+entry.getKey()+" "+entry.getValue()[ctr]+" lvg_boot", levelthree.getResult(entry.getValue()[ctr], entry2.getValue()[j]));
													}
													else {
														levelThreeHash.put(entry2.getKey()+" "+entry2.getValue()[j]+" "+entry.getKey()+" "+entry.getValue()[ctr]+" lvg_boot", Double.toString(levelthree.lvg_bootInfoGain));
													}
												} catch (SQLException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
												   
											   }
										   }
									
								
									});
								
								
							}
						}
						catch (Exception e) {
							// TODO: handle exception
						}
					 
					}
					
				 });
				
				
				levelThreeHash.entrySet().forEach(entry->{
				    System.out.println(entry.getKey() + " " + entry.getValue());  
				 });
	}

}
