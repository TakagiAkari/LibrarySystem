package ls.bean;

import java.io.Serializable;

public class LendingBean implements Serializable {

	private String bookId;
	private String bookName;
	private String userId;
	private String userName;

	public LendingBean() {}

	public LendingBean(String bookId, String bookName, String userId, String userName) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.userId = userId;
		this.userName = userName;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
