import javax.swing.UIManager;

public class TicTacToeGUIController {

	private BoardModel board;
	private DimensionChoiceGUI dimChoice;
	
	TicTacToeGUIController() {
		dimChoice = new DimensionChoiceGUI();
		dimChoice.createAndShowGUI();
	}
	
	public static void main(String[] args) {
			
			try {
				UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			javax.swing.SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					createAndShowGUI();
				}
			});
		}

	public static void createAndShowGUI() {
		
	}
}
