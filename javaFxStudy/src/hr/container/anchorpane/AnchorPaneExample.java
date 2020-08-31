package hr.container.anchorpane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AnchorPaneExample extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		AnchorPane root = new AnchorPane();
		root.setPrefWidth(300);
		root.setPrefHeight(150);

		Label lblId = new Label();
		lblId.setLayoutX(42);
		lblId.setLayoutY(28);
		lblId.setText("아이디");

		Label lblPasswd = new Label();
		lblPasswd.setLayoutX(42);
		lblPasswd.setLayoutY(66);
		lblPasswd.setText("패스워드");

		TextField tfId = new TextField();
		tfId.setLayoutX(120);
		tfId.setLayoutY(24);

		PasswordField pfPasswd = new PasswordField();
		pfPasswd.setLayoutX(120);
		pfPasswd.setLayoutY(62);

		Button btnOk = new Button("로그인");
		btnOk.setLayoutX(97);
		btnOk.setLayoutY(106);

		Button btnCancel = new Button("취소");
		btnCancel.setLayoutY(106);
		btnCancel.setLayoutX(164);

		root.getChildren().addAll(lblId, lblPasswd, tfId, pfPasswd, btnOk, btnCancel);
		
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("AnchorPane Example");
		primaryStage.setResizable(false);
		
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
