package hr.control.list;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ListView.EditEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FxListViewExample4 extends Application {
	// Declaring the TextArea for Logging
	TextArea logging;

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		// Create the TextArea
		logging = new TextArea();
		logging.setMaxWidth(350);
		logging.setMaxHeight(350);

		// Create the Label
		Label fruitLbl = new Label("Select or Edit Fruits: ");

		// Create the List of Fruits
		ObservableList<String> fruitList = FXCollections.<String>observableArrayList("Apple", "Banana", "Orange",
				"Mango", "Lemon");

		// Create the ListView
		final ListView<String> fruits = new ListView<String>();
		// Add the Items to the ListView
		fruits.getItems().addAll(fruitList);
		// Set the size of the ListView
		fruits.setPrefSize(200, 120);
		// Make the ListView editable
		fruits.setEditable(true);
		// Add the CellFactory to the ListView
		fruits.setCellFactory(TextFieldListCell.forListView());
		// Select the first entry in the list
		fruits.getSelectionModel().selectLast();

		// Set editing related event handlers (OnEditStart)
		fruits.setOnEditStart(new EventHandler<ListView.EditEvent<String>>() {
			@Override
			public void handle(EditEvent<String> event) {
				editStart(event);
			}
		});

		// Set editing related event handlers (OnEditCommit)
		fruits.setOnEditCommit(new EventHandler<ListView.EditEvent<String>>() {
			@Override
			public void handle(EditEvent<String> event) {
				fruits.getItems().set(event.getIndex(), event.getNewValue());
				editCommit(event);
			}
		});

		// Set editing related event handlers (OnEditCancel)
		fruits.setOnEditCancel(new EventHandler<ListView.EditEvent<String>>() {
			@Override
			public void handle(EditEvent<String> event) {
				editCancel(event);
			}
		});

		// Create the Selection Box
		HBox selection = new HBox();
		// Set Spacing to 20 pixels
		selection.setSpacing(20);
		// Add the Label and the ListView to the HBox
		selection.getChildren().addAll(fruitLbl, fruits);

		// Create the VBox
		VBox root = new VBox();
		// Set Spacing to 10 pixels
		root.setSpacing(10);
		// Add the HBox and the TextArea to the VBox
		root.getChildren().addAll(selection, logging);

		// Set the Style-properties of the VBox
		root.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
				+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: blue;");

		// Create the Scene
		Scene scene = new Scene(root);
		// Add the Scene to the Stage
		stage.setScene(scene);
		// Set the Title
		stage.setTitle("A ListView Example with Edit Events");
		// Display the Stage
		stage.show();
	}

	// Helper Methods to display the Index and Value of the Item, which will be
	// edited

	public void editStart(ListView.EditEvent<String> e) {
		logging.appendText("Edit Start: Index=" + e.getIndex() + ", Item=" + e.getNewValue() + "\n");
	}

	public void editCommit(ListView.EditEvent<String> e) {
		logging.appendText("Edit Commit: Index=" + e.getIndex() + ", Item=" + e.getNewValue() + "\n");
	}

	public void editCancel(ListView.EditEvent<String> e) {
		logging.appendText("Edit Cancel: Index=" + e.getIndex() + ", Item=" + e.getNewValue() + "\n");
	}

}
