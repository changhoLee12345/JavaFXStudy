package hr.verify2;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChartExercise extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		VBox root = new VBox();

		BarChart<String, Number> bChart = new BarChart(new CategoryAxis(), new NumberAxis());

		XYChart.Series<String, Number> ser1 = new XYChart.Series<String, Number>();
		ObservableList<XYChart.Data<String, Number>> observ = FXCollections.observableArrayList();
		observ.add(new XYChart.Data<>("국어", 15));
		observ.add(new XYChart.Data<>("영어", 25));
		observ.add(new XYChart.Data<>("수학", 35));
		ser1.setData(observ);
		ser1.setName("user1");

		XYChart.Series<String, Number> ser2 = new XYChart.Series<String, Number>();
		ObservableList<XYChart.Data<String, Number>> observ2 = FXCollections.observableArrayList();
		observ2.add(new XYChart.Data<>("국어", 15));
		observ2.add(new XYChart.Data<>("영어", 25));
		observ2.add(new XYChart.Data<>("수학", 35));

		ser2.setData(observ2);
		ser2.setName("user2");

		bChart.getData().addAll(ser1, ser2);

		root.getChildren().add(bChart);

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
