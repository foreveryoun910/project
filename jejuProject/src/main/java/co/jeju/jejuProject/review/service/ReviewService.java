package co.jeju.jejuProject.review.service;

import java.util.List;

import co.jeju.jejuProject.review.vo.ReviewCommentVO;
import co.jeju.jejuProject.review.vo.ReviewVO;

public interface ReviewService {
	List<ReviewVO> reviewSelectList(); // 후기게시판 전체글보기
	List<ReviewVO> reviewSelect(int no); // 글조회
	int reviewInsert(ReviewVO vo); // 글작성
	int reviewUpdate(ReviewVO vo); // 글수정
	int reviewDelete(ReviewVO vo); // 글삭제
	
	int reviewCommentInsert(ReviewCommentVO vo); // 댓글작성
	int reviewCommentUpdate(ReviewCommentVO vo); // 댓글수정
	int reviewCommentDelete(ReviewCommentVO vo); // 댓글삭제
	
	int reviewRecOn(ReviewCommentVO vo); // 추천on
	int reviewRecOff(ReviewCommentVO vo); // 추천off
}
