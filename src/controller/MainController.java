package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class MainController {
	// // // Attributes
	private Stage primaryStage;
	protected int agent_level = 0;

	private final int MENU_VIEW = 1;
	private final int GAME_VIEW = 2;



	// // // Constructors
	public MainController(Stage stage) {
		// Stage setup
		primaryStage = stage;
		primaryStage.setTitle("TicTacToe Game");
        primaryStage.setResizable(false);
        primaryStage.centerOnScreen();
        changeScene(GAME_VIEW);
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

		file_name = "TicTacToeView";				// TO REMOVE
		// Load FXML File
		loader.setLocation(getClass().getResource("/view/" + file_name + ".fxml"));

		// Set Scene
		try {
			primaryStage.setScene(new Scene(loader.load()));

		} catch (IOException e) {
			 System.out.println("OOF");
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
}