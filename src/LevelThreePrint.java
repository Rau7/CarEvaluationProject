import java.sql.SQLException;
import java.util.HashMap;

public class LevelThreePrint {
	
	ConnectionOfDB ct;
	HashMap<String, String[]> attrs;
	HashMap<String, String> tree;
	
	
	public LevelThreePrint(ConnectionOfDB connection, HashMap<String, String[]> attrs,HashMap<String, String> tree2) {
		this.ct = connection;
		this.attrs = attrs;
		this.tree = tree2;
	}
	
	public HashMap<String, String> printLevelThree(HashMap<String, String> lvl2) {
		HashMap<String,String> levelThreeHash = new HashMap();
		HashMap<String,String> levelthreePrint = new HashMap();
		HashMap<String,String> lvltwo = lvl2;
				
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
														levelThreeHash.put("["+entry.getKey()+"-"+entry.getValue()[ctr]+"]+["+entry2.getKey()+"-"+entry2.getValue()[j]+"] buying", levelthree.getResult(entry.getValue()[ctr], entry2.getValue()[j]));
													}
													else {
														levelThreeHash.put("["+entry.getKey()+"-"+entry.getValue()[ctr]+"]+["+entry2.getKey()+"-"+entry2.getValue()[j]+"] buying", Double.toString(levelthree.buyingInfoGain));
													}
													if(levelthree.maintInfoGain == 0) {
														levelThreeHash.put("["+entry.getKey()+"-"+entry.getValue()[ctr]+"]+["+entry2.getKey()+"-"+entry2.getValue()[j]+"] maint", levelthree.getResult(entry.getValue()[ctr], entry2.getValue()[j]));
													}
													else {
														levelThreeHash.put("["+entry.getKey()+"-"+entry.getValue()[ctr]+"]+["+entry2.getKey()+"-"+entry2.getValue()[j]+"] maint", Double.toString(levelthree.maintInfoGain));
													}
													if(levelthree.doorsInfoGain == 0) {
														levelThreeHash.put("["+entry.getKey()+"-"+entry.getValue()[ctr]+"]+["+entry2.getKey()+"-"+entry2.getValue()[j]+"] doors", levelthree.getResult(entry.getValue()[ctr], entry2.getValue()[j]));
													}
													else {
														levelThreeHash.put("["+entry.getKey()+"-"+entry.getValue()[ctr]+"]+["+entry2.getKey()+"-"+entry2.getValue()[j]+"] doors", Double.toString(levelthree.doorsInfoGain));
													}
													if(levelthree.lvg_bootInfoGain == 0) {
														levelThreeHash.put("["+entry.getKey()+"-"+entry.getValue()[ctr]+"]+["+entry2.getKey()+"-"+entry2.getValue()[j]+"] lvg_boot", levelthree.getResult(entry.getValue()[ctr], entry2.getValue()[j]));
													}
													else {
														levelThreeHash.put("["+entry.getKey()+"-"+entry.getValue()[ctr]+"]+["+entry2.getKey()+"-"+entry2.getValue()[j]+"] lvg_boot", Double.toString(levelthree.lvg_bootInfoGain));
													}
													}
												
													catch (SQLException e) {
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
					lvltwo.entrySet().forEach(entry2->{
						if(!entry.getKey().toString().contains(entry2.getKey().toString()) ) {
						if((entry.getValue().toString().contains("acc") || entry.getValue().toString().contains("unacc") || entry.getValue().toString().contains("good") || entry.getValue().toString().contains("vgood"))) {
							levelthreePrint.put(entry.getKey().toString().substring(0,entry.getKey().toString().lastIndexOf("]")+1), entry.getValue());
					     
						}
						}
					});
				 });
				
				return levelthreePrint;
	}

}
