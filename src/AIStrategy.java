import java.util.ArrayList;

public class AIStrategy {
	
	private String player;
	private String self;
	
	AIStrategy() {
		player = "X";
		self = "O";
	}
	
	public int minimax(BoardModel board) {
		
		if (board.getWinner() == self) {
			return 1;
		}
		
		else if (board.getWinner() == player) {
			return -1;
		}
		
		else {
			ArrayList<Symbol> empty = board.emptyCells();
			if (empty.size() == 0)
				return 0;
		}
		return 0;
	}
	
}
