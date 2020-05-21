package net.prismarray.connect4;

public class Board {
	
	static int[][] board = new int[6][5];
	
	public static void setValue(int column, int line, int value) {
		board[column][line] = value;
	}
	
	public static int getValue(int column, int line) {
		return board[column][line];
	}
	
	public static boolean checkEmpty(int column, int line) {
		if (board[column][line] == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean checkDraw() {
		// check entire array for 0
	}
	
	public static boolean checkVictory(int ref_column, int ref_line, int player) {
		
		// Horizontal check
		
		
	}
	
	public static void drawBoard() {
		//print board to console
	}

}
