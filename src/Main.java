import java.sql.SQLException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

	static boolean lvl1Fl = false;
	static boolean lvl2Fl = false;
	static boolean lvl3Fl = false;
	static boolean lvl4Fl = false;
	static boolean lvl5Fl = false;
	static boolean lvl6Fl = false;

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		

		HashMap<String, String> tree = new HashMap<String, String>();
		
		
		HashMap<String, String []> attrs = new HashMap<String, String[]>();
		
		String buying[] = {"vhigh","high","med","low"};
		String maint[] = {"vhigh","high","med","low"};
		String doors[] = {"2","3","4","0"};
		String persons[] = {"2","4","0"};
		String lvg_boot[] = {"big","med","small"};
		String safety[] = {"high","med","low"};
		
		
		attrs.put("buying", buying);
		attrs.put("maint", maint);
		attrs.put("doors", doors);
		attrs.put("persons", persons);
		attrs.put("lvg_boot", lvg_boot);
		attrs.put("safety", safety);
		
		
		
		ConnectionOfDB connection = new ConnectionOfDB();
		
		LevelOnePrint lvlone = new LevelOnePrint(connection,attrs,tree);
		
		//lvlone.printLevelOne();
		
		
		
		LevelTwoPrint lvltwo = new LevelTwoPrint(connection,attrs,tree);
		
		HashMap<String, String> lvl2=lvltwo.printLevelTwo();
		
		/*lvl2.entrySet().forEach(entry->{
			
		    System.out.println(entry.getKey() + " " + entry.getValue());  
		 });*/
		
		
		

		LevelThreePrint lvlthree = new LevelThreePrint(connection, attrs,tree);
		
		HashMap<String, String> lvl3=lvlthree.printLevelThree(lvl2);
		
		/*lvl3.entrySet().forEach(entry->{
			
		    System.out.println(entry.getKey() + " " + entry.getValue());  
		 });*/
		
		
		
		LevelFourPrint lvlfour = new LevelFourPrint(connection, attrs);
		
		HashMap<String, String> lvl4=lvlfour.printLevelFour(lvl2,lvl3);
		
		/*lvl4.entrySet().forEach(entry->{
			
		    System.out.println(entry.getKey() + " " + entry.getValue());  
		 });*/
		
		
		
		LevelFivePrint lvlfive = new LevelFivePrint(connection, attrs);
		
		HashMap<String, String> lvl5=lvlfive.printLevelFive(lvl2,lvl3,lvl4);
		
		/*lvl5.entrySet().forEach(entry->{
			
		    System.out.println(entry.getKey() + " " + entry.getValue());  
		 });*/
		
	
		
		LevelSixPrint lvlsix = new LevelSixPrint(connection, attrs);
		
		HashMap<String, String> lvl6=lvlsix.printLevelSix(lvl2,lvl3,lvl4,lvl5);
		
		/*lvl6.entrySet().forEach(entry->{
			
		    System.out.println(entry.getKey() + " " + entry.getValue());  
		 });*/
		
		/*System.out.println();
		System.out.println();
		System.out.println("********************************************");
		*/
		
		LevelSevenPrint lvlseven = new LevelSevenPrint(connection, attrs);
		
		HashMap<String, String> lvl7=lvlseven.printLevelSeven(lvl2,lvl3,lvl4,lvl5,lvl6);
		
		/*lvl7.entrySet().forEach(entry->{
			
		    System.out.println(entry.getKey() + " " + entry.getValue());  
		 });*/
		
		String attributes="";
		
		
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Please enter the car attributes wtih this format buying maint doors persons lvg_boot safety");
		
		attributes=in.nextLine();
		
		String[] attrin = attributes.split(" ");
		

		String buyingIN="[buying-"+attrin[0]+"]";
		String maintIN="[maint-"+attrin[1]+"]";
		String doorsIN="[doors-"+attrin[2]+"]";
		String personsIN="[persons-"+attrin[3]+"]";
		String lvg_bootIN="[lvg_boot-"+attrin[4]+"]";
		String safetyIN="[safety-"+attrin[5]+"]";
            
		String lvl1Str = safetyIN;
		String lvl2Str = safetyIN+"+"+personsIN;
		String lvl3Str = safetyIN+"+"+personsIN+"+"+buyingIN;	    
		String lvl4Str = safetyIN+"+"+personsIN+"+"+buyingIN+"+"+maintIN;
		String lvl5Str = safetyIN+"+"+personsIN+"+"+buyingIN+"+"+maintIN+"+"+lvg_bootIN;
		String lvl6Str = safetyIN+"+"+personsIN+"+"+buyingIN+"+"+maintIN+"+"+lvg_bootIN+"+"+doorsIN;
		
		
		
		lvl1Fl = false;
		lvl2Fl = false;
		lvl3Fl = false;
		lvl4Fl = false;
		lvl5Fl = false;
		lvl6Fl = false;
		
		
		lvl2.entrySet().forEach(entry->{
			if(entry.getKey().toString().contains(lvl1Str)) {
				System.out.println("LVL1 Result is: "+entry.getValue());
			}
			else {
				lvl1Fl = true;
			}
		});
		
		if(lvl1Fl) {
			lvl3.entrySet().forEach(entry->{
				if(entry.getKey().toString().contains(lvl2Str)) {
					System.out.println("LVL2 Result is: "+entry.getValue());
				}
				else {
					lvl2Fl = true;
				}
			});
		}
		if(lvl2Fl) {
			lvl4.entrySet().forEach(entry->{
				if(entry.getKey().toString().contains(lvl3Str)) {
					System.out.println("LVL3 Result is: "+entry.getValue());
				}
				else {
					lvl3Fl = true;
				}
			});
		}
		
		if(lvl3Fl) {
			lvl5.entrySet().forEach(entry->{
				if(entry.getKey().toString().contains(lvl4Str)) {
					System.out.println("LVL4 Result is: "+entry.getValue());
				}
				else {
					lvl4Fl = true;
				}
			});
		}
		
		if(lvl4Fl) {
			lvl6.entrySet().forEach(entry->{
				if(entry.getKey().toString().contains(lvl5Str)) {
					System.out.println("LVL5 Result is: "+entry.getValue());
				}
				else {
					lvl5Fl = true;
				}
			});
		}
		if(lvl5Fl) {
			lvl7.entrySet().forEach(entry->{
				if(entry.getKey().toString().equals(lvl6Str)) {
					System.out.println("LVL6 Result is: "+entry.getValue());
				}
				else {
					lvl6Fl = true;
				}
			});
		}
		
		
		connection.con.close();
	
		
	}
	
}
