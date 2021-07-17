package model;

import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.scene.Parent;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.util.Duration;

public class fxxsubscene extends SubScene {
	private String Font_Path = "src/model/resources/kenvector_future.ttf";
	private String backimage = "file:boat.png";
	private boolean ishidden;
	public TranslateTransition transition;
	int x;
	// farmer_subscene farmer=new farmer_subscene();

	public double y;

	public fxxsubscene() {
		super(new AnchorPane(), 600, 400);
		prefWidth(600);
		prefHeight(400);
		BackgroundImage image = new BackgroundImage(new Image(backimage, 120, 70, false, true),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);
		AnchorPane root2 = (AnchorPane) this.getRoot();
		root2.setBackground(new Background(image));
		setLayoutX(1024);
		setLayoutY(300);

		// TODO Auto-generated constructor stub
	}

	public boolean moveSubscene() {
		boolean k = false;

		// farmer=new farmer_subscene();
		transition = new TranslateTransition();
		transition.setDuration(Duration.seconds(3));
		transition.setNode(this);
		if (x == 1) {
			transition.setToX(-635);
			y = transition.getToX();
			ishidden = false;
			x = 0;
			// y=transition.getToX();
			k = true;
			// System.out.println(k);
		} else if (x == 0) {
			transition.setToX(-410);
			y = transition.getToX();
			ishidden = true;
			k = false;

			x = 1;
			// System.out.println(k);

			// System.out.println(y);

		}
		transition.play();

		return k;

	}

}
