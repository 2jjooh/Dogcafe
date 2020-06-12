package team.DB;

import team.login.*;
import team.DB.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;


public class TeamDAO {
	
	public static void saveCoupon(int coupon) {
		if(coupon>12) {
			coupon=12;
		}
		Connection conn=null;
		PreparedStatement pstmt =null;
		//Login user = new Login();
		TeamVO vo= new TeamVO();
		try {
			conn =DBUtil.getMySQLConnection();
			String sql=String.format("UPDATE client SET coupon =? WHERE clientId =?");
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,coupon);
			pstmt.setString(2,Login.userID);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn);
			DBUtil.close(pstmt);
		}
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
			pstmt.setString(1,Login.userID);//디비에서 받아온 아이디 넣을껏
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
		int cou=vo.getCoupon();
		
		return cou;
	
	}
	
	
	public static String getDBName() {
		Connection conn=null;
		PreparedStatement pstmt =null;
		ResultSet rs=null;
		TeamVO vo= new TeamVO();
		try {
			conn=DBUtil.getMySQLConnection();
			String sql = "select clientName from client where clientId=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,Login.userID);//디비에서 받아온 아이디 넣을껏
			rs=pstmt.executeQuery();
			while (rs.next()) {
				vo.setClientName(rs.getString("clientName"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn);
			DBUtil.close(pstmt);
			DBUtil.close(rs);
		}
		String Cname=vo.getClientName();
		return Cname;
	
	}

//로그인 된 사용자 ID를 가져온다
	public static String getDBID() {
		Connection conn=null;
		PreparedStatement pstmt =null;
		ResultSet rs=null;
		TeamVO vo= new TeamVO();
		try {
			conn=DBUtil.getMySQLConnection();
			String sql = "select * from client where clientId=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,Login.userID);//디비에서 아이디 받아오기.
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
		String Cid=vo.getClientID();
		return Cid;
	
	}	
	public static ArrayList<OrderVO> select() {
		ArrayList<OrderVO> list=null;
		try {
		//	MemoProjectWIN.
			Connection conn = DBUtil.getMySQLConnection();
			String sql = "select * from orderd where orderId=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,getDBID());
			ResultSet rs=pstmt.executeQuery();
			//ResultSet 객체에서 얻어온 테이블의 글 목록을 ArrayList에 저장한다.
			
			list=new ArrayList<OrderVO>();
			while (rs.next()) {
				OrderVO vo=new OrderVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setMenuName(rs.getString("menuName"));
				vo.setPrice(rs.getString("Price"));
				vo.setOrderTime(rs.getDate("orderTime"));
				//vo.setOrderTime(rs.getTimestamp("orderTime"));
//				vo.setIdx(rs.getInt("idx"));
//				vo.setName(rs.getString("name"));
//				vo.setPassword(rs.getString("password"));
//				vo.setMemo(rs.getString("memo"));
//				vo.setWriteDate(rs.getTimestamp("writeDate"));
				list.add(vo);
				
			}
			DBUtil.close(conn);
			DBUtil.close(pstmt);
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
}