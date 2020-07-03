import java.util.HashMap;

public class LevelFourPrint {
	
	ConnectionOfDB ct;
	HashMap<String, String[]> attrs;

	
	
	public LevelFourPrint(ConnectionOfDB connection, HashMap<String, String[]> attrs) {
		this.ct = connection;
		this.attrs = attrs;
	}
	
	public void printLevelFour() {
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
													  
													  
													
													   LevelFour levelfour;
													   levelfour = new LevelFour(ct,entry.getValue()[ctr].toString(),entry2.getValue()[ctr2].toString(),entry3.getValue()[k]);
													   if(levelfour.maintInfoGain == 0) {
														   levelFourHash.put(entry3.getKey()+" "+entry3.getValue()[k]+" "+entry2.getKey()+" "+entry2.getValue()[ctr2]+" "+entry.getKey()+" "+entry.getValue()[ctr]+" maint", levelfour.getResult(entry.getValue()[ctr].toString(),entry2.getValue()[ctr2].toString(),entry3.getValue()[k]));
													   }
													   else {
														   levelFourHash.put(entry3.getKey()+" "+entry3.getValue()[k]+" "+entry2.getKey()+" "+entry2.getValue()[ctr2]+" "+entry.getKey()+" "+entry.getValue()[ctr]+" maint", Double.toString(levelfour.maintInfoGain));
													   }
													   if(levelfour.doorsInfoGain == 0) {
														   levelFourHash.put(entry3.getKey()+" "+entry3.getValue()[k]+" "+entry2.getKey()+" "+entry2.getValue()[ctr2]+" "+entry.getKey()+" "+entry.getValue()[ctr]+" doors", levelfour.getResult(entry.getValue()[ctr].toString(),entry2.getValue()[ctr2].toString(),entry3.getValue()[k]));
													   }
													   else {
														   levelFourHash.put(entry3.getKey()+" "+entry3.getValue()[k]+" "+entry2.getKey()+" "+entry2.getValue()[ctr2]+" "+entry.getKey()+" "+entry.getValue()[ctr]+" doors", Double.toString(levelfour.doorsInfoGain));
													   }
													   if(levelfour.lvg_bootInfoGain == 0) {
														   levelFourHash.put(entry3.getKey()+" "+entry3.getValue()[k]+" "+entry2.getKey()+" "+entry2.getValue()[ctr2]+" "+entry.getKey()+" "+entry.getValue()[ctr]+" lvg_boot", levelfour.getResult(entry.getValue()[ctr].toString(),entry2.getValue()[ctr2].toString(),entry3.getValue()[k]));
													   }
													   else {
														   levelFourHash.put(entry3.getKey()+" "+entry3.getValue()[k]+" "+entry2.getKey()+" "+entry2.getValue()[ctr2]+" "+entry.getKey()+" "+entry.getValue()[ctr]+" lvg_boot", Double.toString(levelfour.lvg_bootInfoGain));
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
		
		
		levelFourHash.entrySet().forEach(entry->{
			if(entry.getValue().toString().contains("acc") && !entry.getValue().toString().contains("unacc")) {
		    System.out.println(entry.getKey() + " " + entry.getValue());  
			}
		 });
	}

}
