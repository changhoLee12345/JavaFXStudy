package hr;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Book {
	SimpleStringProperty bookCode;
	SimpleStringProperty bookName;
	SimpleStringProperty bookAuthor;
	SimpleIntegerProperty bookPrice;
	SimpleIntegerProperty soldQty;
	
	public void setBookCode(String bookCode) {
		this.bookCode.set(bookCode);
	}
	public String getBookCode() {
		return this.bookCode.get();
	}
	public void setBookName(String bookName) {
		this.bookName.set(bookName);
	}
	public String getBookName() {
		return this.bookName.get();
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor.set(bookAuthor);
	}
	public String getBookAuthor() {
		return this.bookAuthor.get();
	}
	public void setBookPrice(int bookPrice) {
		this.bookPrice.set(bookPrice);
	}
	public int getBookPrice() {
		return this.bookPrice.get();
	}
	public void setSoldQty(int soldQty) {
		this.soldQty.set(soldQty);
	}
	public int getSoldQty() {
		return this.soldQty.get();
	}
	
}
