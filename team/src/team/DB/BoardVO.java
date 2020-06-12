package team.DB;

import java.util.Date;

//sql 명령문을 실행하는 함수의 집합
public class BoardVO {
 
	private int idx;
	private String wirteID;
	private String memo;
	private Date writeDay;

	
	
// Getter & Setter
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getWirteID() {
		return wirteID;
	}
	public void setWirteID(String wirteID) {
		this.wirteID = wirteID;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public Date getWriteDay() {
		return writeDay;
	}
	public void setWriteDay(Date writeDay) {
		this.writeDay = writeDay;
	}
	@Override
	public String toString() {
		return "BoardVO [idx=" + idx + ", wirteID=" + wirteID + ", memo=" + memo + ", writeDay=" + writeDay + "]";
	}
	
	
}
