import model.*;
import java.util.Scanner;
import java.util.Hashtable;

public class Driver {
	public static void main(String[] args) {

		CodeTable table = new CodeTable();	
	
		/* Default Driver */
		Scanner sc = new Scanner(System.in);

		NBoard game = new NBoard(true);
		Player agent = new Player(game, 1);

		game.printBoard();	
		while (game.getGameState() == NBoard.ONGOING) {
		

			if (game.isPTurn()) {
				game.enterMove(sc.next().toUpperCase().charAt(0));
			} else {
				game.enterMove(agent.getNextMove());
			}


			System.out.println(game.getGameStateString());

			game.printBoard();
			System.out.println(game);
			System.out.println(game.getValidMoves());
			System.out.println(game.getMoveHistory());

			System.out.println("-------------------------");
		}

		System.out.println(game.getGameStateString());
		System.out.println("-------------------------");
	}
}