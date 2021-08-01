package co.jeju.jejuProject.info.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.jeju.jejuProject.dao.DataSource;
import co.jeju.jejuProject.info.service.InfoService;
import co.jeju.jejuProject.info.vo.InfoVO;
import co.jeju.jejuProject.review.vo.ReviewVO;

public class InfoServiceImpl implements InfoService {
	private DataSource dataSource = DataSource.getInstance();
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;	

	@Override
	public List<InfoVO> infoSelectList() {
		// TODO 정보게시판 전체글보기
		List<InfoVO> list = new ArrayList<InfoVO>();
		InfoVO vo;
		String sql = "select * from info order by ino desc";
		conn = dataSource.getConnection();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new InfoVO();
				vo.setiNo(rs.getInt("ino"));
				vo.setiSubject(rs.getString("isubject"));
				vo.setiTitle(rs.getString("ititle"));
				vo.setiContent(rs.getString("icontent"));
				vo.setiWriter(rs.getString("iwriter"));
				vo.setiDate(rs.getDate("idate"));
				vo.setiHit(rs.getInt("ihit"));
				list.add(vo);					
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {close();}
		return list;
	}

	@Override
	public InfoVO infoSelect(InfoVO vo) {
		// TODO 글조회
		String sql = "select * from info where ino = ?";
		conn = dataSource.getConnection();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getiNo());
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setiNo(rs.getInt("ino"));
				vo.setiSubject(rs.getString("isubject"));
				vo.setiTitle(rs.getString("ititle"));
				vo.setiContent(rs.getString("icontent"));
				vo.setiWriter(rs.getString("iwriter"));
				vo.setiDate(rs.getDate("idate"));
				vo.setiHit(rs.getInt("ihit"));
				
				hitUpdate(vo.getiNo()); // 조회수 증가 메소드
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {close();}
		return vo;
	}

	private void hitUpdate(int no) {
		// TODO 조회수 증가 (게시글 읽으면=상세조회하면 조회수 증가)
		String sql = "update info set ihit = ihit + 1 where ino = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, no);
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}			
	
	@Override
	public int infoInsert(InfoVO vo) {
		// TODO 글작성
		String sql = "insert into info(ino, isubject, ititle, icontent, iwriter, idate) values(i_seq.nextval, ?, ?, ?, ?, ?)";
		int n = 0;
		conn = dataSource.getConnection();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getiSubject());
			psmt.setString(2, vo.getiTitle());
			psmt.setString(3, vo.getiContent());
			psmt.setString(4, vo.getiWriter());
			psmt.setDate(5, vo.getiDate());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {close();}
		return n;
	}

	@Override
	public int infoUpdate(InfoVO vo) {
		// TODO 글수정
		String sql = "update info set isubject = ?, ititle = ?, icontent = ? where ino = ?";
		int n = 0;
		conn = dataSource.getConnection();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getiSubject());
			psmt.setString(2, vo.getiTitle());
			psmt.setString(3, vo.getiContent());
			psmt.setInt(4, vo.getiNo());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {close();}
		return n;
	}

	@Override
	public int infoDelete(InfoVO vo) {
		// TODO 글삭제
		String sql = "delete from info where ino = ?";
		int n = 0;
		conn = dataSource.getConnection();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getiNo());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {close();}
		return n;
	}

	
	private void close() {
		try {
			if(rs != null) rs.close();
			if(psmt != null) psmt.close();
			if(conn != null) conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}	
}
