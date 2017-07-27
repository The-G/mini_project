package proj.member.dto;

public class MemberVO {
	private String name;
	private String userid;
	private String pwd;
	private String nickname;
	private String email;
	private String phone;
	private String worstMovie;
	private int gender;
	private int receiveEmail;
	private int receiveSns;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getWorstMovie() {
		return worstMovie;
	}
	public void setWorstMovie(String worstMovie) {
		this.worstMovie = worstMovie;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public int getReceiveEmail() {
		return receiveEmail;
	}
	public void setReceiveEmail(int receiveEmail) {
		this.receiveEmail = receiveEmail;
	}
	public int getReceiveSns() {
		return receiveSns;
	}
	public void setReceiveSns(int receiveSns) {
		this.receiveSns = receiveSns;
	}
	@Override
	public String toString() {
		return "MemberVO [name=" + name + ", userid=" + userid + ", pwd=" + pwd + ", nickname=" + nickname + ", email="
				+ email + ", phone=" + phone + ", worstMovie=" + worstMovie + ", gender=" + gender + ", receiveEmail="
				+ receiveEmail + ", receiveSns=" + receiveSns + "]";
	}
	
	

}
