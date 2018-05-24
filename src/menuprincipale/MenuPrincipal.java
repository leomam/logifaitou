package menuprincipale;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import gobalVariable.Global;

public class MenuPrincipal extends Stage {
	
	private Button bnExit = new Button("Quitter");
	private Button bnJeux = new Button("Jeux");
	private Button bnUtilitaires = new Button("Utilitaires");
	private Button bnProjet = new Button("Projets");
	
	public MenuPrincipal(){
		this.setTitle("Logiciel qui fait tout");
		this.setResizable(true);
		Scene laScene = new Scene(creerContenu());
		Global glob = Global.LOGOPATH;
		this.getIcons().add(new Image(glob.toString()));
		this.setScene(laScene);
		this.sizeToScene();
	}
	
	private Parent creerContenu() {
		
		bnJeux.setPrefSize(170, 20);
		bnJeux.setStyle("-fx-color : #CCCCCC");
		bnUtilitaires.setPrefSize(170, 20);
		bnUtilitaires.setStyle("-fx-color : #CCCCCC");
		bnProjet.setPrefSize(170, 20);
		bnProjet.setStyle("-fx-color : #CCCCCC");
		bnExit.setStyle("-fx-color : #DDAAAA");
		HBox menudeska = new HBox();
		menudeska.setPadding(new Insets(5));
		menudeska.setSpacing(10);
		menudeska.getChildren().addAll(bnJeux, bnUtilitaires, bnProjet,bnExit);
		

		bnJeux.setOnAction(e -> {
			MenuJeux c = new MenuJeux();
			c.initOwner(this);
			c.show();
		});
		
		bnUtilitaires.setOnAction(e -> {
			MenuUtilitaires c = new MenuUtilitaires();
			c.initOwner(this);
			c.show();
		});
		
		bnProjet.setOnAction(e -> {
			MenuProjets c = new MenuProjets();
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
