import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import javax.swing.JScrollPane;
/*
 * Created on 07.09.2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author markusschlichting
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class frmMain extends JFrame{

	private JPanel jContentPane = null;
	// private JFrame jFrame = null;  //  @jve:decl-index=0:visual-constraint="53,16"
	private JMenuBar jJMenuBar = null;
	private JTable jTable = null;
	private JScrollPane jScrollPane = null;
	private JMenuItem jMenuItem = null;
	/**
	 * This method initializes jContentPane	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			try {
				jContentPane = new JPanel();
				jContentPane.setLayout(new BorderLayout());  // Generated
				jContentPane.add(getJJMenuBar(), java.awt.BorderLayout.NORTH);  // Generated
				jContentPane.add(getJScrollPane(), java.awt.BorderLayout.CENTER);  // Generated
			}
			catch (java.lang.Throwable e) {
				// TODO: Something
			}
		}
		return jContentPane;
	}
	/**
	 * This method initializes jFrame	
	 * 	
	 * @return javax.swing.JFrame	
	 */    
	public frmMain() {
			try {
				this.setContentPane(getJContentPane());  // Generated
				this.setSize(520, 276);  // Generated
				this.addWindowListener(new java.awt.event.WindowAdapter() { 
					public void windowClosing(java.awt.event.WindowEvent e) {    
						System.exit(0);
						//System.out.println("windowClosing()"); // TODO Auto-generated Event stub windowClosing()
					}
				});
				this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
			}
			catch (java.lang.Throwable e) {
				// TODO: Something
			}
		}
	
	/**
	 * This method initializes jJMenuBar	
	 * 	
	 * @return javax.swing.JMenuBar	
	 */    
	private JMenuBar getJJMenuBar() {
		if (jJMenuBar == null) {
			try {
				jJMenuBar = new JMenuBar();
				jJMenuBar.add(getJMenuItem("Datei"), java.awt.BorderLayout.EAST);
				jJMenuBar.add(getJMenuItem("Stammdaten"), java.awt.BorderLayout.WEST);
				jJMenuBar.add(getJMenuItem("Einstellungen"), java.awt.BorderLayout.WEST);
				jJMenuBar.add(getJMenuItem("Hilfe"), java.awt.BorderLayout.WEST);
			}
			catch (java.lang.Throwable e) {
				// TODO: Something
			}
		}
		return jJMenuBar;
	}
	/**
	 * This method initializes jTable	
	 * 	
	 * @return javax.swing.JTable	
	 */    
	private JTable getJTable() {
		if (jTable == null) {
			try {
				String rowData[][] = {
					      { "Japan", "245", "12", "12", "11", "10" },
						  { "USA", "240", "12", "12", "11", "10" },
						  { "Italien", "220", "12", "12", "11", "10" },
					      { "Spanien", "217", "12", "12", "11", "10" },
						  { "Türkei", "215", "30", "34", "23", "42"} ,
						  { "England", "214", "12", "12", "11", "10"},
					      { "Frankreich", "190", "12", "12", "11", "10" }, {"Griechenland", "185", "12", "12", "11", "10" },
					      { "Deutschland", "180", "12", "12", "11", "10" }, {"Portugal", "170", "12", "12", "11", "10" }
					    };

					    String  columnNames[] = {
					      "Lehrer", "Fachbereich1", "Fachbereich2", "Fachbereich3", "Fachbereich4", "Summe"
					    }; 
				jTable = new JTable(rowData, columnNames);
				// jTable.addColumn();
				
			}
			catch (java.lang.Throwable e) {
				// TODO: Something
			}
		}
		return jTable;
	}
	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */    
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			try {
				jScrollPane = new JScrollPane();
				jScrollPane.setViewportView(getJTable());  // Generated
			}
			catch (java.lang.Throwable e) {
				// TODO: Something
			}
		}
		return jScrollPane;
	}
	/**
	 * This method initializes jMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */    
	private JMenuItem getJMenuItem(String str) {
		if (jMenuItem == null) {
			try {
				jMenuItem = new JMenuItem(str);
			}
			catch (java.lang.Throwable e) {
				// TODO: Something
			}
		}
		return jMenuItem;
	}
   }
