import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject; 

public class FootballGUI extends JFrame implements ActionListener {
	FootballAPI footballAPI=new FootballAPI();


	JLabel jLabel;
	
	   private JTable footballTable;
	    private DefaultTableModel tableModel;

	
	
	FootballGUI()
	{
		super("Football");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600,700 );
		setResizable(false);
		setLayout(null);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.BLACK);
		addGuiComponents();
	}

	private void addGuiComponents() {
		
		JButton spainBtn=new JButton("spainBtn",loadImage("src/assets/141.1.jpg"));
		spainBtn.setBounds(20, 10,160, 100);
		spainBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(spainBtn);
		spainBtn.addActionListener(this);
		
		JButton englandBtn=new JButton("englandBtn",loadImage("src/assets/40.1.png"));
		englandBtn.setBounds(210, 10,160, 100);
		englandBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(englandBtn);
		englandBtn.addActionListener(this);
		
		JButton italyBtn=new JButton("italyBtn",loadImage("src/assets/135.1.jpg"));
		italyBtn.setBounds(400, 10,160, 100);
		italyBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(italyBtn);
		italyBtn.addActionListener(this);
		
		JButton iranBtn=new JButton("iranBtn",loadImage("src/assets/290.jpg"));
		iranBtn.setBounds(20, 130,160, 100);
		iranBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(iranBtn);
		iranBtn.addActionListener(this);
		
		JButton germanyBtn=new JButton("germanyBtn",loadImage("src/assets/78.1.png"));
		germanyBtn.setBounds(210,130,160, 100);
		germanyBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(germanyBtn);
		germanyBtn.addActionListener(this);
		
		JButton franceBtn=new JButton("franceBtn",loadImage("src/assets/61.1.png"));
		franceBtn.setBounds(400, 130,160, 100);
		franceBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(franceBtn);
		franceBtn.addActionListener(this);
		
		JButton worldCupBtn=new JButton("worldCupBtn",loadImage("src/assets/15.1.png"));
		worldCupBtn.setBounds(90, 260,400, 100);
		worldCupBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(worldCupBtn);
		worldCupBtn.addActionListener(this);


	}

	private Icon loadImage(String resourcePath) {
		try {
	BufferedImage image= ImageIO.read(new File(resourcePath));
		return new ImageIcon(image);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("Could not find resource file");
		return null;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	    String choice = e.getActionCommand().toString();

	    DefaultTableModel model = new DefaultTableModel();
	    JTable table = new JTable(model);
	    table.setPreferredScrollableViewportSize(new Dimension(500, 200));
	    table.setFillsViewportHeight(true);

	    JScrollPane scrollPane = new JScrollPane(table);
	    scrollPane.setBounds(20, 380, 550, 250);
	    add(scrollPane);

	    model.addColumn("Country");
	    model.addColumn("Home Team Goals");
	    model.addColumn("Away Team Goals");
	  
	    model.addColumn("Date");

/*	    JTextArea leagueMatches=new JTextArea();
		leagueMatches.setBounds(20,380,550,200);
		add(leagueMatches);
	    
	 */
	    int homeTeamGoals = 3; 
	    int awayTeamGoals = 1; 
	    
	    String date = "2024-01-26"; 

	    model.addRow(new Object[]{choice, homeTeamGoals, awayTeamGoals, date});
	}
	
}
