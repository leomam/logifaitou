package application;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DroneAvion extends Stage {
	private Button bnRetour = 			new Button("Retour");
	private Button bnVitessePlus = 		new Button("^");
	private Button bnVitesseMoins = 	new Button("v");
	private Button bnVrilleGauche =	 	new Button("<");
	private Button bnVrilleDroite =	 	new Button(">");
	private Button bnDefautGauche =	 	new Button("");
	private Button bnDefautDroit =	 	new Button("");
	private Button bnDescente = 		new Button("^");
	private Button bnMonter = 			new Button("v");
	private Button bnTournerGauche = 	new Button("<");
	private Button bnTournerDroite = 	new Button(">");
	private Button bnChangerAlitude = 	new Button("Ok");
	private TextField tfChangerAlitude = new TextField();
	private Label lAltitude =			new Label("Altidude Actuelle : 0.0m");
	private double altitude =	0;
	private Label lChangerAltitude =	new Label("Changer :");
	private Button bnChangerVitesse = 	new Button("Ok");
	private TextField tfChangerVitesse = new TextField();
	private Label lVitesse =			new Label("Vitesse Actuelle : 0.0km/h");
	private double vitesse = 0;
	private Label lChangerVitesse =		new Label("Changer :");

	public DroneAvion() {

		this.setTitle("Avion Drone Contrôles");
		this.setResizable(false);
		this.initModality(Modality.WINDOW_MODAL);
		Scene laScene = new Scene(creerContenu());
		this.setScene(laScene);
		this.sizeToScene();
		this.getIcons().add(new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTqCosUL5iACTRqWclFw94mTDS38dR1l9ZS4yYeATRS7TDDSehsuw"));

	}

	private Parent creerContenu() {
		
		//Taille des boutons
		
		bnVitessePlus.setPrefSize(25, 40);
		bnVitesseMoins.setPrefSize(25, 40);
		bnVrilleGauche.setPrefSize(40, 25);
		bnVrilleDroite.setPrefSize(40, 25);
		bnDefautGauche.setPrefSize(25, 25);
		bnDefautDroit.setPrefSize(25, 25);
		bnDescente.setPrefSize(25, 40);
		bnMonter.setPrefSize(25, 40);
		bnTournerGauche.setPrefSize(40, 25);
		bnTournerDroite.setPrefSize(40, 25);
		tfChangerAlitude.setPrefSize(45, 25);
		tfChangerVitesse.setPrefSize(45, 25);

		//Horizontal Box et Vertical Box
		
		BorderPane joystickGauche = new BorderPane();
		joystickGauche.setPadding(new Insets(50));
		BorderPane.setAlignment(bnVitessePlus, Pos.CENTER);
		BorderPane.setAlignment(bnVitesseMoins, Pos.CENTER);
		joystickGauche.setTop(bnVitessePlus);
		joystickGauche.setLeft(bnVrilleGauche);
		joystickGauche.setCenter(bnDefautGauche);
		joystickGauche.setRight(bnVrilleDroite);
		joystickGauche.setBottom(bnVitesseMoins);
		
		BorderPane joystickDroit = new BorderPane();
		joystickDroit.setPadding(new Insets(50));
		BorderPane.setAlignment(bnDescente, Pos.CENTER);
		BorderPane.setAlignment(bnMonter, Pos.CENTER);
		joystickDroit.setTop(bnDescente);
		joystickDroit.setLeft(bnTournerGauche);
		joystickDroit.setCenter(bnDefautDroit);
		joystickDroit.setRight(bnTournerDroite);
		joystickDroit.setBottom(bnMonter);
		
		
		HBox boutonsC = new HBox();
		boutonsC.setPadding(new Insets(10));
		boutonsC.setSpacing(20);
		boutonsC.getChildren().addAll(bnRetour);
		
		
		HBox changementsVariablesAltitudes = new HBox();
		changementsVariablesAltitudes.setSpacing(10);
		changementsVariablesAltitudes.getChildren().addAll(lChangerAltitude,tfChangerAlitude,bnChangerAlitude);
		
		VBox altitudesView = new VBox();
		altitudesView.setPadding(new Insets(10));
		altitudesView.setSpacing(10);
		altitudesView.getChildren().addAll(lAltitude,changementsVariablesAltitudes);
		
		HBox changementsVariablesVitesse = new HBox();
		changementsVariablesVitesse.setSpacing(10);
		changementsVariablesVitesse.getChildren().addAll(lChangerVitesse,tfChangerVitesse,bnChangerVitesse);
		
		VBox vitesseView = new VBox();
		vitesseView.setPadding(new Insets(10));
		vitesseView.setSpacing(10);
		vitesseView.getChildren().addAll(lVitesse,changementsVariablesVitesse);
		
		HBox controleView = new HBox();
		controleView.setSpacing(20);
		controleView.getChildren().addAll(altitudesView,vitesseView);
		
		//Propriété du texte, ici seulement les chiffres et le point sont autorisés
		
		tfChangerAlitude.textProperty().addListener(new ChangeListener<String>() {
		    @Override
		    public void changed(ObservableValue<? extends String> observable, String oldValue, 
		        String newValue) {
		        if (!newValue.matches("[\\d.]*")) {
		            tfChangerAlitude.setText(newValue.replaceAll("[^\\d.]", ""));
		        }
		    }
		});
		
		tfChangerVitesse.textProperty().addListener(new ChangeListener<String>() {
		    @Override
		    public void changed(ObservableValue<? extends String> observable, String oldValue, 
		        String newValue) {
		        if (!newValue.matches("[\\d.]*")) {
		            tfChangerVitesse.setText(newValue.replaceAll("[^\\d.]", ""));
		        }
		    }
		});
		
		//Actions à la pression des boutons

		bnChangerAlitude.setOnAction(e -> {
			this.altitude = Double.parseDouble(tfChangerAlitude.getText());
			this.lAltitude.setText("Altidude Actuelle : "+altitude+"m");
			this.tfChangerAlitude.setText("");
		});
		
		bnDescente.setOnAction(e -> {
			this.altitude--;
			this.lAltitude.setText("Altitude Actuelle : "+altitude+"m");
		});
		
		bnMonter.setOnAction(e -> {
			this.altitude++;
			this.lAltitude.setText("Altitude Actuelle : "+altitude+"m");
		});
		
		bnChangerVitesse.setOnAction(e -> {
			this.vitesse = Double.parseDouble(tfChangerVitesse.getText());
			this.lVitesse.setText("Vitesse Actuelle : "+vitesse+"km/h");
			this.tfChangerVitesse.setText("");
		});
		
		bnVitessePlus.setOnAction(e -> {
			this.vitesse++;
			this.lVitesse.setText("Vitesse Actuelle : "+vitesse+"km/h");
		});
		
		bnVitesseMoins.setOnAction(e -> {
			this.vitesse--;
			this.lVitesse.setText("Vitesse Actuelle : "+vitesse+"km/h");
		});
		
		bnRetour.setOnAction(e -> {
			this.close();
		});

		//BorderPane final

		BorderPane root = new BorderPane();
		root.setPadding(new Insets(10));
		root.setTop(controleView);
		root.setLeft(joystickGauche);
		root.setRight(joystickDroit);
		root.setBottom(boutonsC);

		return root;

	}

}
