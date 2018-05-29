import java.util.Observable;
import java.util.ArrayList;

public class BoardModel extends Observable {
	
	private Symbol[][] grid; 
	private int[] dimensions;
	
	BoardModel(int m, int n) {
		this.dimensions = new int[]{m, n};
		this.grid = new Symbol[m][n];
		for (int i = 0; i < m; i ++) {
			for (int j = 0; j < n; j ++) {
				this.grid[i][j] = new Symbol(i, j);
			}
		}
	}
	
	@Override
	public String toString() {
		String ret = "";
		for (int i = 0; i < this.dimensions[0]; i ++) {
			for (int j = 0; j < this.dimensions[1]; j ++) {
				ret += (this.grid[i][j].getSymbol());
				ret += " ";
			}
			ret += '\n';
		}
		return ret;
	}
	
	public void makeMove(String s, int x, int y) {
		if (x >= this.dimensions[0] || y >= this.dimensions[1]) {
			System.out.println("Cell is out of bounds");
			return;
		}
		if (this.grid[x][y].isEmpty()) {
			this.grid[x][y].setSymbol(s);
		} else {
			System.out.println("Cell is full");
			return;
		}
	}
	
	public boolean isRowFilled(int x, String[] winner) {
		Symbol[] row = this.grid[x];
		String[] symbols = new String[]{"_"};
		for (Symbol cell : row) {
			if (cell.isEmpty()) {
				return false;
			}
			else {
				if (symbols[0] == "_") {
					symbols[0] = cell.getSymbol();
				} else if (symbols[0] != cell.getSymbol()){
					return false;
				}
			}
		}
		winner[0] = symbols[0];
		return true;
	}
	
	public boolean isColumnFilled(int y, String[] winner) {
		String[] symbols = new String[]{"_"};
		for (Symbol[] row : this.grid) {
			if (row[y].isEmpty()) {
				return false;
			} else {
				if (symbols[0] == "_") {
					symbols[0] = row[y].getSymbol();
				} else if (symbols[0] != row[y].getSymbol()){
					return false;
				}
			}
		}
		winner[0] = symbols[0];
		return true;
	}
	
	public boolean isDiagonalFilled(String[] winner) {
		int i = 0; int j = 0;
		String prev = "_";
		while (i < this.dimensions[0] && j < this.dimensions[1]) {
			if (this.grid[i][j].isEmpty() || 
					(prev != this.grid[i][j].getSymbol() 
					&& prev != "_")) { 
				return false;
			} else {
				prev = this.grid[i][j].getSymbol();
			}
			i ++; j ++;
		}
		winner[0] = prev;
		return true;
	}
	
	public ArrayList<Symbol> emptyCells() {
		ArrayList<Symbol> empty = new ArrayList<Symbol>();
		for (int i = 0; i < dimensions[0]; i ++) {
			for (int j = 0 ; j < dimensions[1]; j ++) {
				if (this.grid[i][j].isEmpty())
					empty.add(this.grid[i][j]);
			}
		}
		return empty;
	}
	
	public boolean isSolved() {
		int m = this.dimensions[0];
		int n = this.dimensions[1];
		boolean anyRow = false;
		boolean anyColumn = false;
		for (int x = 0; x < m; x ++) {
			if (isRowFilled(x, new String[1])) {
				anyRow = true;
			}
		}
		for (int y = 0; y < n; y ++) {
			if (isColumnFilled(y, new String[1])) {
				anyColumn = true;
			}
		}
		return isDiagonalFilled(new String[1]) || anyColumn || anyRow;
	}
	
	public String getWinner() {
		String[] winner = new String[1];
		if (isDiagonalFilled(winner))
			return winner[0];
		
		int m = this.dimensions[0];
		int n = this.dimensions[1];
		
		for (int x = 0; x < m; x ++) {
			if (isRowFilled(x, winner)) {
				return winner[0];
			}
		}
		
		for (int y = 0; y < n; y ++) {
			if (isColumnFilled(y, winner)) {
				return winner[0];
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		BoardModel a = new BoardModel(3, 3);
		a.makeMove("X", 0, 1);
		a.makeMove("X", 1, 1);
		a.makeMove("C", 2, 1);
		
		System.out.println(a.getWinner());
		
		System.out.println(a.toString());
		System.out.println(a.isSolved());

	}
	
}
