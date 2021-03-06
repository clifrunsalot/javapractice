package refresher.practice.swing.tables.MyList;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

//****** 2 *******
//Create frame for window
class MyList extends JFrame implements ActionListener, MenuListener {
	public MyList() {
		setTitle("Test Menu");
		setSize(310, 310);

		// Create window listener
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		// ****** 3 *******
		// Create menu panel
		topPanel = new JPanel();
		topPanel.setLayout(new BorderLayout());

		contentPane = getContentPane();
		contentPane.add(topPanel);

		// ****** 4 *******
		// Create menu bar
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		// ****** 5 *******
		// Create File menu and submenus
		fileMenu = new JMenu("File");
		openItem = new JMenuItem("Open");
		openItem.addActionListener(this);
		fileMenu.add(openItem);

		saveItem = new JMenuItem("Save");
		saveItem.addActionListener(this);
		fileMenu.add(saveItem);

		closeItem = new JMenuItem("Close");
		closeItem.addActionListener(this);
		fileMenu.add(closeItem);

		exitItem = new JMenuItem("Exit");
		exitItem.addActionListener(this);
		fileMenu.addSeparator();
		fileMenu.add(exitItem);

		// Add edit menu and submenus
		editMenu = new JMenu("Edit");
		copyItem = new JMenuItem("Copy");
		copyItem.addActionListener(this);
		editMenu.add(copyItem);

		cutItem = new JMenuItem("Cut");
		cutItem.addActionListener(this);
		editMenu.add(cutItem);

		pasteItem = new JMenuItem("Paste");
		pasteItem.addActionListener(this);
		editMenu.add(pasteItem);

		// ****** 6 *******
		// Add menus to menu bar
		menuBar.add(fileMenu);
		menuBar.add(editMenu);

		try {

			String infile = "C:\\Users\\clif\\workspace\\java_practice\\src\\refresher\\practice\\swing\\tables\\MyList\\Ab.dat";
			BufferedReader din = new BufferedReader(new FileReader(infile));

			String n = din.readLine();
			int records = Integer.parseInt(n);
			filledList = new String[records][MAXCOLUMNS];
			String[] str = new String[MAXCOLUMNS];

			for (int i = 0; i < records; i++) {
				String s = din.readLine();
				StringTokenizer t = new StringTokenizer(s, ":");
				for (int j = 0; j < MAXCOLUMNS; j++) {
					str[j] = t.nextToken();
					filledList[i][j] = str[j];
				}
			}
			din.close();
		} catch (IOException e) {
			System.out.println("Internal error: " + e);
		}

		// ****** 8 ******
		// Add JTable and a scrollpane
		table = new JTable(filledList, COLUMNS);
		JScrollPane scrollPane = new JScrollPane(table);
		contentPane.add(scrollPane, "Center");
	}

	public void saveFile(String f) {
	}

	public void closeFile() {
	}

	// ****** 9 ******
	// Create behavior to occur when menu items
	// are clicked
	public void actionPerformed(ActionEvent event) {
	}

	public void menuSelected(MenuEvent event) {
	}

	public void menuDeselected(MenuEvent event) {
	}

	public void menuCanceled(MenuEvent event) {
	}

	// ***** 1 *******
	// Create class instance
	public static void main(String[] args) {
		MyList myFrame = new MyList();
		myFrame.pack();
		myFrame.setVisible(true);
	}

	private Container contentPane;
	private JPanel topPanel;
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenu editMenu;
	private JMenuItem openItem;
	private JMenuItem saveItem;
	private JMenuItem closeItem;
	private JMenuItem exitItem;
	private JMenuItem cutItem;
	private JMenuItem copyItem;
	private JMenuItem pasteItem;
	private JTable table;
	private String[][] filledTable;
	private String[][] filledList;
	private final int MAXCOLUMNS = 3;
	private final String[] COLUMNS = { "First", "Last", "Zip" };
}
