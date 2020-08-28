package hr.control;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

public class SliderController implements Initializable {

	@FXML
	private ImageView imageView;
	@FXML
	private Button btnPlay, btnPause, btnStop;
	@FXML
	private MediaView mediaView;

	@FXML
	private Label labelTime;
	@FXML
	private Slider sliderVolume;
	@FXML
	private ProgressBar progressBar;
	@FXML
	private ProgressIndicator progressIndicator;

	private boolean endOfMedia;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		Media media1 = new Media(getClass().getResource("/medias/video.m4v").toString());
		Media media2 = new Media(getClass().getResource("/medias/video.mp4").toString());
		Media media3 = new Media(getClass().getResource("/medias/audio.wav").toString());
		Media media = media3;

		MediaPlayer mediaPlayer = new MediaPlayer(media);
		mediaView.setMediaPlayer(mediaPlayer);

		// setOnReady
		mediaPlayer.setOnReady(new Runnable() {
			@Override
			public void run() {
				btnPlay.setDisable(false);
				btnPause.setDisable(true);
				btnStop.setDisable(true);

				mediaPlayer.currentTimeProperty().addListener(new ChangeListener<Duration>() {
					@Override
					public void changed(ObservableValue<? extends Duration> observable, Duration oldValue,
							Duration newValue) {
						double progress = mediaPlayer.getCurrentTime().toSeconds()
								/ mediaPlayer.getTotalDuration().toSeconds();

						progressBar.setProgress(progress);
						progressIndicator.setProgress(progress);

						labelTime.setText((int) mediaPlayer.getCurrentTime().toSeconds() + "/"
								+ (int) mediaPlayer.getTotalDuration().toSeconds());
					}
				});
			}
		});

		// setOnPlaying
		mediaPlayer.setOnPlaying(new Runnable() {
			@Override
			public void run() {
				btnPlay.setDisable(true);
				btnPause.setDisable(false);
				btnStop.setDisable(false);
			}
		});

		// setOnPaused
		mediaPlayer.setOnPaused(new Runnable() {
			@Override
			public void run() {
				btnPlay.setDisable(false);
				btnPause.setDisable(true);
				btnStop.setDisable(false);
			}
		});

		// setOnEndOfMedia
		mediaPlayer.setOnEndOfMedia(new Runnable() {
			@Override
			public void run() {
				endOfMedia = true;

				btnPlay.setDisable(false);
				btnPause.setDisable(true);
				btnStop.setDisable(true);

				progressBar.setProgress(1.0);
				progressIndicator.setProgress(1.0);
			}
		});

		// setOnPaused
		mediaPlayer.setOnStopped(new Runnable() {
			@Override
			public void run() {
				btnPlay.setDisable(false);
				btnPause.setDisable(true);
				btnStop.setDisable(true);
			}
		});

		// setOnAction
		btnPlay.setOnAction(event -> {
			if (endOfMedia) {
				mediaPlayer.stop();
				mediaPlayer.seek(mediaPlayer.getStartTime());
			}
			mediaPlayer.play();
			endOfMedia = false;
		});

		// setOnAction(btnPause)
		btnPause.setOnAction(event -> mediaPlayer.pause());

		// setOnAction(btnStop)
		btnStop.setOnAction(event -> mediaPlayer.stop());

		// setting volume
		sliderVolume.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				mediaPlayer.setVolume(sliderVolume.getValue() / 100.0);
			}
		});
		sliderVolume.setValue(50);

	}
}
