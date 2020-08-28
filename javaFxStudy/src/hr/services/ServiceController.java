package hr.services;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class ServiceController implements Initializable {
	@FXML
	private ProgressBar progressBar;
	@FXML
	private Label lblWorkDone, lblResult;
	@FXML
	private Button btnStart, btnStop;

	private TimeService timeService;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnStart.setOnAction(e -> handleBtnStart(e));
		btnStop.setOnAction(e -> handleBtnStop(e));

		timeService = new TimeService();
		timeService.start();
	}

	public void handleBtnStart(ActionEvent e) {
		timeService.restart();
		lblResult.setText("");
	}

	public void handleBtnStop(ActionEvent e) {
		timeService.cancel();
	}

	class TimeService extends Service<Integer> {

		@Override
		protected Task<Integer> createTask() {

			Task<Integer> task = new Task<Integer>() {

				@Override
				protected Integer call() throws Exception {
					int result = 0;
					for (int i = 0; i <= 100; i++) {
						if (isCancelled())
							break;
						result += i;
						updateProgress(i, 100);
						updateMessage(String.valueOf(i));

						try {
							Thread.sleep(100);
						} catch (Exception e) {
							if (isCancelled())
								break;
						}
					}
					return result;
				}

			};
			progressBar.progressProperty().bind(task.progressProperty());
			lblWorkDone.textProperty().bind(task.messageProperty());

			return task;
		} // end of createTask()

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

	} // end of TimeService class

} // end of ServiceController class
