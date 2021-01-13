    package controller;

import model.*;
import javafx.fxml.FXML;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.image.*;


public class GameController extends Controller {
	// // // Attributes
    private NBoard game;
    private Player agent;
    private boolean started = false;

    
    // Images
    private final String o_url = "/resources/circle.png";
    private final String x_url = "/resources/x.png";

    
    @FXML
    private Button tileAButton;
    
    @FXML
    private Button tileBButton;

    @FXML
    private Button tileCButton;

    @FXML
    private Button tileDButton;

    @FXML
    private Button tileEButton;

    @FXML
    private Button tileFButton;

    @FXML
    private Button tileGButton;

    @FXML
    private Button tileHButton;

    @FXML
    private Button tileIButton;

    @FXML
    private Button backButton;

    @FXML
    private Button startButton;

    @FXML
    private Button clearButton;

    @FXML
    private Label endCardLabel;



    // // // Events
    @FXML
    public void onStartButtonClick() {            
        if (!started) {
            // Setup 
            game = new NBoard(mainController.isFirstPlayer);
            agent = new Player(game, mainController.agent_level);

            startButton.setText("");
            endCardLabel.setText(String.valueOf(mainController.agent_level));
            update();
        }     
    }

    @FXML
    public void onBackButtonClick() {
        mainController.changeScene(mainController.MENU_VIEW);

    }

    @FXML
    public void onClearButtonClick() {
        mainController.changeScene(mainController.GAME_VIEW);

    }

    @FXML
    public void onTileAButtonClick() {        
        try {
            if (game.toString().toCharArray()[0] != ' ') {
                // Marked Tile
                return;
            }


            if (game.getGameState() == NBoard.ONGOING) {
                game.enterMove('A');
                updateImage(tileAButton, game.isXTurn());

            } else {
                System.out.println("Error: Game has already reached a Conclusion!");

            }

        } catch (NullPointerException e) {
            System.out.println("Error: Game has not Started!");

        }

        update();
    }

    @FXML
    public void onTileBButtonClick() {
        try {
            if (game.toString().toCharArray()[1] != ' ') {
                // Marked Tile
                return;
            }

            if (game.getGameState() == NBoard.ONGOING) {
                game.enterMove('B');
                updateImage(tileBButton, game.isXTurn());

            } else {
                System.out.println("Error: Game has already reached a Conclusion!");

            }

        } catch (NullPointerException e) {
            System.out.println("Error: Game has not Started!");

        }

        update();
    }

    @FXML
    public void onTileCButtonClick() {
        try {
            if (game.toString().toCharArray()[2] != ' ') {
                // Marked Tile
                return;
            }

            if (game.getGameState() == NBoard.ONGOING) {
                game.enterMove('C');
                updateImage(tileCButton, game.isXTurn());

            } else {
                System.out.println("Error: Game has already reached a Conclusion!");

            }

        } catch (NullPointerException e) {
            System.out.println("Error: Game has not Started!");

        }

        update();
    }

    @FXML
    public void onTileDButtonClick() {
        try {
            if (game.toString().toCharArray()[3] != ' ') {
                // Marked Tile
                return;
            }

            if (game.getGameState() == NBoard.ONGOING) {
                game.enterMove('D');
                updateImage(tileDButton, game.isXTurn());

            } else {
                System.out.println("Error: Game has already reached a Conclusion!");

            }

        } catch (NullPointerException e) {
            System.out.println("Error: Game has not Started!");

        }

        update();
    }

    @FXML
    public void onTileEButtonClick() {
        try {
            if (game.toString().toCharArray()[4] != ' ') {
                // Marked Tile
                return;
            }

            if (game.getGameState() == NBoard.ONGOING) {
                game.enterMove('E');
                updateImage(tileEButton, game.isXTurn());

            } else {
                System.out.println("Error: Game has already reached a Conclusion!");

            }

        } catch (NullPointerException e) {
            System.out.println("Error: Game has not Started!");

        }

        update();
    }

    @FXML
    public void onTileFButtonClick() {
        try {
            if (game.toString().toCharArray()[5] != ' ') {
                // Marked Tile
                return;
            }

            if (game.getGameState() == NBoard.ONGOING) {
                game.enterMove('F');
                updateImage(tileFButton, game.isXTurn());

            } else {
                System.out.println("Error: Game has already reached a Conclusion!");

            }

        } catch (NullPointerException e) {
            System.out.println("Error: Game has not Started!");

        }

        update();
    }

    @FXML
    public void onTileGButtonClick() {
        try {
            if (game.toString().toCharArray()[6] != ' ') {
                // Marked Tile
                return;
            }

            if (game.getGameState() == NBoard.ONGOING) {
                game.enterMove('G');
                updateImage(tileGButton, game.isXTurn());

            } else {
                System.out.println("Error: Game has already reached a Conclusion!");

            }

        } catch (NullPointerException e) {
            System.out.println("Error: Game has not Started!");

        }

        update();
    }

    @FXML
    public void onTileHButtonClick() {
        try {
            if (game.toString().toCharArray()[7] != ' ') {
                // Marked Tile
                return;
            }

            if (game.getGameState() == NBoard.ONGOING) {
                game.enterMove('H');
                updateImage(tileHButton, game.isXTurn());

            } else {
                System.out.println("Error: Game has already reached a Conclusion!");

            }

        } catch (NullPointerException e) {
            System.out.println("Error: Game has not Started!");

        }

        update();
    }

    @FXML
    public void onTileIButtonClick() {
        try {
            if (game.toString().toCharArray()[8] != ' ') {
                // Marked Tile
                return;
            }

            if (game.getGameState() == NBoard.ONGOING) {
                game.enterMove('I');
                updateImage(tileIButton, game.isXTurn());

            } else {
                System.out.println("Error: Game has already reached a Conclusion!");

            }

        } catch (NullPointerException e) {
            System.out.println("Error: Game has not Started!");

        }

        update();
    }

    // // // Methods
    private void updateImage(Button tile, boolean xturn) {
        // Update Tile Icons
        if (!xturn) {
            tile.setGraphic(new ImageView(new Image(x_url)));

        } else {
            tile.setGraphic(new ImageView(new Image(o_url)));

        }

        System.out.println("-------------------------");
        game.printBoard();
        System.out.println("State: " + game.getGameStateString());
        System.out.println("X_TURN: " + game.isXTurn());
        System.out.println("P_TURN: " + game.isPTurn());
    }

    private void update() {
        try {
            if (game.getGameState() != NBoard.ONGOING) {                              // Game is finished

                switch (game.getGameState()) {
                    case NBoard.X_WIN -> endCardLabel.setText("X Wins!");
                    case NBoard.O_WIN -> endCardLabel.setText("O Wins!");
                    case NBoard.DRAW  -> endCardLabel.setText("DRAW!");
                }
            } else {
                enterAgentMove();

            }                        
        } catch (NullPointerException e) {

        }
    }

    private void enterAgentMove() {
        if (!game.isPTurn()) {                                  // If not the Human Player's Turn
            try {
                switch (agent.getNextMove()) {                  // Get Agent Move and Press Tile Button
                    case 'A' -> onTileAButtonClick();
                    case 'B' -> onTileBButtonClick();
                    case 'C' -> onTileCButtonClick();
                    case 'D' -> onTileDButtonClick();
                    case 'E' -> onTileEButtonClick();
                    case 'F' -> onTileFButtonClick();
                    case 'G' -> onTileGButtonClick();
                    case 'H' -> onTileHButtonClick();
                    case 'I' -> onTileIButtonClick();
                    default  -> System.out.println("Something went very wrong!");
                }
            } catch (NullPointerException e) {
                System.out.println("Hashtable Error!");

            }
        }                             
    }
}
