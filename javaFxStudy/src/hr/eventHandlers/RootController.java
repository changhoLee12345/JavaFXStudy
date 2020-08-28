package hr.eventHandlers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class RootController implements Initializable {
	@FXML
	Button btnNew;
	@FXML
	Button btnOpen;
	@FXML
	Button btnSave;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		System.out.println(location);
		System.out.println(resources);

		btnNew.setGraphic(new ImageView(new Image("/icons/new.png")));
		btnOpen.setGraphic(new ImageView(new Image("/icons/open.png")));
		btnSave.setGraphic(new ImageView(new Image("/icons/save.png")));

		btnNew.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("New.. clicked.");

			}
		});

		btnOpen.setOnAction(event -> handleBtnOpenAction(event));
	}

	public void handleBtnOpenAction(ActionEvent event) {
		System.out.println("Open.. clicked.");
	}

	public void handleBtnSaveAction(ActionEvent event) {
		System.out.println("Save.. clicked.");
	}

}
