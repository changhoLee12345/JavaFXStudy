package hr.verify;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppMain extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		Parent root = FXMLLoader.load(getClass().getResource("Root.fxml"));

//		FXMLLoader loader = new FXMLLoader(getClass().getResource("Root.fxml"));
//		BorderPane root = loader.load();

//		RootController controller = loader.getController();
//		controller.setPrimaryStage(primaryStage);

		Scene scene = new Scene(root);

		primaryStage.setScene(scene);
		primaryStage.setTitle("AppMain");
		primaryStage.setResizable(false);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
