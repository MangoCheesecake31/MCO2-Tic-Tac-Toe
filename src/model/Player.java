package model;

import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

public class Player {
	// // // Attributes
	private Board game;
	private int level;
	//private ArrayList<Character> valid_moves = new ArrayList<>(Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'));



	// // // Constructors
	public Player(Board game, int level) {
		this.game = game;
		this.level = level;
	}



	// // // Methods
	public char getNextMove() {
		switch (level) {
			case 0: return level0Move();
			// case 1: return level0Move();
			// case 2: return level0Move();
			// case 3: return level0Move();
			// case 4: return level0Move();
			// case 5: return level0Move();
		}

		return '-';
	}

	public char level0Move() {												// Random Valid Moves
		// Get Move Options
		ArrayList<Character> valid_moves = game.getValidMoves();

		// Decision
		Random rd = new Random();
		return valid_moves.get(rd.nextInt(valid_moves.size()));
	}
}