package hr.basics.compare;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class AppMain extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		HBox hbox = new HBox();
		hbox.setPadding(new Insets(10,10,10,10));
		hbox.setSpacing(10);
		
		TextField tf = new TextField();
		tf.setPrefWidth(200);
		
		Button btn = new Button();
		btn.setText("확인");
		
		hbox.getChildren().addAll(tf, btn);
		
		Scene scene = new Scene(hbox);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("첫 프로그램");
		primaryStage.show();

	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
