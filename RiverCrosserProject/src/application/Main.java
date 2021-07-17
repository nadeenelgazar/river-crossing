package application;

import GameEngine.Game;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			viewmanager manager = new viewmanager();
			Game game = new Game();
			game.setview(manager);
			manager.setgame(game);
			primaryStage = manager.getMainStage();
			primaryStage.setTitle("River Crossing Puzzle");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
