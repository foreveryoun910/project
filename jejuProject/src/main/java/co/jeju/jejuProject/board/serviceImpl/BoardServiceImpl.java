package co.jeju.jejuProject.board.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.jeju.jejuProject.board.service.BoardService;
import co.jeju.jejuProject.board.vo.BoardVO;
import co.jeju.jejuProject.dao.DataSource;

public class BoardServiceImpl implements BoardService {
	private DataSource dataSource = DataSource.getInstance();
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;

	@Override
	public List<BoardVO> boardSelectList() {
		// TODO 전체공지보기
		List<BoardVO> list = new ArrayList<BoardVO>();
		BoardVO vo;
		String sql = "select * from board order by bno desc";
		conn = dataSource.getConnection();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new BoardVO();
				vo.setbNo(rs.getInt("bno"));
				vo.setbTitle(rs.getString("btitle"));
				vo.setbContent(rs.getString("bcontent"));
				vo.setbWriter(rs.getString("bwriter"));
				vo.setbDate(rs.getDate("bdate"));
				vo.setbHit(rs.getInt("bhit"));
				list.add(vo);				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {close();}
		return list;
	}

	@Override
	public BoardVO boardSelect(BoardVO vo) {
		// TODO 공지선택조회
		String sql = "select * from board where bno = ?";
		conn = dataSource.getConnection();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getbNo());
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setbNo(rs.getInt("bno"));
				vo.setbTitle(rs.getString("btitle"));
				vo.setbContent(rs.getString("bcontent"));
				vo.setbWriter(rs.getString("bwriter"));
				vo.setbDate(rs.getDate("bdate"));
				vo.setbHit(rs.getInt("bhit"));
				
				hitUpdate(vo.getbNo()); // 조회수 증가 메소드				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {close();}
		return vo;
	}

	private void hitUpdate(int no) {
		// TODO 조회수 증가 (게시글 읽으면=상세조회하면 조회수 증가)
		String sql = "update board set bhit = bhit + 1 where bno = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, no);
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
	
	@Override
	public int boardInsert(BoardVO vo) {
		// TODO 공지작성
		String sql = "insert into board(bno, btitle, bcontent, bwriter, bdate) values(b_seq.nextval, ?, ?, ?, ?)";
		int n = 0;
		conn = dataSource.getConnection();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getbTitle());
			psmt.setString(2, vo.getbContent());
			psmt.setString(3, vo.getbWriter());
			psmt.setDate(4, vo.getbDate());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {close();}
		return n;
	}

	@Override
	public int boardUpdate(BoardVO vo) {
		// TODO 공지수정
		String sql = "update board set btitle = ?, bcontent = ? where bno = ?";
		int n = 0;
		conn = dataSource.getConnection();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getbTitle());
			psmt.setString(2, vo.getbContent());
			psmt.setInt(3, vo.getbNo());
			n = psmt.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {close();}
		return n;
	}

	@Override
	public int boardDelete(BoardVO vo) {
		// TODO 공지삭제
		String sql = "delete from board where bno = ?";
		int n = 0;
		conn = dataSource.getConnection();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getbNo());
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
