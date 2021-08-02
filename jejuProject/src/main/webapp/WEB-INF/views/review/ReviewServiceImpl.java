package co.jeju.jejuProject.review.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.jeju.jejuProject.dao.DataSource;
import co.jeju.jejuProject.review.service.ReviewService;
import co.jeju.jejuProject.review.vo.ReviewCommentVO;
import co.jeju.jejuProject.review.vo.ReviewVO;

public class ReviewServiceImpl implements ReviewService {
	private DataSource dataSource = DataSource.getInstance();
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	
	@Override
	public List<ReviewVO> reviewSelectList() {
		// TODO 후기게시판 전체글보기
		List<ReviewVO> list = new ArrayList<ReviewVO>();
		ReviewVO vo;
		String sql = "select * from review order by rno desc";
		conn = dataSource.getConnection();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new ReviewVO();
				vo.setrNo(rs.getInt("rno"));
				vo.setrTitle(rs.getString("rtitle"));
				vo.setrContent(rs.getString("rcontent"));
				vo.setrWriter(rs.getString("rwriter"));
				vo.setrDate(rs.getDate("rdate"));
				vo.setrHit(rs.getInt("rhit"));
				vo.setrAno(rs.getInt("rano"));
				list.add(vo);					
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {close();}
		return list;
	}

	@Override
	public List<ReviewVO> reviewSelect(int no) {
		// TODO 글조회 (댓글까지 같이 조회)
//		String sql = "select * from review where rno = ?";
		List<ReviewVO> list = new ArrayList<ReviewVO>();
		ReviewVO vo;
		boolean b = false;
		String sql = "select a.*, b.rcname, b.rccontent, b.rcdate from review a left outer join review_comment b on (a.rno = b.rno) where a.rno = ?";
		conn = dataSource.getConnection();		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, no);
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo = new ReviewVO();
				vo.setrNo(rs.getInt("rno"));
				vo.setrTitle(rs.getString("rtitle"));
				vo.setrContent(rs.getString("rcontent"));
				vo.setrWriter(rs.getString("rwriter"));
				vo.setrDate(rs.getDate("rdate"));
				vo.setrHit(rs.getInt("rhit"));
				vo.setrAno(rs.getInt("rano"));
				vo.setRcName(rs.getString("rcname"));
				vo.setRcContent(rs.getString("rccontent"));
				vo.setRcDate(rs.getDate("rcdate"));
				list.add(vo);
				
				hitUpdate(vo.getrNo()); // 조회수 증가 메소드				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {close();}
		return list;
	}

	private void hitUpdate(int no) {
		// TODO 조회수 증가 (게시글 읽으면=상세조회하면 조회수 증가)
		String sql = "update review set rhit = rhit + 1 where rno = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, no);
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}		
	
	@Override
	public int reviewInsert(ReviewVO vo) {
		// TODO 글작성
		String sql = "insert into review(rno, rtitle, rcontent, rwriter, rdate) values(r_seq.nextval, ?, ?, ?, ?)";
		int n = 0;
		conn = dataSource.getConnection();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getrTitle());
			psmt.setString(2, vo.getrContent());
			psmt.setString(3, vo.getrWriter());
			psmt.setDate(4, vo.getrDate());
			n = psmt.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {close();}
		return n;
	}

	@Override
	public int reviewUpdate(ReviewVO vo) {
		// TODO 글수정
		String sql = "update review set rtitle = ?, rcontent = ? where rno = ?";
		int n = 0;
		conn = dataSource.getConnection();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getrTitle());
			psmt.setString(2, vo.getrContent());
			psmt.setInt(3, vo.getrNo());
			n = psmt.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {close();}
		return n;
	}

	@Override
	public int reviewDelete(ReviewVO vo) {
		// TODO 글삭제
		String sql = "delete from review where rno = ?";
		int n = 0;
		conn = dataSource.getConnection();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getrNo());
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


	@Override
	public int reviewCommentInsert(ReviewCommentVO vo) {
		// TODO 댓글작성
		String sql = "insert into review_comment values(?, rc_seq.nextval, ?, ?, ?)";
		int n = 0;
		conn = dataSource.getConnection();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getrNo());
			psmt.setString(2, vo.getRcContent());
			psmt.setString(3, vo.getRcName());
			psmt.setDate(4, vo.getRcDate());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {close();}
		return n;
	}

	@Override
	public int reviewCommentUpdate(ReviewCommentVO vo) {
		// TODO 댓글수정
		String sql = "update review_comment set rccontent = ? where rcno = ?";
		int n = 0;
		conn = dataSource.getConnection();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getRcContent());
			psmt.setInt(2, vo.getRcNo());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {close();}
		return n;
	}

	@Override
	public int reviewCommentDelete(ReviewCommentVO vo) {
		// TODO 댓글삭제
		String sql = "delete from review_comment where rcno = ?";
		int n = 0;
		conn = dataSource.getConnection();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getRcNo());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {close();}
		return n;
	}
}
