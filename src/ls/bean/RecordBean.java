package ls.bean;

import java.io.Serializable;
import java.sql.Date;

public class RecordBean implements Serializable {

	int bookId;
	int isbn;
	Date stockDay;
	Date throwoutDay;
	String memo;

	public RecordBean() {}

	public RecordBean(int bookId, int isbn, Date stockDay, Date throwoutDay, String memo) {
		super();
		this.bookId = bookId;
		this.isbn = isbn;
		this.stockDay = stockDay;
		this.throwoutDay = throwoutDay;
		this.memo = memo;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public Date getStockDay() {
		return stockDay;
	}

	public void setStockDay(Date stockDay) {
		this.stockDay = stockDay;
	}

	public Date getThrowoutDay() {
		return throwoutDay;
	}

	public void setThrowoutDay(Date throwoutDay) {
		this.throwoutDay = throwoutDay;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}




}
