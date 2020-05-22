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
		for (int i = 0; i < 7; i++) {
			for (int ii = 0; ii < 6; i++) {
				if (board[i][ii] == 0) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static boolean checkVictory(int ref_column, int ref_line, int player) {
		Cursor vcursor = new Cursor(ref_column, ref_line);
		String[][] instructions = {{"left", "right"}, {"up", "down"}, {"upleft", "downright"}, {"upright", "downleft"}};
		int streak = 0;
		
		for (int i = 0; i < 4; i++) {
			while (vcursor.checkPos() == player) {
				vcursor.move(instructions[i][0], 1);
			}
			vcursor.move(instructions[i][1], 1);
			while (vcursor.checkPos() == player) {
				streak++;
				vcursor.move(instructions[i][1], 1);
			}
			if (streak >= 4) {
				return true;
			}
			vcursor.goHome();
			streak = 0;
		}
		
		return false;
	}
	
	public static void drawBoard() {
		String draw_out = "";
		for (int i = 0; i < 6; i++) {
			for (int ii = 0; ii < 7; i++) {
				draw_out = draw_out + board[ii][i];
			}
			draw_out = draw_out + "\n";
		}
		
		System.out.println(draw_out);
	}

}
