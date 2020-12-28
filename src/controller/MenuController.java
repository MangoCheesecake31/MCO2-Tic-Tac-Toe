package controller;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class MenuController extends Controller {
	@FXML
    private Button xStartButton;

	@FXML
    private Button oStartButton;

    @FXML
    private Slider levelSlider;

    @FXML
    public void onXStartButtonClick(Event event) {
    	System.out.println("X");

    	mainController.setAgentLevel((int) levelSlider.getValue());
    	mainController.setIsFirstPlayer(true);

    	mainController.changeScene(mainController.GAME_VIEW);
    }

    @FXML
    public void onOStartButtonClick(Event event) {
    	System.out.println("O");
    	mainController.setAgentLevel((int) levelSlider.getValue());
    	mainController.setIsFirstPlayer(false);

    	mainController.changeScene(mainController.GAME_VIEW);
    }
}
