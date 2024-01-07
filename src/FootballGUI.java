import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*; 

public class FootballGUI extends JFrame{
	
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
		JButton spainBtn=new JButton(loadImage("src/assets/la-liga-logo-.jpg"));
		spainBtn.setBounds(20, 10,160, 100);
		add(spainBtn);
		JButton englandBtn=new JButton(loadImage("src/assets/premierleague.png"));
		englandBtn.setBounds(210, 10,160, 100);
		add(englandBtn);
		JButton italyBtn=new JButton(loadImage("src/assets/logo-serie-a.jpg"));
		italyBtn.setBounds(400, 10,160, 100);
		add(italyBtn);
		JButton iranBtn=new JButton(loadImage("src/assets/iran.jpg"));
		iranBtn.setBounds(20, 130,160, 100);
		add(iranBtn);
		JButton germanyBtn=new JButton(loadImage("src/assets/bundesliga-logo-1024x683.png"));
		germanyBtn.setBounds(210,130,160, 100);
		add(germanyBtn);
		JButton franceBtn=new JButton(loadImage("src/assets/franceLigue1.jpg"));
		franceBtn.setBounds(400, 130,160, 100);
		add(franceBtn);
		JButton worldCupBtn=new JButton(loadImage("src/assets/worldCup1.png"));
		worldCupBtn.setBounds(90, 260,400, 100);
		add(worldCupBtn);
		
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
	
}
