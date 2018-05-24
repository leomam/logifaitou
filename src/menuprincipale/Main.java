package menuprincipale;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import gobalVariable.Global;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage = new MenuPrincipal();
			Global glob = Global.LOGOPATH;
			primaryStage.getIcons().add(new Image(glob.toString()));
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		launch(args);
	}
}
