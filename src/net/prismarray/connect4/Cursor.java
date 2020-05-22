package net.prismarray.connect4;

public class Cursor {
	int home_cl;
	int home_ln;
	Board board;
	
	int cl = 0; // Column
	int ln = 0; // Line
		
	public Cursor(Board board, int hx, int hy) {
		this.home_cl = hx;
		this.home_ln = hy;
		this.board = board;
		goHome();
	}
	
	public void goHome() {
		cl = home_cl;
		ln = home_ln;
	}
	
	public void goTo(int goto_cl, int goto_ln) {
		cl = goto_cl;
		ln = goto_ln;
	}
	
	public int checkPos() {
		return board.getValue(cl, ln);
	}
	
	public void move(String direction, int steps) {
		
		for (int i = 0; i < steps; i++) {
			if (direction == "up") {
				ln--;
			} else if (direction.equals("down")) {
				ln++;
			} else if (direction.equals("left")) {
				cl--;
			} else if (direction.equals("right")) {
				cl++;
			} else if (direction.equals("upleft")) {
				ln--;
				cl--;
			} else if (direction.equals("upright")) {
				ln--;
				cl++;
			} else if (direction.equals("downleft")) {
				ln++;
				cl--;
			} else if (direction.equals("downright")) {
				ln++;
				cl++;
			}
		}
		
	}
}
