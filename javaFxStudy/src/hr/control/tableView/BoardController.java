package hr.control.tableView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class BoardController implements Initializable {
	@FXML
	TableView<Board> boardView;
	@FXML
	Button btnPrev, btnNext, btnAdd, btnClose;

	String selectedTitle = null;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		columnFetch();
		loadData();

		// 이벤트 처리.

		btnAdd.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				handleBtnAddAction(event);
			}

		});

		btnClose.setOnAction((e) -> Platform.exit());

		boardView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Board>() {

			@Override
			public void changed(ObservableValue<? extends Board> arg0, Board ov, Board nv) {
				selectedTitle = nv.getTitle();

			}

		});

		boardView.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent me) {
				if (me.getClickCount() == 2) {
					try {

						selectedTitle = boardView.getSelectionModel().getSelectedItem().getTitle();

						Stage stage = new Stage(StageStyle.DECORATED);
						stage.initModality(Modality.WINDOW_MODAL);
						stage.initOwner(btnAdd.getScene().getWindow());

//						AnchorPane updateAp = FXMLLoader.load(getClass().getResource("BoardUpdate.fxml"));
						FXMLLoader loader = new FXMLLoader(getClass().getResource("BoardUpdate.fxml"));
						AnchorPane updateAp = loader.load();

						BoardUpdateController controller = loader.getController();
						controller.setTitle(selectedTitle);

						Scene scene = new Scene(updateAp);
						stage.setScene(scene);
						stage.show();

					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}

		});

	} // end of initialize()

	public void columnFetch() {
		// 컬럼 맵핑
		TableColumn<Board, ?> col1 = new TableColumn<>("제목");
		col1.setCellValueFactory(new PropertyValueFactory<>("title"));
		col1.setStyle("-fx-alignment: CENTER; ");

		TableColumn<Board, ?> col2 = new TableColumn<>("공개여부");
		col2.setCellValueFactory(new PropertyValueFactory<>("publicity"));
		col2.setStyle("-fx-alignment: CENTER; ");

		TableColumn<Board, ?> col3 = new TableColumn<>("종료일자");
		col3.setCellValueFactory(new PropertyValueFactory<>("exitDate"));
		col3.setStyle("-fx-alignment: CENTER; ");

		TableColumn<Board, ?> col4 = new TableColumn<>("내용");
		col4.setCellValueFactory(new PropertyValueFactory<>("content"));
		col4.setStyle("-fx-alignment: CENTER; ");

		boardView.getColumns().addAll(col1, col2, col3, col4);
	}

	public void loadData() {
		// 리스트 매핑
		boardView.setItems(BoardDAO.getBoardList());

	}

	// 필드 필요한 것 받아오기.
	AnchorPane ap = null;
	Button btnReg, btnCancel;

	TextField txtTitle;
	PasswordField txtPassword;
	ComboBox<String> comboPublic;
	DatePicker dateExit;
	TextArea txtContent;

	public void intializeControl() {
		btnReg = (Button) ap.lookup("#btnReg");
		btnCancel = (Button) ap.lookup("#btnCancel");

		txtTitle = (TextField) ap.lookup("#txtTitle");
		txtPassword = (PasswordField) ap.lookup("#txtPassword");
		comboPublic = (ComboBox<String>) ap.lookup("#comboPublic");
		dateExit = (DatePicker) ap.lookup("#dateExit");
		txtContent = (TextArea) ap.lookup("#txtContent");

		txtTitle.setText("");
		txtPassword.setText("");
		comboPublic.setValue("");
		dateExit.setValue(null);
		txtContent.setText("");

		txtTitle.requestFocus();
	}

	public void handleBtnAddAction(MouseEvent event) {
		try {
			Stage stage = new Stage(StageStyle.DECORATED);
			stage.initModality(Modality.WINDOW_MODAL);
			stage.initOwner(btnAdd.getScene().getWindow());

			ap = FXMLLoader.load(getClass().getResource("BoardInput.fxml"));
			Scene scene = new Scene(ap);
			stage.setScene(scene);
			stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}

		intializeControl();

		btnReg.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Board board = new Board(txtTitle.getText(), txtPassword.getText(), comboPublic.getValue().toString(),
						dateExit.getValue().toString(), txtContent.getText());
				BoardDAO.insertBoard(board);

				showCustomDialog("입력됨.");
				intializeControl();
				loadData();
			}

		});

		btnCancel.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				intializeControl();
			}

		});

	} // end of handleBtnAddAction()

	public void showCustomDialog(String message) {

		Stage dialogStage = new Stage(StageStyle.UTILITY);
		dialogStage.initModality(Modality.WINDOW_MODAL);
		dialogStage.initOwner(btnAdd.getScene().getWindow());
		dialogStage.setTitle("확인");
		dialogStage.setResizable(false);

		AnchorPane ap = new AnchorPane();
		ap.setPrefSize(400, 150);

		ImageView imageView = new ImageView();
		imageView.setImage(new Image(getClass().getResource("../../images/dialog-info.png").toString()));
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

	} // end of showCustomDialog()

}
