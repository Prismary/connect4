package net.prismarray.connect4;

public class Cursor {
	int home_cl;
	int home_ln;
	
	int cl = 0; // Column
	int ln = 0; // Line
		
	public Cursor(int hx, int hy) {
		this.home_cl = hx;
		this.home_ln = hy;
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
		return Board.getValue(cl, ln);
	}
	
	public void move(String direction, int steps) {
		
		for (int i = 0; i < steps+1; i++) {
			if (direction == "up") {
				ln--;
			} else if (direction == "down") {
				ln++;
			} else if (direction == "left") {
				cl--;
			} else if (direction == "right") {
				cl++;
			} else if (direction == "upleft") {
				ln--;
				cl--;
			} else if (direction == "upright") {
				ln--;
				cl++;
			} else if (direction == "downleft") {
				ln++;
				cl--;
			} else if (direction == "downright") {
				ln++;
				cl++;
			}
		}
		
	}
}
