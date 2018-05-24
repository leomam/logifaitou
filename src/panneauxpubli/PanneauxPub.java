package panneauxpubli;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class PanneauxPub extends Stage {
	private Button bnAjouter = 			new Button("Ajouter");
	private Button bnSupprimer = 		new Button("Supprimer");
	private Button bnClient = 			new Button("Client");
	

	public PanneauxPub() {

		this.setTitle("Accueil");
		this.setResizable(false);
		this.initModality(Modality.WINDOW_MODAL);
		Scene laScene = new Scene(creerContenu());
		this.setScene(laScene);
		this.sizeToScene();
		this.getIcons().add(new Image("https://image.ibb.co/n1TBm7/logo.png"));

	}

	private Parent creerContenu() {
		Image imageLannion = new Image("https://preview.ibb.co/fFdAUS/Carte_Lannion.png");
		ImageView imageVLannion = new ImageView();
		Image imageDrapeauFrancais = new Image("https://image.ibb.co/e14gKS/drapeaufrancais.png");
		ImageView imageVDrapeaux = new ImageView();
		Image imageDrapeauBreton = new Image("https://image.ibb.co/kxFfW7/drapeaubreton.png");
		imageVLannion.setImage(imageLannion);
		imageVDrapeaux.setImage(imageDrapeauFrancais);
		imageVDrapeaux.setFitHeight(20);
		imageVDrapeaux.setFitWidth(28);
		
		//Menu du Haut
		MenuBar menuBar = new MenuBar();

		Menu helpM = new Menu("Aide");
		Menu affichageM = new Menu("Affichage");
		Menu fileM = new Menu("Fichiers");
		MenuItem notesdemajMI = new MenuItem("Notes de mises à jour");
		MenuItem quitterMI = new MenuItem("Quitter");
		MenuItem aboutMI = new MenuItem("à propos");
		MenuItem affichageMI = new MenuItem("? A quoi sert cette rubrique ?? soit j'ai pas suivis (fort probable) soit c'est une petite fantaisie");
		
		aboutMI.setOnAction(e -> {
			AboutUSnotUSA c = new AboutUSnotUSA();
			c.initOwner(this);
			c.show();				
		});
		notesdemajMI.setOnAction(e -> {
			NotesdemajPanneauxdePub c = new NotesdemajPanneauxdePub();
			c.initOwner(this);
			c.show();				
		});
		quitterMI.setOnAction(e -> {
			this.close();
		});
		affichageM.getItems().add(affichageMI);
		fileM.getItems().addAll(notesdemajMI,quitterMI);
		helpM.getItems().add(aboutMI);
		
		menuBar.getMenus().addAll(fileM,affichageM ,helpM);
		
		//Taille des boutons
		
		bnAjouter.setPrefSize(80, 20);
		bnSupprimer.setPrefSize(80, 20);
		bnClient.setPrefSize(80, 20);
		
        Button bnDrapeaux = new Button("");
        
        bnDrapeaux.setGraphic(imageVDrapeaux);
        bnDrapeaux.setOnAction(e -> {
        	if (imageVDrapeaux.getImage().equals(imageDrapeauFrancais)) {
	        	imageVDrapeaux.setImage(imageDrapeauBreton);
	        	bnDrapeaux.setGraphic(imageVDrapeaux);
        	} else {
        		imageVDrapeaux.setImage(imageDrapeauFrancais);
	        	bnDrapeaux.setGraphic(imageVDrapeaux);
        	}
		});
        
        bnAjouter.setOnAction(e -> {
        	AjoutPanneauxEmplacementView c = new AjoutPanneauxEmplacementView();
			c.initOwner(this);
			c.show();		
			});
        

        bnSupprimer.setOnAction(e -> {
        	SuppressionPanneauxEmplacementView c = new SuppressionPanneauxEmplacementView();
			c.initOwner(this);
			c.show();		
			});


        bnClient.setOnAction(e -> {
        	ClientsModalView c = new ClientsModalView();
			c.initOwner(this);
			c.show();		
			});

        
		//Horizontal Box et Vertical Box
		
		HBox menubarprincipale = new HBox();
		menubarprincipale.setSpacing(435);
		menubarprincipale.getChildren().addAll(menuBar, bnDrapeaux);
		
		HBox boutonsC = new HBox();
		boutonsC.setPadding(new Insets(5));
		boutonsC.setSpacing(10);
		boutonsC.getChildren().addAll(bnAjouter,bnSupprimer, bnClient);
		
		VBox principale = new VBox();
		principale.setPadding(new Insets(10));
		principale.setSpacing(20);
		principale.getChildren().addAll(boutonsC, imageVLannion);
		
		
		
		
		
		//Actions à la pression des boutons

		

		//BorderPane final

		BorderPane root = new BorderPane();
		root.setTop(menubarprincipale);
		root.setCenter(principale);

		return root;

	}
}
