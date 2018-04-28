package application;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Littrestodm3 extends Stage {
	private Button bnRetour = new Button("Retour");
	private Button bnCalculer = new Button("Calculer");
	private TextField volume = new TextField();
	private TextField nbcube = new TextField();
	private double multi = 1;
	private double rat = 1;

	public Littrestodm3() {

		this.setTitle("Combien de Littres ?");
		this.setResizable(false);
		this.initModality(Modality.WINDOW_MODAL);
		Scene laScene = new Scene(creerContenu());
		this.setScene(laScene);
		this.sizeToScene();
		this.getIcons().add(new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTqCosUL5iACTRqWclFw94mTDS38dR1l9ZS4yYeATRS7TDDSehsuw"));

	}

	private Parent creerContenu() {

		//Observable Listes

		ObservableList<String> options = FXCollections.observableArrayList(
				"Littres",
				"Decilitre",
				"Centilitre",
				"Millilitre"	
				);
		ObservableList<String> options2 = FXCollections.observableArrayList(
				"m³",
				"dm³",
				"cm³",
				"mm³"	
				);

		//Combon Box

		ComboBox<String> cb1 = new ComboBox<String>(options);
		cb1.setValue(options.get(0));

		cb1.valueProperty().addListener(new ChangeListener<String>() {
			public void changed(ObservableValue<? extends String> ov, String t, String t1){
				switch (cb1.getSelectionModel().getSelectedItem()){
				case "Littres": multi = 1; break;
				case "Decilitre": multi = 0.001; break;
				case "Centilitre": multi = 0.000001; break;
				case "Millilitre": multi = 0.000000001; break;
				
				}
			}
		});

		ComboBox<String> cb2 = new ComboBox<String>(options2);
		cb2.setValue(options2.get(1));

		cb2.valueProperty().addListener(new ChangeListener<String>() {
			public void changed(ObservableValue<? extends String> ov, String t, String t1){
				switch (cb2.getSelectionModel().getSelectedItem()){
				case "m³": rat = 0.001; break;
				case "dm³": rat = 1; break;
				case "cm³": rat = 1000; break;
				case "mm³": rat = 1000000; break;
				}
			}
		});

		//Horizontal Box

		HBox volumec = new HBox();
		volumec.setPadding(new Insets(5));
		volumec.setSpacing(10);
		volumec.getChildren().addAll(volume, cb1);

		HBox nbcubec = new HBox();
		nbcubec.setPadding(new Insets(5));
		nbcubec.setSpacing(10);
		nbcubec.getChildren().addAll(nbcube, cb2);

		HBox boutonsC = new HBox();
		boutonsC.setPadding(new Insets(10));
		boutonsC.setSpacing(20);
		boutonsC.getChildren().addAll(bnCalculer, bnRetour);

		//Textfield property

		volume.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, 
					String newValue) {
				if (!newValue.matches("[\\d.]*")) {
					volume.setText(newValue.replaceAll("[^\\d.]", ""));
				}
			}
		});

		nbcube.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, 
					String newValue) {
				if (!newValue.matches("[\\d.]*")) {
					nbcube.setText(newValue.replaceAll("[^\\d.]", ""));
				}
			}
		});

		nbcube.setEditable(false);

		//Boutons Actions

		bnCalculer.setOnAction(e -> {
			affichagetext();
		});

		cb2.setOnAction(e -> {
			affichagetext();
		});

		bnRetour.setOnAction(e -> {
			this.close();
		});

		//BorderPane

		BorderPane root = new BorderPane();
		root.setPadding(new Insets(10));
		root.setTop(volumec);
		root.setCenter(nbcubec);
		root.setBottom(boutonsC);

		return root;

	}

	//Transformer en Double

	public void affichagetext(){
		String converSt1 = volume.getText();
		double converDou1 = Double.parseDouble(converSt1);
		converDou1=converDou1*rat*multi;
		converSt1 = String.valueOf(converDou1);
		nbcube.setText(converSt1);
	}
}
