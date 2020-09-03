package hr.verify2;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ChartExercise extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		URL url = new URL("file:///d:/git/changhoLee12345/JavaFXStudy/javaFxStudy/src/hr/verify2/Chart.fxml");// 절대경로
		url = this.getClass().getResource("Chart.fxml");// 상대경로

		Parent root = FXMLLoader.load(url);

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
