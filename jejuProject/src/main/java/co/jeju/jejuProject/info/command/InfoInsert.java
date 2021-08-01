package co.jeju.jejuProject.info.command;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jeju.jejuProject.common.Command;
import co.jeju.jejuProject.info.service.InfoService;
import co.jeju.jejuProject.info.serviceImpl.InfoServiceImpl;
import co.jeju.jejuProject.info.vo.InfoVO;

public class InfoInsert implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 글작성
		InfoService dao = new InfoServiceImpl();
		InfoVO vo = new InfoVO();
		vo.setiSubject(request.getParameter("iSubject"));
		vo.setiTitle(request.getParameter("iTitle"));
		vo.setiContent(request.getParameter("iContent"));
		vo.setiWriter(request.getParameter("iWriter"));
		vo.setiDate(Date.valueOf(request.getParameter("iDate")));
		List<InfoVO> list = new ArrayList<InfoVO>();
		int n = dao.infoInsert(vo);
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
