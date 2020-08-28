package hr.control;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class MediaController implements Initializable {

	@FXML
	private ImageView imageView;
	@FXML
	private Button btnPlay, btnPause, btnStop;
	@FXML
	private MediaView mediaView;

	private boolean endOfMedia;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

//		Media media = new Media(getClass().getResource("/medias/video.m4v").toString());
		Media media = new Media(getClass().getResource("/medias/audio.wav").toString());

		MediaPlayer mediaPlayer = new MediaPlayer(media);
		mediaView.setMediaPlayer(mediaPlayer);

		mediaPlayer.setOnReady(new Runnable() {
			@Override
			public void run() {
				btnPlay.setDisable(false);
				btnPause.setDisable(true);
				btnStop.setDisable(true);

//				if (mediaPlayer.isAutoPlay()) {
//					mediaView.setVisible(false);
//				}
			}
		});

		mediaPlayer.setOnPlaying(new Runnable() {
			@Override
			public void run() {
				btnPlay.setDisable(true);
				btnPause.setDisable(false);
				btnStop.setDisable(false);
			}
		});

		mediaPlayer.setOnPaused(new Runnable() {
			@Override
			public void run() {
				btnPlay.setDisable(false);
				btnPause.setDisable(true);
				btnStop.setDisable(false);
			}
		});

		mediaPlayer.setOnEndOfMedia(new Runnable() {
			@Override
			public void run() {
				endOfMedia = true;

				btnPlay.setDisable(false);
				btnPause.setDisable(true);
				btnStop.setDisable(true);
			}
		});

		mediaPlayer.setOnStopped(new Runnable() {
			@Override
			public void run() {
				btnPlay.setDisable(false);
				btnPause.setDisable(true);
				btnStop.setDisable(true);
			}
		});

		btnPlay.setOnAction(event -> {
			if (endOfMedia) {
				mediaPlayer.stop();
				mediaPlayer.seek(mediaPlayer.getStartTime());
			}
			mediaPlayer.play();
			endOfMedia = false;
		});

		btnPause.setOnAction(event -> mediaPlayer.pause());
		btnStop.setOnAction(event -> mediaPlayer.stop());

	}

}
