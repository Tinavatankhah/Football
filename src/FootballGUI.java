import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import org.json.simple.JSONArray; 

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
		
		JButton spainBtn=new JButton("spainBtn",loadImage("src/assets/la-liga-logo-.jpg"));
		spainBtn.setBounds(20, 10,160, 100);
		spainBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(spainBtn);
		spainBtn.addActionListener(this);
		
		JButton englandBtn=new JButton("englandBtn",loadImage("src/assets/premierleague.png"));
		englandBtn.setBounds(210, 10,160, 100);
		englandBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(englandBtn);
		englandBtn.addActionListener(this);
		
		JButton italyBtn=new JButton("italyBtn",loadImage("src/assets/logo-serie-a.jpg"));
		italyBtn.setBounds(400, 10,160, 100);
		italyBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(italyBtn);
		italyBtn.addActionListener(this);
		
		JButton iranBtn=new JButton("iranBtn",loadImage("src/assets/iran.jpg"));
		iranBtn.setBounds(20, 130,160, 100);
		iranBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(iranBtn);
		iranBtn.addActionListener(this);
		
		JButton germanyBtn=new JButton("germanyBtn",loadImage("src/assets/bundesliga-logo-1024x683.png"));
		germanyBtn.setBounds(210,130,160, 100);
		germanyBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(germanyBtn);
		germanyBtn.addActionListener(this);
		
		JButton franceBtn=new JButton("franceBtn",loadImage("src/assets/franceLigue1.jpg"));
		franceBtn.setBounds(400, 130,160, 100);
		franceBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(franceBtn);
		franceBtn.addActionListener(this);
		
		JButton worldCupBtn=new JButton("worldCupBtn",loadImage("src/assets/worldCup1.png"));
		worldCupBtn.setBounds(90, 260,400, 100);
		worldCupBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(worldCupBtn);
		worldCupBtn.addActionListener(this);
		
	
      
		
	
		jLabel=new JLabel("salam");
		jLabel.setBounds(0, 200, 1000, 800);
		jLabel.setFont(new Font("Dialog" , Font.PLAIN, 18));
		jLabel.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel.setForeground(Color.RED);
		add(jLabel);
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
		
		
	        jLabel.setText("Computer: " +  footballAPI.getLeagueData(choice));
	
		
	}
	
}
