package co.jeju.jejuProject.info.service;

import java.util.List;

import co.jeju.jejuProject.info.vo.InfoVO;

public interface InfoService {
	List<InfoVO> infoSelectList(); // 정보게시판 전체글보기
	InfoVO infoSelect(InfoVO vo); // 글조회
	int infoInsert(InfoVO vo); // 글작성
	int infoUpdate(InfoVO vo); // 글수정
	int infoDelete(InfoVO vo); // 글삭제
}
