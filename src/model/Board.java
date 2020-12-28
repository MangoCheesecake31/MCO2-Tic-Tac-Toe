package model;

import java.util.ArrayList;

public class Board {
	// // // Attributes
	public final static char[] VALID_SYMBOLS = {'O', 'X', ' '};
	public final static String[] VALID_RESULTS = {"ONGOING", "X-WIN", "O-WIN", "DRAW"};

	// States
	private boolean player_turn;				// Is it the Human Player's Turn?
	private boolean x_turn;						// Is it the First Player's Turn?
	private boolean in_game;					// Is the Game ongoing?
	private String result;
	private int move_count;

	// Board 
	private char[][] game_board = new char[3][3];

	// Board Positions
	private final static int[] tile_A = {0, 0};
	private final static int[] tile_B = {1, 0};
	private final static int[] tile_C = {2, 0};		
	private final static int[] tile_D = {0, 1};		//	| A | B | C |
	private final static int[] tile_E = {1, 1};		//	| D | E | F |
	private final static int[] tile_F = {2, 1};		//	| G | H | I |
	private final static int[] tile_G = {0, 2};
	private final static int[] tile_H = {1, 2};
	private final static int[] tile_I = {2, 2};

	// Board Map (Reference for getting Valid Moves)
	private final char[][] game_map = {{'A', 'D', 'G'},
									   {'B', 'E', 'H'},
									   {'C', 'F', 'I'}};



	// // // Constructors
	public Board(Boolean first_player) {
		// True if Human Player is First
		player_turn = first_player;
		resetBoard();
	}



	// // // Methods
	public void enterMove(char position) {
		if (in_game) {																// If Game is ongoing, add player's new move
			try {
				// Get Position Array
				int[] location = getTilePosition(position);

				// Check if specified tile already has input (Marked)		
				if (game_board[location[0]][location[1]] != ' ') {					// Set to Null to trigger NullPointerException
					location = null;
				}

				// Update Board with new Move
				if (x_turn)	{										// X's Move
					game_board[location[0]][location[1]] = 'X';
					x_turn = false;

				} else {											// O's Move
					game_board[location[0]][location[1]] = 'O';
					x_turn = true;
				}

				// Increment Counter
				move_count++;

				// Check Win/Draw/Lose
				char winner = checkWin();
				System.out.println(winner);

				// Update States
				switch (winner) {
					case 'X' -> {
							result = "X-WIN";
							in_game = false;
					}

					case 'O' -> {
							result = "O-WIN";
							in_game = false;
					}

					case '-' -> {
						if (move_count == 9) {
							result = "DRAW";
							in_game = false;
						}
					}
				}

				// Player Turn
				player_turn = !player_turn;

			} catch (NullPointerException e) {
				System.out.println("Invalid tile position!");

			}
		} else {
			System.out.println("The Game is already finished!");

		}
	}

	public void printBoard() {
		System.out.println("+ - - - +");
		
		String line;

		for (int i = 0; i < 3; i++) {
			
			line = "| ";
			for (int j = 0; j < 3; j++) {
				line = line + game_board[j][i] + " ";
			}
			line = line + "|";

			System.out.println(line);
		}

		System.out.println("+ - - - +");
	}

	public String getResult() {
		return result;
	}

	public boolean isInGame() {
		return in_game;
	}

	public boolean isXTurn() {
		return x_turn;
	}

	public boolean isPlayerTurn() {
		return player_turn;
	}

	public void resetBoard() {
		// Set Counter
		move_count = 0;

		// Set Board Tiles to " "
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				game_board[i][j] = ' ';
			}
		}

		// Set States to Default
		result = "ONGOING";
		x_turn = true;					// Is it X's Turn?
	 	in_game = true;					// Is the Game ongoing?
	}

	private char checkWin() {
		// Diagonals
		if ((game_board[0][0] == game_board[1][1]) && (game_board[1][1] == game_board[2][2]) ){				// Right Diagonal
			return game_board[1][1];

		} else if ((game_board[0][2] == game_board[1][1]) && (game_board[1][1] == game_board[2][0])) {		// Left Diagonal
			return game_board[1][1];

		}	

		// Verticals & Horizontals
		for (int i = 0; i < 3; i++) {
			if ((game_board[i][0] == game_board[i][1]) && (game_board[i][1] == game_board[i][2])) {			// Vertical
				return game_board[i][1];

			} else if ((game_board[0][i] == game_board[1][i]) && (game_board[1][i] == game_board[2][i])) {	// Horizontal
				return game_board[1][i];

			}	
		}

		return '-';																							// returns 'X', 'O', '-'
	}

	private int[] getTilePosition(char position) {
		switch (position) {
			case'A': return tile_A;
			case'B': return tile_B;
			case'C': return tile_C;
			case'D': return tile_D;
			case'E': return tile_E;
			case'F': return tile_F;
			case'G': return tile_G;
			case'H': return tile_H;
			case'I': return tile_I;
			default: return null;
		}
	}

	protected ArrayList<Character> getValidMoves() {
		ArrayList<Character> valid_moves = new ArrayList<>();

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				
				if (game_board[i][j] == ' ') {
					valid_moves.add(game_map[i][j]);
				}
			}
		}

		return valid_moves;
	}
}