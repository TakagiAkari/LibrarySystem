package ls.bean;

import java.io.Serializable;
import java.sql.Date;

public class LendingBean implements Serializable {

	private int lendId;
	private int bookId;
	private String bookName;
	private int userId;
	private String userName;
	private Date lendDay;
	private Date returnLimit;
	private Date returnDay;
	private String memo;

	public LendingBean() {}


	public LendingBean(int lendId, int bookId, String bookName, int userId, String userName, Date lendDay,
			Date returnLimit, Date returnDay, String memo) {
		super();
		this.lendId = lendId;
		this.bookId = bookId;
		this.bookName = bookName;
		this.userId = userId;
		this.userName = userName;
		this.lendDay = lendDay;
		this.returnLimit = returnLimit;
		this.returnDay = returnDay;
		this.memo = memo;
	}

	public LendingBean(int bookId, String bookName, int userId, String userName, Date lendDay, Date returnLimit,
			Date returnDay, String memo) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.userId = userId;
		this.userName = userName;
		this.lendDay = lendDay;
		this.returnLimit = returnLimit;
		this.returnDay = returnDay;
		this.memo = memo;
	}
	public LendingBean(int bookId, String bookName, int userId, String userName, Date lendDay, Date returnLimit,
			 String memo) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.userId = userId;
		this.userName = userName;
		this.lendDay = lendDay;
		this.returnLimit = returnLimit;
		this.memo = memo;
	}
	public LendingBean(int bookId, String bookName, int userId, String userName, Date lendDay, String memo) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.userId = userId;
		this.userName = userName;
		this.lendDay = lendDay;
		this.memo = memo;
	}
	public LendingBean(int lendId, int bookId, int userId, Date lendDay, Date returnLimit, Date returnDay, String memo) {
		super();
		this.lendId = lendId;
		this.bookId = bookId;
		this.userId = userId;
		this.lendDay = lendDay;
		this.returnLimit = returnLimit;
		this.returnDay = returnDay;
		this.memo = memo;
	}

	public LendingBean(int lendId, int bookId, int userId,  Date lendDay, Date returnLimit, String memo) {
		// DBからとってきた場合
		this.lendId = lendId;
		this.bookId = bookId;
		this.userId = userId;
		this.lendDay = lendDay;
		this.returnLimit = returnLimit;
		this.memo = memo;
	}


	public int getLendId() {
		return lendId;
	}


	public void setLendId(int lendId) {
		this.lendId = lendId;
	}


	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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
