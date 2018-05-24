package glisserdeposer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import demineurnorauto.Demineur;
import gobalVariable.Global;

public class GlisseAndDepose extends Stage {
	private Button bnGauche = new Button("<");
	private Button bnDroite = new Button(">");
	
	public GlisseAndDepose() {
		this.setTitle("Glisser Déposer");
		this.setResizable(false);
		this.initModality(Modality.WINDOW_MODAL);
		Scene laScene = new Scene(creerContenu());
		this.setScene(laScene);
		this.sizeToScene();
		Global glob = Global.LOGOPATH;
		this.getIcons().add(new Image(glob.toString()));
	}
	
	public Parent creerContenu(){
		
		ObservableList<String> o = FXCollections.observableArrayList(
				"Batôn",
				"Bicyclette",
				"Avion Radiocommandé",
				"Pélicule",
				"Pile",
				"Démineur",
				"Taquin",
				"Faritas sauce Salsa",
				"La terre est plate",
				"Dieu à créer les hommes pour les manger"
				);
		
		ListView<String> listeDroite = new ListView<String>();
		ListView<String> listeGauche = new ListView<String>(o);
		
		bnDroite.setOnAction(e -> {
			Demineur c = new Demineur();
			c.initOwner(this);
			c.show();
		});
		
		bnGauche.setOnAction(e -> {
			this.close();
		});
		
		
		bnDroite.setPrefSize(100, 20);
		bnGauche.setPrefSize(100, 20);

		
		VBox bouton = new VBox();
		bouton.setSpacing(10);
		bouton.getChildren().addAll(bnGauche,bnDroite);
		
		HBox racine = new HBox();
		racine.setPadding(new Insets(15));
		racine.setSpacing(10);
		racine.getChildren().addAll(listeGauche,bouton,listeDroite);
		
		return racine;
	}
}
