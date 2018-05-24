package menuprincipale;

import demineurnorauto.Demineur;
import gobalVariable.Global;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import logitropbien.DroneAvion;
import panneauxpubli.PanneauxPub;

		public class MenuProjets extends Stage {
			
			private Button bnExit = new Button("Retour Menu Principal");
			private Button bnDroneAv = new Button("Drone Avion Contrôles");
			private Button bnPanneauxpub = new Button("Gestion Panneaux de pub");
			private Button bnDemineurNorauto = new Button("Demineur de Norauto");
			
			public MenuProjets(){
				this.setTitle("Menu Projets");
				this.setResizable(true);
				Scene laScene = new Scene(creerContenu());
				this.initModality(Modality.WINDOW_MODAL);
				Global glob = Global.LOGOPATH;
				this.getIcons().add(new Image(glob.toString()));
				this.setScene(laScene);
				this.sizeToScene();
			}
			
			private Parent creerContenu() {
				
				bnDroneAv.setPrefSize(170, 20);
				bnPanneauxpub.setPrefSize(170, 20);
				bnPanneauxpub.setStyle("-fx-color : #CCCCCC");
				bnDroneAv.setStyle("-fx-color : #CCCCCC");
				bnExit.setStyle("-fx-color : #DDAAAA");

				HBox menudeska = new HBox();
				menudeska.setPadding(new Insets(5));
				menudeska.setSpacing(10);
				menudeska.getChildren().addAll(bnDroneAv, bnPanneauxpub,bnDemineurNorauto, bnExit);
				
				
				bnDroneAv.setOnAction(e -> {
					DroneAvion c = new DroneAvion();
					c.initOwner(this);
					c.show();
				});
				
				bnPanneauxpub.setOnAction(e -> {
					PanneauxPub c = new PanneauxPub();
					c.initOwner(this);
					c.show();
				});
				
				bnDemineurNorauto.setOnAction(e -> {
					Demineur c = new Demineur();
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
