import java.util.ArrayList;

public class AIStrategy {
	
	private String player;
	private String self;
	private int reward;
	
	AIStrategy(String ai, String plyr) {
		player = plyr;
		self = ai;
		reward = 0;
	}
	
	public int minimax(String current, BoardModel board) {
		
		if (board.getWinner() == self) {
			return 1;
		}
		
		else if (board.getWinner() == player) {
			return -1;
		}
		
		else {
			ArrayList<Symbol> empty = board.emptyCells();
			ArrayList<int[]> locations = new ArrayList<int[]>();
			if (empty.size() == 0)
				return 0;
			for (Symbol sym : empty) {
				locations.add(sym.getPos());
				board.makeMove(current, sym.getPos()[0], sym.getPos()[1]);
				if (current == self) {
					reward = minimax(self, board);
				} else {
					reward = minimax(player, board);
				}
				board.makeMove("_", sym.getPos()[0], sym.getPos()[1]);				
			}
		}
		return 0;
	}
	
}
