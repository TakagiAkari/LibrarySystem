package ls.bean;

public class InputMemberBean {
	private String name;
	private String address;
	private String tel;
	private String email;
	private String birthY;
	private String birthM;
	private String birthD;


	public InputMemberBean() {}

	public InputMemberBean(String name, String address, String tel, String email, String birthY, String birthM, String birthD) {
		super();

		this.name = name;
		this.address = address;
		this.tel = tel;
		this.email = email;
		this.birthY = birthY;
		this.birthM = birthM;
		this.birthD = birthD;


	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getBirthY() {
		return birthY;
	}

	public void setBirthY(String birthY) {
		this.birthY = birthY;
	}

	public String getBirthM() {
		return birthM;
	}

	public void setBirthM(String birthM) {
		this.birthM = birthM;
	}

	public String getBirthD() {
		return birthD;
	}

	public void setBirthD(String birthD) {
		this.birthD = birthD;
	}


}
