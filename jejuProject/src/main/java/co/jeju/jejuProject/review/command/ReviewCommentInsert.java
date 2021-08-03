package co.jeju.jejuProject.review.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jeju.jejuProject.common.Command;
import co.jeju.jejuProject.review.service.ReviewService;
import co.jeju.jejuProject.review.serviceImpl.ReviewServiceImpl;
import co.jeju.jejuProject.review.vo.ReviewVO;

public class ReviewCommentInsert implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 댓글작성
		ReviewService dao = new ReviewServiceImpl();
		ReviewVO vo = new ReviewVO();
		vo.setrNo(Integer.valueOf(request.getParameter("rNo")));
		vo.setRcContent(request.getParameter("rcContent"));
		vo.setRcName(request.getParameter("rcName"));
		int n = dao.reviewCommentInsert(vo);
		List<ReviewVO> list = new ArrayList<ReviewVO>();
		list = dao.reviewSelect(vo.getrNo());
//		System.out.println(list);
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
