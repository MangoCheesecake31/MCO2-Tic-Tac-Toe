package model;

public class Board {
	// // // Attributes
	public final char[] VALID_SYMBOLS = {'O', 'X', ' '};
	public final String[] VALID_RESULTS = {"ONGOING", "X-WIN", "O-WIN", "DRAW"};

	// States
	private boolean x_turn;						// Is it Crosses' Turn?
	private boolean in_game;					// Is the Game ongoing?
	private String result;
	private int move_count;

	// Board 
	private char[][] game_board = new char[3][3];

	// Board Positions
	private final int[] tile_A = {0, 0};
	private final int[] tile_B = {1, 0};
	private final int[] tile_C = {2, 0};		
	private final int[] tile_D = {0, 1};		//	| A | B | C |
	private final int[] tile_E = {1, 1};		//	| D | E | F |
	private final int[] tile_F = {2, 1};		//	| G | H | I |
	private final int[] tile_G = {0, 2};
	private final int[] tile_H = {1, 2};
	private final int[] tile_I = {2, 2};



	// // // Constructors
	public Board() {
		resetBoard();
	}



	// // // Methods
	public void enterMove(char position) {
		if (in_game) {							// If Game is ongoing, add new move
			try {
				// Get Position Array
				int[] location = getTilePosition(position);

				// Check if specified tile already has input (Marked)		
				if (game_board[location[0]][location[1]] != ' ') {	// Set to Null to trigger NullPointerException
					location = null;
				}

				// Update Board with new Move
				if (x_turn)	{				// X's Move
					game_board[location[0]][location[1]] = 'X';
					x_turn = false;

				} else {					// O's Move
					game_board[location[0]][location[1]] = 'O';
					x_turn = true;
				}

				// Increment Counter
				move_count++;

				// Check Win/Draw/Lose
				char winner = checkWin();
				System.out.println(winner);

				// Update States
				if (winner != '-' && winner != ' ') {				// Game is Finished
					in_game = false;
				}

				// Update Result
				if (move_count == 9) {								// DRAW
					result = "DRAW";

				} else {											// X or O WIN
					switch (winner) {
						case'X' -> result = "X-WIN";
						case'O' -> result = "O-WIN";
					}
				}

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
}