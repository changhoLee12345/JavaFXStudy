package hr.basics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AppMain extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		VBox root = new VBox();
		root.setPrefHeight(150);
		root.setPrefWidth(350);

		Label label = new Label();
		label.setText("Hello, JavaFX");

		Button button = new Button();
		button.setText("확인");

		root.getChildren().add(label);
		root.getChildren().add(button);

		Scene scene = new Scene(root);

		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
