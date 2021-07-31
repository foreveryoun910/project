package co.jeju.jejuProject.board.service;

import java.util.List;

import co.jeju.jejuProject.board.vo.BoardVO;

public interface BoardService {
	List<BoardVO> boardSelectList(); // 전체공지보기
	BoardVO boardSelect(BoardVO vo); // 공지선택조회
	int boardInsert(BoardVO vo); // 공지작성
	int boardUpdate(BoardVO vo); // 공지수정
	int boardDelete(BoardVO vo); // 공지삭제
}
