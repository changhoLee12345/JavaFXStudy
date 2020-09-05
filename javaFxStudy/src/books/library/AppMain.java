package books.library;

import books.library.control.BookController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppMain extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
//		Parent root = FXMLLoader.load(getClass().getResource("view/BookMain.fxml"));
		FXMLLoader loader = new FXMLLoader(getClass().getResource("view/BookMain.fxml"));
		Parent root = loader.load();

		BookController controller = loader.getController();
		controller.setPrimaryStage(primaryStage);

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
