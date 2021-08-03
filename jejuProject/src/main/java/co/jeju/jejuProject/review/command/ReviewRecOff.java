package co.jeju.jejuProject.review.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jeju.jejuProject.common.Command;
import co.jeju.jejuProject.review.service.ReviewService;
import co.jeju.jejuProject.review.serviceImpl.ReviewServiceImpl;
import co.jeju.jejuProject.review.vo.ReviewVO;

public class ReviewRecOff implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 추천off
		ReviewService dao = new ReviewServiceImpl();
		ReviewVO vo = new ReviewVO();
		vo.setrNo(Integer.valueOf(request.getParameter("rNo")));
		List<ReviewVO> list = new ArrayList<ReviewVO>();
		int n = dao.reviewUpdate(vo);
		list = dao.reviewSelectList();
		request.setAttribute("list", list);	
		
		String page = "";
		if(n != 0) {
			page = "review/reviewList";
		} else {
			page = "review/reviewMessage";
		}
		return page;
	}

}
