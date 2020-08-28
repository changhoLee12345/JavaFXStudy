package hr.eventHandlers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppMainFxml extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {

		String controlName = "BoardControl.fxml";
		Parent root = FXMLLoader.load(getClass().getResource(controlName));

		Scene scene = new Scene(root);

		primaryStage.setTitle(controlName);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
