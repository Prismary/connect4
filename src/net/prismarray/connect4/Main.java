package net.prismarray.connect4;

public class Main {
	public static void main (String[] args) {
		
		Board board = new Board();
		Controller player1 = new Controller(board, 1);
		Controller player2 = new Controller(board, 2);
		
		System.out.println("Welcome to Connect4!");
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