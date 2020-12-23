package controller;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class MenuController extends Controller {
	@FXML
    private Button startButton;

    @FXML
    private Slider levelSlider;

    @FXML
    void onStartButtonClick(Event event) {
    	mainController.setAgentLevel((int) levelSlider.getValue());
    	mainController.changeScene(mainController.GAME_VIEW);

    }
}
