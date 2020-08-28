package hr.com.board;

public class Board {
	String title;
	String password;
	String publicity;
	String exitDate;
	String content;

	public Board(String title, String password, String publicity, String exitDate, String content) {
		super();
		this.title = title;
		this.password = password;
		this.publicity = publicity;
		this.exitDate = exitDate;
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public String getPassword() {
		return password;
	}

	public String getPublicity() {
		return publicity;
	}

	public String getExitDate() {
		return exitDate;
	}

	public String getContent() {
		return content;
	}

	@Override
	public String toString() {
		return "Board [title=" + title + ", password=" + password + ", publicity=" + publicity + ", exitDate="
				+ exitDate + ", content=" + content + "]";
	}

}
