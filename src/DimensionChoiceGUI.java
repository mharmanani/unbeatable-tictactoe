import java.awt.GridLayout;

import javax.swing.*;

public class DimensionChoiceGUI {

	public void createAndShowGUI() {
		JFrame ask = new JFrame("Tic Tac Toe");
		
		JPanel questPanel = new JPanel();
		JPanel choicePanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		
		JLabel question = new JLabel("Board dimensions: ");
		JTextField nField = new JTextField(10);
		JButton confirm = new JButton("Confirm");
		
		ask.add(question);
		ask.add(nField);
		
		ask.setLayout(new GridLayout(3,1));
		questPanel.add(question);
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
