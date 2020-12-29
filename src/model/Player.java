package model;

import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

public class Player {
	// // // Attributes
	private NBoard game;
	private int level;



	// // // Constructors
	public Player(NBoard game, int level) {
		this.game = game;
		this.level = level;
	}



	// // // Methods
	public char getNextMove() {
		switch (level) {
			case 0: return level0Move();
			// case 1: return level1Move();
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
		// TODO LIST
		// Generate Table (hash?)
		// Assign Optimal Moves per Board State
		// output based on board code?
		
		return '-';
	}

	private char level2Move() {
		return '-';
	}		
}