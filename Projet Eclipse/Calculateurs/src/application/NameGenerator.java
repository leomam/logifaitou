package application;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Random;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class NameGenerator extends Stage {
	private Button bnRetour = new Button("Retour");
	private Button bnGenerer = new Button("Générer");
	private TextField nom = new TextField();
	private TextField prenom = new TextField();
	private TextField emailGoogle = new TextField();
	private TextField emailGMX = new TextField();
	private TextField jour = new TextField();
	private TextField mois = new TextField();
	private TextField annee = new TextField();
	private int tabnbjours [] = {31,28,31,30,31,30,31,31,30,31,30,31};
	private String tabmois [] = {"Janvier","Février","Mars", "Avril", "Mai", "Juin", "Juillet", "Août","Septembre","Octobre","Novembre", "Décembre"};
	private int anneeMinimalePourUnCompte = 1960;
	private int anneeMaximalePourUnCompte = 2001;
	private String tabprenom [] = {"Adrien","Albert","Alex","Axel","Hugo","Florent","Florian","Lucas","Josiane","Mathilde","Emma","Mathieu","Mélanie","Ugo","Ludovic","Loraine","Claude","Olivier","Pierre","Thomas","Clément","David","Ivan","Rachelle","Roger","Gérard","Lionel","Camille","Daniel","Henry","Hervé","José","Laura","Léon","Marie","Marion","Michel","Michelle","Noémie","Pascal","Pascale","Paul","Paule","Sandra","Théo","Titouan","Yann","Yoann"};
	private String tabnom [] = {"Lenormand","Hamilton","Leroy","Roux","Leblanc","Philippe","Balasco","Nidelle","Dargaud","Ferry","Dupre","Dupuis","Marion", "Henry","Maurel","Launay","Voisin"};
	public NameGenerator() {
		
		this.setTitle("Fake ID");
		this.setResizable(false);
		this.initModality(Modality.WINDOW_MODAL);
		Scene laScene = new Scene(creerContenu());
		this.setScene(laScene);
		this.sizeToScene();
		this.getIcons().add(new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTqCosUL5iACTRqWclFw94mTDS38dR1l9ZS4yYeATRS7TDDSehsuw"));

	}

	private Parent creerContenu() {
		
		//set size Textfield
		
		prenom.setPrefSize(180, 20);
		nom.setPrefSize(180, 20);
		emailGoogle.setPrefSize(370, 20);
		emailGMX.setPrefSize(370, 20);
		jour.setPrefSize(120, 20);
		mois.setPrefSize(110, 20);
		annee.setPrefSize(120, 20);

		//Horizontal Box et Verticale Box

		HBox nomc = new HBox();
		nomc.setPadding(new Insets(5));
		nomc.setSpacing(10);
		nomc.getChildren().addAll(prenom,nom);
		
		HBox datec = new HBox();
		datec.setSpacing(10);
		datec.getChildren().addAll(jour,mois,annee);
		
		VBox emailGoogleC = new VBox();
		emailGoogleC.setPadding(new Insets(5));
		emailGoogleC.setSpacing(10);
		emailGoogleC.getChildren().addAll(emailGoogle,emailGMX,datec);

		HBox boutonsC = new HBox();
		boutonsC.setPadding(new Insets(10));
		boutonsC.setSpacing(20);
		boutonsC.getChildren().addAll(bnGenerer, bnRetour);

		prenom.setEditable(false);
		nom.setEditable(false);
		emailGoogle.setEditable(false);
		emailGMX.setEditable(false);
		jour.setEditable(false);
		mois.setEditable(false);
		annee.setEditable(false);

		//Boutons Actions

		bnGenerer.setOnAction(e -> {
			affichagetext();
			triDoublon(tabprenom);
			triDoublon(tabnom);
		});


		bnRetour.setOnAction(e -> {
			this.close();
		});

		//BorderPane

		BorderPane root = new BorderPane();
		root.setPadding(new Insets(10));
		root.setTop(nomc);
		root.setCenter(emailGoogleC);
		root.setBottom(boutonsC);

		return root;

	}

	//Affichage dans textfield

	public void affichagetext(){
		Random r = new Random();
		int a,b,c, rmois,rannee,rjours;
		a = r.nextInt(tabprenom.length);
		b = r.nextInt(tabnom.length);
		c = 0;
		rmois = r.nextInt(12);
		rjours = r.nextInt(tabnbjours[rmois]+1);
		rannee = r.nextInt(anneeMaximalePourUnCompte-anneeMinimalePourUnCompte)+anneeMinimalePourUnCompte;
		while (c<10000) {
			c = r.nextInt(100000);
		}
		prenom.setText(tabprenom[a]);
		nom.setText(tabnom[b]);
		//stripAccents permet d'enlever les accents. LowerCase enlève les majuscules
		emailGoogle.setText(stripAccents(tabprenom[a]).toLowerCase()+"."+stripAccents(tabnom[b]).toLowerCase()+c+"@gmail.com");
		emailGMX.setText(stripAccents(tabprenom[a]).toLowerCase()+"."+stripAccents(tabnom[b]).toLowerCase()+c+"@gmx.fr");
		mois.setText(tabmois[rmois]);
		jour.setText(String.valueOf(rjours));
		annee.setText(String.valueOf(rannee));
	}
	
	public static String stripAccents(String s) 
	{
	    s = Normalizer.normalize(s, Normalizer.Form.NFD);
	    s = s.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
	    return s;
	}
	
	//le tri à bulle pour trier un tableau
	

	public static void triBulleOptimise(String tableau[])
    {
    int longueur=tableau.length;
    int doublons=0;
    boolean inversion;
    ArrayList <String> tDoubles = new ArrayList<String>();
    do
        {
        inversion=false;

        for(int i=0;i<longueur-1;i++)
            {
            if(tableau[i].compareTo(tableau[i+1])>0)
                {
                echanger(tableau,i,i+1);
                inversion=true;
                }
            }
         longueur--;
         }
    while(inversion);
    
    for (int p=0;p<tableau.length-1;p++) {
    	if (tableau[p]==tableau[p+1]) {
    		doublons++;
    		tDoubles.add(tableau[p]);
    	}		
	}
    System.out.println("Doublons : "+doublons);
    if (doublons!=0) {
	    for (int k=0;k<tDoubles.size();k++) {
	    	System.out.print(tDoubles.get(k)+" ");
		}
	    System.out.println("");
    }
    }

	private static void echanger(String[] t, int i, int j) {
		String temp = t[i];
		t[i]=t[j];
		t[j]=temp;
	}
	
	public void triDoublon(String[] tab) {
		triBulleOptimise(tab);
		for (int i=0;i<tab.length;i++) {
			System.out.print("\""+tab[i]+"\""+",");
		}
		System.out.println("");
	}
}
