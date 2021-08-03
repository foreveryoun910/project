package co.jeju.jejuProject.info.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.jeju.jejuProject.dao.DataSource;
import co.jeju.jejuProject.info.service.InfoService;
import co.jeju.jejuProject.info.vo.InfoCommentVO;
import co.jeju.jejuProject.info.vo.InfoVO;

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
				vo.setiAno(rs.getInt("iano"));
				vo.setiLike(rs.getInt("ilike"));
				list.add(vo);					
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {close();}
		return list;
	}

	@Override
	public List<InfoVO> infoSelect(int no) {
		// TODO 글조회 ( 댓글까지 조회되도록 수정------------------)
		List<InfoVO> list = new ArrayList<InfoVO>();
		InfoVO vo;
		boolean b = false;
		String sql = "select a.*, b.icno, b.icname, b.iccontent, b.icdate from info a left outer join info_comment b on (a.ino = b.ino) where a.ino = ?";
		conn = dataSource.getConnection();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, no);
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo = new InfoVO();
				vo.setiNo(rs.getInt("ino"));
				vo.setiSubject(rs.getString("isubject"));
				vo.setiTitle(rs.getString("ititle"));
				vo.setiContent(rs.getString("icontent"));
				vo.setiWriter(rs.getString("iwriter"));
				vo.setiDate(rs.getDate("idate"));
				vo.setiHit(rs.getInt("ihit"));
				vo.setiAno(rs.getInt("iano"));
				vo.setiLike(rs.getInt("ilike"));
				vo.setIcNo(rs.getInt("icno"));
				vo.setIcName(rs.getString("icname"));
				vo.setIcContent(rs.getString("iccontent"));
				vo.setIcDate(rs.getDate("icdate"));
				list.add(vo);
			}
			hitUpdate(no); // 조회수 증가 메소드
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {close();}
		return list;
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

	
	@Override
	public int infoCommentInsert(InfoCommentVO vo) {
		// TODO 댓글작성
		String sql = "insert into info_comment(ino, icno, iccontent, icname, icdate) values(?, ic_seq.nextval, ?, ?, sysdate)";
		int n = 0;
		conn = dataSource.getConnection();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getiNo());
			psmt.setString(2, vo.getIcContent());
			psmt.setString(3, vo.getIcName());
			n = psmt.executeUpdate();
			anoUpdate(vo.getiNo());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {close();}
		return n;
	}

	private void anoUpdate(int no) {
		// TODO 댓글수 카운트
		String sql = "update info set iano = iano + 1 where ino = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, no);
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
	
	@Override
	public int infoCommentUpdate(InfoCommentVO vo) {
		// TODO 댓글수정
		String sql = "update info_comment set iccontent = ? where icno = ?";
		int n = 0;
		conn = dataSource.getConnection();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getIcContent());
			psmt.setInt(2, vo.getIcNo());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {close();}
		return n;
	}

	@Override
	public int infoCommentDelete(InfoCommentVO vo) {
		// TODO 댓글삭제
		String sql = "delete from info_comment where icno = ?";
		int n = 0;
		conn = dataSource.getConnection();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getIcNo());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {close();}
		return n;
	}

	@Override
	public int infoRecOn(InfoCommentVO vo) {
		// TODO 추천on
		String sql = "update info_comment set I_REC_ID = 1 where ino = ?";
		int n = 0;
		conn = dataSource.getConnection();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getiNo());
			n = psmt.executeUpdate();
			likePlus(vo.getiNo());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {close();}
		return n;		
	}

	private void likePlus(int no) {
		// TODO 좋아요 수 카운트 +
		String sql = "update info set ilike = ilike + 1 where ino = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, no);
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
	
	
	@Override
	public int infoRecOff(InfoCommentVO vo) {
		// TODO 추천off
		String sql = "update info_comment set I_REC_ID = 0 where ino = ?";
		int n = 0;
		conn = dataSource.getConnection();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getiNo());
			n = psmt.executeUpdate();
			likeMinus(vo.getiNo());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {close();}
		return n;
	}
	
	private void likeMinus(int no) {
		// TODO 좋아요 수 카운트 -
		String sql = "update info set ilike = ilike - 1 where ino = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, no);
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
