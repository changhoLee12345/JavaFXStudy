package hr.control.tableView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				// 리스트 매핑
				boardView.setItems(BoardDAO.getBoardList());

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

		});

		// 이벤트 처리.

		btnAdd.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				handleBtnAddAction(event);
			}
		});

		btnClose.setOnAction((e) -> Platform.exit());

	}

	// 필드 필요한 것 받아오기.
	AnchorPane ap;

	public void handleBtnAddAction(MouseEvent event) {
		try {
			Stage stage = new Stage(StageStyle.DECORATED);
			stage.initModality(Modality.WINDOW_MODAL);
			stage.initOwner(btnAdd.getScene().getWindow());

			AnchorPane ap = FXMLLoader.load(getClass().getResource("InputControl.fxml"));
			Scene scene = new Scene(ap);
			stage.setScene(scene);
			stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}

		// 입력화면 관련.
		Button btnReg = (Button) ap.lookup("#btnReg");
		btnReg.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

			}

		});

	}

}
