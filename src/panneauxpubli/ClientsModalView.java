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

public class ClientsModalView extends Stage {
	private Button bnOK = 			new Button("Ok");
	private Button bnAnnuler = 		new Button("Annuler");
	

	public ClientsModalView() {

		this.setTitle("Clients");
		this.setResizable(false);
		this.initModality(Modality.WINDOW_MODAL);
		Scene laScene = new Scene(creerContenu());
		this.setScene(laScene);
		this.sizeToScene();
		this.getIcons().add(new Image("https://image.ibb.co/n1TBm7/logo.png"));

	}

	private Parent creerContenu() {
		
		bnOK.setPrefSize(120, 20);
		bnAnnuler.setPrefSize(120, 20);
		
		 bnAnnuler.setOnAction(e -> {
	        	this.close();	
			});
		
		//Horizontal Box et Vertical Box
		
		HBox boutonsC = new HBox();
		boutonsC.setSpacing(20);
		boutonsC.getChildren().addAll(bnOK,bnAnnuler);
		
		VBox principale = new VBox();
		principale.setPadding(new Insets(20));
		principale.setSpacing(20);
		principale.getChildren().addAll(new Label("Clients ?"),boutonsC);

		return principale;

	}
}
