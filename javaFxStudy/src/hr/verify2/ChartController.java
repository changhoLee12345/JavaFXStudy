package hr.verify2;

import java.net.URL;
import java.util.Arrays;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;

public class ChartController implements Initializable {
	@FXML
	BarChart<String, Number> barChart;
	@FXML
	Button style1, style2;
	@FXML
	CategoryAxis xAxis;

	// 카테고리의 레이블을 담을 자료 구조
	String[] cates = { "속도", "평점", "주행거리", "안정성" };

	// 시리즈를 담을 자료 구조
	XYChart.Series<String, Number> series = null; // 그래프의 값을 담을 series 변수
	private ObservableList<String> xLables = FXCollections.observableArrayList(); // 카테고리를 만들 xLables 배열 변수

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println("FXML 완");
		xLables.addAll(Arrays.asList(cates)); // 한번에 다 넣기, add로 하나씩 넣어도 됨
		xAxis.setCategories(xLables);

		style1.setOnAction(e -> style1());
		style2.setOnAction(e -> style2());
	}

	public void style1() { // 바 하나짜리 차트
		// 바 추가
		series = new XYChart.Series<String, Number>();
		// 기존 차트 초기화
		barChart.getData().clear();
		// 바의 이름 설정
		series.setName("자동차");
		// 데이터 생성
		for (int i = 0; i < cates.length; i++) {
			series.getData().add(new XYChart.Data<String, Number>(xLables.get(i), random()));
		}
		// 차트에 추가
		barChart.getData().add(series);
	}

	// 여러개의 바 추가
	public void style2() {
		// 시리즈를 여러개(4개) 생성
		barChart.getData().clear(); // 차트 초기화, 안하면 바가 계속 추가됨
		String[] names = { "코인", "떡락", "열차", "뿜붐" };
		for (int i = 0; i < names.length; i++) {
			// 시리즈를 여러개(4개) 생성
			series = new XYChart.Series<String, Number>();
			// 시리즈의 이름(4개) 생성
			series.setName(names[i]);
			// 시리즈별 데이터 생성(4개)
			for (int j = 0; j < cates.length; j++) {
				series.getData().add(new XYChart.Data<String, Number>(xLables.get(j), random()));
			}
			// 차트에 추가
			barChart.getData().add(series);
		}
	}

	// 임의의 값을 추출
	public int random() {
		Random rand = new Random();
		return rand.nextInt(9) + 1; // 1~100의 랜덤값
	}

}
