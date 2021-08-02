package co.jeju.jejuProject.review.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jeju.jejuProject.common.Command;
import co.jeju.jejuProject.review.service.ReviewService;
import co.jeju.jejuProject.review.serviceImpl.ReviewServiceImpl;
import co.jeju.jejuProject.review.vo.ReviewVO;

public class ReviewCommentDelete implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 댓글삭제
		ReviewService dao = new ReviewServiceImpl();
		ReviewVO vo = new ReviewVO();
		vo.setRcNo(Integer.valueOf(request.getParameter("rcNo")));
		dao.reviewCommentDelete(vo);
		int n = dao.reviewCommentDelete(vo);
		List<ReviewVO> list = new ArrayList<ReviewVO>();
		list = dao.reviewSelect(vo.getRcNo());
		request.setAttribute("list", list);
		
		String page = "";
		if(n != 0) {
			page = "review/reviewSelect";
		} else {
			page = "review/reviewMessage";
		}
		return page;
	}

}
