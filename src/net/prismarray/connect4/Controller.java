package net.prismarray.connect4;

import java.util.Scanner;

public class Controller {
	Scanner scanner = new Scanner(System.in);
	int id;
	
	public Controller(int id) {
		this.id = id;
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
			
			while (Board.checkEmpty(column, line) == true && line < 6) {
				line++;
			}
			line--;
			if (Board.checkEmpty(column, line) == true) {
				Board.setValue(column, line, id);
				break;
			} else {
				line = 0;
				System.out.println("[!] This column is already full!");
			}
		}
		
		if (Board.checkVictory(column, line, id) == true) {
			Board.drawBoard();
			System.out.println("Player "+id+" won the game!");
			return true;
		}
		if (Board.checkDraw() == true) {
			Board.drawBoard();
			System.out.println("The game ended in a draw!");
			return true;
		}
		return false;
		
	}
}
