import java.awt.*;


import javax.swing.*;
import javax.swing.table.TableColumn;

/**
 * @author timobusshaus
 * 
 * 
 */
public class MainFrame extends JFrame
{
	public static void main(String[] args) 
	{
		MainFrame my = new MainFrame();
	}
    public MainFrame()
    {
        super("LehrerStundenVerwaltung");
        this.setSize(600,400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        initFrame();
        this.setVisible(true);
    }

    protected void initFrame()
    {
        this.setJMenuBar(initMenu());
        Container rootpane = getContentPane();
        rootpane.add(initTabbedPane());
    }

    protected JMenuBar initMenu()
    {
        JMenuBar retMenuBar = new JMenuBar();
        // Dateimenü
        JMenu tmpMenu = new JMenu("Datei");
        tmpMenu.add(new JMenuItem("Export"));
        tmpMenu.add(new JMenuItem("Auswertung"));
        tmpMenu.addSeparator();
        tmpMenu.add(new JMenuItem("Beenden"));

        retMenuBar.add(tmpMenu);

        // Stammdatenmenü
        tmpMenu = new JMenu("Stammdaten");
        retMenuBar.add(tmpMenu);

        // Optionsmenü
        tmpMenu = new JMenu("Optionen");
        retMenuBar.add(tmpMenu);

        // Hilfemenü
        tmpMenu = new JMenu("?");
        tmpMenu.add(new JMenuItem("Hilfe"));
        tmpMenu.add(new JMenuItem("über..."));
        retMenuBar.add(tmpMenu);

        return retMenuBar;
    }

    protected JTabbedPane initTabbedPane()
    {
        JTabbedPane retPane = new JTabbedPane();
        JPanel tmpPanel = new JPanel();
              
        //retPane.addTab("Halbjahresauswahl", tmpPanel);
                
        String[] columnNames =
        { "Name", "Fachbereich", "Stunden",};
        Object[][] data =
        {
                { "Mary", "Campione", "Snowboarding"},
                { "Alison", "Huml", "Rowing"},
                { "Kathy", "Walrath", "Knitting"},
                { "Sharon", "Zakhour", "Speed reading"},
                { "Philip", "Milne", "Pool"}
              	};
        JTable table = new JTable(data, columnNames);
        TableColumn firstcol = table.getColumnModel().getColumn(0);
        firstcol.setPreferredWidth(200);
        JComboBox firstcombo = new JComboBox();
        firstcombo.addItem("Mary");
        firstcombo.addItem("Alison");
        firstcombo.addItem("Kathy");
        firstcombo.addItem("Sharon");
        firstcombo.addItem("Philip");
        firstcol.setCellEditor(new DefaultCellEditor(firstcombo));
        
        TableColumn secondcol = table.getColumnModel().getColumn(1);
        secondcol.setPreferredWidth(200);
        JComboBox secondcombo = new JComboBox();
        secondcombo.addItem("Campione");
        secondcombo.addItem("Huml");
        secondcombo.addItem("Walrath");
        secondcombo.addItem("Zakhour");
        secondcombo.addItem("Milne");
        secondcol.setCellEditor(new DefaultCellEditor(secondcombo));
        JScrollPane scrollpane = new JScrollPane ( table);
        JPanel centerPane=new JPanel(new BorderLayout());
        centerPane.add(scrollpane,BorderLayout.CENTER);
        
        TableColumn thirdcol = table.getColumnModel().getColumn(2);
        thirdcol.setMinWidth(50);
        thirdcol.setMaxWidth(50);
        JPanel rightPane=new JPanel(new BorderLayout());
        
        rightPane.add(new JButton("Löschen"),BorderLayout.NORTH);
        centerPane.add(rightPane,BorderLayout.EAST);
        //rightPane.add(new JButton("Speichern"),BorderLayout.EAST);
        //retPane.addTab("Stundeneingabe", scrollpane );
        retPane.addTab("Stundeneingabe", centerPane);
    
        retPane.addTab("Halbjahresübersicht", new JPanel());
        return retPane;
    }
}