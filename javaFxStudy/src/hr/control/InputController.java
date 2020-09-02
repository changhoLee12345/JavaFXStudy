package hr.control;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.ResourceBundle;

import hr.common.board.Board;
import hr.common.board.BoardDAO;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class InputController implements Initializable {

	@FXML
	TextField txtTitle;
	@FXML
	PasswordField txtPassword;
	@FXML
	ComboBox<String> comboPublic;
	@FXML
	DatePicker dateExit;
	@FXML
	TextArea txtContent;
	@FXML
	Button btnCancel;
	@FXML
	Button btnReg;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnCancel.setOnAction(event -> handleBtnCancelAction(event));
		comboPublic.getItems().add("공개1");
		comboPublic.getItems().add("비공개1");
//		FXCollections.observableArrayList("공개1", "비공개1");
	}

//	Stage primaryStage;
//
//	public void setPrimaryStage(Stage primaryStage) {
//		this.primaryStage = primaryStage;
//	}

	public void handleBtnRegAction(ActionEvent event) {
		String title = txtTitle.getText();
		String password = txtPassword.getText();
		String strPublic = comboPublic.getValue();
		LocalDate localDate = dateExit.getValue();
		String content = txtContent.getText();

		if (title == null || title.equals("")) {
			showPopup("타이틀을 입력하세요.");

		} else if (password == null || password.equals("")) {
			showCustomDialog("비번을 입력하세요.");

		} else if (strPublic == null || strPublic.equals("")) {
			showPopup("공개여부를 입력하세요.");

		} else if (content == null || content.equals("")) {
			showPopup("내용을 입력하세요.");

		} else if (localDate == null) {
			showPopup("종료날짜를 입력하세요.");

		} else {

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			Board board = new Board(title, password, strPublic, localDate.format(formatter), content);
			System.out.println(board);

			BoardDAO dao = BoardDAO.getInstance();
			Map<String, String> resultMap = dao.insertBoard(board);
			if (resultMap.get("status").equals("success")) {
				showCustomDialog("입력성공");
				txtTitle.setText("");
				txtPassword.setText("");
				comboPublic.setValue("Public");
				dateExit.setValue(null);
				txtContent.setText(null);
			} else if (resultMap.get("status").equals("fail")) {
				showPopup("처리중 에러 발생");
			}
		}

	}

	public void handleBtnCancelAction(ActionEvent event) {
		Platform.exit();
	}

	public void showPopup(String message) {

		HBox hbox = new HBox();
		hbox.setAlignment(Pos.CENTER_LEFT);
		hbox.setStyle("-fx-background-color:black; -fx-background-radius: 20; ");
		ImageView imageView = new ImageView();
		imageView.setImage(new Image(getClass().getResource("../images/dialog-info.png").toString()));
		imageView.setFitHeight(30);
		imageView.setFitWidth(30);
		imageView.setPreserveRatio(true);

		Label label = new Label("label");
		label.setStyle("-fx-text-fill: white;");
		HBox.setMargin(label, new Insets(0, 5, 0, 5));
		label.setText(message);

		hbox.getChildren().add(imageView);
		hbox.getChildren().add(label);

		Popup popup = new Popup();
		popup.getContent().add(hbox);
		popup.setAutoHide(true);
//		Stage primaryStage = (Stage) btnReg.getScene().getWindow();
		popup.show(btnReg.getScene().getWindow());

	}

	public void showCustomDialog(String message) {

		Stage dialogStage = new Stage(StageStyle.UTILITY);
		dialogStage.initModality(Modality.WINDOW_MODAL);
		dialogStage.initOwner(btnReg.getScene().getWindow());
		dialogStage.setTitle("확인");
		dialogStage.setResizable(false);

		AnchorPane ap = new AnchorPane();
		ap.setPrefSize(400, 150);

		ImageView imageView = new ImageView();
		imageView.setImage(new Image(getClass().getResource("../images/dialog-info.png").toString()));
		imageView.setFitHeight(50);
		imageView.setFitWidth(50);
		imageView.setLayoutX(15);
		imageView.setLayoutY(15);
		imageView.setPreserveRatio(true);
		Button btnOk = new Button("확인");
		btnOk.setLayoutX(336);
		btnOk.setLayoutY(104);
		btnOk.setOnAction(event -> dialogStage.close());
		Label label = new Label(message);
		label.setLayoutX(87);
		label.setLayoutY(33);
		label.setPrefHeight(15);
		label.setPrefWidth(290);

		ap.getChildren().add(imageView);
		ap.getChildren().add(btnOk);
		ap.getChildren().add(label);

		Scene scene = new Scene(ap);

		dialogStage.setScene(scene);
		dialogStage.show();

	}
}
