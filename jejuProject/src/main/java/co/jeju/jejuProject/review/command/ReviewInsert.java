package co.jeju.jejuProject.review.command;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jeju.jejuProject.common.Command;
import co.jeju.jejuProject.review.service.ReviewService;
import co.jeju.jejuProject.review.serviceImpl.ReviewServiceImpl;
import co.jeju.jejuProject.review.vo.ReviewVO;

public class ReviewInsert implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 글작성
		ReviewService dao = new ReviewServiceImpl();
		ReviewVO vo = new ReviewVO();
		vo.setrTitle(request.getParameter("rTitle"));
		vo.setrContent(request.getParameter("rContent"));
		vo.setrWriter(request.getParameter("rWriter"));
		vo.setrDate(Date.valueOf(request.getParameter("rDate")));
		List<ReviewVO> list = new ArrayList<ReviewVO>();
		int n = dao.reviewInsert(vo);
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
