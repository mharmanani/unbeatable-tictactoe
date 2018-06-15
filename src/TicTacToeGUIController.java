import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class TicTacToeGUIController extends JFrame implements ActionListener {

	private BoardModel board;
	private AIStrategy AI;
	private JButton[][] buttons;
	private String player;
	private String ai;
	private String turn;

	public TicTacToeGUIController() {
		super("Unbeatable Tic Tac Toe");
		JPanel gridPanel = new JPanel(new GridLayout(3,3));
		player = "X";
		ai = "O";
		String[] choices = new String[] {ai, player};
		int random = (int)(Math.random() * 2);
		turn  = choices[random];
		System.out.println("It's " + turn + "'s turn");
		board = new BoardModel(3,3);
		buttons = new JButton[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j ++) {
				buttons[i][j] = new JButton();
				buttons[i][j].addActionListener(this);
				gridPanel.add(buttons[i][j]);
			}
		}
		
		AI = new AIStrategy(ai, player);
		
		this.getContentPane().setPreferredSize(new Dimension(500,500));
		this.getContentPane().add(gridPanel, BorderLayout.CENTER);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.pack();
		
		if (turn == ai) {
			JOptionPane.showMessageDialog(this, "The computer will have the first turn.");
			ArrayList<Symbol> empty = board.emptyCells();
			int i = (int)(Math.random() * empty.size());
			int[] aiMove = empty.get(i).getPos();
			JButton b = this.buttons[aiMove[0]][aiMove[1]];
			b.setEnabled(false);
			b.setBackground(new Color(48, 48, 48));
			//b.setIcon(new ImageIcon("icns/icnCPU.png"));
			board.makeMove(ai, aiMove[0], aiMove[1]);
			turn = player;
		} else {
			JOptionPane.showMessageDialog(this, "The first turn is yours.");
		}
	}
	
	public void freeze() {
		for (JButton[] bArray : this.buttons) {
			for (JButton b : bArray) {
				b.setEnabled(false);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//System.out.println(this.board.emptyCells());
		
		int[] dim = new int []{-1,-1};
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j ++) {
				if (buttons[i][j] == e.getSource())
					dim = new int []{i,j};
			}
		}
		
		if (turn == player) {
			JButton b = (JButton)e.getSource();
			b.setEnabled(false);
			b.setBackground(new Color(0, 188, 246));
			//b.setIcon(new ImageIcon("icns/icnX_2.png"));
			board.makeMove(player, dim[0], dim[1]);
			if (board.isSolved()) {
				System.out.println("Solved");
				//this.dispose();
			}
			turn = ai;
		}

		Reward reward = AI.minimax(turn, board);
		if (reward.getMove() == null) {
			JOptionPane.showMessageDialog(this, "It's a draw!");
			this.freeze();
			return;
		}
		//System.out.println(reward.getReward());
		//System.out.println(reward.getMove());
		int[] aiMove = reward.getMove().getPos();
		JButton b = this.buttons[aiMove[0]][aiMove[1]];
		b.setEnabled(false);
		b.setBackground(new Color(48, 48, 48));
		//b.setIcon(new ImageIcon("icns/icnCPU.png"));
		board.makeMove(ai, aiMove[0], aiMove[1]);
		turn = player;
		
		if (board.isSolved()) {
			if (board.getWinner() == ai) {
				JOptionPane.showMessageDialog(this, "You have lost.");
				this.freeze();
				return;
			} else {
				JOptionPane.showMessageDialog(this, "You have won!");
				this.freeze();
				return;
			}
		} else if (board.isFull()) {
			JOptionPane.showMessageDialog(this, "It's a draw!");
			this.freeze();
			return;
		}
	}
}
