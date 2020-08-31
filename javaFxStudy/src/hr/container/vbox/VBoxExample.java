package hr.container.vbox;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VBoxExample extends Application {
	int loc = 2;

	@Override
	public void start(Stage primaryStage) throws Exception {
		VBox root = new VBox();
		root.setPadding(new Insets(10, 10, 10, 10));

		ImageView iv = new ImageView();
		iv.setFitWidth(200);
		iv.setPreserveRatio(true);
		iv.setImage(new Image("/hr/container/images/fruit1.jpg"));

		HBox hbox = new HBox();
		hbox.setAlignment(Pos.CENTER);
		hbox.setSpacing(20);
		Button btnPrev = new Button("이전");
		btnPrev.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (loc == 0)
					loc = 6;
				iv.setImage(new Image("/hr/container/images/fruit" + --loc + ".jpg"));
				
			}
		});
		Button btnNext = new Button("다음");
		btnNext.setOnAction(new EventHandler<ActionEvent>() {

//			int loc = 2;
			@Override
			public void handle(ActionEvent ae) {
				String[] jpgs = { "fruit1", "fruit2", "fruit3", "fruit4", "fruit5" };
				if (loc == 6)
					loc = 0;
				iv.setImage(new Image("/hr/container/images/fruit" + ++loc + ".jpg"));
			}
		});
		HBox.setHgrow(btnNext, Priority.ALWAYS);
		btnNext.setMaxWidth(Double.MAX_VALUE);
		hbox.getChildren().addAll(btnPrev, btnNext);

		VBox.setMargin(hbox, new Insets(10));

		root.getChildren().addAll(iv, hbox);

		Scene scene = new Scene(root);

		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setResizable(false);

	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
