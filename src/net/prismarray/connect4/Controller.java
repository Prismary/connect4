package net.prismarray.connect4;

import java.util.Scanner;

public class Controller {
	int id;
	
	public Controller(int id) {
		this.id = id;
	}
	
	public boolean playTurn() {
		Scanner scanner = new Scanner(System.in);
		int column;
		int line = 0;
		
		while (true) {
			System.out.println("\nPlayer "+id+", please choose a column:\n>> ");
			column = scanner.nextInt();
			scanner.close();
			
			while (Board.checkEmpty(column, line) == true) {
				line++;
			}
			
			if (line <= 5) {
				line--;
				Board.setValue(column, line, id);
				break;
			} else {
				line = 0;
				System.out.println("[!] This column is already full!");
			}
		}
		
		if (Board.checkVictory(column, line, id) == true) {
			System.out.println("\nPlayer "+id+" won the game!");
			return true;
		}
		if (Board.checkDraw() == true) {
			System.out.println("\nThe game ended in a draw!");
			return true;
		}
		return false;
		
	}
}
