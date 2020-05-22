package net.prismarray.connect4;

public class Board {
	
	private int[][] board_arr = new int[7][6];
	
	public void setValue(int column, int line, int value) {
		board_arr[column][line] = value;
	}
	
	public int getValue(int column, int line) {
		try {
			return board_arr[column][line];
		} catch (ArrayIndexOutOfBoundsException e) {
			return 0;
		}
		
	}
	
	public boolean checkEmpty(int column, int line) {
		try {
			if (board_arr[column][line] == 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean checkDraw() {
		for (int i = 0; i < 7; i++) {
			for (int ii = 0; ii < 6; ii++) {
				if (board_arr[i][ii] == 0) {
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean checkVictory(int ref_column, int ref_line, int player) {
		Cursor vcursor = new Cursor(this, ref_column, ref_line);
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
	
	public void drawBoard() {
		String draw_out = "";
		for (int i = 0; i < 6; i++) {
			draw_out = draw_out + "\n+-+-+-+-+-+-+-+\n|";
			for (int ii = 0; ii < 7; ii++) {
				draw_out = draw_out + board_arr[ii][i] + "|";
			}
		}
		draw_out = draw_out + "\n+-+-+-+-+-+-+-+"
							+ "\n ^ ^ ^ ^ ^ ^ ^"
							+ "\n 1 2 3 4 5 6 7\n";
		
		System.out.println(draw_out);
	}

}
