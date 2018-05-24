package panneauxpubli;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class NotesdemajPanneauxdePub extends Stage {
	private Label notesmaj = new Label("- Le drapeau change quand on clic dessus\n- La fenetre notes de maj à fait son apparition\n- La fenetre à propos à fait son apparition\n- Le bouton supprimer marche");
	

	public NotesdemajPanneauxdePub() {

		this.setTitle("Notes de Maj !");
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
		principale.getChildren().addAll(notesmaj);

		return principale;

	}
}
