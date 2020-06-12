package team.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import team.login.Login;

public class OrderDAO {
	/*
	public static void insertMenu(String name, int sumPrice) {
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt;
		try {
			conn = DBUtil.getMySQLConnection();
			String sql = "insert into menu (menuName, menuPrice) values (?, ?) ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, sumPrice);
		
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
			DBUtil.close(stmt);
		}
		System.out.println("menu 저장 완료");
	}
	*/

	public static void insertOrderd(int count, String size, String ice, String shot, String whip, String menuName, int price) {
		
		TeamDAO vo = new TeamDAO();
		
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt;
		try {
			conn = DBUtil.getMySQLConnection();
			String sql = "insert into orderd (amount, size, ice, shot, whip, menuName, price,orderID) values (?, ?, ?, ?, ?, ?, ?, ?);";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, count);
			pstmt.setString(2, size);
			pstmt.setString(3, ice);
			pstmt.setString(4, shot);
			pstmt.setString(5, whip);
			pstmt.setString(6, menuName);
			pstmt.setInt(7, price);
			pstmt.setString(8, vo.getDBID());
		
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
			DBUtil.close(stmt);
		}
		System.out.println("orderd 저장 완료");
	}
	public static void historyOrderd(String menuName, int count, String size, String ice, String shot, String whip) {
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt;
		try {
			conn = DBUtil.getMySQLConnection();
			String sql = "insert into orderd (menuName, amount, size, ice, shot, whip) values (?, ?, ?, ?, ?, ?);";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, menuName);
			pstmt.setInt(2, count);
			pstmt.setString(3, size);
			pstmt.setString(4, ice);
			pstmt.setString(5, shot);
			pstmt.setString(6, whip);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
			DBUtil.close(stmt);
		}
		System.out.println("orderd 저장 완료");
	}
	
	public static void insertOrdert(String orderID, int sumPrice, String orderStatus) {
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt;
		try {
			conn = DBUtil.getMySQLConnection();
			String sql = "insert into ordert (orderID, totalPrice, orderStatus) values (?, ?, ?);";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, orderID);
			pstmt.setInt(2, sumPrice);
			pstmt.setString(3, orderStatus);
			
		
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
			DBUtil.close(stmt);
		}
		System.out.println("ordert 저장 완료");
	}
	
	public static int getDBCoupon() {
	      Connection conn=null;
	      PreparedStatement pstmt =null;
	      ResultSet rs=null;
	      TeamVO vo= new TeamVO();
	      try {
	         conn=DBUtil.getMySQLConnection();
	         String sql = "select coupon from client where clientId=?";
	         pstmt=conn.prepareStatement(sql);
	         pstmt.setString(1,OrderDAO.getDBID());//디비에서 받아온 아이디 넣을껏
	         rs=pstmt.executeQuery();
	         while (rs.next()) {
	            vo.setCoupon(rs.getInt("coupon"));
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }finally {
	         DBUtil.close(conn);
	         DBUtil.close(pstmt);
	         DBUtil.close(rs);
	      }
	      return vo.getCoupon();
	}
	
	public static String getDBID() {
		Connection conn=null;
		PreparedStatement pstmt =null;
		ResultSet rs=null;
		TeamVO vo= new TeamVO();
		try {
			conn = DBUtil.getMySQLConnection();
			String sql = "select clientId from client where clientId = ?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, Login.userID); //디비에서 아이디 받아오기. dla3946gns은 실험용이고 2번째 변수 안에 Login.userID가 들어가야 함.
//			pstmt.setInt(1, 12);
			rs=pstmt.executeQuery();
			while (rs.next()) {
				vo.setClientID(rs.getString("clientId"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn);
			DBUtil.close(pstmt);
			DBUtil.close(rs);
		}
		return vo.getClientID();
	}	
	
	public static void insertCouponZero() {
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt=null;
		TeamDAO dao = new TeamDAO();
		try {
			conn = DBUtil.getMySQLConnection();
			String sql = "UPDATE client SET coupon =0 WHERE clientId =?";
			pstmt = conn.prepareStatement(sql);
			System.out.println(dao.getDBID());
			pstmt.setString(1, dao.getDBID());
		
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
			DBUtil.close(stmt);
			DBUtil.close(pstmt);
		}
		System.out.println("쿠폰 초기화 완료");
	}
	
}



































