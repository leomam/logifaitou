package menuprincipale;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import glisserdeposer.GlisseAndDepose;
import gobalVariable.Global;
import logitropbien.Littrestodm3;
import logitropbien.NameGenerator;
import logitropbien.Vitessedebi;

	public class MenuUtilitaires extends Stage {
		
		private Button bnExit = new Button("Retour Menu Principal");
		private Button bnVitessedebit = new Button("Vitesse Débit");
		private Button bnLittres = new Button("Littres Conversion");
		private Button bnNameGen = new Button("Génération de Nom");
		private Button bnGlisserDepo = new Button("Glisser Déposer");
		
		public MenuUtilitaires(){
			this.setTitle("Menu Utilitaires");
			this.setResizable(true);
			Scene laScene = new Scene(creerContenu());
			this.initModality(Modality.WINDOW_MODAL);
			Global glob = Global.LOGOPATH;
			this.getIcons().add(new Image(glob.toString()));
			this.setScene(laScene);
			this.sizeToScene();
		}
		
		private Parent creerContenu() {
			
			bnVitessedebit.setPrefSize(170, 20);
			bnLittres.setPrefSize(170, 20);
			bnNameGen.setPrefSize(170, 20);
			bnGlisserDepo.setPrefSize(170, 20);
			bnVitessedebit.setStyle("-fx-color : #CCCCCC");
			bnLittres.setStyle("-fx-color : #CCCCCC");
			bnNameGen.setStyle("-fx-color : #CCCCCC");
			bnGlisserDepo.setStyle("-fx-color : #CCCCCC");
			bnExit.setStyle("-fx-color : #DDAAAA");

			HBox menudeska = new HBox();
			menudeska.setPadding(new Insets(5));
			menudeska.setSpacing(10);
			menudeska.getChildren().addAll(bnVitessedebit, bnLittres, bnNameGen, bnGlisserDepo, bnExit);
			

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
			
			bnGlisserDepo.setOnAction(e -> {
				GlisseAndDepose c = new GlisseAndDepose();
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
