package net.prismarray.connect4;

public class Main {
	public static void main (String[] args) {
		
		Board board = new Board();
		Controller player1 = new Controller(board, 1);
		Controller player2 = new Controller(board, 2);
		
		System.out.println(
				"   ____                            _   _  _   \r\n" + 
				"  / ___|___  _ __  _ __   ___  ___| |_| || |  \r\n" + 
				" | |   / _ \\| '_ \\| '_ \\ / _ \\/ __| __| || |_ \r\n" + 
				" | |__| (_) | | | | | | |  __/ (__| |_|__   _|\r\n" + 
				"  \\____\\___/|_| |_|_| |_|\\___|\\___|\\__|  |_|  \r\n" +
				"   The Classic Vertical Four-In-A-Row Game\n");
		board.drawBoard();
		
		while (true) {
			// Player 1 Turn
			if (player1.playTurn() == false) {
				board.drawBoard();
			} else {
				System.exit(0);
			}
			
			// Player 2 Turn
			if (player2.playTurn() == false) {
				board.drawBoard();
			} else {
				System.exit(0);
			}
		}
		
	}
}