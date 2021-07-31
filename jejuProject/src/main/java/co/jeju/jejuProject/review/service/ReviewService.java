package co.jeju.jejuProject.review.service;

import java.util.List;

import co.jeju.jejuProject.review.vo.CommentsVO;
import co.jeju.jejuProject.review.vo.ReviewVO;

public interface ReviewService {
	List<ReviewVO> reviewSelectList(); // 여행후기게시판 글목록
	List<ReviewVO> reviewSelect(int no); // 글 조회
	int reviewInsert(ReviewVO vo); // 글 작성
	int reviewUpdate(ReviewVO vo); // 글 수정
	int reviewDelete(ReviewVO vo); // 글 삭제
	int commentsInsert(CommentsVO vo); // 댓글 작성
	int commentsUpdate(CommentsVO vo); // 댓글 수정
	int commentsDelete(CommentsVO vo); // 댓글 삭제
}
