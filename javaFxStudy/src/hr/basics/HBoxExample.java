package hr.basics;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class HBoxExample extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		HBox hbox = new HBox();
		hbox.setPrefWidth(300);
		hbox.setPrefHeight(100);
		Label label = new Label();
		label.setText("이름");

		TextField tfName = new TextField();
		tfName.setText("이름 입력.");

		Button btnOk = new Button();
		btnOk.setText("확인");
		btnOk.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent ae) {
				Platform.exit();
			}
		});

		hbox.getChildren().add(label);
		hbox.getChildren().addAll(tfName, btnOk);

		Scene scene = new Scene(hbox);

		primaryStage.setScene(scene);
		primaryStage.setTitle("첫 프로그램");
		primaryStage.show();

	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
