package hr.container.tilepane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class TilePaneExample extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		TilePane root = new TilePane();
		root.setPrefTileHeight(100);
		root.setPrefTileWidth(100);

		ImageView[] iv = new ImageView[5];
		for (int i = 0; i < 5; i++) {
			iv[i] = new ImageView();
			iv[i].setImage(new Image("/hr/container/images/fruit" + (i + 1) + ".jpg"));
			root.getChildren().add(iv[i]);
		}
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
