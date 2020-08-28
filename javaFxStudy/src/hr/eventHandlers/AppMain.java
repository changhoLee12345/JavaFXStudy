package hr.eventHandlers;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class AppMain extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {

//		Parent root = FXMLLoader.load(getClass().getResource("Root.fxml"));

		HBox root = new HBox();
		root.setPrefSize(200, 50);
		root.setAlignment(Pos.CENTER);
		root.setSpacing(10);

		Button btn1 = new Button();
		btn1.setText("버튼1");
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("btn1 clicked.");
				System.out.println(event.getEventType().getName() + ", " + event.getTarget());
			}
		});

		btn1.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				System.out.println("mouse click");
			}
		});

		Button btn2 = new Button("버튼2");
		btn2.setOnAction(event -> System.out.println("btn2 clicked."));

		Label label = new Label("title");
		label.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				System.out.println(label.getText());
			}
		});
		root.getChildren().addAll(label, btn1, btn2);

		Scene scene = new Scene(root);

		primaryStage.setTitle("버튼 클릭 호출");
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent event) {
				System.out.println("close btn clicked.");
				System.out.println(event);

			}
		});

	}

	public static void main(String[] args) {
		launch(args);
	}
}
