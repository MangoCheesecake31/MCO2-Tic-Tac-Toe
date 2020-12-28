package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class MainController {
	// // // Attributes
	private Stage primaryStage;
	protected int agent_level = 0;
	protected boolean isFirstPlayer = true;

	public final int MENU_VIEW = 1;
	public final int GAME_VIEW = 2;



	// // // Constructors
	public MainController(Stage stage) {
		// Stage setup
		primaryStage = stage;
		primaryStage.setTitle("TicTacToe Game");
        primaryStage.setResizable(false);
        primaryStage.centerOnScreen();
        changeScene(MENU_VIEW);
	}



	// // // Methods
	public void changeScene(int view) {
		FXMLLoader loader = new FXMLLoader();

		String file_name;
		switch (view) {
			case MENU_VIEW -> file_name = "MenuView";
			case GAME_VIEW -> file_name = "TicTacToeView";
			default 	   -> file_name = "";
		}

		// Load FXML File
		loader.setLocation(getClass().getResource("/view/" + file_name + ".fxml"));

		// Set Scene
		try {
			primaryStage.setScene(new Scene(loader.load()));

		} catch (IOException e) {
			 System.out.println("Load Fail");
			 e.printStackTrace();

		}

		// Set Controllers
		Controller controller = loader.getController();
		controller.setMainController(this);

		// Display
		primaryStage.show();
	}

	public void setAgentLevel(int level) {
		agent_level = level;
	}

	public void setIsFirstPlayer(boolean condition) {
		isFirstPlayer = condition;
	}
}