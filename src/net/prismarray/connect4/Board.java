package net.prismarray.connect4;

public class Board {
	
	int[][] board = new int[6][5];
	
	public void setValue(int column, int line, int value) {
		board[column][line] = value;
	}
	
	public boolean checkValue(int column, int line, int value) {
		if (board[column][line] == value) {
			return true;
		} else {
			return false;
		}
	}
	
	public void drawBoard() {
		//print board to console
	}

}
