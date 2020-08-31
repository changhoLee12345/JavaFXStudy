package hr.control;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class ButtonController implements Initializable {

	@FXML
	private CheckBox chk1;
	@FXML
	private CheckBox chk2;
	@FXML
	private ImageView checkImageView;
	@FXML
	private ToggleGroup group;
	@FXML
	private ImageView radioImageView;
	@FXML
	private Button btnExit;
	@FXML
	private RadioButton rad1;
	@FXML
	private RadioButton rad2;
	@FXML
	private RadioButton rad3;
	@FXML
	private VBox vbox;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			@Override
			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
				System.out.println(observable.getValue().toString());
				String url = this.getClass().getResource("../images/" + newValue.getUserData().toString() + ".png")
						.toString();
				radioImageView.setImage(new Image(url));
			}
		});

		rad1.setOnMouseClicked(event -> System.out.println(rad1.getUserData().toString()));
		rad2.setOnMouseClicked(event -> System.out.println("rad2 clicked."));
		rad3.setOnMouseClicked(event -> System.out.println("rad3 clicked."));

//		btnExit.setOnAction((event) -> Platform.exit());
		btnExit.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent me) {
//				btnExit.setStyle("-fx-background-color: yellow;");
				btnExit.setUserData("hhh");
			}
		});
		btnExit.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				System.out.println(btnExit.getUserData());
			}

		});
		btnExit.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent me) {
				Platform.exit();
			}

		});

		chk1.setSelected(true);
		chk2.setSelected(true);
		handleChkAction(new ActionEvent());

		BorderPane.setMargin(btnExit, new Insets(20, 0, 0, 0));
		BorderPane.setAlignment(btnExit, Pos.CENTER);

		vbox.setSpacing(20);
		vbox.setAlignment(Pos.CENTER_LEFT);

		chk2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				handleChkAction(event);
			}
		});
	}

	public void handleChkAction(ActionEvent event) {
		System.out.println(event);
		String image = null;
		if (chk1.isSelected() && chk2.isSelected()) {
			image = "geek-glasses-hair.gif";
		} else if (chk1.isSelected()) {
			image = "geek-glasses.gif";
		} else if (chk2.isSelected()) {
			image = "geek-hair.gif";
		} else {
			image = "geek.gif";
		}
		checkImageView.setImage(new Image(getClass().getResource("../images/" + image).toString()));
	}

}
