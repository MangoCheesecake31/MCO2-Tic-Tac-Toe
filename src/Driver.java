import model.*;
import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Sample
		Board game = new Board();

		Player agent = new Player(game, 0);
					
		game.printBoard();	
		while (game.isInGame()) {
			System.out.println(game.getResult());
			
			if (game.isXTurn()) {									// Human
				game.enterMove(sc.next().toUpperCase().charAt(0));

			} else {												// Bot
				game.enterMove(agent.getNextMove());

			}
			
			game.printBoard();
			System.out.println("-------------------------");
		}

		System.out.println("The Winner is " + game.getResult());
		System.out.println("-------------------------");
	}
}