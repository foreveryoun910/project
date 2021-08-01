package co.jeju.jejuProject.review.service;

import java.util.List;

import co.jeju.jejuProject.review.vo.ReviewVO;

public interface ReviewService {
	List<ReviewVO> reviewSelectList(); // 후기게시판 전체글보기
	ReviewVO reviewSelect(ReviewVO vo); // 글조회
	int reviewInsert(ReviewVO vo); // 글작성
	int reviewUpdate(ReviewVO vo); // 글수정
	int reviewDelete(ReviewVO vo); // 글삭제
}
