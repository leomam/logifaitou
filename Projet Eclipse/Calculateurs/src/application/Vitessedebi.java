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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Vitessedebi extends Stage {
	private Button bnRetour = new Button("Retour");
	private Button bnCalculer = new Button("Calculer");
	private TextField kbs = new TextField();
	private TextField nbeur = new TextField();
	private TextField resulta = new TextField();
	private Label lresulta = new Label("Résultat :");
	private int multi = 1;
	private int rat = 3600;
	private int chat = 1000000;

	public Vitessedebi(){
		this.setTitle("Combien de Gigas ?");
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
				"ko/s",
				"Mo/s",
				"Go/s"	
				);
		ObservableList<String> options2 = FXCollections.observableArrayList(
				"Jours",
				"Heures",
				"Minutes",
				"Secondes"	
				);
		
		ObservableList<String> options3 = FXCollections.observableArrayList(
				"Téras",
				"Gigas",
				"Mégas",
				"Kilos"	
				);
		
		//Combon Box
		
		ComboBox<String> cb1 = new ComboBox<String>(options);
		cb1.setValue(options.get(0));
		
		cb1.valueProperty().addListener(new ChangeListener<String>() {
			public void changed(ObservableValue<? extends String> ov, String t, String t1){
				switch (cb1.getSelectionModel().getSelectedItem()){
				case "ko/s": multi = 1; break;
				case "Mo/s": multi = 1000; break;
				case "Go/s": multi = 1000000; break;
				}
			}
		});
		
		ComboBox<String> cb2 = new ComboBox<String>(options2);
		cb2.setValue(options2.get(1));
		
		cb2.valueProperty().addListener(new ChangeListener<String>() {
			public void changed(ObservableValue<? extends String> ov, String t, String t1){
				switch (cb2.getSelectionModel().getSelectedItem()){
				case "Jours": rat = 86400; break;
				case "Heures": rat = 3600; break;
				case "Minutes": rat = 60; break;
				case "Secondes": rat = 1; break;
				}
			}
		});
		
		ComboBox<String> cb3 = new ComboBox<String>(options3);
		cb3.setValue(options3.get(1));
		
		cb3.valueProperty().addListener(new ChangeListener<String>() {
			public void changed(ObservableValue<? extends String> ov, String t, String t1){
				switch (cb3.getSelectionModel().getSelectedItem()){
				case "Téras": chat = 1000000000; break;
				case "Gigas": chat = 1000000; break;
				case "Mégas": chat = 1000; break;
				case "Kilos": chat = 1; break;
				}
			}
		});
		
		//Horizontal Box
		
		HBox kbsc = new HBox();
		kbsc.setPadding(new Insets(5));
		kbsc.setSpacing(10);
		kbsc.getChildren().addAll(kbs, cb1);
		
		HBox nbheurc = new HBox();
		nbheurc.setPadding(new Insets(5));
		nbheurc.setSpacing(10);
		nbheurc.getChildren().addAll(nbeur, cb2);
		
		HBox resultatt = new HBox();
		resultatt.setPadding(new Insets(10));
		resultatt.setSpacing(20);
		resultatt.getChildren().addAll(bnCalculer, bnRetour);
		resultatt.getChildren().addAll(lresulta,resulta, cb3);
		
		//Textfield property
		
		kbs.textProperty().addListener(new ChangeListener<String>() {
		    @Override
		    public void changed(ObservableValue<? extends String> observable, String oldValue, 
		        String newValue) {
		        if (!newValue.matches("[\\d.]*")) {
		            kbs.setText(newValue.replaceAll("[^\\d.]", ""));
		        }
		    }
		});
		
		nbeur.textProperty().addListener(new ChangeListener<String>() {
		    @Override
		    public void changed(ObservableValue<? extends String> observable, String oldValue, 
		        String newValue) {
		        if (!newValue.matches("[\\d.]*")) {
		            nbeur.setText(newValue.replaceAll("[^\\d.]", ""));
		        }
		    }
		});
		
		resulta.setEditable(false);
		
		//Boutons Actions

		bnCalculer.setOnAction(e -> {
			affichagetext();
		});
		
		cb3.setOnAction(e -> {
			affichagetext();
		});

		bnRetour.setOnAction(e -> {
			this.close();
		});
		
		//BorderPane
		
		BorderPane root = new BorderPane();
		root.setPadding(new Insets(10));
		root.setTop(kbsc);
		root.setCenter(nbheurc);
		root.setBottom(resultatt);

		return root;

	}
	
	//Transformer en Double
	
	public void affichagetext(){
		String converSt1 = kbs.getText();
		String converSt2 = nbeur.getText();
		double converDou1 = Double.parseDouble(converSt1);
		double converDou2 = Double.parseDouble(converSt2);
		converDou1=converDou1*converDou2*rat*multi/chat;
		converSt1 = String.valueOf(converDou1);
		resulta.setText(converSt1);
	}
}
