public class Symbol {
	
	private String symbol;
	private int[] pos;
	
	Symbol(int m, int n) {
		this.symbol = "_";
		this.pos = new int[] {m, n};
	}
	
	public void setSymbol(String s) {
		this.symbol = s;
	}
	
	public String getSymbol() {
		return this.symbol;
	}
	
	public int[] getPos() {
		return this.pos;
	}
	
	public void setPos(int x, int y) {
		this.pos[0] = x;
		this.pos[1] = y;
	}
	
	public boolean isEmpty() {
		return this.getSymbol() == "_";
	}
}
