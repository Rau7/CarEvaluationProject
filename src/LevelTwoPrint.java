import java.sql.SQLException;
import java.util.HashMap;

public class LevelTwoPrint {
	
	HashMap<String, String> tree;
	ConnectionOfDB ct;
	HashMap<String, String[]> attrs;
	
	double sf_high = 0;
	double sf_med = 0;
	double sf_low = 0;
	
	String sfH = "";
	String sfL = "";
	String sfM = "";
	
	public LevelTwoPrint(ConnectionOfDB connection, HashMap<String, String[]> attrs, HashMap<String, String> tree2) {
		this.tree = tree2;
		this.ct = connection;
		this.attrs = attrs;
	}

	public HashMap<String, String> printLevelTwo(){
		HashMap<String,String> leveltwoHash = new HashMap();
		HashMap<String,String> leveltwoPrint = new HashMap();

		
		attrs.entrySet().forEach(entry->{
			if(entry.getKey().equals("safety")) {
					for (int i = 0; i < entry.getValue().length; i++) {
						try {
							
							LevelTwo leveltwo = new LevelTwo(ct, entry.getValue()[i].toString());
							if(leveltwo.buyingInfoGain == 0) {
								leveltwoHash.put("["+entry.getKey()+"-"+entry.getValue()[i]+"] buying", leveltwo.getResult(entry.getValue()[i]));
							}
							else {
								leveltwoHash.put("["+entry.getKey()+"-"+entry.getValue()[i]+"] buying", Double.toString(leveltwo.buyingInfoGain));
							}
							if(leveltwo.maintInfoGain == 0) {
								leveltwoHash.put("["+entry.getKey()+"-"+entry.getValue()[i]+"] maint", leveltwo.getResult(entry.getValue()[i]));
							}
							else {
								leveltwoHash.put("["+entry.getKey()+"-"+entry.getValue()[i]+"] maint", Double.toString(leveltwo.maintInfoGain));
							}
							if(leveltwo.doorsInfoGain == 0) {
								leveltwoHash.put("["+entry.getKey()+"-"+entry.getValue()[i]+"] doors", leveltwo.getResult(entry.getValue()[i]));
							}
							else {
								leveltwoHash.put("["+entry.getKey()+"-"+entry.getValue()[i]+"] doors", Double.toString(leveltwo.doorsInfoGain));
							}
							if(leveltwo.personInfoGain == 0) {
								leveltwoHash.put("["+entry.getKey()+"-"+entry.getValue()[i]+"] persons", leveltwo.getResult(entry.getValue()[i]));
							}
							else {
								leveltwoHash.put("["+entry.getKey()+"-"+entry.getValue()[i]+"] persons", Double.toString(leveltwo.personInfoGain));
							}
							if(leveltwo.lvg_bootInfoGain == 0) {
								leveltwoHash.put("["+entry.getKey()+"-"+entry.getValue()[i]+"] lvg_boot", leveltwo.getResult(entry.getValue()[i]));
							}
							else {
								leveltwoHash.put("["+entry.getKey()+"-"+entry.getValue()[i]+"] lvg_boot", Double.toString(leveltwo.lvg_bootInfoGain));
							}
						
						
							
					
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				 
			}
			
		 });
		
		
		
		
		leveltwoHash.entrySet().forEach(entry->{
			if(entry.getValue().toString().contains("acc") || entry.getValue().toString().contains("unacc") || entry.getValue().toString().contains("good") || entry.getValue().toString().contains("vgood") ) {
				leveltwoPrint.put(entry.getKey().toString().substring(0,entry.getKey().toString().lastIndexOf("]")+1), entry.getValue());
		     
			}
		 });
		 
		
		
		return leveltwoPrint;
		
		
		
	}

}
