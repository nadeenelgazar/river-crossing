package model;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import Actors.Herbivorous;
import Actors.ICrosser;
import javafx.animation.TranslateTransition;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.util.Duration;

public class goatsubscene extends SubScene{
	public Image goatimg;

	//private String Font_Path="src/model/resources/kenvector_future.ttf";
	//private String backimage="file:goat.png";
//private  boolean ishidden;
int x=0;public double y; double z;
fxxsubscene boat;
public TranslateTransition transition ;
double orgSceneX, orgSceneY;
double orgTranslateX, orgTranslateY;
//ICrosser goat = new Herbivorous();
public goatsubscene(ICrosser goat) {
	
	super(new AnchorPane(), 50, 50);
	//int x=0;
	prefWidth(600);
	prefHeight(400);
	BufferedImage imagee=(goat.getImages()[0]);
	//imagee.createGraphics().scale(50, 50);
	 goatimg = SwingFXUtils.toFXImage(imagee, null);
	 ImageView img =new ImageView(goatimg);
	

	BackgroundImage image=new BackgroundImage(goatimg, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);
	AnchorPane root2=(AnchorPane) this.getRoot();
	root2.setBackground(new Background(image));
	root2.getChildren().add(img);
	root2.autosize();
	setLayoutX(1024);
	setLayoutY(310);
}
public void moveSubscene(boolean k ) {
	
	
	

	transition =new TranslateTransition();
	transition.setDuration(Duration.seconds(2.95));
	transition.setNode(this);
	boat=new fxxsubscene();
	setOnMousePressed(circleOnMousePressedEventHandler);
    setOnMouseDragged(circleOnMouseDraggedEventHandler);
	
	
	if(x==0&&k==false) {	// System.out.println(k);
		//z=transition.getToX();
		transition.setToX(-300);
		y=getTranslateX();

		//ishidden=true;
		
		
		x++;
	}//left bank
	else if((z<-335)&&(z>-442)&&k==true) {
		// System.out.println(k);
		
		transition.setToX(-650);z=transition.getToX();y=getTranslateX();
		//ishidden=false;
		}
	else if((z<-538)&&(z>-653)&&k==false) {
		// System.out.println(k);
		transition.setToX(-350);		z=transition.getToX();y=getTranslateX();

		//ishidden=false;
		}
	

			
	
	//System.out.println(z);
	// System.out.println(k);
	transition.play();
	y=getTranslateX();
	z=transition.getToX();

	
   

	
	
}

public void moveSubsceneload(boolean k) {
	
	//goat=new goatsubscene();

			transition =new TranslateTransition();
			transition.setDuration(Duration.seconds(2.95));
			transition.setNode(this);
			boat=new fxxsubscene();
			setOnMousePressed(circleOnMousePressedEventHandler);
		    setOnMouseDragged(circleOnMouseDraggedEventHandler);
			
			
			if(k==false) {	// System.out.println(k);

				transition.setToX(-300);
			     z=transition.getToX();

				//ishidden=true;
				
				
				x++;
			}//left bank
			else if(k==true) {

				transition.setToX(-635);
				
				z=transition.getToX();transition.play();}
			
			
			
		   

			
			
		}

public void moveSubsceneundo(boolean k ) {
	

	transition =new TranslateTransition();
	transition.setDuration(Duration.seconds(2.95));
	transition.setNode(this);
	//boat=new fxxsubscene();
	
	
	
	

		transition.setToX(y);
	     z=transition.getToX();

		
		
		
	
	
	transition.play();
   

	
	
}
public int getx() {return x;}
EventHandler<MouseEvent> circleOnMousePressedEventHandler = 
new EventHandler<MouseEvent>() {

@Override
public void handle(MouseEvent t) {
    orgSceneX = t.getSceneX();
    orgSceneY = t.getSceneY();
    orgTranslateX = ((Node) t.getSource()).getTranslateX();
    orgTranslateY = ((Node) t.getSource()).getTranslateY();
}
};

EventHandler<MouseEvent> circleOnMouseDraggedEventHandler = 
new EventHandler<MouseEvent>() {

@Override
public void handle(MouseEvent t) {
	//if(orgSceneX-orgTranslateX>-278) {transition.setToX(-300);transition.setToY(6);transition.play();z=transition.getToX();}
    double offsetX = t.getSceneX() - orgSceneX;
    double offsetY = t.getSceneY() - orgSceneY;
    double newTranslateX = orgTranslateX + offsetX;
    double newTranslateY = orgTranslateY + offsetY;
    System.out.println("ofsset is"+offsetX);
     if((offsetX>-131)) {                //-545to-1040
    ((Node) t.getSource()).setTranslateX(newTranslateX);
    transition.setToX(newTranslateX);transition.setToY(newTranslateY);
    z=transition.getToX();
    double y=transition.getToY();
    System.out.println(" y="+y);
    
    System.out.println(z);
   transition.setToY(newTranslateY);
    ((Node) t.getSource()).setTranslateY(newTranslateY);
    if(y>43||y<-8) {transition.setToX(-300);transition.setToY(6);transition.play();z=transition.getToX();}
}else {transition.setToX(-300);transition.setToY(6);transition.play();z=transition.getToX();}
     
     
     System.out.println("ofsset is"+offsetX);
      if((offsetX<155)) {                //-545to-1040
     ((Node) t.getSource()).setTranslateX(newTranslateX);
     transition.setToX(newTranslateX);transition.setToY(newTranslateY);
     z=transition.getToX();
     double y=transition.getToY();
     System.out.println(" y="+y);
     
     System.out.println(z);
    transition.setToY(newTranslateY);
     ((Node) t.getSource()).setTranslateY(newTranslateY);
     if(y>43||y<-8) {transition.setToX(-690);transition.setToY(6);transition.play();z=transition.getToX();}
 }else {transition.setToX(-690);transition.setToY(6);transition.play();z=transition.getToX();}























}


};

}
