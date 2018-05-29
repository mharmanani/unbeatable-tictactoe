import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

public class TicTacToeGUIController extends JFrame implements ActionListener {

	private BoardModel board;
	private JButton[][] buttons;
	private String player;
	private String ai;
	private int turns;

	public TicTacToeGUIController() {
		super("Unbeatable Tic Tac Toe");
		JPanel gridPanel = new JPanel(new GridLayout(3,3));
		player = "X";
		ai = "O";
		board = new BoardModel(3,3);
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
		
		System.out.println(this.board.emptyCells());
		
		int[] dim = new int []{-1,-1};
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j ++) {
				if (buttons[i][j] == e.getSource())
					dim = new int []{i,j};
			}
		}
		
		if (turns%2 == 0) {
			JButton b = (JButton)e.getSource();
			b.setEnabled(false);
			b.setIcon(new ImageIcon("icns/icnX_2.png"));
			board.makeMove("X", dim[0], dim[1]);
			if (board.isSolved()) {
				System.out.println("Solved");
				this.dispose();
			}
			this.turns++;
		}
		
		JButton b = this.buttons[2][2];
		b.setEnabled(false);
		b.setIcon(new ImageIcon("icns/icnCPU.png"));
		board.makeMove("O", 2, 2);
		this.turns++;
	}
}
