package ls.bean;

import java.io.Serializable;
import java.sql.Date;

public class ReturnBean implements Serializable {

	private int lendId;
	private int userId;
	private int bookId;
	private Date lendDay;
	private Date returnLimit;
	private Date returnDay;
	private String memo;



public ReturnBean() {}

public ReturnBean(int lendId, int userId, int bookId, Date lendDay, Date returnLimit, Date returnDay, String memo) {
	super();
	this.lendId = lendId;
	this.userId = userId;
	this.bookId = bookId;
	this.lendDay = lendDay;
	this.returnLimit = returnLimit;
	this.returnDay = returnDay;
	this.memo = memo;
}

	public int getLendId() {
		return lendId;
	}

	public void setLendId(int lendId) {
		this.lendId = lendId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public Date getlendDay() {
		return lendDay;
	}

	public void setlendDay(Date lendDay) {
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

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

}
