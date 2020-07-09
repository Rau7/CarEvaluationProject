import java.util.HashMap;

public class LevelFourPrint {
	
	ConnectionOfDB ct;
	HashMap<String, String[]> attrs;

	int for2 = 0;
	int for3 = 0;
	
	
	public LevelFourPrint(ConnectionOfDB connection, HashMap<String, String[]> attrs) {
		this.ct = connection;
		this.attrs = attrs;
	}
	
	public HashMap<String, String> printLevelFour(HashMap<String, String> lvl2, HashMap<String, String> lvl3) {
	HashMap<String,String> levelFourHash = new HashMap();
	HashMap<String,String> levelfourPrint = new HashMap();
	HashMap<String,String> lvlthree = lvl3;
	HashMap<String,String> lvltwo = lvl2;
	
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
														   levelFourHash.put("["+entry.getKey()+"-"+entry.getValue()[ctr]+"]+["+entry2.getKey()+"-"+entry2.getValue()[ctr2]+"]+["+entry3.getKey()+"-"+entry3.getValue()[k]+"] maint", levelfour.getResult(entry.getValue()[ctr].toString(),entry2.getValue()[ctr2].toString(),entry3.getValue()[k]));
													   }
													   else {
														   levelFourHash.put("["+entry.getKey()+"-"+entry.getValue()[ctr]+"]+["+entry2.getKey()+"-"+entry2.getValue()[ctr2]+"]+["+entry3.getKey()+"-"+entry3.getValue()[k]+"] maint", Double.toString(levelfour.maintInfoGain));
													   }
													   if(levelfour.doorsInfoGain == 0) {
														   levelFourHash.put("["+entry.getKey()+"-"+entry.getValue()[ctr]+"]+["+entry2.getKey()+"-"+entry2.getValue()[ctr2]+"]+["+entry3.getKey()+"-"+entry3.getValue()[k]+"] doors", levelfour.getResult(entry.getValue()[ctr].toString(),entry2.getValue()[ctr2].toString(),entry3.getValue()[k]));
													   }
													   else {
														   levelFourHash.put("["+entry.getKey()+"-"+entry.getValue()[ctr]+"]+["+entry2.getKey()+"-"+entry2.getValue()[ctr2]+"]+["+entry3.getKey()+"-"+entry3.getValue()[k]+"] doors", Double.toString(levelfour.doorsInfoGain));
													   }
													   if(levelfour.lvg_bootInfoGain == 0) {
														   levelFourHash.put("["+entry.getKey()+"-"+entry.getValue()[ctr]+"]+["+entry2.getKey()+"-"+entry2.getValue()[ctr2]+"]+["+entry3.getKey()+"-"+entry3.getValue()[k]+"] lvg_boot", levelfour.getResult(entry.getValue()[ctr].toString(),entry2.getValue()[ctr2].toString(),entry3.getValue()[k]));
													   }
													   else {
														   levelFourHash.put("["+entry.getKey()+"-"+entry.getValue()[ctr]+"]+["+entry2.getKey()+"-"+entry2.getValue()[ctr2]+"]+["+entry3.getKey()+"-"+entry3.getValue()[k]+"] lvg_boot", Double.toString(levelfour.lvg_bootInfoGain));
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
		
		
		filter3.entrySet().forEach(entry->{
				if((entry.getValue().toString().contains("acc") || entry.getValue().toString().contains("unacc") || entry.getValue().toString().contains("good") || entry.getValue().toString().contains("vgood")) ) {
					levelfourPrint.put(entry.getKey().toString().substring(0,entry.getKey().toString().lastIndexOf("]")+1), entry.getValue());
			     
				}
		 });
		
		return levelfourPrint;
	}

}
