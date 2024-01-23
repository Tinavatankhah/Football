import javax.swing.SwingUtilities;
import java.net.HttpURLConnection;

public class AppLauncher {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new FootballGUI().setVisible(true);
				
			}
		});


	}

}