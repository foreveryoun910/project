package co.jeju.jejuProject.review.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.jeju.jejuProject.dao.DataSource;
import co.jeju.jejuProject.review.service.ReviewService;
import co.jeju.jejuProject.review.vo.CommentsVO;
import co.jeju.jejuProject.review.vo.ReviewVO;

public class ReviewServiceImpl implements ReviewService {
	private DataSource dataSource = DataSource.getInstance();
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;

	@Override
	public List<ReviewVO> reviewSelectList() {
		// TODO 여행후기게시판 글목록
		List<ReviewVO> list = new ArrayList<ReviewVO>();
		ReviewVO vo;
		String sql = "select * from review order by rno desc";
		conn = dataSource.getConnection();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new ReviewVO();
				vo.setrNo(rs.getInt("rNo"));
				vo.setrTitle(rs.getString("rTitle"));
				vo.setrContent(rs.getString("rContent"));
				vo.setrWriter(rs.getString("rWriter"));
				vo.setrDate(rs.getDate("rDate"));
				vo.setrHit(rs.getInt("rHit"));
				vo.setrLike(rs.getInt("rLike"));
				vo.setrRecommend(rs.getInt("rRecommend"));
				vo.setrAno(rs.getInt("rAno"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {close();}
		return list;
	}

	@Override
	public List<ReviewVO> reviewSelect(int no) {
		// TODO 글 조회 (댓글 포함)
		return null;
	}

	@Override
	public int reviewInsert(ReviewVO vo) {
		// TODO 글 작성
		return 0;
	}

	@Override
	public int reviewUpdate(ReviewVO vo) {
		// TODO 글 수정
		return 0;
	}

	@Override
	public int reviewDelete(ReviewVO vo) {
		// TODO 글 삭제
		return 0;
	}

	@Override
	public int commentsInsert(CommentsVO vo) {
		// TODO 댓글 작성
		return 0;
	}

	@Override
	public int commentsUpdate(CommentsVO vo) {
		// TODO 댓글 수정
		return 0;
	}

	@Override
	public int commentsDelete(CommentsVO vo) {
		// TODO 댓글 삭제
		return 0;
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
