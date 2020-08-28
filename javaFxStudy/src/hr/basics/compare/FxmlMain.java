package hr.basics.compare;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FxmlMain extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent parent = FXMLLoader.load(getClass().getResource("Root.fxml"));

		Scene scene = new Scene(parent);

		primaryStage.setScene(scene);
		primaryStage.setTitle("FXML 프로그램");
		primaryStage.show();

	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
