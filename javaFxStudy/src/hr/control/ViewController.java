package hr.control;

import java.net.URL;
import java.util.ResourceBundle;

import hr.com.phone.Phone;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ViewController implements Initializable {
	@FXML
	private ListView<String> listView;
	@FXML
	private TableView<Phone> tableView;
	@FXML
	private ImageView imageView;
	@FXML
	private Button btnCancel;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		listView.setItems(
				FXCollections.observableArrayList("갤럭시S1", "갤럭시S2", "갤럭시S3", "갤럭시S4", "갤럭시S5", "갤럭시S6", "갤럭시S7"));

		listView.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				tableView.getSelectionModel().select(newValue.intValue());
				tableView.scrollTo(newValue.intValue());
			}

		});

		ObservableList<Phone> phoneList = FXCollections.observableArrayList(new Phone("갤럭시S1", "phone01.png"),
				new Phone("갤럭시S2", "phone02.png"), new Phone("갤럭시S3", "phone03.png"), new Phone("갤럭시S4", "phone04.png"),
				new Phone("갤럭시S5", "phone05.png"), new Phone("갤럭시S6", "phone06.png"));
		phoneList.add(new Phone("갤럭시S7", "phone07.png"));

		TableColumn<Phone, ?> tcSmartPhone = tableView.getColumns().get(0);
		tcSmartPhone.setCellValueFactory(new PropertyValueFactory<>("smartPhone"));
		tcSmartPhone.setStyle("-fx-alignment: CENTER;");

		TableColumn<Phone, ?> tcImage = tableView.getColumns().get(1);
		tcImage.setCellValueFactory(new PropertyValueFactory<>("image"));
		tcImage.setStyle("-fx-alignment: CENTER;");

		tableView.setItems(phoneList);

		// i) selectedItemProperty()
		tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Phone>() {

			@Override
			public void changed(ObservableValue<? extends Phone> observable, Phone oldValue, Phone newValue) {
				imageView.setImage(new Image(getClass().getResource("../images/" + newValue.getImage()).toString()));
			}

		});

		// ii) selectedIndexProperty()
//		tableView.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
//			TableColumn tcImage = tableView.getColumns().get(1);
//
//			@Override
//			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
//				imageView.setImage(new Image(getClass().getResource("../images/" + tcImage.getCellData(newValue.intValue())).toString()));
//				System.out.println(tcImage.getCellData(newValue.intValue()));
//			}
//
//		});

		imageView.setImage(new Image("/images/phone01.png"));

		btnCancel.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				handleBtnCancelAction(event);
			}
		});
	}

	public void handleBtnOkAction(ActionEvent event) {

	}

	public void handleBtnCancelAction(MouseEvent event) {
		Platform.exit();
	}
}
