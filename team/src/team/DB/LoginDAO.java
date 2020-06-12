package team.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class LoginDAO {

	
	public static boolean selectuser(String id, String pw) {
		
		try {
			Connection conn = DBUtil.getMySQLConnection();
			String sql = "select * from client where clientId = ? ";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			
			
			if(rs.next()) {
				if(rs.getString("clientPw").equals(pw)) {
					return true;
				}else {
					System.out.println(rs.getString("clientPw"));
					JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.");
					return false;
				}
			}else {
				JOptionPane.showMessageDialog(null, "일치하는 id가 없습니다.");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	} // end selectuser
	
	public static boolean idCheck(String id) {
		try {
			Connection conn = DBUtil.getMySQLConnection();
			String sql = "select clientId from client where clientId = ? ";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(!rs.next()) {
				return true;
			}else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	} // end check
	
	public static void join(String id, String name, String pw, String phone) {
		Connection conn = null;
		PreparedStatement pstmt = null; 
		
		try {
			conn = DBUtil.getMySQLConnection();
			
			String sql = "INSERT INTO client(clientId,clientPw,clientName,phoneNum) VALUES(?,?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, phone);
			
			pstmt.executeUpdate();

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	}
}