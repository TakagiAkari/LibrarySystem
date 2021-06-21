package ls.bean;

import java.io.Serializable;
import java.sql.Date;

public class MemberBean implements Serializable{

	private int userId;
	private String userName;
	private String address;
	private String tel;
	private String email;
	private Date birth;
	private Date enterDay;
	private Date leaveDay;

	public MemberBean() {}

	public MemberBean(int userId, String userName, String address, String tel, String email, Date birth, Date enterDay,
			Date leaveDay) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.address = address;
		this.tel = tel;
		this.email = email;
		this.birth = birth;
		this.enterDay = enterDay;
		this.leaveDay = leaveDay;
	}
	public MemberBean(int userId, String userName, String address, String tel, String email, Date birth, Date enterDay) {
		this.userId = userId;
		this.userName = userName;
		this.address = address;
		this.tel = tel;
		this.email = email;
		this.birth = birth;
		this.enterDay = enterDay;
	}
	public MemberBean(int userId, String userName, String address, String tel, String email, Date birth) {
		this.userId = userId;
		this.userName = userName;
		this.address = address;
		this.tel = tel;
		this.email = email;
		this.birth = birth;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public Date getEnterDay() {
		return enterDay;
	}

	public void setEnterDay(Date enterDay) {
		this.enterDay = enterDay;
	}

	public Date getLeaveDay() {
		return leaveDay;
	}

	public void setLeaveDay(Date leaveDay) {
		this.leaveDay = leaveDay;
	}


}

