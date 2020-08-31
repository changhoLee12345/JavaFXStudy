package hr.container.gridpane;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class GridPaneExample extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		GridPane root = new GridPane();
		root.setPrefWidth(300);
		root.setHgap(10);
		root.setVgap(10);
		root.setPadding(new Insets(10));

		Label lblId = new Label();
		lblId.setText("아이디");
		GridPane.setRowIndex(lblId, 0);
		GridPane.setColumnIndex(lblId, 0);

		TextField txtId = new TextField();
		GridPane.setRowIndex(txtId, 0);
		GridPane.setColumnIndex(txtId, 1);
		GridPane.setHgrow(txtId, Priority.ALWAYS);

		Label lblPasswd = new Label();
		lblPasswd.setText("패스워드");
		GridPane.setRowIndex(lblPasswd, 1);
		GridPane.setColumnIndex(lblPasswd, 0);

		TextField txtPasswd = new TextField();
		GridPane.setRowIndex(txtPasswd, 1);
		GridPane.setColumnIndex(txtPasswd, 1);
		GridPane.setHgrow(txtPasswd, Priority.ALWAYS);

		HBox hbox = new HBox();
		hbox.setAlignment(Pos.CENTER);
		hbox.setSpacing(20);
		GridPane.setRowIndex(hbox, 2);
		GridPane.setColumnIndex(hbox, 0);
		GridPane.setHgrow(hbox, Priority.ALWAYS);
		GridPane.setColumnSpan(hbox, 2);
		hbox.getChildren().add(new Button("로그인"));
		hbox.getChildren().add(new Button("취소"));

		root.getChildren().addAll(lblId, txtId, lblPasswd, txtPasswd, hbox);
		
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
