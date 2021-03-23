package hr.eventHandlers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.util.Callback;

public class PhoneController implements Initializable {
	@FXML
	ListView<String> listView;
	@FXML
	TableView<Phone> tableView;
	@FXML
	ImageView imageView;
	@FXML
	Button btnCancelAction;
	@FXML
	TableColumn<Phone, String> col1;
	@FXML
	TableColumn<Phone, String> col2;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		ObservableList<String> list1 = FXCollections.observableArrayList("GalaxyS1", "GalaxyS2", "GalaxyS3", "GalaxyS4",
				"GalaxyS5", "GalaxyS6", "GalaxyS7");
		list1.clear();
		for (int i = 1; i <= 7; i++) {
			list1.add("GalaxyS" + i);
		}
		listView.setItems(FXCollections.observableArrayList());
		listView.setItems(list1);

		ObservableList<Phone> list2 = FXCollections.observableArrayList(//
				new Phone("GalaxyS1", "phone01.png"), //
				new Phone("GalaxyS2", "phone02.png"), //
				new Phone("GalaxyS3", "phone03.png"), //
				new Phone("GalaxyS4", "phone04.png"), //
				new Phone("GalaxyS5", "phone05.png"), //
				new Phone("GalaxyS6", "phone06.png"), //
				new Phone("GalaxyS7", "phone07.png") //
		);
		list2.clear();
		for (int i = 1; i <= 7; i++) {
			list2.add(new Phone("GalaxyS" + i, "phone0" + i + ".png"));
		}

		TableColumn<Phone, String> col1 = new TableColumn<Phone, String>("smartPhone");
//		col1.setCellValueFactory(new Callback<CellDataFeatures<Phone, String>, ObservableValue<String>>() {
//			@Override
//			public ObservableValue<String> call(CellDataFeatures<Phone, String> param) {
//				return param.getValue().smartPhoneProperty();
//			}
//		});
		col1.setCellValueFactory(new PropertyValueFactory<Phone, String>("smartPhone"));
		TableColumn<Phone, String> col2 = new TableColumn<Phone, String>("image");
//		col2.setCellValueFactory(new Callback<CellDataFeatures<Phone, String>, ObservableValue<String>>() {
//			@Override
//			public ObservableValue<String> call(CellDataFeatures<Phone, String> param) {
//				return param.getValue().imageProperty();
//			}
//		});
		col2.setCellValueFactory(new PropertyValueFactory<Phone, String>("image"));

		tableView.getColumns().add(col1);
		tableView.getColumns().add(col2);

		tableView.setItems(list2);

		btnCancelAction.setOnAction((ActionEvent event) -> Platform.exit());
	}

	public void btnOkAction(ActionEvent event) {
		System.out.println();
	}

}
