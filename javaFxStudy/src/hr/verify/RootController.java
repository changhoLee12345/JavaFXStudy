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
import javafx.scene.chart.Axis;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.ValueAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
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

		btnAdd.setOnAction(event -> handleBtnAddAction(event));
		btnBarChart.setOnAction(event -> handleBtnBarChartAction(event));

		list = FXCollections.observableArrayList();

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

		tableView.setItems(list);

		tableView.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				if (event.getClickCount() == 2) {
					AnchorPane ap = new AnchorPane();
					TextField tfName = new TextField();
					TextField tfKorean = new TextField();
					TextField tfMath = new TextField();
					TextField tfEnglish = new TextField();

					ap.getChildren().addAll(tfName, tfKorean, tfMath, tfEnglish);

				} else {
					return;
				}
			}

		});
	}

	private void handleBtnAddAction(ActionEvent event) {
		try {
			Stage dialog = new Stage(StageStyle.UTILITY);
			dialog.initModality(Modality.WINDOW_MODAL);
//			dialog.initOwner(btnAdd.getScene().getWindow());
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void handleBtnBarChartAction(ActionEvent e) {
		try {
			Stage dialog = new Stage(StageStyle.UTILITY);
			dialog.initModality(Modality.WINDOW_MODAL);
//			dialog.initOwner(btnAdd.getScene().getWindow());
			dialog.initOwner(primaryStage);

			dialog.setTitle("BarChart");

			Parent parent = FXMLLoader.load(getClass().getResource("BarChart.fxml"));

			BarChart<String, Integer> barChart = (BarChart) parent.lookup("#barChart");

			XYChart.Series<String, Integer> seriesKorean = new XYChart.Series<>();
			seriesKorean.setName("Korean");
			ObservableList<XYChart.Data<String, Integer>> koreanList = FXCollections.observableArrayList();
			for (int i = 0; i < list.size(); i++) {
				koreanList.add(new XYChart.Data<String, Integer>(list.get(i).getName(), list.get(i).getKorean()));
			}
			seriesKorean.setData(koreanList);
			barChart.getData().add(seriesKorean);

			XYChart.Series<String, Integer> seriesMath = new XYChart.Series<>();
			seriesMath.setName("Math");
			ObservableList<XYChart.Data<String, Integer>> mathList = FXCollections.observableArrayList();
			for (int i = 0; i < list.size(); i++) {
				mathList.add(new XYChart.Data<>(list.get(i).getName(), list.get(i).getMath()));
			}
			seriesMath.setData(mathList);
			barChart.getData().add(seriesMath);

			XYChart.Series<String, Integer> seriesEnglish = new XYChart.Series<>();
			seriesEnglish.setName("English");
			ObservableList<XYChart.Data<String, Integer>> englishList = FXCollections.observableArrayList();
			for (int i = 0; i < list.size(); i++) {
				englishList.add(new XYChart.Data<>(list.get(i).getName(), list.get(i).getEnglish()));
			}
			seriesEnglish.setData(englishList);
			barChart.getData().add(seriesEnglish);

			Button btnClose = (Button) parent.lookup("#btnClose");
			btnClose.setOnAction(evnt -> dialog.close());

			Scene scene = new Scene(parent);
			dialog.setScene(scene);
			dialog.show();

		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}
}
