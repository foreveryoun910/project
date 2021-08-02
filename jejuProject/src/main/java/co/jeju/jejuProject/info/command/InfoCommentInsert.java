package co.jeju.jejuProject.info.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jeju.jejuProject.common.Command;
import co.jeju.jejuProject.info.service.InfoService;
import co.jeju.jejuProject.info.serviceImpl.InfoServiceImpl;
import co.jeju.jejuProject.info.vo.InfoVO;

public class InfoCommentInsert implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 댓글작성
		InfoService dao = new InfoServiceImpl();
		InfoVO vo = new InfoVO();
		vo.setiNo(Integer.valueOf(request.getParameter("iNo")));
		vo.setIcContent(request.getParameter("icContent"));
		vo.setIcName(request.getParameter("icName"));
		int n = dao.infoCommentInsert(vo);
		List<InfoVO> list = new ArrayList<InfoVO>();
		list = dao.infoSelect(vo.getiNo());
		request.setAttribute("list", list);
		System.out.println(list);
		
		String page = "";
		if(n != 0) {
			page = "info/infoSelect";
		} else {
			page = "info/infoMessage";
		}
		return page;
	}

}
