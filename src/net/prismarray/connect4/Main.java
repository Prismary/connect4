package net.prismarray.connect4;

public class Main {
	public static void main (String[] args) {
		
		Board board = new Board();
		Controller player1 = new Controller(1);
		Controller player2 = new Controller(2);
		
		System.out.println("Welcome to Connect4!");
		
		while (true) {
			// Player 1 Turn
			if (player1.playTurn() == false) {
				Board.drawBoard();
			} else {
				System.exit(0);
			}
			
			// Player 2 Turn
			if (player2.playTurn() == false) {
				Board.drawBoard();
			} else {
				System.exit(0);
			}
		}
		
	}
}