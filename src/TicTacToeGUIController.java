import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TicTacToeGUIController extends JFrame implements ActionListener {

	private BoardModel board;
	private JButton[][] buttons;
	private int turns;

	public TicTacToeGUIController() {
		super("Unbeatable Tic Tac Toe");
		JPanel gridPanel = new JPanel(new GridLayout(3,3));
		buttons = new JButton[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j ++) {
				buttons[i][j] = new JButton();
				buttons[i][j].addActionListener(this);
				gridPanel.add(buttons[i][j]);
			}
		}
		
		turns = 0;
		
		this.getContentPane().setPreferredSize(new Dimension(500,500));
		this.getContentPane().add(gridPanel, BorderLayout.CENTER);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		int[] dim;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j ++) {
				if (buttons[i][j] == e.getSource())
					dim = new int []{i,j};
			}
		}
		
		if (turns%2 == 0) {
			JButton b = (JButton)e.getSource();
			b.setEnabled(false);
		}
		
		this.turns++;
	}
}
