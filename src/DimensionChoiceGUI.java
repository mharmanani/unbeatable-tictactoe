import java.awt.GridLayout;

import javax.swing.*;

public class DimensionChoiceGUI {

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});

	}

	public static void createAndShowGUI() {
		JFrame ask = new JFrame("Tic Tac Toe");
		
		JPanel questPanel = new JPanel();
		JPanel choicePanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		
		JLabel question = new JLabel("Board dimensions: ");
		JTextField mField = new JTextField(10);
		JTextField nField = new JTextField(10);
		JLabel byLabel = new JLabel("by");
		JButton confirm = new JButton("Confirm");
		
		ask.add(question);
		ask.add(mField);
		ask.add(byLabel);
		ask.add(nField);
		
		ask.setLayout(new GridLayout(3,1));
		questPanel.add(question);
		choicePanel.add(mField);
		choicePanel.add(byLabel);
		choicePanel.add(nField);
		buttonPanel.add(confirm);
		ask.add(questPanel); ask.add(choicePanel);
		ask.add(confirm);
		
		ask.setVisible(true);
		ask.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ask.setLocationRelativeTo(null);
		ask.pack();
	}
}
