import java.sql.SQLException;
import java.util.HashMap;

public class Main {


	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		
		
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
		
		LevelOnePrint lvlone = new LevelOnePrint(connection);
		
		lvlone.printLevelOne();
		
		System.out.println();
		System.out.println();
		System.out.println("********************************************");
		
		
		LevelTwoPrint lvltwo = new LevelTwoPrint(connection,attrs);
		
		lvltwo.printLevelTwo();
		
		System.out.println();
		System.out.println();
		System.out.println("********************************************");
		

		LevelThreePrint lvlthree = new LevelThreePrint(connection, attrs);
		
		lvlthree.printLevelThree();
		
		System.out.println();
		System.out.println();
		System.out.println("********************************************");
		
		LevelFourPrint lvlfour = new LevelFourPrint(connection, attrs);
		
		lvlfour.printLevelFour();
		
		
		System.out.println();
		System.out.println();
		System.out.println("********************************************");
		
		LevelFivePrint lvlfive = new LevelFivePrint(connection, attrs);
		
		lvlfive.printLevelFive();
		
		System.out.println();
		System.out.println();
		System.out.println("********************************************");
		
		LevelSixPrint lvlsix = new LevelSixPrint(connection, attrs);
		
		lvlsix.printLevelSix();
		
		
		
		connection.con.close();
	
		
	}
	
}
