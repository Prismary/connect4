package net.prismarray.connect4;

import java.util.Scanner;

public class Controller {
	Scanner scanner = new Scanner(System.in);
	int id;
	Board board;
	
	public Controller(Board board, int id) {
		this.id = id;
		this.board = board;
	}
	
	public boolean playTurn() {
		int column;
		int line = 0;
		
		while (true) {
			System.out.print("Player "+id+", please choose a column:\n>> ");
			try {
				column = scanner.nextInt()-1;
			} catch (Exception e) {
				System.out.println("[!] Invalid input.");
				continue;
			}
			if (column > 6 || column < 0) {
				System.out.println("[!] Invalid input.");
				continue;
			}
			
			while (board.checkEmpty(column, line) == true && line < 6) {
				line++;
			}
			line--;
			if (board.checkEmpty(column, line) == true) {
				board.setValue(column, line, id);
				break;
			} else {
				line = 0;
				System.out.println("[!] This column is already full!");
			}
		}
		
		if (board.checkVictory(column, line, id) == true) {
			board.drawBoard();
			System.out.println("Player "+id+" won the game!");
			return true;
		}
		if (board.checkDraw() == true) {
			board.drawBoard();
			System.out.println("The game ended in a draw!");
			return true;
		}
		return false;
		
	}
}
