import java.util.ArrayList;
import java.util.HashMap;

public class AIStrategy {
	
	private String player;
	private String self;
	
	AIStrategy(String ai, String plyr) {
		player = plyr;
		self = ai;
	}
	
	public Reward minimax(String current, BoardModel board) {
		
		ArrayList<Symbol> empty = board.emptyCells();
		
		if (board.getWinner() == self)
			return new Reward(1);

		else if (board.getWinner() == player)
			return new Reward(-1);
		
		else if (empty.size() == 0)
			return new Reward(0);
		
		ArrayList<Reward> locations = new ArrayList<Reward>();
		for (Symbol sym : empty) {
			Reward currMove = new Reward(sym);
			board.makeMove(current, sym.getPos()[0], sym.getPos()[1]);
			if (current == self) {
				Reward r = minimax(player, board);
				currMove.setReward(r.getReward());
		
			} else {
				Reward r = minimax(self, board);
				currMove.setReward(r.getReward());
			}
			board.setEmpty(sym.getPos()[0], sym.getPos()[1]);
			locations.add(currMove);
		}
			
		Reward bestScore;
		if (current == self) {
			bestScore = new Reward(Integer.MIN_VALUE);
			for (int i = 0; i < locations.size(); i ++) {
				if (locations.get(i).getReward() > bestScore.getReward()) {
					bestScore = locations.get(i);
				}
			}
			return bestScore;
		} else {
			bestScore = new Reward(Integer.MAX_VALUE);
			for (int i = 0; i < locations.size(); i ++) {
				if (locations.get(i).getReward() < bestScore.getReward()) {
					bestScore = locations.get(i);
				}
			}
			return bestScore;
		}
	}
	
}
