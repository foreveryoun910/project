package co.jeju.jejuProject.info.service;

import java.util.List;

import co.jeju.jejuProject.info.vo.InfoCommentVO;
import co.jeju.jejuProject.info.vo.InfoVO;
import co.jeju.jejuProject.review.vo.ReviewCommentVO;

public interface InfoService {
	List<InfoVO> infoSelectList(); // 정보게시판 전체글보기
	List<InfoVO> infoSelect(int no); // 글조회
	int infoInsert(InfoVO vo); // 글작성
	int infoUpdate(InfoVO vo); // 글수정
	int infoDelete(InfoVO vo); // 글삭제
	
	int infoCommentInsert(InfoCommentVO vo); // 댓글작성
	int infoCommentUpdate(InfoCommentVO vo); // 댓글수정
	int infoCommentDelete(InfoCommentVO vo); // 댓글삭제
	
	int infoRecOn(InfoCommentVO vo); // 추천on
	int infoRecOff(InfoCommentVO vo); // 추천off
}
