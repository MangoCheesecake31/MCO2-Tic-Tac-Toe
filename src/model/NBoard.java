package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class NBoard {
	// // // Attributes

	// Board Configuration
	private char[] game_board = new char[9];
	private final char[] tile_names = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'}; 

	// Move History
	private LinkedList<Character> move_history;

	// States
	private int current_game_state;
	private boolean its_x_turn;						// It is Player One's Turn
	private boolean its_p_turn;						// It is the Human Player's Turn (Could be 1st or 2nd)

	public static final int ONGOING = 0;
	public static final int X_WIN = 1;
	public static final int O_WIN = 2;
	public static final int DRAW = 3;



	// // // Constructors 
	public NBoard(Boolean human_first_player) {
		its_p_turn = human_first_player;			// If the Human player is the first player
		resetBoard();								// Setup/Reset the Board
	}



	// // // Methods

	// // Public
	public void enterMove(char position) {
		if (current_game_state == ONGOING) {

			try {
				position = Character.toUpperCase(position);

				// Check If Input Tile is already Marked
				if (game_board[getTilePosition(position)] != ' ') {
					System.out.println("Error: Tile is already Marked by a Player!");
					return;
				}

				// Entering Move
				if (its_x_turn) {									// X Turn/Move
					game_board[getTilePosition(position)] = 'X';

				} else {											// O Turn/Move
					game_board[getTilePosition(position)] = 'O';

				}

				// Update Turn States
				its_x_turn = !its_x_turn;
				its_p_turn = !its_p_turn;

				// Add Move to History
				move_history.push(position);

				// Checking Winner & Updating States
				checkWin();

			} catch (IndexOutOfBoundsException e) {	
				System.out.println("Error: Invalid Tile! (" + position + ") is not a valid tile!");

			}

		} else {
			System.out.println("Error: The Game has already ended.");

		}
	}

	public void undoMove() {
		try {
			game_board[getTilePosition(move_history.pop())] = ' ';
			
			its_x_turn = !its_x_turn;
			its_p_turn = !its_p_turn;

			checkWin();

		} catch (NoSuchElementException e) {
			System.out.println("Error: There are no moves to undo!");

		}
	}

	public void printBoard() {
		System.out.println("+ - - - +");
		
		for (int i = 0; i < 9; i += 3) {
			System.out.println("| " + game_board[i] + " " + game_board[i + 1] + " " + game_board[i + 2] + " |");

		}
			
		System.out.println("+ - - - +");
	}

	public void resetBoard() {

		// Reset Board Configuraton
		for (int i = 0; i < 9; i++) {
			game_board[i] = ' ';
		}

		// Reset Move History
		move_history = new LinkedList<>();

		// Reset Board States
		current_game_state = ONGOING;
		its_x_turn = true;
	}

	// Getters
	public int getGameState() {
		return current_game_state;
	}

	public String getGameStateString() {
		switch (current_game_state) {
			case ONGOING: return "ONGOING";
			case X_WIN  : return "X_WIN";
			case O_WIN  : return "O_WIN";
			case DRAW   : return "DRAW";
			default     : return null;
		}
	}

	public ArrayList<Character> getValidMoves() {
		ArrayList<Character> valid_moves = new ArrayList<>();

		for (int i = 0; i < 9 ; i++) {
			if (game_board[i] == ' ') {
				valid_moves.add(tile_names[i]);

			}
		}

		return valid_moves;
	}

	public LinkedList<Character> getMoveHistory() {
		return move_history;
	}

	public boolean isXTurn() {
		return its_x_turn;
	}

	public boolean isPTurn() {
		return its_p_turn;
	}

	@Override
	public String toString() {
		String code = "";

		for (int i = 0; i < 9; i++) {
			code += game_board[i];
		}

		return code;
	}

	// // Private
	private void checkWin() {				
		// Diagonals
		if (game_board[0] == game_board[4] && game_board[4] == game_board[8]) {				// Left Diagonal
			updateGameState(game_board[4]);
			return;

		} else if (game_board[2] == game_board[4] && game_board[4] == game_board[6]) {		// Right Diagonal
			updateGameState(game_board[4]);
			return;

		}


		// Horizontals
		for (int i = 0; i < 9; i += 3) {
			if (game_board[i] == game_board[i + 1] && game_board[i + 1] == game_board[i + 2]) {
				updateGameState(game_board[i + 1]);
				return;

			}
		}

		// Verticals
		for (int i = 0; i < 3; i++) {
			if (game_board[i] == game_board[i + 3] && game_board[i + 3] == game_board[i + 6]) {
				updateGameState(game_board[i + 3]);
				return;

			}
		}

		updateGameState('-');
	}

	private void updateGameState(char winner) {
		switch (winner) {
			case 'X' -> current_game_state = X_WIN;
			case 'O' -> current_game_state = O_WIN;
			case '-' -> {

				if (move_history.size() == 9) {
					current_game_state = DRAW;

				} else {
					current_game_state = ONGOING;

				}
			} 
			default  -> current_game_state = ONGOING;
		}
	}

	private int getTilePosition(char position) {
		switch (position) {
			case 'A': return 0;
			case 'B': return 1;
			case 'C': return 2;
			case 'D': return 3;
			case 'E': return 4;
			case 'F': return 5;
			case 'G': return 6;
			case 'H': return 7;
			case 'I': return 8;
		}

		return -1;
	}
}