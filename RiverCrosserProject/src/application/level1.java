package application;

import java.awt.List;
import java.nio.file.Paths;
import java.time.Duration;
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
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaBuilder;
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

public class level1 {
	viewmanager x;

	private AnchorPane mainPane;
	private Scene level1Scene;
	private Stage level1Stage;
	private fxxsubscene creditssub;
	Scene scene;
	Stage menustage;
	private goatsubscene goat;
	private farmer_subscene farmer;
	private wolfsubscene wolf;
	private plantsubscene plant;
	private boolean goatonboat = false;
	private boolean farmeronboat = false;
	private boolean wolfonboat = false;
	private boolean plantonboat = false;
	Game game;
	Stage primaryStage;
	private java.util.List<ICrosser> crossersOnBoat;
	java.util.List<ICrosser> crossers = new ArrayList<ICrosser>();
	viewmanager fring = new viewmanager();

	public void createsubscene() {
		creditssub = new fxxsubscene();
		mainPane.getChildren().add(creditssub);
		goat = new goatsubscene(crossers.get(2));
		mainPane.getChildren().add(goat);
		farmer = new farmer_subscene(crossers.get(0));
		mainPane.getChildren().add(farmer);
		wolf = new wolfsubscene(crossers.get(1));
		mainPane.getChildren().add(wolf);
		plant = new plantsubscene(crossers.get(3));
		mainPane.getChildren().add(plant);

	}

	public void createlevel1(Stage menustage) {
		this.menustage = menustage;
		this.menustage.hide();
		level1Stage.setTitle("Level 1");
		level1Stage.show();

	}

	public level1(java.util.List<ICrosser> crossers, Game game) {
		this.crossers = crossers;
		this.game = game;
		x = new viewmanager();
		mainPane = new AnchorPane();
		String mainPanestyle = "-fx-background-image: url('file:backgrounfinal.jpeg');";
		mainPane.setStyle(mainPanestyle);
		level1Scene = new Scene(mainPane, 850, 600);
		level1Stage = new Stage();
		level1Stage.setScene(level1Scene);
		Levelsbuttons button1 = new Levelsbuttons("GO!!");
		Levelsbuttons button2 = new Levelsbuttons("goat");
		Levelsbuttons button3 = new Levelsbuttons("undo");
		Levelsbuttons button4 = new Levelsbuttons("redo");
		Levelsbuttons button5 = new Levelsbuttons("reset");
		Levelsbuttons button6 = new Levelsbuttons("save");
		Levelsbuttons button7 = new Levelsbuttons("back");
		Levelsbuttons button8 = new Levelsbuttons("solve");
		Label label1 = new Label(crossers.get(0).getLabelToBeShown());
		Label label2 = new Label(crossers.get(1).getLabelToBeShown());
		Label label3 = new Label(crossers.get(2).getLabelToBeShown());
		Label label4 = new Label(crossers.get(3).getLabelToBeShown());
		Label label5 = new Label("Number of moves: " + String.valueOf(game.getNumberOfSails()));

		VBox v2 = new VBox();
		v2.getChildren().add(label1);
		v2.getChildren().add(label2);
		v2.getChildren().add(label3);
		v2.getChildren().add(label4);
		v2.getChildren().add(label5);
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
		h.getChildren().add(button8);
		h.setSpacing(50);
		h.setLayoutX(0);
		h.setLayoutY(0);

		v.setSpacing(50);
		mainPane.getChildren().add(v);
		mainPane.getChildren().add(h);
		mainPane.getChildren().add(v2);

		v.setLayoutX(400);
		v.setLayoutY(50);
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Hello");
		alert.setHeaderText("Instructions");
		alert.setContentText(game.getLevel1logic().getInstructions()[0] + game.getLevel1logic().getInstructions()[1]
				+ game.getLevel1logic().getInstructions()[2]);
		alert.showAndWait();
		button1.setOnAction(m -> {
			boolean goatonboat = false;
			boolean farmeronboat = false;
			boolean wolfonboat = false;
			boolean plantonboat = false;
			crossersOnBoat = new ArrayList<>();

			if ((creditssub.getTranslateX() > -430) || (creditssub.getTranslateX() < -537)) {
				if ((goat.getTranslateX() < -318 && goat.getTranslateX() > -430)
						^ (goat.getTranslateX() < -537 && goat.getTranslateX() > -655)) {

					goatonboat = true;
				}
			}
			if ((farmer.getTranslateX() < -318 && farmer.getTranslateX() > -430)
					^ (farmer.getTranslateX() < -537 && farmer.getTranslateX() > -655)) {
				farmeronboat = true;
			}

			if ((plant.getTranslateX() < -318 && plant.getTranslateX() > -430)
					^ (plant.getTranslateX() < -537 && plant.getTranslateX() > -655)) {
				plantonboat = true;
			}
			if ((wolf.getTranslateX() < -318 && wolf.getTranslateX() > -430)
					^ (wolf.getTranslateX() < -537 && wolf.getTranslateX() > -655)) {
				wolfonboat = true;
			}
			if (game.isBoatOnTheLeftBank() == false) {

				if (farmeronboat == true) {
					for (int j = 0; j < game.getCrossersOnRightBank().size(); j++) {
						if (game.getCrossersOnRightBank().get(j) instanceof Farmer)
							crossersOnBoat.add(game.getCrossersOnRightBank().get(j));
					}
				}

				if (goatonboat == true) {
					for (int j = 0; j < game.getCrossersOnRightBank().size(); j++) {
						if (game.getCrossersOnRightBank().get(j) instanceof Herbivorous)
							crossersOnBoat.add(game.getCrossersOnRightBank().get(j));
					}
				}

				if (wolfonboat == true) {
					for (int j = 0; j < game.getCrossersOnRightBank().size(); j++) {
						if (game.getCrossersOnRightBank().get(j) instanceof Carnivorous)
							crossersOnBoat.add(game.getCrossersOnRightBank().get(j));
					}
				}

				if (plantonboat == true) {
					for (int j = 0; j < game.getCrossersOnRightBank().size(); j++) {
						if (game.getCrossersOnRightBank().get(j) instanceof Plant)
							crossersOnBoat.add(game.getCrossersOnRightBank().get(j));
					}
				}
			} else {
				if (farmeronboat == true) {
					System.out.println(game.getCrossersOnLeftBank().size());
					for (int j = 0; j < game.getCrossersOnLeftBank().size(); j++) {
						if (game.getCrossersOnLeftBank().get(j) instanceof Farmer)
							crossersOnBoat.add(game.getCrossersOnLeftBank().get(j));
					}
				}

				if (goatonboat == true) {
					for (int j = 0; j < game.getCrossersOnLeftBank().size(); j++) {
						if (game.getCrossersOnLeftBank().get(j) instanceof Herbivorous)
							crossersOnBoat.add(game.getCrossersOnLeftBank().get(j));
					}
				}

				if (wolfonboat == true) {
					for (int j = 0; j < game.getCrossersOnLeftBank().size(); j++) {
						if (game.getCrossersOnLeftBank().get(j) instanceof Carnivorous)
							crossersOnBoat.add(game.getCrossersOnLeftBank().get(j));
					}
				}

				if (plantonboat == true) {
					for (int j = 0; j < game.getCrossersOnLeftBank().size(); j++) {
						if (game.getCrossersOnLeftBank().get(j) instanceof Plant)
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
				farmer.moveSubscene(game.isBoatOnTheLeftBank());
				wolf.moveSubscene(game.isBoatOnTheLeftBank());
				plant.moveSubscene(game.isBoatOnTheLeftBank());
				System.out.println("print for go " + game.isBoatOnTheLeftBank());
				if (game.getCrossersOnLeftBank().size() == 4) {
					Alert alert2 = new Alert(AlertType.INFORMATION);
					alert2.setTitle("Hello");
					alert2.setHeaderText("Instructions");
					alert2.setContentText("bravo");
					alert2.showAndWait();
					button7.fire();
				}
			}
			// }
			label5.setText("Number of moves: " + String.valueOf(game.getNumberOfSails()));

		});

		button3.setOnAction(m -> {
			if (game.canUndo()) {
				game.commandundo();
				this.crossersOnBoat = game.getCrossers();
				System.out.println("size of crossers undo gui " + this.crossersOnBoat.size());
				System.out.println(game.getCrossers().size());
				creditssub.moveSubscene();
				for (int i = 0; i < this.crossersOnBoat.size(); i++) {
					if ((this.crossersOnBoat.get(i) instanceof Farmer) && game.isBoatOnTheLeftBank() == true) {
						farmer.moveSubscene(game.isBoatOnTheLeftBank());
					}
					if ((this.crossersOnBoat.get(i) instanceof Farmer) && game.isBoatOnTheLeftBank() == false) {
						farmer.moveSubscene(game.isBoatOnTheLeftBank());
					}
					if ((this.crossersOnBoat.get(i) instanceof Herbivorous) && game.isBoatOnTheLeftBank() == true) {
						goat.moveSubscene(game.isBoatOnTheLeftBank());
					}
					if ((this.crossersOnBoat.get(i) instanceof Herbivorous) && game.isBoatOnTheLeftBank() == false) {
						goat.moveSubscene(game.isBoatOnTheLeftBank());
					}
					if ((this.crossersOnBoat.get(i) instanceof Carnivorous) && game.isBoatOnTheLeftBank() == true) {
						wolf.moveSubscene(game.isBoatOnTheLeftBank());
					}
					if ((this.crossersOnBoat.get(i) instanceof Carnivorous) && game.isBoatOnTheLeftBank() == false) {
						wolf.moveSubscene(game.isBoatOnTheLeftBank());
					}
					if ((this.crossersOnBoat.get(i) instanceof Plant) && game.isBoatOnTheLeftBank() == true) {
						plant.moveSubscene(game.isBoatOnTheLeftBank());
					}
					if ((this.crossersOnBoat.get(i) instanceof Plant) && game.isBoatOnTheLeftBank() == false) {
						plant.moveSubscene(game.isBoatOnTheLeftBank());
					}
				}
			}
			label5.setText("Number of moves: " + String.valueOf(game.getNumberOfSails()));

		});
		button4.setOnAction(m -> {
			if (game.canRedo()) {
				game.commandredo();
				this.crossersOnBoat = game.getCrossers();
				System.out.println("size of crossers redo gui " + this.crossersOnBoat.size());
				System.out.println(game.getCrossers().size());
				creditssub.moveSubscene();
				for (int i = 0; i < this.crossersOnBoat.size(); i++) {
					if ((this.crossersOnBoat.get(i) instanceof Farmer) && game.isBoatOnTheLeftBank() == true) {
						farmer.moveSubscene(game.isBoatOnTheLeftBank());
					}
					if ((this.crossersOnBoat.get(i) instanceof Farmer) && game.isBoatOnTheLeftBank() == false) {
						farmer.moveSubscene(game.isBoatOnTheLeftBank());
					}
					if ((this.crossersOnBoat.get(i) instanceof Herbivorous) && game.isBoatOnTheLeftBank() == true) {
						goat.moveSubscene(game.isBoatOnTheLeftBank());
					}
					if ((this.crossersOnBoat.get(i) instanceof Herbivorous) && game.isBoatOnTheLeftBank() == false) {
						goat.moveSubscene(game.isBoatOnTheLeftBank());
					}
					if ((this.crossersOnBoat.get(i) instanceof Carnivorous) && game.isBoatOnTheLeftBank() == true) {
						wolf.moveSubscene(game.isBoatOnTheLeftBank());
					}
					if ((this.crossersOnBoat.get(i) instanceof Carnivorous) && game.isBoatOnTheLeftBank() == false) {
						wolf.moveSubscene(game.isBoatOnTheLeftBank());
					}
					if ((this.crossersOnBoat.get(i) instanceof Plant) && game.isBoatOnTheLeftBank() == true) {
						plant.moveSubscene(game.isBoatOnTheLeftBank());
					}
					if ((this.crossersOnBoat.get(i) instanceof Plant) && game.isBoatOnTheLeftBank() == false) {
						plant.moveSubscene(game.isBoatOnTheLeftBank());
					}
				}
			}
			label5.setText("Number of moves: " + String.valueOf(game.getNumberOfSails()));

		});

		button5.setOnAction(m -> {

			level1Stage.close();
			game.setReset(true);
			game.resetGame();
			System.out.println(game.numberOfSails);

		});

		button6.setOnAction(m -> {

			game.saveGame();

		});

		button7.setOnAction(m -> {

			viewmanager manager = new viewmanager();
			Game game2 = new Game();
			game2.setview(manager);
			manager.setgame(game2);
			primaryStage = manager.getMainStage();
			level1Stage.close();
			primaryStage.show();

		});

		button8.setOnAction(m -> {

			Media media = new Media(Paths.get("Level1.mp4").toUri().toString());
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
		farmer.moveSubscene(game.isBoatOnTheLeftBank());
		wolf.moveSubscene(game.isBoatOnTheLeftBank());
		plant.moveSubscene(game.isBoatOnTheLeftBank());

	}

	public void loadsaved() {

		if (game.isBoatOnTheLeftBank() == true) {
			creditssub.moveSubscene();
		}

		for (int i = 0; i < game.getCrossersOnLeftBank().size(); i++) {

			if (game.getCrossersOnLeftBank().get(i) instanceof Farmer) {
				farmer.moveSubsceneload(true);
			}
			if (game.getCrossersOnLeftBank().get(i) instanceof Carnivorous) {
				wolf.moveSubsceneload(true);
			}
			if (game.getCrossersOnLeftBank().get(i) instanceof Herbivorous) {
				goat.moveSubsceneload(true);
			}
			if (game.getCrossersOnLeftBank().get(i) instanceof Plant) {
				plant.moveSubsceneload(true);
			}

		}
		for (int i = 0; i < game.getCrossersOnRightBank().size(); i++) {

			if (game.getCrossersOnRightBank().get(i) instanceof Farmer) {
				farmer.moveSubscene(false);
			}
			if (game.getCrossersOnRightBank().get(i) instanceof Carnivorous) {
				wolf.moveSubscene(false);
			}
			if (game.getCrossersOnRightBank().get(i) instanceof Plant) {
				plant.moveSubscene(false);
			}
			if (game.getCrossersOnRightBank().get(i) instanceof Herbivorous) {
				goat.moveSubscene(false);
			}

		}

	}

}