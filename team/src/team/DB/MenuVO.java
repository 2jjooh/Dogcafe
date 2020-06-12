package team.DB;

public class MenuVO {
String menuName,menuPrice,menuCode;

public String getMenuName() {
	return menuName;
}

public void setMenuName(String menuName) {
	this.menuName = menuName;
}

public String getMenuPrice() {
	return menuPrice;
}

public void setMenuPrice(String menuPrice) {
	this.menuPrice = menuPrice;
}

public String getMenuCode() {
	return menuCode;
}

public void setMenuCode(String menuCode) {
	this.menuCode = menuCode;
}

@Override
public String toString() {
	return "menuVO [menuName=" + menuName + ", menuPrice=" + menuPrice + ", menuCode=" + menuCode + "]";
}


}
