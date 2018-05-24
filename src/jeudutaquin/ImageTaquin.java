package jeudutaquin;

import gobalVariable.Global;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class ImageTaquin extends Stage {
	//Taille du Jeu : minimum 3
	private static final int TAILLE	= 4;
	//private static int videX = -1 ,videY = -1;
	
	//Variables d'instance
	private Label  lnbclic =						new Label("Nombre de clics : 0");
	private Button bnMelange =						new Button("Mélanger");
	private Button tableauDesBoutons[][] = 			new Button[TAILLE][TAILLE];
	private Image tableauImage[][] = 				new Image[TAILLE][TAILLE];
	private ImageView tableauImageView [][] = 		new ImageView[TAILLE][TAILLE];
	//la dernière image et l'avant dernière sont identique
	private String tableauImagePath[][] = 			{{"https://image.ibb.co/cEVCkd/1.png","https://image.ibb.co/iiThkd/2.png","https://image.ibb.co/iKmorJ/3.png","https://image.ibb.co/mr5gBJ/4.png"},
													{"https://image.ibb.co/efYJ1T/5.png","https://image.ibb.co/gOcWMT/6.png","https://image.ibb.co/gs57vo/7.png","https://image.ibb.co/jFGK88/8.png"},
													{"https://image.ibb.co/cLofgT/9.png","https://image.ibb.co/es4mMT/10.png","https://image.ibb.co/cAmGMT/11.png","https://image.ibb.co/dQvXvo/12.png"},
													{"https://image.ibb.co/dN0bMT/13.png","https://image.ibb.co/jGUaFo/14.png","https://image.ibb.co/mj3D1T/15.png","https://image.ibb.co/mj3D1T/15.png"}};

	public ImageTaquin() {

		this.setTitle("Jeu du Taquin Hamster");
		this.setResizable(false);
		this.initModality(Modality.WINDOW_MODAL);
		Scene laScene = new Scene(creerContenu());
		this.setScene(laScene);
		this.sizeToScene();
		Global glob = Global.LOGOPATH;
		this.getIcons().add(new Image(glob.toString()));

	}

	private Parent creerContenu() {
		
		initialisationTableauDesBoutons();
		initialisationDesImagesAvecLePath();
		initialisationDesImageViewAvecLesImages();
		GridPane terrainDeJeu = new GridPane();
		initialisationDuGridPanePrincipal(terrainDeJeu);		
		melangerLaGrille(tableauDesBoutons);
		
		//je ne peux pas tester donc a tester chez moi
		
		
		VBox FenetreduJeu = new VBox();
		FenetreduJeu.setSpacing(20);
		FenetreduJeu.getChildren().addAll(lnbclic,terrainDeJeu,bnMelange);

		return FenetreduJeu;
	}
	
	
	 //		  \\
	//Fonctions\\
   //			\\
	
	
	void initialisationTableauDesBoutons(){
		for (int i=0;i<TAILLE;i++) {		
			for (int j=0;j<TAILLE;j++) {
				//les boutons ont comme label respectivement : 0,1,2,3 ....
				tableauDesBoutons[j][i]=(new Button());
				tableauDesBoutons[j][i].setOnAction(e -> {//clicSurUnBouton(j,e);
					});
				tableauDesBoutons[j][i].setPrefSize(100, 100);
				}				
			}
		}
	
	void initialisationDesImagesAvecLePath(){
		for (int i=0;i<TAILLE;i++) {		
			for (int j=0;j<TAILLE;j++) {
				//Attention : URL de la dernière case
				tableauImage[j][i]=(new Image(tableauImagePath[j][i]));
			}
		}
	}
	void initialisationDesImageViewAvecLesImages(){
		for (int i=0;i<TAILLE;i++) {		
			for (int j=0;j<TAILLE;j++) {
				tableauImageView[j][i]=(new ImageView(tableauImage[j][i]));
			}
		}
	}
	
	void initialisationDuGridPanePrincipal(GridPane t){
		for (int i=0;i<TAILLE;i++) {		
			for (int j=0;j<TAILLE;j++) {
				tableauDesBoutons[j][i].setGraphic(tableauImageView[j][i]);
				t.add(tableauDesBoutons[j][i], j, i);
			}
		}
	}
	
	void echangeDeuxCase(int coord1x,int coord1y,int coord2x, int coord2y,GridPane t){
		//je ne peux pas tester donc a tester chez moi
		t.add(tableauDesBoutons[coord1x][coord1y], coord2x, coord2y);
		t.add(tableauDesBoutons[coord2x][coord2y], coord1x, coord1y);
		Button ech = new Button();
		ech = tableauDesBoutons[coord1x][coord1y];
		tableauDesBoutons[coord1x][coord1y] = tableauDesBoutons[coord2x][coord2y];
		tableauDesBoutons[coord2x][coord2y] = ech;	
	}
	
	void clicSurUnBouton(int x,int y,ActionEvent e) {
		//Ceci est totalement du copier coller donc vérifie
		/*boolean trouve = false;
		int i = 0, j = 0;
		while (i<TAILLE && !trouve) {
			j = 0;
			while (j<TAILLE && !trouve) {
				if (tableauDesBoutons[i][j]==e.getSource()) {
					trouve = true;
				}
				else if (!trouve) {
					j = j+1;
				}
			}
			if (!trouve) {
				i = i+1;
			}
		}*/
		System.out.println(e.getSource());
	}
	
	void melangerLaGrille(Button[][] t){
		
	}
}
