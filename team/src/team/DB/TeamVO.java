package team.DB;

public class TeamVO {
	private int idx,menuPrice,coupon,meunIdx;
	private String menuName,clientID,clientName,password,phoneNumber,memo;
	//clientID coupon meunIdx menuName menuPrice
	
	public int getIdx() {
		return idx;
	}
	public int getMeunIdx() {
		return meunIdx;
	}
	public void setMeunIdx(int meunIdx) {
		this.meunIdx = meunIdx;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getMenuPrice() {
		return menuPrice;
	}
	public void setMenuPrice(int menuPrice) {
		this.menuPrice = menuPrice;
	}
	public int getCoupon() {
		return coupon;
	}
	public void setCoupon(int coupon) {
		this.coupon = coupon;
	}
	public int getMenuIdx() {
		return meunIdx;
	}
	public void setMenuIdx(int menuIdx) {
		this.meunIdx = menuIdx;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getClientID() {
		return clientID;
	}
	public void setClientID(String clientID) {
		this.clientID = clientID;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return  idx + ". " +"고객이름 : " + clientName+"("+clientID+")"+"("+password+")\n"
				+meunIdx+". "+"주문하신 메뉴 =" + menuName +" "+menuPrice+"원 \n" 
				+"현재 쿠폰계수" + coupon ;
	}
	

	
}
