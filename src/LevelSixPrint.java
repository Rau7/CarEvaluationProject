import java.util.HashMap;

public class LevelSixPrint {
	
	ConnectionOfDB ct;
	HashMap<String, String[]> attrs;

	
	
	public LevelSixPrint(ConnectionOfDB connection, HashMap<String, String[]> attrs) {
		this.ct = connection;
		this.attrs = attrs;
	}
	
	public void printLevelSix() {
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
																			   int ctr4 = m;
																			   
																			   attrs.entrySet().forEach(entry5->{
																				   if(entry5.getKey().equals("lvg_boot")) {
																					   
																					   try {
																						   for (int b = 0; b < entry.getValue().length; b++) {
																							   LevelSix levelsix;
																							   levelsix = new LevelSix(ct,entry.getValue()[ctr].toString(),entry2.getValue()[ctr2].toString(),entry3.getValue()[ctr3],entry4.getValue()[ctr4],entry5.getValue()[b]);
																							   
																							   if(levelsix.doorsInfoGain == 0 || levelsix.doorsInfoGain == 1) {
																								   levelFourHash.put(entry5.getKey()+" "+entry5.getValue()[b]+" "+entry4.getKey()+" "+entry4.getValue()[ctr4]+" "+entry3.getKey()+" "+entry3.getValue()[ctr3]+" "+entry2.getKey()+" "+entry2.getValue()[ctr2]+" "+entry.getKey()+" "+entry.getValue()[ctr]+" doors", levelsix.getResult(entry.getValue()[ctr].toString(),entry2.getValue()[ctr2].toString(),entry3.getValue()[ctr3],entry4.getValue()[ctr4],entry5.getValue()[b]));
																							   }
																							   else {
																								   levelFourHash.put(entry5.getKey()+" "+entry5.getValue()[b]+" "+entry4.getKey()+" "+entry4.getValue()[ctr4]+" "+entry3.getKey()+" "+entry3.getValue()[ctr3]+" "+entry2.getKey()+" "+entry2.getValue()[ctr2]+" "+entry.getKey()+" "+entry.getValue()[ctr]+" doors", Double.toString(levelsix.doorsInfoGain));
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
								
								
							}
						}
						catch (Exception e) {
							// TODO: handle exception
						}
					 
					}
					
				 });
				
				
				levelFourHash.entrySet().forEach(entry->{
					if(entry.getValue().toString().contains("[unacc]")) {
						System.out.println(entry.getKey() + " " + entry.getValue());  
					}
				    
				 });
	}

}
