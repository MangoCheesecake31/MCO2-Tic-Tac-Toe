import model.*;

public class Driver {
	public static void main(String[] args) {
		
		// Sample
		Board game = new Board();

		game.enterMove('A');
		game.printBoard();
		System.out.println(game.getResult());

		game.enterMove('D');
		game.printBoard();
		System.out.println(game.getResult());

		game.enterMove('E');
		game.printBoard();
		System.out.println(game.getResult());

		game.enterMove('G');
		game.printBoard();
		System.out.println(game.getResult());
	}
}