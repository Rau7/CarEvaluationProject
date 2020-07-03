import java.util.HashMap;

public class LevelFivePrint {
	
	ConnectionOfDB ct;
	HashMap<String, String[]> attrs;

	
	
	public LevelFivePrint(ConnectionOfDB connection, HashMap<String, String[]> attrs) {
		this.ct = connection;
		this.attrs = attrs;
	}
	
	public void printLevelFive() {
		HashMap<String,String> levelFourHash = new HashMap();
				
				attrs.entrySet().forEach(entry->{
					if(entry.getKey().equals("safety")) {
						try {
							for (int i = 0; i < entry.getValue().length; i++) {
							
								int ctr = i;
									attrs.entrySet().forEach(entry2->{
										   if(entry2.getKey().equals("persons")) {
											   
											   
											   try {
											   for (int j = 0; j < entry2.getValue().length; j++) {
												   int ctr2 = j;
												  
												
												   attrs.entrySet().forEach(entry3->{
													   if(entry3.getKey().equals("buying")) {
														   
														  
														   try {
														   for (int k = 0; k < entry3.getValue().length; k++) {
															   int ctr3 = k;
															   
															   attrs.entrySet().forEach(entry4->{
																   if(entry4.getKey().equals("maint")) {
																	   
																	   try {
																		   for (int m = 0; m < entry4.getValue().length; m++) {
																			   LevelFive levelfive;
																			   levelfive = new LevelFive(ct,entry.getValue()[ctr].toString(),entry2.getValue()[ctr2].toString(),entry3.getValue()[ctr3],entry4.getValue()[m]);
																			   
																			   if(levelfive.doorsInfoGain == 0 || levelfive.doorsInfoGain == 1) {
																				   levelFourHash.put(entry4.getKey()+" "+entry4.getValue()[m]+" "+entry3.getKey()+" "+entry3.getValue()[ctr3]+" "+entry2.getKey()+" "+entry2.getValue()[ctr2]+" "+entry.getKey()+" "+entry.getValue()[ctr]+" doors", levelfive.getResult(entry.getValue()[ctr].toString(),entry2.getValue()[ctr2].toString(),entry3.getValue()[ctr3],entry4.getValue()[m]));
																			   }
																			   else {
																				   levelFourHash.put(entry4.getKey()+" "+entry4.getValue()[m]+" "+entry3.getKey()+" "+entry3.getValue()[ctr3]+" "+entry2.getKey()+" "+entry2.getValue()[ctr2]+" "+entry.getKey()+" "+entry.getValue()[ctr]+" doors", Double.toString(levelfive.doorsInfoGain));
																			   }
																			   if(levelfive.lvg_bootInfoGain == 0 || levelfive.lvg_bootInfoGain == 1) {
																				   levelFourHash.put(entry4.getKey()+" "+entry4.getValue()[m]+" "+entry3.getKey()+" "+entry3.getValue()[ctr3]+" "+entry2.getKey()+" "+entry2.getValue()[ctr2]+" "+entry.getKey()+" "+entry.getValue()[ctr]+" lvg_boot", levelfive.getResult(entry.getValue()[ctr].toString(),entry2.getValue()[ctr2].toString(),entry3.getValue()[ctr3],entry4.getValue()[m]));
																			   }
																			   else {
																				   levelFourHash.put(entry4.getKey()+" "+entry4.getValue()[m]+" "+entry3.getKey()+" "+entry3.getValue()[ctr3]+" "+entry2.getKey()+" "+entry2.getValue()[ctr2]+" "+entry.getKey()+" "+entry.getValue()[ctr]+" lvg_boot", Double.toString(levelfive.lvg_bootInfoGain));
																			   }
																				
																		
																		}
																	   }
																	   catch (Exception e) {
																		// TODO: handle exception
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
												
												   
											   }
											   }
											   catch (Exception e) {
												// TODO: handle exception
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
				
				
				levelFourHash.entrySet().forEach(entry->{
					if((entry.getValue().toString().contains("acc") && !entry.getValue().toString().contains("unacc")) || entry.getValue().toString().substring(entry.getValue().toString().length()-4).equals("vgood")) {
						System.out.println(entry.getKey() + " " + entry.getValue());  
					}
				    
				 });
	}

}
