package hr.threads;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class RunController implements Initializable {
	@FXML
	Button btnStart, btnStop;
	@FXML
	Label lblTime;

	boolean stop = true;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		// setOnAction
		btnStart.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				handleBtnStart(event);
			}
		});

		// setOnAction
		btnStop.setOnAction(e -> handleBtnStop(e));
		
		btnStop.setDisable(true);
	}

	public void handleBtnStart(ActionEvent event) {
		stop = false;
		Thread thread = new Thread() {

			@Override
			public void run() {
				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
				while (!stop) {
					String strTime = sdf.format(new Date());

					Platform.runLater(new Runnable() {
						@Override
						public void run() {
							lblTime.setText(strTime);

						}
					});
					try {
						Thread.sleep(100);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		};
		thread.setDaemon(true);
		thread.start();
		btnStart.setDisable(true);
		btnStop.setDisable(false);
		
	} // end of handleBtnStart

	public void handleBtnStop(ActionEvent event) {
		stop = true;
		btnStart.setDisable(false);
		btnStop.setDisable(true);
	}
}
