import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
 * Created on 14.12.2004
 */
/**
 * @author madmarkus
 *
 * Es muss die hsqldb.jar  im JavaBuildPath sein, damit diese Datei
 * kompiliert werden kann. Also unter
 * http://hsqldb.sourceforge.net
 * herunterladen, entpacken, und einbinden.
 */
public class Database {
	private Connection c;
	
	public Database(){
		try{
			try {
		        Class.forName("org.hsqldb.jdbcDriver" );
		    } catch (Exception e) {
		        System.out.println("ERROR: HSQLDB JDBC driver konnte nicht geladen werden.");
		        e.printStackTrace();
		        return;
		    }
			
		    
		    //Öffnen der DB Verbindung. Entsprechdend der Verzeichnisstruktur in
		    //dem SVN Baum von LehStuVer. Bei mir, unter Linux, funktionierst so, evtl. 
		    //unter Windows nicht. Einfach den Pfad anpassen. 
			c = DriverManager.getConnection("jdbc:hsqldb:file:../Development/Datenbank/lestuverhsqldb", "sa", "");
		}catch(Exception e){
			System.out.println("Fehler beim Öffnen der Datenbank:" + e.getMessage() + e.toString());
		}
	}
	
	public JTable testGet(){
		JTable aTable = new JTable();
		try{
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM \"tbl_Lehrer\"");
			
			//Recordset in Table wandeln
			
//			 TableModel definition
			String[] tableColumnsName = {"ID","nachname","vorname","Gebdate"};
			
			DefaultTableModel aModel = (DefaultTableModel) aTable.getModel();
			aModel.setColumnIdentifiers(tableColumnsName);
			

//			 Loop through the ResultSet and transfer in the Model
			java.sql.ResultSetMetaData rsmd = rs.getMetaData();
			int colNo = rsmd.getColumnCount();
			while(rs.next()){
			 Object[] objects = new Object[colNo];

			 for(int i=0;i<colNo;i++){
			  objects[i]=rs.getObject(i+1);
			  }
			 aModel.addRow(objects);
			}
			aTable.setModel(aModel);
			
			
			
		}catch(Exception e ){
			System.out.println(e.getMessage());
		}
		
		return aTable;
	}
	
	public void close(){
		
		try{
			//HSQL Hat einen SHUTDOWN Befehl für die Datenbank,
			//also führen wir den mal lieber aus...
			c.createStatement().execute("SHUTDOWN;");
			
			//Schliessen der Verbindung
			c.close();
		
		}catch(Exception e){
			
		}
	}
	
}
