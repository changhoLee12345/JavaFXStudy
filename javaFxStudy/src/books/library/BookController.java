package books.library;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class BookController implements Initializable {

	@FXML
	Button btnAdd;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		btnAdd.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				handleButtonAction();
			}
		});

	}

	public void handleButtonAction() {
		Stage stage = (Stage) btnAdd.getScene().getWindow();
		stage.close();

		try {
			Parent container = FXMLLoader.load(getClass().getResource("view/BookAdd.fxml"));
			Scene scene = new Scene(container);
			stage.setScene(scene);
			stage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
