package demineurnorauto;



import java.util.Random;

import gobalVariable.Global;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
//import javafx.scene.paint.Color;
import javafx.stage.Stage;

/*
 * Enora la best
 * La classe Demineur g�re en m�moire une matrice (le terrain) dont chaque case contient :
 * 		- soit -1 (ce qui repr�sente une mine)
 * 		- soit le nombre de mines situ�es dans les cases voisines (valeur entre 0 et 8 donc).
 * 
 * Au niveau de l'affichage, une matrice de boutons (la map) repr�sente graphiquement
 * le terrain. Au d�part les boutons n'ont pas de libell�s mais au fur et � mesure du
 * jeu, les boutons "se d�couvrent" (en devenant "disabled") en laissant appara�tre :
 *    - soit une mine (repr�sent�e graphiquement par un 'O' sur fond rouge), et dans ce cas c'est perdu !
 *    - soit la valeur correspondante dans le terrain (ou rien si cette valeur est 0)
 *
 */
public class Demineur extends Stage {
	// les variables et constante de la classe
	private static int 	NB_MINES					= 10;
	private static int 	TAILLE						= 10;
	
	private int 				nbCasesDecouvertes	= 0;
	private int 				nbClics				= 0;
	private int					nbMinesDecouvertes 	= 0;
	private int 				terrain[][]			= new int[getTAILLE()][getTAILLE()];
	
	// les composants de la fen�tre
	private Button		map[][]	= new Button[getTAILLE()][getTAILLE()];
	private Label 		message	= new Label();
	private VBox 		racine	= new VBox();
	private GridPane 	grille 	= new GridPane();
//	private Button		recommencer = new Button("Recommencer");
			
	public Demineur() {
		this.initTerrain();
		this.setTitle("Démineur");
		this.initModality(Modality.WINDOW_MODAL);
		this.setResizable(false);
		Scene laScene = new Scene(creerContenu());
		this.setScene(laScene);
		this.sizeToScene();
		Global glob = Global.LOGOPATH;
		this.getIcons().add(new Image(glob.toString()));
	}
	
	public Parent creerContenu(){
		// Crée le contenu de la fenêtre. Retourne la racine du Scene Graph
		int i,j;
		
		message.setText("Nombre de clics = " + nbClics+"                                   Nombre de mines restantes : "+(getNB_MINES()-nbMinesDecouvertes));
		
		/* A COMPLETER
		 * 
		 * Ici, création de la "map" dans le GridPane. Chaque bouton de la map doit pouvoir détecter :
		 *	- un clic,
		 *	- et un clic droit
		 */
		
		for (i=0; i<getTAILLE(); i++) {
			for (j=0; j<getTAILLE(); j++) {
				map[i][j] = new Button();
				map[i][j].setStyle("-fx-color : cornflowerblue");
				map[i][j].setPrefSize(40, 40);
				map[i][j].setOnAction(e -> {gererClic(e);});
				map[i][j].setOnMouseClicked(e -> {gererClicDroit(e);});
				grille.add(map[i][j], i, j);
			}
		}
		
		racine.setPadding(new Insets(15));
		racine.setSpacing(10);
		racine.getChildren().addAll(message, grille);//, recommencer);
		
		return racine;
	}
	
	void initTerrain(){
		Random random = new Random();
		int mines, i, j;
		/* A COMPLETER
		 * 
		 * placer les mines aléatoirement (valeur = -1), en veillant à ne pas en placer deux sur la même case
		 * 
		 */
		for (mines=0; mines<getNB_MINES(); mines++) {
			i = random.nextInt(getTAILLE());
			j = random.nextInt(getTAILLE());
			while (terrain[i][j]==-1) {
				i = random.nextInt(getTAILLE());
				j = random.nextInt(getTAILLE());
			}
			terrain[i][j] = -1;
		}
		
		/* A COMPLETER
		 * 
		 * calculer les valeurs des autres cases (=les cases "non mines") :
		 * 
		 * 	si la case n'est pas elle-même une mine, calculer sa valeur en comptant
		 *	le nombre de mines dans son voisinage (regarder ses 8 voisins s'ils existent)
		 *
		 */
		for (i=0; i<getTAILLE(); i++) {
			for (j=0; j<getTAILLE(); j++) {
				if (terrain[i][j]!=-1) {
					terrain[i][j] = this.nbMines(i,j);
				}
			}
		}
	}
	
	public int nbMines(int i,int j) {
		int nbMines, ligne, colonne;
		nbMines = 0;
		if (i!=0 && j!=0 && i!=getTAILLE()-1 && j!=getTAILLE()-1) {
			for (ligne=i-1; ligne<=i+1; ligne++) {
				for (colonne=j-1; colonne<=j+1; colonne++) {
					if (ligne!=i || colonne!=j) {
						if (terrain[ligne][colonne]==-1) {
							nbMines = nbMines+1;
						}
					}
				}
			}
		}
		else if (i==0) {
			if (j==0) {
				for (ligne=i; ligne<=i+1; ligne++) {
					for (colonne=j; colonne<=j+1; colonne++) {
						if (ligne!=i || colonne!=j) {
							if (terrain[ligne][colonne]==-1) {
								nbMines = nbMines+1;
							}
						}
					}
				}
			}
			else if (j==getTAILLE()-1) {
				for (ligne=i; ligne<=i+1; ligne++) {
					for (colonne=j-1; colonne<=j; colonne++) {
						if (ligne!=i || colonne!=j) {
							if (terrain[ligne][colonne]==-1) {
								nbMines = nbMines+1;
							}
						}
					}
				}
			}
			else {
				for (ligne=i; ligne<=i+1; ligne++) {
					for (colonne=j-1; colonne<=j+1; colonne++) {
						if (ligne!=i || colonne!=j) {
							if (terrain[ligne][colonne]==-1) {
								nbMines = nbMines+1;
							}
						}
					}
				}
			}
		}
		else if (i==getTAILLE()-1) {
			if (j==0) {
				for (ligne=i-1; ligne<=i; ligne++) {
					for (colonne=j; colonne<=j+1; colonne++) {
						if (ligne!=i || colonne!=j) {
							if (terrain[ligne][colonne]==-1) {
								nbMines = nbMines+1;
							}
						}
					}
				}
			}
			else if (j==getTAILLE()-1) {
				for (ligne=i-1; ligne<=i; ligne++) {
					for (colonne=j-1; colonne<=j; colonne++) {
						if (ligne!=i || colonne!=j) {
							if (terrain[ligne][colonne]==-1) {
								nbMines = nbMines+1;
							}
						}
					}
				}
			}
			else {
				for (ligne=i-1; ligne<=i; ligne++) {
					for (colonne=j-1; colonne<=j+1; colonne++) {
						if (ligne!=i || colonne!=j) {
							if (terrain[ligne][colonne]==-1) {
								nbMines = nbMines+1;
							}
						}
					}
				}
			}
		}
		else if (j==0) {
			for (ligne=i-1; ligne<=i+1; ligne++) {
				for (colonne=j; colonne<=j+1; colonne++) {
					if (ligne!=i || colonne!=j) {
						if (terrain[ligne][colonne]==-1) {
							nbMines = nbMines+1;
						}
					}
				}
			}
		}
		else {
			for (ligne=i-1; ligne<=i+1; ligne++) {
				for (colonne=j-1; colonne<=j; colonne++) {
					if (ligne!=i || colonne!=j) {
						if (terrain[ligne][colonne]==-1) {
							nbMines = nbMines+1;
						}
					}
				}
			}
		}
		return(nbMines);
	}
	
	
	private void decouvrir(int x, int y) {
		/* m�thode r�cursive :
		 *		si la case (x,y) existe
		 *			si elle n'est pas déjà d�couverte (=si le Button correspondant n'est pas d�sactiv�)
		 *				si sa valeur est 0 alors
		 *					il faut la d�couvrir ainsi que ses 8 voisins �ventuels
		 *			 	sinon 
		 *					il faut juste la d�couvrir
		 *				finsi
		 *			finsi
		 *		finsi
		 */
		if ( (x>=0) && (x<getTAILLE()) && (y>=0) && (y<getTAILLE()) ) {
			if  (map[x][y].isDisabled() == false){
				if (terrain[x][y]==0) {
					map[x][y].setDisable(true);
					map[x][y].setText("");
					decouvrir(x-1,y-1);
					decouvrir(x-1,y);
					decouvrir(x-1,y+1);
					decouvrir(x,y-1);
					decouvrir(x,y+1);
					decouvrir(x+1,y-1);
					decouvrir(x+1,y);
					decouvrir(x+1,y+1);
				} else {
					map[x][y].setDisable(true);
					map[x][y].setText("" + terrain[x][y]);
					
				}
				this.nbCasesDecouvertes++;
			}
		}
	}
	void afficherLesMines() {
		int i, j;
		
		// affiche le contenu de la grille : les 0 ne sont pas affich�s et les -1 (les bombes)
		// sont remplac�s par un O sur fond rouge
		for (i=0;i<getTAILLE();i++) {
			for (j=0;j<getTAILLE();j++) {
				if (terrain[i][j]==-1) {
					map[i][j].setText("O");
					map[i][j].setStyle("-fx-color : red");
				}else if (terrain[i][j] != 0) {
					map[i][j].setText(""+terrain[i][j]);
				}
				map[i][j].setDisable(true);
			}
		}
	}
	private void gererClic(ActionEvent e){
		boolean trouve = false;
		int i,j;	// indices du bouton cliqu�
				

		i = 0;
		j = 0;
		
		/* A COMPLETER
		 * 
		 * 	rechercher quel carreau (Button) a �t� cliqu�
		 * 	� l'issue de la recherche, i et j contiennent les coordonn�es du bouton cliqu�
		 * 
		 */
		while (i<getTAILLE() && !trouve) {
			j=0;
			while (j<getTAILLE() && !trouve) {
				if (e.getSource().equals(map[i][j])) {
					trouve = true;
				}
				else {
					j = j+1;
				}
			}
			if (!trouve) {
				i = i+1;
			}
		}
		
		/* A COMPLETER
		 * 
		 *  Si la case cliqu�e contient une mine, c'est PERDU et on affiche toutes les mines (appel � la m�thode afficherLesMines() )
		 *  sinon on d�couvre la case [i][j] (appel � la m�thode decouvrir(...) ), et on regarde si c'est GAGNE
		 *  
		 */
		if (trouve) {
			if (terrain[i][j]==-1 && !map[i][j].getText().equals("F")) {
				this.afficherLesMines();
				nbClics++;
				message.setText("Nombre de clics = " + nbClics+"                                   Nombre de mines restantes : "+(getNB_MINES()-nbMinesDecouvertes));
			}
			else if (!map[i][j].getText().equals("F")){
				nbClics++;
				message.setText("Nombre de clics = " + nbClics+"                                   Nombre de mines restantes : "+(getNB_MINES()-nbMinesDecouvertes));
				this.decouvrir(i, j);
				if (nbCasesDecouvertes==getTAILLE()*getTAILLE()-getNB_MINES()) {
					message.setText("Victoire ! Félicitations");
					for (i=0;i<getTAILLE();i++) {
						for (j=0;j<getTAILLE();j++) {
							if (terrain[i][j]==-1) {
								map[i][j].setText("O");
								map[i][j].setStyle("-fx-color : limegreen");
							}
							else if (terrain[i][j] != 0) {
								map[i][j].setText(""+terrain[i][j]);
							}
							map[i][j].setDisable(true);
						}
					}
				}
			}
		}
	}
	
	
	private void gererClicDroit(MouseEvent e){
		boolean trouve = false;
		int i=0,j=0;	// indices du bouton cliqu�
				
		// S'il s'agit d'un clic droit
		if (e.getButton()==MouseButton.SECONDARY){
			
		
			/* A COMPLETER
			 * 
			 * rechercher quelle est la source du clic droit...
			 */
			while (i<getTAILLE() && !trouve) {
				j = 0;
				while (j<getTAILLE() && !trouve) {
					if (e.getSource()==map[i][j]) {
						trouve = true;
					}
					else {
						j = j+1;
					}
				}
				if (!trouve) {
					i = i+1;
				}
			}
			// ... et y placer la lettre F
			if (trouve){
				if (map[i][j].getText().equals("F")) {
					map[i][j].setText("");
					nbMinesDecouvertes--;
				}
				else {
					map[i][j].setText("F");
					nbMinesDecouvertes++;
				}
			}
			message.setText("Nombre de clics = " + nbClics+"                                   Nombre de mines restantes : "+(getNB_MINES()-nbMinesDecouvertes));
		}
		
	}

	public static int getNB_MINES() {
		return NB_MINES;
	}

	public static void setNB_MINES(int nB_MINES) {
		NB_MINES = nB_MINES;
	}

	public static int getTAILLE() {
		return TAILLE;
	}

	public static void setTAILLE(int tAILLE) {
		TAILLE = tAILLE;
	}
	
//	public void recommencerPartie(ActionEvent e) {
//		int i,j;
//		this.initTerrain();
//		grille = new GridPane();
//		for (i=0; i<TAILLE; i++) {
//			for (j=0; j<TAILLE; j++) {
//				map[i][j] = new Button();
//				map[i][j].setStyle("-fx-color : cornflowerblue");
//				map[i][j].setPrefSize(50, 50);
//				map[i][j].setOnAction(event -> {gererClic(event);});
//				map[i][j].setOnMouseClicked(event -> {gererClicDroit(event);});
//				grille.add(map[i][j], i, j);
//			}
//		}
//		nbClics = 0;
//		nbMinesDecouvertes = 0;
//		nbCasesDecouvertes = 0;
//		message.setText("Nombre de clics = " + nbClics+" - Nombre de mines restantes : "+(NB_MINES-nbMinesDecouvertes));
//	}
	
}