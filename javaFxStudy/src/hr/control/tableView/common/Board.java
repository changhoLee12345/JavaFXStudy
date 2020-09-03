package hr.control.tableView.common;

import javafx.beans.property.SimpleStringProperty;

public class Board {
//	private SimpleStringProperty boardNo;
	private SimpleStringProperty title;
	private SimpleStringProperty password;
	private SimpleStringProperty publicity;
	private SimpleStringProperty exitDate;
	private SimpleStringProperty content;

	public Board(String boardNo, String title, String content) {
		super();
//		this.boardNo = new SimpleStringProperty(boardNo);
		this.title = new SimpleStringProperty(title);
		this.content = new SimpleStringProperty(content);
	}

	public Board(String title, String password, String publicity, String exitDate, String content) {
		this.title = new SimpleStringProperty(title);
		this.password = new SimpleStringProperty(password);
		this.publicity = new SimpleStringProperty(publicity);
		this.exitDate = new SimpleStringProperty(exitDate);
		this.content = new SimpleStringProperty(content);
	}

//	public String getBoardNo() {
//		return this.boardNo.get();
//	}
//
//	public void setBoardNo(String boardNo) {
//		this.boardNo.set(boardNo);
//	}
//
//	public SimpleStringProperty boardNoProperty() {
//		return this.boardNo;
//	}

	public String getTitle() {
		return title.get();
	}

	public void setTitle(String title) {
		this.title.set(title);
	}

	public SimpleStringProperty titleProperty() {
		return this.title;
	}

	public String getPassword() {
		return password.get();
	}

	public void setPassword(String password) {
		this.title.set(password);
	}

	public SimpleStringProperty passwordProperty() {
		return this.password;
	}

	public String getPublicity() {
		return publicity.get();
	}

	public void setPublicity(String publicity) {
		this.publicity.set(publicity);
	}

	public SimpleStringProperty publicityProperty() {
		return this.publicity;
	}

	public String getExitDate() {
		return exitDate.get();
	}

	public void setExitDate(String exitDate) {
		this.exitDate.set(exitDate);
	}

	public SimpleStringProperty exitDateProperty() {
		return this.exitDate;
	}

	public String getContent() {
		return content.get();
	}

	public void setContent(String content) {
		this.content.set(content);
	}

	public SimpleStringProperty contentProperty() {
		return this.content;
	}

}
