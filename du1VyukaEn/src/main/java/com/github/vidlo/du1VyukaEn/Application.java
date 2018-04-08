package com.github.vidlo.du1Vyuka;



import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * Trieda na spustenie aplikacie.
 *
 */
public class Application extends javafx.application.Application {

	/**
	 * Metoda spustenia
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length == 0) {
            launch(args);
		}
	}
	/**
	 * Predanie kontroleru
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass()
		          .getResource("gui.fxml"));
		Parent root = loader.load();

		Controller controller = loader.getController();
		controller.inicializuj();
		
        primaryStage.setTitle("Výuka");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
		
	}

}
