package hr.eventHandlers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.text.Font;

public class BindingController implements Initializable {
	@FXML
	Label label;
	@FXML
	Slider slider;
	@FXML
	TextArea textArea1;
	@FXML
	TextArea textArea2;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		slider.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				label.setFont(new Font(newValue.doubleValue()));
			}
		});

		Bindings.bindBidirectional(textArea1.textProperty(), textArea2.textProperty());

	}
}
