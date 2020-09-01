package hr.control;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.Axis;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;

public class ChartController implements Initializable {

	@FXML
	private PieChart pieChart;
	@FXML
	private BarChart<String, Integer> barChart;
	@FXML
	private AreaChart<String, Integer> areaChart;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		pieChart.setData(FXCollections.observableArrayList( //
				new PieChart.Data("AWT", 10), new PieChart.Data("Swing", 30), //
				new PieChart.Data("SWT", 25), new PieChart.Data("JavaFX", 35))//
		);

		XYChart.Series<String, Integer> series1 = new XYChart.Series<>();
		series1.setName("Men");
		series1.setData(FXCollections.observableArrayList(getSeries1()));

		XYChart.Series<String, Integer> series2 = new XYChart.Series<>();
		series2.setName("Women");
		series2.setData(FXCollections.observableArrayList(getSeries2()));

		barChart.getData().add(series1);
		barChart.getData().add(series2);

		XYChart.Series<String, Integer> series3 = new XYChart.Series<>();
		series3.setName("Celsius");
		series3.setData(FXCollections.observableArrayList(getSeries3()));
		areaChart.getData().add(series3);

		XYChart.Series<String, Integer> series4 = new XYChart.Series<>();
		series4.setName("Covid19");
		series4.setData(FXCollections.observableArrayList(getSeries4()));
		areaChart.getData().add(series4);

	}

	public ObservableList<XYChart.Data<String, Integer>> getSeries1() {
		ObservableList<XYChart.Data<String, Integer>> series = FXCollections.observableArrayList();
		series.add(new XYChart.Data<String, Integer>("2015", 70));
		series.add(new XYChart.Data<String, Integer>("2016", 40));
		series.add(new XYChart.Data<String, Integer>("2017", 50));
		series.add(new XYChart.Data<String, Integer>("2018", 30));
		return series;
	}

	public ObservableList<XYChart.Data<String, Integer>> getSeries2() {
		ObservableList<XYChart.Data<String, Integer>> series = FXCollections.observableArrayList();
		series.add(new XYChart.Data<String, Integer>("2015", 30));
		series.add(new XYChart.Data<String, Integer>("2016", 60));
		series.add(new XYChart.Data<String, Integer>("2017", 50));
		series.add(new XYChart.Data<String, Integer>("2018", 80));
		return series;
	}

	public ObservableList<XYChart.Data<String, Integer>> getSeries3() {
		ObservableList<XYChart.Data<String, Integer>> series = FXCollections.observableArrayList();
		series.add(new XYChart.Data<String, Integer>("2015", 13));
		series.add(new XYChart.Data<String, Integer>("2016", 6));
		series.add(new XYChart.Data<String, Integer>("2017", 22));
		series.add(new XYChart.Data<String, Integer>("2018", 19));
		return series;
	}

	public ObservableList<XYChart.Data<String, Integer>> getSeries4() {
		ObservableList<XYChart.Data<String, Integer>> series = FXCollections.observableArrayList();
		series.add(new XYChart.Data<String, Integer>("2015", 25));
		series.add(new XYChart.Data<String, Integer>("2016", 45));
		series.add(new XYChart.Data<String, Integer>("2017", 29));
		series.add(new XYChart.Data<String, Integer>("2018", 43));
		return series;
	}
}
