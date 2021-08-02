package co.jeju.jejuProject.review.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jeju.jejuProject.common.Command;
import co.jeju.jejuProject.review.service.ReviewService;
import co.jeju.jejuProject.review.serviceImpl.ReviewServiceImpl;
import co.jeju.jejuProject.review.vo.ReviewVO;

public class ReviewUpdateForm implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 글수정 폼
		ReviewService dao = new ReviewServiceImpl();
		List<ReviewVO> list = new ArrayList<ReviewVO>();
		int n = Integer.valueOf(request.getParameter("rNo"));
//		System.out.println(n);
		list = dao.reviewSelect(n);
		request.setAttribute("list", list);
		
		return "review/reviewUpdateForm";	
	}

}
