package hr.verify;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.Axis;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AppMain extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

//		Parent root = FXMLLoader.load(getClass().getResource("Root.fxml"));
//		FXMLLoader loader = new FXMLLoader(getClass().getResource("Root.fxml"));
//		Parent root = loader.load();
//		
//		RootController controller = loader.getController();
//		controller.setPrimaryStage(primaryStage);

		VBox root = new VBox();

		Axis<String> category = new CategoryAxis();
		Axis<Number> datas = new NumberAxis();

		BarChart<String, Integer> bc = new BarChart(category, datas);

		XYChart.Series<String, Integer> ser1 = new XYChart.Series<String, Integer>();
		ObservableList<XYChart.Data<String, Integer>> data1 = FXCollections.observableArrayList();
		data1.add(new XYChart.Data<>("국어", 10));
		data1.add(new XYChart.Data<>("영어", 20));
		data1.add(new XYChart.Data<>("수학", 30));
		ser1.setData(data1);
		ser1.setName("user1");

		XYChart.Series<String, Integer> ser2 = new XYChart.Series<String, Integer>();
		ObservableList<XYChart.Data<String, Integer>> data2 = FXCollections.observableArrayList();
		data2.add(new XYChart.Data<>("수학", 22));
		data2.add(new XYChart.Data<>("영어", 15));
		data2.add(new XYChart.Data<>("국어", 35));
		ser2.setData(data2);
		ser2.setName("user2");

		bc.getData().add(ser1);
		bc.getData().add(ser2);

		Button btnExit = new Button("종료");
		btnExit.setOnAction(e -> Platform.exit());

		root.setAlignment(Pos.CENTER);

		root.getChildren().addAll(bc, btnExit);

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
