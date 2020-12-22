import model.*;
import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Sample
		Board game = new Board();

		game.printBoard();
		while (game.isInGame()) {
			System.out.println(game.getResult());
			game.enterMove(sc.next().toUpperCase().charAt(0));
			game.printBoard();
			System.out.println("-------------------------");
		}

		System.out.println("The Winner is " + game.getResult());
		System.out.println("-------------------------");
	}
}