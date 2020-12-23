package controller;

import model.*;
import javafx.fxml.FXML;
import javafx.event.Event;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.image.*;


public class GameController extends Controller {
	// // // Attributes
    private Board game = new Board();

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
    private Button clearButton;

    @FXML
    private Label endCardLabel;

    // // // Events
    @FXML
    public void onBackButtonClick(Event event) {
        mainController.changeScene(mainController.MENU_VIEW);

    }

    @FXML
    public void onClearButtonClick(Event event) {
        mainController.changeScene(mainController.GAME_VIEW);

    }

    @FXML
    public void onTileAButtonClick(Event event) {
        if (game.isInGame()) {
            game.enterMove('A');
            updateImage(tileAButton, game.isXTurn());

        }
        update();
    }

    @FXML
    public void onTileBButtonClick(Event event) {
        if (game.isInGame()) {
            game.enterMove('B');
            updateImage(tileBButton, game.isXTurn());

        }
        update();
    }

    @FXML
    public void onTileCButtonClick(Event event) {
        if (game.isInGame()) {
            game.enterMove('C');
            updateImage(tileCButton, game.isXTurn());

        }
        update();
    }

    @FXML
    public void onTileDButtonClick(Event event) {
        if (game.isInGame()) {
            game.enterMove('D');
            updateImage(tileDButton, game.isXTurn());

        }
        update();
    }

    @FXML
    public void onTileEButtonClick(Event event) {
        if (game.isInGame()) {
            game.enterMove('E');
            updateImage(tileEButton, game.isXTurn());

        }
        update();
    }

    @FXML
    public void onTileFButtonClick(Event event) {
        if (game.isInGame()) {
            game.enterMove('F');
            updateImage(tileFButton, game.isXTurn());

        }
        update();
    }

    @FXML
    public void onTileGButtonClick(Event event) {
        if (game.isInGame()) {
            game.enterMove('G');
            updateImage(tileGButton, game.isXTurn());

        }
        update();
    }

    @FXML
    public void onTileHButtonClick(Event event) {
        if (game.isInGame()) {
            game.enterMove('H');
            updateImage(tileHButton, game.isXTurn());

        }
        update();
    }

    @FXML
    public void onTileIButtonClick(Event event) {
        if (game.isInGame()) {
            game.enterMove('I');
            updateImage(tileIButton, game.isXTurn());

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
        System.out.println(game.getResult());
    }

    private void update() {
        if (!game.isInGame()) {                              // Game is finished

            switch (game.getResult()) {
                case "X-WIN" -> endCardLabel.setText("X Wins!");
                case "O-WIN" -> endCardLabel.setText("O Wins!");
                case "DRAW" -> endCardLabel.setText("DRAW!");
            }
        }                             
    }
}
