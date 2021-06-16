package ls.bean;

import java.sql.Date;

public class MemberBean {

	int user_id;
	String user_name;
	String address;
	String tel;
	String email;
	Date birth;
	Date enter_day;
	Date leave_day;

	public MemberBean() {}


	public MemberBean(int user_id, String user_name, String address, String tel, String email, Date birth,
			Date enter_day, Date leave_day) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.address = address;
		this.tel = tel;
		this.email = email;
		this.birth = birth;
		this.enter_day = enter_day;
		this.leave_day = leave_day;
	}


	public int getUser_id() {
		return user_id;
	}



	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}



	public String getUser_name() {
		return user_name;
	}



	public void setUser_name(String user_name) {
		this.user_name = user_name;
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

	public Date getEnter_day() {
		return enter_day;
	}

	public void setEnter_day(Date enter_day) {
		this.enter_day = enter_day;
	}

	public Date getLeave_day() {
		return leave_day;
	}

	public void setLeave_day(Date leave_day) {
		this.leave_day = leave_day;
	}


}

