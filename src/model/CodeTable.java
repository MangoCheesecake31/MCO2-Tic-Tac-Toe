package model;

import java.util.Hashtable;

public class CodeTable {
	// // // Attributes
	private Hashtable<String, Character> table;
	private int count = 0;


	// // // Constructors
	public CodeTable() {
		NBoard game = new NBoard(true);
		table = new Hashtable<>();

		// Generate Table
		generate(game);
	}



	// // // Methods
	public char getMove(String code) {
		return table.get(code);
	}

	private void generate(NBoard game) {

		count++;
		table.put(game.toString(), moveDecision(game));

		//System.out.println(count + " : " + game + " : " + game.getGameStateString() + " : " + moveDecision(game));

		// Branch to Valid Moves
		for (char move: game.getValidMoves()) {
			if (game.getGameState() == NBoard.ONGOING) {
				game.enterMove(move);
				generate(game);
				game.undoMove();
			}
		}
	}

	public char moveDecision(NBoard game) {
		int heuristic_val;
		int low_heuristic = 9;
		char max_move = '-';

		// Winning Move

		// Enemy Winning Move

		// Heuristic
		for (char move: game.getValidMoves()) { 

			if (game.getGameState() == NBoard.ONGOING) {
				game.enterMove(move);

				if (game.getGameState() != NBoard.ONGOING) {							// Meaning Won or Draw
					game.undoMove();
					return move;
				}

				if (game.isXTurn()) {
					heuristic_val = getHeuristics(game.toString(), "X_PLAYER");
				} else {
					heuristic_val = getHeuristics(game.toString(), "O_PLAYER");
				}
					
				if (low_heuristic >= heuristic_val) {
					max_move = move;
					low_heuristic = heuristic_val;
				}

				game.undoMove();
			}
		}	

		return max_move;
	}

	public int getHeuristics(String game_code, String player) {
		int heuristic_value = 8;
		char opponent;

		char[] code = game_code.toCharArray();

		if (player == "X_PLAYER") {										// Get Heuristic of X
			opponent = 'O';

		} else {														// Get Heuristic of O
			opponent = 'X';

		} 

		// Diagonals
		if (code[0] == opponent || code[4] == opponent || code[8] == opponent) {				// Left Diagonal
			heuristic_value--;

		} 

		if (code[2] == opponent || code[4] == opponent || code[6] == opponent) {				// Right Diagonal
			heuristic_value--;
			
		} 


		// Horizontals
		for (int i = 0; i < 9; i += 3) {
			if (code[i] == opponent || code[i + 1] == opponent || code[i + 2] == opponent) {
				heuristic_value--;

			}
		}

		// Verticals
		for (int i = 0; i < 3; i++) {
			if (code[i] == opponent || code[i + 3] == opponent || code[i + 6] == opponent) {
				heuristic_value--;

			}
		}

		return heuristic_value;
	}
}  