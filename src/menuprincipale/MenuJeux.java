package menuprincipale;

import demineurnorauto.MenuDemineur;
import gobalVariable.Global;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import Coul.Couleurs;
import jeudutaquin.ImageTaquin;

public class MenuJeux extends Stage {
	
	private Button bnExit = new Button("Retour Menu Principal");
	private Button bnHamster = new Button("Le Taquin");
	private Button bnDemineurNorauto = new Button("Démineur");
	private Button bnCouleurs = new Button("/!\\ Couleurs /!\\");
	
	public MenuJeux(){
		this.setTitle("Menu Jeux");
		this.setResizable(true);
		Scene laScene = new Scene(creerContenu());
		this.initModality(Modality.WINDOW_MODAL);
		Global glob = Global.LOGOPATH;
		this.getIcons().add(new Image(glob.toString()));
		this.setScene(laScene);
		this.sizeToScene();
	}
	
	private Parent creerContenu() {
		
		bnHamster.setPrefSize(170, 20);
		bnDemineurNorauto.setPrefSize(170, 20);
		bnCouleurs.setPrefSize(170, 20);
		bnHamster.setStyle("-fx-color : #CCCCCC");
		bnDemineurNorauto.setStyle("-fx-color : #CCCCCC");
		bnCouleurs.setStyle("-fx-color : #CCCCCC");
		bnExit.setStyle("-fx-color : #DDAAAA");

		HBox menudeska = new HBox();
		menudeska.setPadding(new Insets(5));
		menudeska.setSpacing(10);
		menudeska.getChildren().addAll(bnHamster,bnDemineurNorauto, bnCouleurs, bnExit);
		

		bnHamster.setOnAction(e -> {
			ImageTaquin c = new ImageTaquin();
			c.initOwner(this);
			c.show();
		});
		
		bnDemineurNorauto.setOnAction(e -> {
			MenuDemineur c = new MenuDemineur();
			c.initOwner(this);
			c.show();
		});
		
		bnCouleurs.setOnAction(e -> {
			Couleurs c = new Couleurs();
			c.initOwner(this);
			c.show();
		});
		
		bnExit.setOnAction(e -> {
			this.close();
		});

		BorderPane root = new BorderPane();
		root.setPadding(new Insets(10));
		root.setCenter(menudeska);
		return root;

	}

}
