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
			case 2: return level2Move();
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
		try {
			NBoard game_copy = (NBoard) game.clone();

			int bestScore = Integer.MIN_VALUE;
			char bestMove = '-';

			for(char move: game_copy.getValidMoves()) {
				game_copy.enterMove(move);
				int score = minimax(game_copy, true);
				game_copy.undoMove();
				if(score > bestScore) {
					bestScore = score;
					bestMove = move;
				}
			}

			return bestMove;
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

		return '-';
	}

	public int minimax(NBoard game, boolean isMaximizing) {
		int bestScore;

		switch(game.getGameState()) {
			case NBoard.X_WIN: return -1;
			case NBoard.O_WIN: return 1;
			case NBoard.DRAW: return 0;
		}

		if(isMaximizing) {
			bestScore = Integer.MIN_VALUE;
			for(char move: game.getValidMoves()) {
				if(game.getGameState() == NBoard.ONGOING) {
					game.enterMove(move);
					int score = minimax(game, false);
					game.undoMove();
					bestScore = Math.max(score, bestScore);
				}
			}
		} else {
			bestScore = Integer.MAX_VALUE;
			for(char move: game.getValidMoves()) {
				if(game.getGameState() == NBoard.ONGOING) {
					game.enterMove(move);
					int score = minimax(game, true);
					game.undoMove();
					bestScore = Math.min(score, bestScore);
				}
			}
		}
		return bestScore;
	}
}