package books.library.control;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import books.library.Book;
import books.library.db.BookDAO;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;

public class BookController implements Initializable {

	@FXML
	Button btnAdd, btnPrev, btnNext;
	@FXML
	TableView<Book> tableView;

	private Stage primaryStage;

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		// 추가버튼
		btnAdd.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				handleButtonAction(event);
			}
		});

		// prev, next 버튼
		btnPrev.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				handleButtonAction(event);
			}
		});
		btnNext.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				handleButtonAction(event);
			}
		});

		tableView.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if (event.getClickCount() == 2) {
					handleMouseClickAction(event);
				}
			}

		});

		// 칼럼 지정.
		fetchColumn();

		// 리스트 출력
		loadData();

	}

	public void handleMouseClickAction(MouseEvent me) {
		Book book = tableView.getSelectionModel().getSelectedItem();
		
	}

	// 버튼 컨트롤 (추가, prev, next)
	public void handleButtonAction(ActionEvent ae) {
		Button btn = (Button) ae.getTarget();
		System.out.println(btn.getId());

		if (btn.getId().equals("btnAdd")) {
			Stage stage = new Stage(StageStyle.DECORATED);
			stage.initModality(Modality.WINDOW_MODAL);
//			Stage primaryStage = (Stage) btnAdd.getScene().getWindow();
			stage.initOwner(primaryStage);

			try {
				ap = FXMLLoader.load(getClass().getResource("../view/BookAdd.fxml"));
				Scene scene = new Scene(ap);
				stage.setScene(scene);
				stage.show();

				initController();

				btnNew.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						btnNewActionEvent();
						loadData();
						stage.close();
					}

				});

				btnCancel.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {

					}
				});

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// 컨트롤러 생성.
	AnchorPane ap;
	TextField txtBookTitle, txtAuthor, txtPress, txtPressDate, txtPrice, txtIsbn;
	Label lblBookTitle, lblAuthor, lblPress, lblPressDate, lblPrice, lblIsbn;
	Button btnNew, btnCancel;

	// 추가화면 컨트롤러 초기화.
	public void initController() {
		txtBookTitle = (TextField) ap.lookup("#txtBookTitle");
		txtAuthor = (TextField) ap.lookup("#txtAuthor");
		txtPress = (TextField) ap.lookup("#txtPress");
		txtPressDate = (TextField) ap.lookup("#txtPressDate");
		txtPrice = (TextField) ap.lookup("#txtPrice");
		txtIsbn = (TextField) ap.lookup("#txtIsbn");
		btnNew = (Button) ap.lookup("#btnAdd");
		btnCancel = (Button) ap.lookup("#btnCancel");
		lblBookTitle = (Label) ap.lookup("#lblBookTitle");
		lblAuthor = (Label) ap.lookup("#lblAuthor");
		lblPress = (Label) ap.lookup("#lblPress");
		lblPressDate = (Label) ap.lookup("#lblPressDate");
		lblPrice = (Label) ap.lookup("#lblPrice");
		lblIsbn = (Label) ap.lookup("#lblIsbn");

		// layout setting.
		Object[] txts = { txtBookTitle, txtAuthor, txtPress, txtPressDate, txtPrice, txtIsbn };
		int xPos = 90, yPos = 64, yHeight = 35;
		for (int i = 0; i < txts.length; i++) {
			((TextField) txts[i]).setLayoutX(xPos);
			((TextField) txts[i]).setLayoutY(yPos);
			yPos += yHeight;
		}
		int aPos = 23, bPos = 68, bHeight = 35;
		Object[] lbls = { lblBookTitle, lblAuthor, lblPress, lblPressDate, lblPrice, lblIsbn };
		for (int i = 0; i < lbls.length; i++) {
			((Label) lbls[i]).setLayoutX(aPos);
			((Label) lbls[i]).setLayoutY(bPos);
			bPos += bHeight;
		}

	}

	public void btnNewActionEvent() {
		System.out.println(txtBookTitle.getText());
		Book book = new Book(txtBookTitle.getText(), txtAuthor.getText(), txtPress.getText(), txtPressDate.getText(),
				Integer.parseInt(txtPrice.getText()), txtIsbn.getText());
		BookDAO.insertBook(book);

	}

	public void loadData() {
		tableView.setItems(BookDAO.getBookList());
	}

	public void fetchColumn() {
		TableColumn<Book, String> col1 = new TableColumn<>("책제목");
		col1.setCellValueFactory(new Callback<CellDataFeatures<Book, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Book, String> param) {
				return param.getValue().bookTitleProperty();
			}

		});
		col1.setPrefWidth(110);
		TableColumn<Book, String> col2 = new TableColumn<>("저자");
		col2.setCellValueFactory(new Callback<CellDataFeatures<Book, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Book, String> param) {
				return param.getValue().authorProperty();
			}

		});
		col2.setPrefWidth(60);
		TableColumn<Book, String> col3 = new TableColumn<>("출판사");
		col3.setCellValueFactory(new Callback<CellDataFeatures<Book, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Book, String> param) {
				return param.getValue().pressProperty();
			}

		});
		col3.setPrefWidth(90);
		TableColumn<Book, String> col4 = new TableColumn<>("출판일자");
		col4.setCellValueFactory(new Callback<CellDataFeatures<Book, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Book, String> param) {
				return param.getValue().pressDateProperty();
			}

		});
		col4.setPrefWidth(88);

		tableView.getColumns().addAll(col1, col2, col3, col4);

	}

}
