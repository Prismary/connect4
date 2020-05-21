package net.prismarray.connect4;

import java.util.Scanner;

public class Controller {
	int id;
	
	public Controller(int id) {
		this.id = id;
	}
	
	public void playTurn() {
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
				System.out.println("[!] This Column is already full!");
			}
		}
		
		Board.checkVictory(id);
	}
}
