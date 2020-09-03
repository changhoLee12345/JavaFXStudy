package hr.control.tableView;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class BoardUpdateController implements Initializable {
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
	Button btnUpdate;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				System.out.println("runlater" + selectedTitle);
				Board board = BoardDAO.getBoard(selectedTitle);
				txtTitle.setText(board.getTitle());
				txtPassword.setText(board.getPassword());
				comboPublic.setValue(board.getPublicity());
				int year = Integer.valueOf(board.getExitDate().substring(0, 4));
				int month = Integer.valueOf(board.getExitDate().substring(5, 7));
				int dayOfMonth = Integer.valueOf(board.getExitDate().substring(8, 10));
				System.out.println(year + "," + month + "," + dayOfMonth);
				LocalDate lDate = LocalDate.of(year, month, dayOfMonth);
				dateExit.setValue(lDate);
				txtContent.setText(board.getContent());
			}

		});
		btnUpdate.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
				Board board = new Board(txtTitle.getText(), txtPassword.getText(), comboPublic.getValue(),
						dateExit.getValue().format(formatter), txtContent.getText());
				BoardDAO.updateBoard(board);

				Platform.runLater(new Runnable() {

					@Override
					public void run() {

					}

				});
			}

		});
	}

	String selectedTitle = null;

	public void setTitle(String str) {
		selectedTitle = str;
		System.out.println(str);

	}

}