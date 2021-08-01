package co.jeju.jejuProject.review.comment.service;

import java.util.List;

import co.jeju.jejuProject.review.comment.vo.ReviewCommentVO;

public interface ReviewCommentService {
	List<ReviewCommentVO> reviewCommentSelectList(); // 전체댓글리스트
	ReviewCommentVO reviewCommentSelect(ReviewCommentVO vo); // 댓글조회?
	int reviewCommentInsert(ReviewCommentVO vo); // 댓글작성
	int reviewCommentUpdate(ReviewCommentVO vo); // 댓글수정
	int reviewCommentDelete(ReviewCommentVO vo); // 댓글삭제
}
