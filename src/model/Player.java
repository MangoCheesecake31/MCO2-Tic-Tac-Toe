package model;

import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

public class Player {
	// // // Attributes
	private NBoard game;
	private int level;
	private CodeTable table;


	// // // Constructors
	public Player(NBoard game, int level) {
		this.game = game;
		this.level = level;

		if (level == 1) {
			table = new CodeTable();
		}
	}



	// // // Methods
	public char getNextMove() {
		switch (level) {
			case 0: return level0Move();
			case 1: return level1Move();
			// case 2: return level2Move();
		}

		return '-';
	}

	private char level0Move() {												// Random Valid Moves
		// Get Move Options
		ArrayList<Character> valid_moves = game.getValidMoves();

		// Decision
		Random rd = new Random();
		return valid_moves.get(rd.nextInt(valid_moves.size()));
	}

	private char level1Move() {		
		return table.getMove(game.toString());
	}

	private char level2Move() {
		return '-';
	}		
}