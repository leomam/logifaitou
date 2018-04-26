package application;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Menu extends Stage {
	
	private Button bnExit = new Button("Quitter");
	private Button bnVitessedebit = new Button("Vitesse Débit");
	private Button bnLittres = new Button("Littres to dcm3");
	
	public Menu(){
		this.setTitle("Logiciel qui fait tout");
		this.setResizable(true);
		Scene laScene = new Scene(creerContenu());
		this.setScene(laScene);
		this.sizeToScene();
	}
	
	private Parent creerContenu() {

		HBox menudeska = new HBox();
		menudeska.setPadding(new Insets(5));
		menudeska.setSpacing(10);
		menudeska.getChildren().addAll(bnVitessedebit, bnLittres, bnExit);

		bnVitessedebit.setOnAction(e -> {
			Vitessedebi c = new Vitessedebi();
			c.initOwner(this);
			c.show();
		});
		
		bnLittres.setOnAction(e -> {
			Littrestodm3 c = new Littrestodm3();
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
