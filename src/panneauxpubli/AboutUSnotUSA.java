package panneauxpubli;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class AboutUSnotUSA extends Stage {
	private Label about = new Label("Nous sommes des étudiants très la qualité\nRegardez moi cette plastique absolument démentielle\nBref c'est juste un test\nJe vous manges");
	

	public AboutUSnotUSA() {

		this.setTitle("A propos");
		this.setResizable(false);
		this.initModality(Modality.WINDOW_MODAL);
		Scene laScene = new Scene(creerContenu());
		this.setScene(laScene);
		this.sizeToScene();
		this.getIcons().add(new Image("https://image.ibb.co/n1TBm7/logo.png"));

	}

	private Parent creerContenu() {
		
		//Horizontal Box et Vertical Box
		
		VBox principale = new VBox();
		principale.setPadding(new Insets(20));
		principale.setSpacing(20);
		principale.getChildren().addAll(about);

		return principale;

	}
}
