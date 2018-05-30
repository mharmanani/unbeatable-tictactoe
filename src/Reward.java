
public class Reward {
	
	private int reward;
	private Symbol move;
	
	Reward(int r) {
		reward = r;
	}
	
	Reward(Symbol s) {
		move = s;
	}
	
	public void setReward(int r) {
		reward = r;
	}
	
	public int getReward() {
		return reward;
	}
	
	public void setMove(Symbol s) {
		move = s;
	}
	
	public Symbol getMove() {
		return move;
	}
}
