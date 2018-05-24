package panneauxpubli;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class AjoutPanneauxEmplacementView extends Stage {
	private Button bnAjouterEmplacement = 			new Button("Emplacements");
	private Button bnAjouterLocations = 			new Button("Locations");
	

	public AjoutPanneauxEmplacementView() {

		this.setTitle("Ajouter");
		this.setResizable(false);
		this.initModality(Modality.WINDOW_MODAL);
		Scene laScene = new Scene(creerContenu());
		this.setScene(laScene);
		this.sizeToScene();
		this.getIcons().add(new Image("https://image.ibb.co/n1TBm7/logo.png"));

	}

	private Parent creerContenu() {
		
		bnAjouterEmplacement.setPrefSize(120, 20);
		bnAjouterLocations.setPrefSize(120, 20);
		
		//Horizontal Box et Vertical Box
		
		HBox boutonsC = new HBox();
		boutonsC.setSpacing(20);
		boutonsC.getChildren().addAll(bnAjouterEmplacement,bnAjouterLocations);
		
		VBox principale = new VBox();
		principale.setPadding(new Insets(20));
		principale.setSpacing(20);
		principale.getChildren().addAll(new Label("Que voulez vous ajouter ?"),boutonsC);

		return principale;

	}
}
