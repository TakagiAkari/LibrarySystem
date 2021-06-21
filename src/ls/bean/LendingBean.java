package ls.bean;

import java.io.Serializable;

public class LendingBean implements Serializable {

	private String memo;
	private String bookId;
	private String bookName;
	private String userId;
	private String userName;
	private int userIdInt;
	private int bookIdInt;

	public LendingBean() {}

	public LendingBean(String memo, String bookId, String bookName, String userId, String userName, int userIdInt, int bookIdInt) {
		super();
		this.memo = memo;
		this.bookId = bookId;
		this.bookName = bookName;
		this.userId = userId;
		this.userName = userName;
		this.userIdInt = userIdInt;
		this.bookIdInt = bookIdInt;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
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

	public int getUserIdInt() {
		return userIdInt;
	}

	public void setUserIdInt(int userIdInt) {
		this.userIdInt = userIdInt;
	}

	public int getBookIdInt() {
		return bookIdInt;
	}

	public void setBookIdInt(int bookIdInt) {
		this.bookIdInt = bookIdInt;
	}
}
