    package controller;

import model.*;
import javafx.fxml.FXML;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.image.*;


public class GameController extends Controller {
	// // // Attributes
    private Board game;
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
            game = new Board(mainController.isFirstPlayer);
            agent = new Player(game, mainController.agent_level);

            startButton.setText("");
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
            if (game.isInGame()) {
                game.enterMove('A');
                updateImage(tileAButton, game.isXTurn());
            }

             update();
        } catch (NullPointerException e) {
            System.out.println("Game has not Started!");

        }
    }

    @FXML
    public void onTileBButtonClick() {
        try {
            if (game.isInGame()) {
                game.enterMove('B');
                updateImage(tileBButton, game.isXTurn());
            }

             update();
        } catch (NullPointerException e) {
            System.out.println("Game has not Started!");

        }
    }

    @FXML
    public void onTileCButtonClick() {
        try {
            if (game.isInGame()) {
                game.enterMove('C');
                updateImage(tileCButton, game.isXTurn());
            }

             update();
        } catch (NullPointerException e) {
            System.out.println("Game has not Started!");

        }
    }

    @FXML
    public void onTileDButtonClick() {
        try {
            if (game.isInGame()) {
                game.enterMove('D');
                updateImage(tileDButton, game.isXTurn());
            }

             update();
        } catch (NullPointerException e) {
            System.out.println("Game has not Started!");

        }
    }

    @FXML
    public void onTileEButtonClick() {
        try {
            if (game.isInGame()) {
                game.enterMove('E');
                updateImage(tileEButton, game.isXTurn());
            }

             update();
        } catch (NullPointerException e) {
            System.out.println("Game has not Started!");

        }
    }

    @FXML
    public void onTileFButtonClick() {
        try {
            if (game.isInGame()) {
                game.enterMove('F');
                updateImage(tileFButton, game.isXTurn());
            }

             update();
        } catch (NullPointerException e) {
            System.out.println("Game has not Started!");

        }
    }

    @FXML
    public void onTileGButtonClick() {
        try {
            if (game.isInGame()) {
                game.enterMove('G');
                updateImage(tileGButton, game.isXTurn());
            }

             update();
        } catch (NullPointerException e) {
            System.out.println("Game has not Started!");

        }
    }

    @FXML
    public void onTileHButtonClick() {
        try {
            if (game.isInGame()) {
                game.enterMove('H');
                updateImage(tileHButton, game.isXTurn());
            }

             update();
        } catch (NullPointerException e) {
            System.out.println("Game has not Started!");

        }
    }

    @FXML
    public void onTileIButtonClick() {
        try {
            if (game.isInGame()) {
                game.enterMove('I');
                updateImage(tileIButton, game.isXTurn());
            }

             update();
        } catch (NullPointerException e) {
            System.out.println("Game has not Started!");

        }
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
        System.out.println(game.getResult());
    }

    private void update() {
        if (!game.isInGame()) {                              // Game is finished

            switch (game.getResult()) {
                case "X-WIN" -> endCardLabel.setText("X Wins!");
                case "O-WIN" -> endCardLabel.setText("O Wins!");
                case "DRAW" -> endCardLabel.setText("DRAW!");
            }
        } else {
            enterAgentMove();

        }                        
    }

    private void enterAgentMove() {
        if (!game.isPlayerTurn()) {                         // If not the Human Player's Turn

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
        }                             
    }
}
