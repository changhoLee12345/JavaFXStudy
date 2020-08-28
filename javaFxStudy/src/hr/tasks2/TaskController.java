package hr.tasks2;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class TaskController implements Initializable {
	@FXML
	private ProgressBar progressBar;
	@FXML
	private Label lblWorkDone, lblResult;
	@FXML
	private Button btnStart, btnStop;

	private Task<Integer> task;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnStart.setOnAction(e -> handleBtnStart(e));
		btnStop.setOnAction(e -> handleBtnStop(e));
	}

	public void handleBtnStart(ActionEvent e) {
		System.out.println("start btn");

		task = new Task<Integer>() {

			// call()
			@Override
			protected Integer call() throws Exception {
				System.out.println("calling");
				int result = 0;

				for (int i = 1; i <= 100; i++) {
					if (isCancelled()) {
						System.out.println("cancelled.");
						break;
					}
					result += i;
					updateProgress(i, 100);
					updateMessage(String.valueOf(i));

					try {
						Thread.sleep(100);
					} catch (Exception e) {
						System.out.println(e.getMessage());
						if (isCancelled()) {
							updateMessage("취소됨");
							break;
						}
					}
				}
				return result;
			} // end of call

			@Override
			protected void succeeded() {
				lblResult.setText(String.valueOf(getValue()));
			}

			@Override
			protected void cancelled() {
				lblResult.setText("취소됨");
			}

			@Override
			protected void failed() {
				lblResult.setText("실패");
			}

		};
		progressBar.progressProperty().bind(task.progressProperty());
		lblWorkDone.textProperty().bind(task.messageProperty());
		lblResult.setText("");

		Thread thread = new Thread(task);
		thread.setDaemon(true);
		System.out.println("before start");
		thread.start();
		System.out.println("after start");

	}

	public void handleBtnStop(ActionEvent e) {
		task.cancel();
	}
}
