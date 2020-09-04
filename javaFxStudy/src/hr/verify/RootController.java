package hr.verify;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class RootController implements Initializable {

	@FXML
	Button btnAdd;
	@FXML
	TableView<Student> tableView;
	@FXML
	Button btnBarChart;

	private Stage primaryStage;

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	private ObservableList<Student> list;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// 버튼 컨트롤.
		btnAdd.setOnAction(event -> handleBtnAddAction(event));
		btnBarChart.setOnAction(event -> handleBtnBarChartAction(event));

		// 테이블뷰 생성.
		String[] fields = { "name", "korean", "math", "english" };
		for (int i = 0; i < fields.length; i++) {
			TableColumn<Student, ?> tc = tableView.getColumns().get(i);
			tc.setCellValueFactory(new PropertyValueFactory<>(fields[i]));
			tc.setStyle("-fx-alignment:CENTER;");

		}

		list = FXCollections.observableArrayList();
		list.add(new Student("user1", 98, 78, 68));
		list.add(new Student("user2", 85, 68, 88));
		list.add(new Student("user3", 88, 59, 79));
		tableView.setItems(list);

		// 뷰에 더블클릭(새로운 창 생성.)
		tableView.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				if (event.getClickCount() == 2) {
					String userName = tableView.getSelectionModel().getSelectedItem().getName();
					handleDoubleClickAction(userName);

				} else {
					return;
				}
			}

		});
	}

	TextField tName = new TextField();
	TextField tKorean = new TextField();
	TextField tMath = new TextField();
	TextField tEnglish = new TextField();
	Button btnChange = new Button("수정");

	public void handleDoubleClickAction(String user) {

		Stage stage = new Stage(StageStyle.UTILITY);
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(primaryStage);

		AnchorPane ap = new AnchorPane();
		ap.setPrefSize(210, 230);
		tName.setEditable(false);
		Label lKorean, lMath, lEnglish;

		lKorean = new Label("국어");
		lKorean.setLayoutX(35);
		lKorean.setLayoutY(73);

		lMath = new Label("수학");
		lMath.setLayoutX(35);
		lMath.setLayoutY(99);

		lEnglish = new Label("영어");
		lEnglish.setLayoutX(35);
		lEnglish.setLayoutY(132);

		tName.setPrefWidth(110);
		tName.setLayoutX(72);
		tName.setLayoutY(30);

		tKorean.setPrefWidth(110);
		tMath.setPrefWidth(110);
		tEnglish.setPrefWidth(110);

		tKorean.setLayoutX(72);
		tMath.setLayoutX(72);
		tEnglish.setLayoutX(72);

		tKorean.setLayoutY(69);
		tMath.setLayoutY(95);
		tEnglish.setLayoutY(128);

		btnChange.setLayoutX(85);
		btnChange.setLayoutY(184);

		for (Student student : list) {
			if (student.getName().equals(user)) {
				tName.setText(user);
				tKorean.setText(String.valueOf(student.getKorean()));
				tMath.setText(String.valueOf(student.getMath()));
				tEnglish.setText(String.valueOf(student.getEnglish()));
				break;
			}
		}

		btnChange.setOnAction(e -> updateScoreAction(e));

		ap.getChildren().addAll(tName, tKorean, tMath, tEnglish, btnChange, lKorean, lMath, lEnglish);

		Scene scene = new Scene(ap);
		stage.setScene(scene);
		stage.show();

	}

	public void updateScoreAction(ActionEvent ae) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getName().equals(tName.getText())) {
				System.out.println(tName.getText());
				System.out.println(list.get(i).getName());
				Student student = new Student(tName.getText(), Integer.parseInt(tKorean.getText()),
						Integer.parseInt(tMath.getText()), Integer.parseInt(tEnglish.getText()));
				list.set(i, student);
			}
		}

		for (Student student : list) {
			System.out.println(student.getName() + "," + student.getKorean() + "," + student.getMath() + ","
					+ student.getEnglish());
		}
	}

	private void handleBtnAddAction(ActionEvent event) {
		try {
			Stage dialog = new Stage(StageStyle.UTILITY);
			dialog.initModality(Modality.WINDOW_MODAL);
			dialog.initOwner(primaryStage);
			dialog.setTitle("Add");

			Parent parent = FXMLLoader.load(getClass().getResource("AddForm.fxml"));

			Button btnFormAdd = (Button) parent.lookup("#btnFormAdd");
			btnFormAdd.setOnAction(evnt -> {
				TextField txtName = (TextField) parent.lookup("#txtName");
				TextField txtKorean = (TextField) parent.lookup("#txtKorean");
				TextField txtMath = (TextField) parent.lookup("#txtMath");
				TextField txtEnglish = (TextField) parent.lookup("#txtEnglish");

				Student student = new Student(txtName.getText(), Integer.parseInt(txtKorean.getText()),
						Integer.parseInt(txtMath.getText()), Integer.parseInt(txtEnglish.getText()));

				list.add(student);

				dialog.close();
			});

			Button btnFormCancel = (Button) parent.lookup("#btnFormCancel");
			btnFormCancel.setOnAction(evnt -> dialog.close());

			Scene scene = new Scene(parent);
			dialog.setScene(scene);
			dialog.setResizable(false);
			dialog.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void handleBtnBarChartAction(ActionEvent e) {
		try {
			Stage dialog = new Stage(StageStyle.UTILITY);
			dialog.initModality(Modality.WINDOW_MODAL);
			dialog.initOwner(primaryStage);

			dialog.setTitle("BarChart");

			BorderPane parent = FXMLLoader.load(getClass().getResource("BarChart.fxml"));

			BarChart<String, Integer> barChart1 = (BarChart) parent.lookup("#barChart");

			XYChart.Series<String, Integer> seriesKorean = new XYChart.Series<>();
			seriesKorean.setName("Korean");
			ObservableList<XYChart.Data<String, Integer>> koreanList = FXCollections.observableArrayList();
			for (int i = 0; i < list.size(); i++) {
				koreanList.add(new XYChart.Data<String, Integer>(list.get(i).getName(), list.get(i).getKorean()));
			}

			XYChart.Series<String, Integer> seriesMath = new XYChart.Series<>();
			seriesMath.setName("Math");
			ObservableList<XYChart.Data<String, Integer>> mathList = FXCollections.observableArrayList();
			for (int i = 0; i < list.size(); i++) {
				mathList.add(new XYChart.Data<>(list.get(i).getName(), list.get(i).getMath()));
			}

			XYChart.Series<String, Integer> seriesEnglish = new XYChart.Series<>();
			seriesEnglish.setName("English");
			ObservableList<XYChart.Data<String, Integer>> englishList = FXCollections.observableArrayList();
			for (int i = 0; i < list.size(); i++) {
				englishList.add(new XYChart.Data<>(list.get(i).getName(), list.get(i).getEnglish()));
			}
			seriesKorean.setData(koreanList);
			barChart1.getData().add(seriesKorean);
			seriesMath.setData(mathList);
			barChart1.getData().add(seriesMath);
			seriesEnglish.setData(englishList);
			barChart1.getData().add(seriesEnglish);

			Button btnClose = (Button) parent.lookup("#btnClose");
			btnClose.setOnAction(evnt -> dialog.close());

			// BarChart 사람이름 기준으로 시리즈 추가.
			HBox hbox = (HBox) parent.lookup("#hbox");

			BarChart<String, Number> barchart2 = new BarChart(new CategoryAxis(), new NumberAxis());
			barchart2.setPrefSize(300, 309);

			for (int i = 0; i < list.size(); i++) {

				XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();
				series.setName(list.get(i).getName());
				ObservableList<XYChart.Data<String, Number>> datas = FXCollections.observableArrayList();
				datas.add(new XYChart.Data<String, Number>("국어", list.get(i).getKorean()));
				datas.add(new XYChart.Data<String, Number>("수학", list.get(i).getMath()));
				datas.add(new XYChart.Data<String, Number>("영어", list.get(i).getEnglish()));
				series.setData(datas);
				barchart2.getData().add(series);

			}

			hbox.getChildren().add(barchart2);

			Scene scene = new Scene(parent);
			dialog.setScene(scene);
			dialog.show();

		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

	public void fetchColumn() {
		TableColumn<Student, ?> tc = tableView.getColumns().get(0);
		tc.setCellValueFactory(new PropertyValueFactory<>("name"));
		tc.setStyle("-fx-alignment:CENTER;");

		tc = tableView.getColumns().get(1);
		tc.setCellValueFactory(new PropertyValueFactory<>("korean"));
		tc.setStyle("-fx-alignment:CENTER;");

		tc = tableView.getColumns().get(2);
		tc.setCellValueFactory(new PropertyValueFactory<>("math"));
		tc.setStyle("-fx-alignment:CENTER;");

		tc = tableView.getColumns().get(3);
		tc.setCellValueFactory(new PropertyValueFactory<>("english"));
		tc.setStyle("-fx-alignment:CENTER;");

	}
}
