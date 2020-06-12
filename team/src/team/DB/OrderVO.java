package team.DB;

import java.sql.Date;
import java.sql.Timestamp;

public class OrderVO {
	int idx,amount;
	String menuCode,size,ice,shot,whip,orderID,Price,menuName;
	Date orderTime;
	boolean orderStatus;
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getMenuCode() {
		return menuCode;
	}
	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getIce() {
		return ice;
	}
	public void setIce(String ice) {
		this.ice = ice;
	}
	public String getShot() {
		return shot;
	}
	public void setShot(String shot) {
		this.shot = shot;
	}
	public String getWhip() {
		return whip;
	}
	public void setWhip(String whip) {
		this.whip = whip;
	}
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public String getPrice() {
		return Price;
	}
	public void setPrice(String price) {
		Price = price;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public boolean isOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(boolean orderStatus) {
		this.orderStatus = orderStatus;
	}
	@Override
	public String toString() {
		return "OrderVO [idx=" + idx + ", amount=" + amount + ", menuCode=" + menuCode + ", size=" + size + ", ice="
				+ ice + ", shot=" + shot + ", whip=" + whip + ", orderID=" + orderID + ", Price=" + Price
				+ ", menuName=" + menuName + ", orderTime=" + orderTime + ", orderStatus=" + orderStatus + "]";
	}
	
}
