package co.jeju.jejuProject.info.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jeju.jejuProject.common.Command;
import co.jeju.jejuProject.info.service.InfoService;
import co.jeju.jejuProject.info.serviceImpl.InfoServiceImpl;
import co.jeju.jejuProject.info.vo.InfoVO;

public class InfoUpdate implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 글수정
		InfoService dao = new InfoServiceImpl();
		InfoVO vo = new InfoVO();
		vo.setiNo(Integer.valueOf(request.getParameter("iNo")));
		vo.setiSubject(request.getParameter("iSubject"));
		vo.setiTitle(request.getParameter("iTitle"));
		vo.setiContent(request.getParameter("iContent"));
		List<InfoVO> list = new ArrayList<InfoVO>();
		int n = dao.infoUpdate(vo);
		list = dao.infoSelectList();
		request.setAttribute("list", list);
		
		String page = "";
		if(n != 0) {
			page = "info/infoList";
		} else {
			page = "info/infoMessage";
		}
		return page;
	}

}
