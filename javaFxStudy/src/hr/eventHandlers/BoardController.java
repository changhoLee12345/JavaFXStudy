package hr.eventHandlers;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

public class BoardController implements Initializable {

	@FXML
	TableView<Board> boardView;
	@FXML
	TextField txtTitle;
	@FXML
	ComboBox<String> comboPublic;
	@FXML
	TextField txtExitDate;
	@FXML
	TextArea txtContent;
	@FXML
	Button btnPrev, btnNext;

	Connection conn;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

//		TableColumn<Board, ?> colExists = boardView.getColumns().get(0);
//		colExists.setCellValueFactory(new PropertyValueFactory<>("boardNo"));
//		colExists.setStyle("-fx-alignment: CENTER;");
//
//		colExists = boardView.getColumns().get(1);
//		colExists.setCellValueFactory(new PropertyValueFactory<>("title"));
//		colExists.setStyle("-fx-alignment: CENTER;");

		TableColumn<Board, String> colBoardNo = new TableColumn<Board, String>("BoardNo");
//		colBoardNo.setCellValueFactory(new Callback<CellDataFeatures<Board, String>, ObservableValue<String>>() {
//			@Override
//			public ObservableValue<String> call(CellDataFeatures<Board, String> param) {
//				return param.getValue().boardNoProperty();
//			}
//		});
		colBoardNo.setCellValueFactory(new PropertyValueFactory<Board, String>("boardNo"));
		colBoardNo.setPrefWidth(60);
		boardView.getColumns().add(colBoardNo);

		TableColumn<Board, String> colTitle = new TableColumn<Board, String>("Title");
//		colTitle.setCellValueFactory(new Callback<CellDataFeatures<Board, String>, ObservableValue<String>>() {
//			@Override
//			public ObservableValue<String> call(CellDataFeatures<Board, String> param) {
//				return param.getValue().titleProperty();
//			}
//		});
		colTitle.setCellValueFactory(new PropertyValueFactory<Board, String>("title"));
		colTitle.setPrefWidth(60);
		boardView.getColumns().add(colTitle);

		TableColumn<Board, String> colContent = new TableColumn<Board, String>("Content");
		colContent.setCellValueFactory(new Callback<CellDataFeatures<Board, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Board, String> param) {
				System.out.println(param.getValue().contentProperty());
				return param.getValue().contentProperty();
			}
		});
//		colContent.setCellValueFactory(new PropertyValueFactory<Board, String>("content"));
		colContent.setPrefWidth(70);
		boardView.getColumns().add(colContent);

		colBoardNo.setStyle("-fx-alignment: CENTER; ");
		colTitle.setStyle("-fx-alignment: CENTER;");
		colContent.setStyle("-fx-alignment: CENTER;");

		ObservableList<Board> boardList = null;
//		boardList = getBoardList();
		boardList = FXCollections.observableArrayList(new Board("b1", "title1", "content1"),
				new Board("b2", "title2", "content2"), new Board("b3", "title3", "content3"),
				new Board("b4", "title4", "content4"), new Board("b5", "title5", "content5"));

		boardView.setItems(boardList);

		boardView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Board>() {
			@Override
			public void changed(ObservableValue<? extends Board> observable, Board oldValue, Board newValue) {
				txtTitle.setText(newValue.getTitle());
//				comboPublic.setValue(newValue.getPublicity());
//				txtExitDate.setText(newValue.getExitDate());
				txtContent.setText(newValue.getContent());
			}
		});

		btnPrev.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println(boardView.getSelectionModel().selectedIndexProperty().get());
				int prevIndex = boardView.getSelectionModel().selectedIndexProperty().get() - 1;
				boardView.getSelectionModel().select(prevIndex);
			}
		});

		btnNext.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println(boardView.getSelectionModel().selectedIndexProperty().get());
				int nextIndex = boardView.getSelectionModel().selectedIndexProperty().get() + 1;
				boardView.getSelectionModel().select(nextIndex);
			}
		});

	}

	public ObservableList<Board> getBoardList() {

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, "hr", "hr");
		} catch (Exception e) {
			e.printStackTrace();
		}

		String sql = "select * from board order by 1";
		ObservableList<Board> list = FXCollections.observableArrayList();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString("board_no"));
				System.out.println(rs.getString("title"));
				System.out.println(rs.getString("publicity"));
				System.out.println(rs.getString("exit_date"));
				System.out.println(rs.getString("content"));
				Board board = new Board(rs.getString("board_no"), rs.getString("title"), rs.getString("publicity"),
						rs.getString("exit_date"), rs.getString("content"));

				list.add(board);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;

	}

}
