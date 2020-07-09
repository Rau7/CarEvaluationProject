import java.sql.SQLException;
import java.util.HashMap;

public class LevelSevenPrint {
	
	ConnectionOfDB ct;
	HashMap<String, String[]> attrs;

	int for2 = 0;
	int for3 = 0;
	int for4 = 0;
	int for5 = 0;
	int for6 = 0;
	
	public LevelSevenPrint(ConnectionOfDB connection, HashMap<String, String[]> attrs) {
		this.ct = connection;
		this.attrs = attrs;
	}
	
	public HashMap<String, String> printLevelSeven(HashMap<String, String> lvl2, HashMap<String, String> lvl3, HashMap<String, String> lvl4, HashMap<String, String> lvl5, HashMap<String, String> lvl6) {
		HashMap<String,String> levelFourHash = new HashMap();
		HashMap<String,String> levelsevenPrint = new HashMap();
		
		HashMap<String,String> lvlthree = lvl3;
		HashMap<String,String> lvltwo = lvl2;
		HashMap<String,String> lvlfour = lvl4;
		HashMap<String,String> lvlfive = lvl5;
		HashMap<String,String> lvlsix = lvl6;
				
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
																						   for (int b = 0; b < entry5.getValue().length; b++) {
																							   int ctr5 = b;
																							   attrs.entrySet().forEach(entry6->{
																								   if(entry6.getKey().equals("doors")) {
																									   
																									   
																										   for (int x = 0; x < entry6.getValue().length; x++) {
																											   LevelSeven levelseven;
																											   try {
																												levelseven = new LevelSeven(ct,entry.getValue()[ctr].toString(),entry2.getValue()[ctr2].toString(),entry3.getValue()[ctr3],entry4.getValue()[ctr4],entry5.getValue()[ctr5],entry6.getValue()[x]);
																											
																											   
																											   
																												
																													levelFourHash.put("["+entry.getKey()+"-"+entry.getValue()[ctr]+"]+["+entry2.getKey()+"-"+entry2.getValue()[ctr2]+"]+["+entry3.getKey()+"-"+entry3.getValue()[ctr3]+"]+["+entry4.getKey()+"-"+entry4.getValue()[ctr4]+"]+["+entry5.getKey()+"-"+entry5.getValue()[ctr5]+"]+["+entry6.getKey()+"-"+entry6.getValue()[x]+"]", levelseven.getResult(entry.getValue()[ctr].toString(),entry2.getValue()[ctr2].toString(),entry3.getValue()[ctr3],entry4.getValue()[ctr4],entry5.getValue()[ctr5],entry6.getValue()[x]));
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
				
				
				HashMap<String,String> filter2 = new HashMap();
				
				levelFourHash.entrySet().forEach(entry->{
					for2 = 0;
					lvltwo.entrySet().forEach(entry2->{
						String a = entry2.getKey().toString();
						if(entry.getKey().toString().contains(a)) {
							for2++;
						}
					});
					if(for2==0) {
						filter2.put(entry.getKey(), entry.getValue());
					}
				});
				
				
				
				HashMap<String,String> filter3 = new HashMap();
				
				filter2.entrySet().forEach(entry->{
					for3 = 0;
					lvlthree.entrySet().forEach(entry2->{
						String a = entry2.getKey().toString();
						if(entry.getKey().toString().contains(a)) {
							for3++;
						}
					});
					if(for3==0) {
						filter3.put(entry.getKey(), entry.getValue());
					}
				});
				
				
				HashMap<String,String> filter4 = new HashMap();
				
				filter3.entrySet().forEach(entry->{
					for4 = 0;
					lvlfour.entrySet().forEach(entry2->{
						String a = entry2.getKey().toString();
						if(entry.getKey().toString().contains(a)) {
							for4++;
						}
					});
					if(for4==0) {
						filter4.put(entry.getKey(), entry.getValue());
					}
				});
				
				HashMap<String,String> filter5 = new HashMap();
				
				filter4.entrySet().forEach(entry->{
					for5 = 0;
					lvlfive.entrySet().forEach(entry2->{
						String a = entry2.getKey().toString();
						if(entry.getKey().toString().contains(a)) {
							for5++;
						}
					});
					if(for5==0) {
						filter5.put(entry.getKey(), entry.getValue());
					}
				});
				
				HashMap<String,String> filter6 = new HashMap();
				
				filter5.entrySet().forEach(entry->{
					for6 = 0;
					lvlsix.entrySet().forEach(entry2->{
						String a = entry2.getKey().toString();
						if(entry.getKey().toString().contains(a)) {
							for6++;
						}
					});
					if(for6==0) {
						filter6.put(entry.getKey(), entry.getValue());
					}
				});
				
				
				filter6.entrySet().forEach(entry->{
					if(entry.getValue().toString().contains("acc") || entry.getValue().toString().contains("unacc") || entry.getValue().toString().contains("good") || entry.getValue().toString().contains("vgood") ) {
						levelsevenPrint.put(entry.getKey().toString().substring(0,entry.getKey().toString().lastIndexOf("]")+1), entry.getValue());
				     
					}
				 });
				
				return levelsevenPrint;
	}

}
