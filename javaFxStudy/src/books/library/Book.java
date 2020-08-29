package books.library;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Book {
	private SimpleStringProperty bookTitle;
	private SimpleStringProperty author;
	private SimpleStringProperty press;
	private SimpleStringProperty pressDate;
	private SimpleIntegerProperty price;
	private SimpleStringProperty isbn;
	private SimpleStringProperty creationDate;

	public void setBookTitle(String bookTitle) {
		this.bookTitle.set(bookTitle);
	}
	public String getBookTitle() {
		return this.bookTitle.get();
	}
	public SimpleStringProperty bookTitleProperty() {
		return bookTitle;
	}
	
	public void setAuthor(String author) {
		this.author.set(author);
	}
	public String getAuthor() {
		return this.author.get();
	}
	public SimpleStringProperty authorProperty() {
		return this.author;
	}
	
	public void setPress(String press) {
		this.press.set(press);
	}
	public String getPress() {
		return this.press.get();
	}
	public SimpleStringProperty pressProperty() {
		return this.press;
	}
	
	public void setPressDate(String pressDate) {
		this.pressDate.set(pressDate);
	}
	public String getPressDate() {
		return this.pressDate.get();
	}
	public SimpleStringProperty pressDateProperty() {
		return this.pressDate;
	}
	
	public void setPrice(Integer price) {
		this.price.set(price);
	}
	public Integer getPrice() {
		return this.price.get();
	}
	public SimpleIntegerProperty priceProperty() {
		return this.price;
	}
	
	public void setIsbn(String isbn) {
		this.isbn.set(isbn);
	}
	public String getIsbn() {
		return this.isbn.get();
	}
	public SimpleStringProperty isbnProperty() {
		return this.isbn;
	}

	public void setCreationDate(String creationDate) {
		this.isbn.set(creationDate);
	}
	public String getCreationDate() {
		return this.creationDate.get();
	}
	public SimpleStringProperty creationDateProperty() {
		return this.creationDate;
	}
}
