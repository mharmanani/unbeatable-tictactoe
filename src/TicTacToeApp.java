import java.awt.GridLayout;
import javax.swing.*;


public class TicTacToeApp {
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new TicTacToeGUIController();
			}
		});
	}
}
