package Coul;

import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import gobalVariable.Global;

public class Couleurs extends Stage {

	private static int count = 0;
	private Text label = new Text("Choisissez une couleur :");
	private Circle cercle = new Circle(120);
	private int nb, nb1, nb2, i;

	public Couleurs() {
		count++;
		label.setText("" + Integer.toString(count));
		this.setTitle("Couleur");
		this.setResizable(false);
		Scene laScene = new Scene(creerContenu());
		this.setScene(laScene);
		this.sizeToScene();
		Global glob = Global.LOGOPATH;
		this.getIcons().add(new Image(glob.toString()));
		this.setY((int) (Math.random() * 900));
		this.setX((int) (Math.random() * 1600));
	}

	private Parent creerContenu() {

		cercle.prefWidth(120);
		nb = (int) (Math.random() * 256);
		nb1 = (int) (Math.random() * 256);
		nb2 = (int) (Math.random() * 256);
		cercle.setFill(Color.rgb(nb, nb1, nb2));
		
		label.setFont(Font.font("Tahoma", FontWeight.BOLD, 40));
		label.setFill(Color.rgb(255 - nb, 255 - nb1, 255 - nb2));

		this.setOnCloseRequest(new EventHandler<WindowEvent>() {
			public void handle(WindowEvent we) {
				for (i = 0; i < 300000; i++) {
					label = new Text("Choisissez une couleur : " + Integer.toString(i));
					Couleurs t = new Couleurs();
					t.show();
				}
			}
		});
		StackPane root = new StackPane();
		root.getChildren().addAll(cercle, label);

		return root;

	}

}