package team.DB;

import java.util.Date;

public class CilentVO {
	private int clientIdx;
	private String clientName;
	private String id;
	private String pw;
	private String phoneNum;
	private Date regDate;
	private int coupon;
	
	
	
	public int getCilentIdx() {
		return clientIdx;
	}
	public void setCilentIdx(int cilentIdx) {
		this.clientIdx = cilentIdx;
	}
	public String getName() {
		return clientName;
	}
	public void setName(String name) {
		this.clientName = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getCoupon() {
		return coupon;
	}
	public void setCoupon(int coupon) {
		this.coupon = coupon;
	}
	
	
}

