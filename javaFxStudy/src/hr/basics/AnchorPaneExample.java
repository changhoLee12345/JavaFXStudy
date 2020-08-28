package hr.basics;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AnchorPaneExample extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		// 컨테이너
		AnchorPane ap = new AnchorPane();
		ap.setPrefHeight(150);
		ap.setPrefWidth(300);

		// 컨트롤
		Label lblId = new Label("아이디");
		lblId.setLayoutX(42);
		lblId.setLayoutY(28);

		Label lblPw = new Label("패스워드");
		lblPw.setLayoutX(42);
		lblPw.setLayoutY(66);

		TextField tfId = new TextField();
		tfId.setLayoutX(120);
		tfId.setLayoutY(24);

		Button btnOk = new Button("로그인");
		btnOk.setLayoutX(97);
		btnOk.setLayoutY(106);
		btnOk.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Platform.exit();
			}
		});

		Button btnCancel = new Button("취소");
		btnCancel.setLayoutX(164);
		btnCancel.setLayoutY(106);

		ap.getChildren().addAll(lblId, lblPw, tfId, btnOk, btnCancel);

		// scene에 담기.
		Scene scene = new Scene(ap);

		stage.setScene(scene);
		stage.show();
		stage.setTitle("프로그램 시작");
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
