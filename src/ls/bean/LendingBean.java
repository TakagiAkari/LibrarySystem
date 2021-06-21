package ls.bean;

import java.io.Serializable;
import java.sql.Date;

public class LendingBean implements Serializable {

	private String memo;
	private String bookId;
	private String bookName;
	private String userId;
	private String userName;
	private int userIdInt;
	private int bookIdInt;
	private Date lendDay;
	private Date returnLimit;
	private Date returnDay;

	public LendingBean() {}

	public LendingBean(String memo, String bookId, String bookName, String userId, String userName, int userIdInt,
			int bookIdInt, Date lendDay, Date returnLimit, Date returnDay) {
		super();
		this.memo = memo;
		this.bookId = bookId;
		this.bookName = bookName;
		this.userId = userId;
		this.userName = userName;
		this.userIdInt = userIdInt;
		this.bookIdInt = bookIdInt;
		this.lendDay = lendDay;
		this.returnLimit = returnLimit;
		this.returnDay = returnDay;
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


	public Date getLendDay() {
		return lendDay;
	}

	public void setLendDay(Date lendDay) {
		this.lendDay = lendDay;
	}

	public Date getReturnLimit() {
		return returnLimit;
	}

	public void setReturnLimit(Date returnLimit) {
		this.returnLimit = returnLimit;
	}

	public Date getReturnDay() {
		return returnDay;
	}

	public void setReturnDay(Date returnDay) {
		this.returnDay = returnDay;
	}


}
