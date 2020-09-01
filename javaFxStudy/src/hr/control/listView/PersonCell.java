package hr.control.listView;

import javafx.scene.control.ListCell;

public class PersonCell extends ListCell<Person> {
	@Override
	public void updateItem(Person item, boolean empty) {
		super.updateItem(item, empty);

		int index = this.getIndex();
		String name = null;

		// Format name
		if (item == null || empty) {
		} else {
			name = (index + 1) + ". " + item.getLastName() + ", " + item.getFirstName();
		}

		this.setText(name);
		setGraphic(null);
	}
}
