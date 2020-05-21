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
			System.out.println("Player "+id+", please choose a column:\n>> ");
			column = scanner.nextInt();
			scanner.close();
			
			while (board.checkValue(column, line, id) == false) {
				line++;
			}
			
			board.setValue(column, line, id);
			
		}
	}
}
