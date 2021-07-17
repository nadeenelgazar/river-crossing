package application;

import java.awt.List;
import java.nio.file.Paths;
import java.util.ArrayList;

import Actors.Carnivorous;
import Actors.Farmer;
import Actors.Herbivorous;
import Actors.ICrosser;
import Actors.Plant;
import GameEngine.Game;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import model.fxxxbutton;
import model.Levelsbuttons;
import model.farmer_subscene;
//import model.resources.farmersubs;
import model.fxxsubscene;
import model.goatsubscene;
import model.plantsubscene;
import model.wolfsubscene;

public class level2 {
	private AnchorPane mainPane;
	private Scene level1Scene;
	private Stage level1Stage;
	private fxxsubscene creditssub;
	Scene scene;
	Stage menustage;

	private farmer_subscene farmer1;
	private model.farmer2 farmer2;
	private model.farmer3 farmer3;
	private model.farmer4 farmer4;
	public goatsubscene goat;
	Game game;

	private boolean farmeronboat = false;

	private java.util.List<ICrosser> crossersOnBoat;
	java.util.List<ICrosser> crossers = new ArrayList<ICrosser>();
	viewmanager fring = new viewmanager();

	public void createsubscene() {
		creditssub = new fxxsubscene();
		mainPane.getChildren().add(creditssub);
		goat = new goatsubscene(crossers.get(4));
		mainPane.getChildren().add(goat);
		farmer1 = new farmer_subscene(crossers.get(0));
		mainPane.getChildren().add(farmer1);
		farmer2 = new model.farmer2(crossers.get(1));
		mainPane.getChildren().add(farmer2);
		farmer3 = new model.farmer3(crossers.get(2));
		mainPane.getChildren().add(farmer3);
		farmer4 = new model.farmer4(crossers.get(3));
		mainPane.getChildren().add(farmer4);

	}

	public void createlevel2(Stage menustage) {
		this.menustage = menustage;
		this.menustage.hide();
		level1Stage.setTitle("Level 2");
		level1Stage.show();

	}

	public level2(java.util.List<ICrosser> crossers, Game game) {

		this.crossers = crossers;
		this.game = game;
		viewmanager x = new viewmanager();
		mainPane = new AnchorPane();
		String mainPanestyle = "-fx-background-image: url('file:backgrounfinal.jpeg');";
		mainPane.setStyle(mainPanestyle);
		level1Scene = new Scene(mainPane, 850, 625);
		level1Stage = new Stage();
		level1Stage.setScene(level1Scene);
		Levelsbuttons button1 = new Levelsbuttons("GO!!");
		Levelsbuttons button2 = new Levelsbuttons("solve");
		Levelsbuttons button3 = new Levelsbuttons("undo");
		Levelsbuttons button4 = new Levelsbuttons("redo");
		Levelsbuttons button5 = new Levelsbuttons("save");
		Levelsbuttons button6 = new Levelsbuttons("reset");
		Levelsbuttons button7 = new Levelsbuttons("back");
		Label label1 = new Label(crossers.get(0).getLabelToBeShown());
		Label label2 = new Label(crossers.get(1).getLabelToBeShown());
		Label label3 = new Label(crossers.get(2).getLabelToBeShown());
		Label label4 = new Label(crossers.get(3).getLabelToBeShown());
		Label label5 = new Label(crossers.get(4).getLabelToBeShown());
		Label label6 = new Label("Number of moves: " + String.valueOf(game.getNumberOfSails()));
		VBox v2 = new VBox();
		v2.getChildren().add(label1);
		v2.getChildren().add(label2);
		v2.getChildren().add(label3);
		v2.getChildren().add(label4);
		v2.getChildren().add(label5);
		v2.getChildren().add(label6);
		v2.setLayoutX(0);
		v2.setLayoutY(500);

		VBox v = new VBox();
		v.getChildren().add(button1);
		
		HBox h = new HBox();
		h.getChildren().add(button3);
		h.getChildren().add(button4);
		h.getChildren().add(button5);
		h.getChildren().add(button6);
		h.getChildren().add(button7);
		h.getChildren().add(button2);
		h.setSpacing(50);
		h.setLayoutX(0);
		h.setLayoutY(0);

		v.setSpacing(25);
		mainPane.getChildren().add(v);
		mainPane.getChildren().add(h);
		mainPane.getChildren().add(v2);

		v.setLayoutX(400);
		v.setLayoutY(50);
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Hello");
		alert.setHeaderText("Instructions");
		alert.setContentText(game.getLevel2logic().getInstructions()[0] + game.getLevel2logic().getInstructions()[1]
				+ game.getLevel2logic().getInstructions()[2]);
		alert.showAndWait();

		button1.setOnAction(m -> {
			boolean goatonboat = false;
			boolean farmer1onboat = false;
			boolean farmer2onboat = false;
			boolean farmer3onboat = false;
			boolean farmer4onboat = false;
			ArrayList<ICrosser> crossersOnBoat = new ArrayList<>();

			if ((creditssub.getTranslateX() > -430) || (creditssub.getTranslateX() < -537)) {
				if ((goat.getTranslateX() < -318 && goat.getTranslateX() > -430)
						^ (goat.getTranslateX() < -537 && goat.getTranslateX() > -655)) {

					goatonboat = true;
				}
			}
			if ((farmer1.getTranslateX() < -318 && farmer1.getTranslateX() > -430)
					^ (farmer1.getTranslateX() < -537 && farmer1.getTranslateX() > -655)) {
				farmer1onboat = true;
			}
			if ((farmer4.getTranslateX() < -318 && farmer4.getTranslateX() > -430)
					^ (farmer4.getTranslateX() < -537 && farmer4.getTranslateX() > -655)) {
				farmer4onboat = true;
			}

			if ((farmer3.getTranslateX() < -318 && farmer3.getTranslateX() > -430)
					^ (farmer3.getTranslateX() < -537 && farmer3.getTranslateX() > -655)) {
				farmer3onboat = true;
			}
			if ((farmer2.getTranslateX() < -318 && farmer2.getTranslateX() > -430)
					^ (farmer2.getTranslateX() < -537 && farmer2.getTranslateX() > -655)) {
				farmer2onboat = true;
			}
			if (game.isBoatOnTheLeftBank() == false) {

				if (farmer1onboat == true) {
					System.out.println(crossers.size());
					for (int j = 0; j < game.getCrossersOnRightBank().size(); j++) {
						if (game.getCrossersOnRightBank().get(j).getweight() == 90)
							crossersOnBoat.add(game.getCrossersOnRightBank().get(j));
					}
				}

				if (goatonboat == true) {
					for (int j = 0; j < game.getCrossersOnRightBank().size(); j++) {
						if (game.getCrossersOnRightBank().get(j) instanceof Herbivorous)
							crossersOnBoat.add(game.getCrossersOnRightBank().get(j));
					}
				}

				if (farmer2onboat == true) {
					for (int j = 0; j < game.getCrossersOnRightBank().size(); j++) {
						if (game.getCrossersOnRightBank().get(j).getweight() == 80)
							crossersOnBoat.add(game.getCrossersOnRightBank().get(j));
					}
				}

				if (farmer3onboat == true) {
					for (int j = 0; j < game.getCrossersOnRightBank().size(); j++) {
						if (game.getCrossersOnRightBank().get(j).getweight() == 60)
							crossersOnBoat.add(game.getCrossersOnRightBank().get(j));

					}
				}
				if (farmer4onboat == true) {

					for (int j = 0; j < game.getCrossersOnRightBank().size(); j++) {
						if (game.getCrossersOnRightBank().get(j).getweight() == 40)
							crossersOnBoat.add(game.getCrossersOnRightBank().get(j));
					}
				}

			} else {
				if (farmer1onboat == true) {
					System.out.println(game.getCrossersOnLeftBank().size());
					for (int j = 0; j < game.getCrossersOnLeftBank().size(); j++) {
						if (game.getCrossersOnLeftBank().get(j).getweight() == 90)
							crossersOnBoat.add(game.getCrossersOnLeftBank().get(j));
					}
				}

				if (goatonboat == true) {
					for (int j = 0; j < game.getCrossersOnLeftBank().size(); j++) {
						if (game.getCrossersOnLeftBank().get(j) instanceof Herbivorous)
							crossersOnBoat.add(game.getCrossersOnLeftBank().get(j));
					}
				}

				if (farmer2onboat == true) {
					for (int j = 0; j < game.getCrossersOnLeftBank().size(); j++) {
						if (game.getCrossersOnLeftBank().get(j).getweight() == 80)
							crossersOnBoat.add(game.getCrossersOnLeftBank().get(j));
					}
				}

				if (farmer3onboat == true) {
					for (int j = 0; j < game.getCrossersOnLeftBank().size(); j++) {
						if (game.getCrossersOnLeftBank().get(j).getweight() == 60)
							crossersOnBoat.add(game.getCrossersOnLeftBank().get(j));
					}
				}
				if (farmer4onboat == true) {
					for (int j = 0; j < game.getCrossersOnLeftBank().size(); j++) {
						if (game.getCrossersOnLeftBank().get(j).getweight() == 40)
							crossersOnBoat.add(game.getCrossersOnLeftBank().get(j));
					}
				}
			}

			for (int i = 0; i < crossersOnBoat.size(); i++)
				System.out.println("on boat gui" + crossersOnBoat.get(i));

			if (game.canMove(crossersOnBoat, game.isBoatOnTheLeftBank())) {

				game.doMove(crossersOnBoat, game.isBoatOnTheLeftBank());

				boolean k = creditssub.moveSubscene();
				goat.moveSubscene(game.isBoatOnTheLeftBank());
				farmer1.moveSubscene(game.isBoatOnTheLeftBank());
				farmer2.moveSubscene(game.isBoatOnTheLeftBank());
				farmer3.moveSubscene(game.isBoatOnTheLeftBank());
				farmer4.moveSubscene(game.isBoatOnTheLeftBank());
				System.out.println("print for go " + game.isBoatOnTheLeftBank());
				if (game.getCrossersOnLeftBank().size() == 5) {
					Alert alert2 = new Alert(AlertType.INFORMATION);
					alert2.setTitle("Hello");
					alert2.setHeaderText("Instructions");
					alert2.setContentText("bravo");
					alert2.showAndWait();
					button7.fire();
				}
			}
			label6.setText("Number of moves: " + String.valueOf(game.getNumberOfSails()));
		});

		button3.setOnAction(m -> {
			if (game.canUndo()) {
				game.commandundo();
				this.crossersOnBoat = game.getCrossers();
				System.out.println("print for undo " + game.isBoatOnTheLeftBank());
				System.out.println("size of crossers undo gui " + this.crossersOnBoat.size());
				creditssub.moveSubscene();
				for (int i = 0; i < this.crossersOnBoat.size(); i++) {
					if ((this.crossersOnBoat.get(i).getweight() == 90) && game.isBoatOnTheLeftBank() == true) {
						farmer1.moveSubscene(game.isBoatOnTheLeftBank());
					}
					if ((this.crossersOnBoat.get(i).getweight() == 90) && game.isBoatOnTheLeftBank() == false) {
						farmer1.moveSubscene(game.isBoatOnTheLeftBank());
					}
					if ((this.crossersOnBoat.get(i) instanceof Herbivorous) && game.isBoatOnTheLeftBank() == true) {
						goat.moveSubscene(game.isBoatOnTheLeftBank());
					}
					if ((this.crossersOnBoat.get(i) instanceof Herbivorous) && game.isBoatOnTheLeftBank() == false) {
						goat.moveSubscene(game.isBoatOnTheLeftBank());
					}
					if ((this.crossersOnBoat.get(i).getweight() == 80) && game.isBoatOnTheLeftBank() == true) {
						farmer2.moveSubscene(game.isBoatOnTheLeftBank());
					}
					if ((this.crossersOnBoat.get(i).getweight() == 80) && game.isBoatOnTheLeftBank() == false) {
						farmer2.moveSubscene(game.isBoatOnTheLeftBank());
					}
					if ((this.crossersOnBoat.get(i).getweight() == 60) && game.isBoatOnTheLeftBank() == true) {
						farmer3.moveSubscene(game.isBoatOnTheLeftBank());
					}
					if ((this.crossersOnBoat.get(i).getweight() == 60) && game.isBoatOnTheLeftBank() == false) {
						farmer3.moveSubscene(game.isBoatOnTheLeftBank());
					}
					if ((this.crossersOnBoat.get(i).getweight() == 40) && game.isBoatOnTheLeftBank() == true) {
						farmer4.moveSubscene(game.isBoatOnTheLeftBank());
					}
					if ((this.crossersOnBoat.get(i).getweight() == 40) && game.isBoatOnTheLeftBank() == false) {
						farmer4.moveSubscene(game.isBoatOnTheLeftBank());
					}
				}
			}
			label6.setText("Number of moves: " + String.valueOf(game.getNumberOfSails()));

		});
		button4.setOnAction(m -> {
			if (game.canRedo()) {
				game.commandredo();
				this.crossersOnBoat = game.getCrossers();
				creditssub.moveSubscene();
				for (int i = 0; i < this.crossersOnBoat.size(); i++) {
					if ((this.crossersOnBoat.get(i).getweight() == 90) && game.isBoatOnTheLeftBank() == true) {
						farmer1.moveSubscene(game.isBoatOnTheLeftBank());
					}
					if ((this.crossersOnBoat.get(i).getweight() == 90) && game.isBoatOnTheLeftBank() == false) {
						farmer1.moveSubscene(game.isBoatOnTheLeftBank());
					}
					if ((this.crossersOnBoat.get(i) instanceof Herbivorous) && game.isBoatOnTheLeftBank() == true) {
						goat.moveSubscene(game.isBoatOnTheLeftBank());
					}
					if ((this.crossersOnBoat.get(i) instanceof Herbivorous) && game.isBoatOnTheLeftBank() == false) {
						goat.moveSubscene(game.isBoatOnTheLeftBank());
					}
					if ((this.crossersOnBoat.get(i).getweight() == 80) && game.isBoatOnTheLeftBank() == true) {
						farmer2.moveSubscene(game.isBoatOnTheLeftBank());
					}
					if ((this.crossersOnBoat.get(i).getweight() == 80) && game.isBoatOnTheLeftBank() == false) {
						farmer2.moveSubscene(game.isBoatOnTheLeftBank());
					}
					if ((this.crossersOnBoat.get(i).getweight() == 60) && game.isBoatOnTheLeftBank() == true) {
						farmer3.moveSubscene(game.isBoatOnTheLeftBank());
					}
					if ((this.crossersOnBoat.get(i).getweight() == 60) && game.isBoatOnTheLeftBank() == false) {
						farmer3.moveSubscene(game.isBoatOnTheLeftBank());
					}
					if ((this.crossersOnBoat.get(i).getweight() == 40) && game.isBoatOnTheLeftBank() == true) {
						farmer4.moveSubscene(game.isBoatOnTheLeftBank());
					}
					if ((this.crossersOnBoat.get(i).getweight() == 40) && game.isBoatOnTheLeftBank() == false) {
						farmer4.moveSubscene(game.isBoatOnTheLeftBank());
					}

				}
			}
			label6.setText("Number of moves: " + String.valueOf(game.getNumberOfSails()));

		});

		button5.setOnAction(m -> {

			game.saveGame();

		});
		button7.setOnAction(m -> {

			viewmanager manager = new viewmanager();
			Game game2 = new Game();
			game2.setview(manager);
			manager.setgame(game2);
			Stage primaryStage = manager.getMainStage();
			level1Stage.close();
			primaryStage.show();

		});

		button6.setOnAction(m -> {

			level1Stage.close();
			game.setReset(false);
			game.resetGame();
			System.out.println(game.numberOfSails);

		});
		
		
		
		button2.setOnAction(m -> {

			Media media = new Media(Paths.get("Level2.mp4").toUri().toString());
			MediaPlayer mediaPlayer = new MediaPlayer(media);
			MediaView view = new MediaView(mediaPlayer);
			Group full = new Group();
			full.getChildren().addAll(view);
			Scene videoScene = new Scene(full, 860, 608);
			Stage solveStage = new Stage();
			solveStage.setScene(videoScene);
			solveStage.setTitle("Solve");
			solveStage.show();
			
			mediaPlayer.play();

		});

		createsubscene();
		boolean k = creditssub.moveSubscene();
		goat.moveSubscene(game.isBoatOnTheLeftBank());
		farmer1.moveSubscene(game.isBoatOnTheLeftBank());
		farmer2.moveSubscene(game.isBoatOnTheLeftBank());
		farmer3.moveSubscene(game.isBoatOnTheLeftBank());
		farmer4.moveSubscene(game.isBoatOnTheLeftBank());

	}

	public void loadsaved() {
		if (game.isBoatOnTheLeftBank() == true) {
			creditssub.moveSubscene();
		}

		for (int i = 0; i < game.getCrossersOnLeftBank().size(); i++) {

			if (game.getCrossersOnLeftBank().get(i).getweight() == 90) {
				farmer1.moveSubsceneload(true);
			}
			if (game.getCrossersOnLeftBank().get(i).getweight() == 80) {
				farmer2.moveSubsceneload(true);
			}
			if (game.getCrossersOnLeftBank().get(i).getweight() == 60) {
				farmer3.moveSubsceneload(true);
			}
			if (game.getCrossersOnLeftBank().get(i).getweight() == 40) {
				farmer4.moveSubsceneload(true);
			}
			if (game.getCrossersOnLeftBank().get(i) instanceof Herbivorous) {
				goat.moveSubsceneload(true);
			}

		}
		for (int i = 0; i < game.getCrossersOnRightBank().size(); i++) {

			if (game.getCrossersOnRightBank().get(i).getweight() == 90) {
				farmer1.moveSubscene(false);
			}
			if (game.getCrossersOnRightBank().get(i).getweight() == 80) {
				farmer2.moveSubscene(false);
			}
			if (game.getCrossersOnRightBank().get(i).getweight() == 60) {
				farmer3.moveSubscene(false);
			}
			if (game.getCrossersOnRightBank().get(i).getweight() == 40) {
				farmer4.moveSubscene(false);
			}
			if (game.getCrossersOnRightBank().get(i) instanceof Herbivorous) {
				goat.moveSubscene(false);
			}

		}

	}

}