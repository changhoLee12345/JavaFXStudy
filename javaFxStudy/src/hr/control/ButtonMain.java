package hr.control;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ButtonMain extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/ButtonControl.fxml"));
		Parent root = loader.load();

//		InputController controller = loader.getController();
//		controller.setPrimaryStage(primaryStage);

		Scene scene = new Scene(root);

		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("ButtonControl");

	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
