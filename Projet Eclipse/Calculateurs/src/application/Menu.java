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
	private Button bnLittres = new Button("Littres Conversion");
	private Button bnNameGen = new Button("Génération de Nom");
	private Button bnDroneAv = new Button("Drone Avion Contrôles");
	
	public Menu(){
		this.setTitle("Logiciel qui fait tout");
		this.setResizable(true);
		Scene laScene = new Scene(creerContenu());
		this.setScene(laScene);
		this.sizeToScene();
	}
	
	private Parent creerContenu() {
		
		bnVitessedebit.setPrefSize(170, 20);
		bnLittres.setPrefSize(170, 20);
		bnNameGen.setPrefSize(170, 20);
		bnDroneAv.setPrefSize(170, 20);

		HBox menudeska = new HBox();
		menudeska.setPadding(new Insets(5));
		menudeska.setSpacing(10);
		menudeska.getChildren().addAll(bnVitessedebit, bnLittres, bnNameGen,bnDroneAv, bnExit);
		

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
		
		bnNameGen.setOnAction(e -> {
			NameGenerator c = new NameGenerator();
			c.initOwner(this);
			c.show();
		});
		
		bnDroneAv.setOnAction(e -> {
			DroneAvion c = new DroneAvion();
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
