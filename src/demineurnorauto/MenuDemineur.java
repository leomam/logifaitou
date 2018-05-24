package demineurnorauto;

import gobalVariable.Global;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MenuDemineur extends Stage {
	
	private Button bnOK = new Button("Ok");
	private Button bnRetour = new Button("Retour");
	
	public MenuDemineur() {
		this.setTitle("Setup Démineur");
		this.setResizable(false);
		this.initModality(Modality.WINDOW_MODAL);
		Scene laScene = new Scene(creerContenu());
		this.setScene(laScene);
		this.sizeToScene();
		Global glob = Global.LOGOPATH;
		this.getIcons().add(new Image(glob.toString()));
	}
	
	public Parent creerContenu(){
		
		ObservableList<String> o2 = FXCollections.observableArrayList(
				"10x10",
				"12x12",
				"15x15",
				"18x18"	
				);
		
		ComboBox<String> cb2 = new ComboBox<String>(o2);
		cb2.setValue(o2.get(0));
		cb2.valueProperty().addListener(new ChangeListener<String>() {
			public void changed(ObservableValue<? extends String> ov, String t, String t1){
				switch (cb2.getSelectionModel().getSelectedItem()){
				case "10x10": Demineur.setTAILLE(10); break;
				case "12x12": Demineur.setTAILLE(12); break;
				case "15x15": Demineur.setTAILLE(15); break;
				case "18x18": Demineur.setTAILLE(18); break;
				
				}
			}
		});
		
		ObservableList<String> o = FXCollections.observableArrayList(
				"Facile",
				"Intermédiaire",
				"Difficile",
				"Impossible",
				"Impossible 2"
				);
		
		ComboBox<String> cb1 = new ComboBox<String>(o);
		cb1.setValue(o.get(0));
		cb1.valueProperty().addListener(new ChangeListener<String>() {
			public void changed(ObservableValue<? extends String> ov, String t, String t1){
				switch (cb1.getSelectionModel().getSelectedItem()){
				case "Facile": Demineur.setNB_MINES((Demineur.getTAILLE()*Demineur.getTAILLE())/10);
				case "Intermédiaire": Demineur.setNB_MINES((Demineur.getTAILLE()*Demineur.getTAILLE()*2)/10); break;
				case "Difficile": Demineur.setNB_MINES((Demineur.getTAILLE()*Demineur.getTAILLE()*3)/10); break;
				case "Impossible": Demineur.setNB_MINES((Demineur.getTAILLE()*Demineur.getTAILLE()*4)/10); break;
				case "Impossible 2": Demineur.setNB_MINES((Demineur.getTAILLE()*Demineur.getTAILLE()*5)/10); break;
				}
			}
		});
		
		
		
		bnOK.setOnAction(e -> {
			Demineur c = new Demineur();
			c.initOwner(this);
			c.show();
		});
		
		bnRetour.setOnAction(e -> {
			this.close();
		});
		
		
		bnOK.setPrefSize(100, 20);
		bnRetour.setPrefSize(100, 20);
		cb1.setPrefSize(100, 20);
		cb2.setPrefSize(100, 20);
		
		HBox choix = new HBox();
		choix.setSpacing(10);
		choix.getChildren().addAll(cb2,cb1);
		
		HBox bouton = new HBox();
		bouton.setSpacing(10);
		bouton.getChildren().addAll(bnOK,bnRetour);
		
		VBox racine = new VBox();
		racine.setPadding(new Insets(15));
		racine.setSpacing(10);
		racine.getChildren().addAll(choix,bouton);
		
		return racine;
	}
}
