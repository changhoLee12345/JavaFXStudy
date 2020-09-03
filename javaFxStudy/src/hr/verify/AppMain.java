package hr.verify;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.Axis;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class AppMain extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

//		Parent root = FXMLLoader.load(getClass().getResource("Root.fxml"));
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Root.fxml"));
		BorderPane root = loader.load();

		RootController controller = loader.getController();
		controller.setPrimaryStage(primaryStage);

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
