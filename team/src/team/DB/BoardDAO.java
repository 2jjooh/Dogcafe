package team.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import team.login.Login;

public class BoardDAO {
	
	public static void insert(BoardVO vo) {
		String svo = TeamDAO.getDBID();
	//=======================================
		
		Connection conn = null;
		PreparedStatement pstmt = null; 
		
		try {
			conn = DBUtil.getMySQLConnection();
			
			String sql = "insert into board(writeId, memo) values(?,?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, svo);
			pstmt.setString(2, vo.getMemo());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
			DBUtil.close(pstmt);
		}
		
	}

	
	
	public static ArrayList<BoardVO> msgShow() {

		Connection conn = null;
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		ArrayList<BoardVO> list= null;
		
		try {
			conn = DBUtil.getMySQLConnection();
			
			String sql = "select * from board order by idx desc";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			list = new ArrayList<BoardVO>();
			
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setWirteID(rs.getString("writeID"));
				vo.setMemo(rs.getString("memo"));
				vo.setWriteDay(rs.getTimestamp("writeDay"));
				
				list.add(vo);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
			DBUtil.close(pstmt);
			DBUtil.close(rs);
		}
		
		return list;
	}



	public static ArrayList<BoardVO> indivMsg() {
		String svo = TeamDAO.getDBID();
	//================================
		Connection conn = null;
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		ArrayList<BoardVO> list= null;
		
		try {
			conn = DBUtil.getMySQLConnection();
			
			String sql = "SELECT * FROM board WHERE writeID=? ORDER BY idx DESC";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,svo);			//로그인된 ID를 가져오면 된다. 
			
			rs = pstmt.executeQuery();
			list = new ArrayList<BoardVO>();

			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setWirteID(rs.getString("writeID"));
				vo.setMemo(rs.getString("memo"));
				vo.setWriteDay(rs.getTimestamp("writeDay"));
				
				list.add(vo);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
			DBUtil.close(pstmt);
			DBUtil.close(rs);
		}
		
		return list;
	}


	
// 글 하나를 선택하는 메서드 
	public static BoardVO selectByIdx(int position) {
		String svo = TeamDAO.getDBID();
	//=====================================
		BoardVO vo = null;
		
		try {
			Connection conn = DBUtil.getMySQLConnection();
			String sql = "SELECT * FROM board  WHERE writeID=? ORDER BY idx desc LIMIT ?,1 ";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,svo);	
			pstmt.setInt(2, position);
			
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			
			vo = new BoardVO();
			vo.setIdx(rs.getInt("idx"));
			vo.setWirteID(rs.getString("writeID"));
			vo.setMemo(rs.getString("memo"));
			vo.setWriteDay(rs.getTimestamp("writeDay"));
		
			DBUtil.close(conn);
			DBUtil.close(pstmt);
			DBUtil.close(rs);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return vo;
	}
	
	
//내가 쓴 글을 삭제하는 메서드 
	public static void deleteMsg(int selectedRow) {
		
		BoardVO vo =	selectByIdx(selectedRow);
		
		try {
			Connection conn = DBUtil.getMySQLConnection();
			String sql = "DELETE FROM board WHERE idx= ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getIdx());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}



	public static String modifyMsg(int selectedRow) {
		BoardVO vo =	selectByIdx(selectedRow);
		//System.out.println(vo.getMemo());
		
		return vo.getMemo();
	}



	public static void updateMsg(String str, int selectedRow) {
	
		BoardVO vo =	selectByIdx(selectedRow);
		
		try {
			Connection conn = DBUtil.getMySQLConnection();
			String sql = "UPDATE board SET memo=? WHERE idx= ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, str);
			pstmt.setInt(2, vo.getIdx());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
