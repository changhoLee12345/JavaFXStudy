package books.library.control;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class BookAddController implements Initializable {

	@FXML
	Button btnAdd;
	@FXML
	Button btnCancel;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnAdd.setOnAction((event) -> {
			handleButtonAction(event);
		});

		btnCancel.setOnAction((event) -> {
			handleButtonAction(event);
		});
	}

	public void handleButtonAction(ActionEvent event) {
		if (event.getSource() == btnAdd) {

		} else if (event.getSource() == btnCancel) {
			Stage stage = (Stage) btnCancel.getScene().getWindow();
			stage.close();

//			try {
//				Parent container = FXMLLoader.load(getClass().getResource("view/BookMain.fxml"));
//				Scene scene = new Scene(container);
//				stage.setScene(scene);
//				stage.show();
//
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
		}

	}

}
