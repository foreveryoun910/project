package co.jeju.jejuProject.info.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.jeju.jejuProject.common.Command;
import co.jeju.jejuProject.info.service.InfoService;
import co.jeju.jejuProject.info.serviceImpl.InfoServiceImpl;
import co.jeju.jejuProject.info.vo.InfoVO;

public class InfoRecOn implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 추천on
		InfoService dao = new InfoServiceImpl();
		HttpSession session = request.getSession();
		InfoVO vo = new InfoVO();
		vo.setiNo(Integer.valueOf(request.getParameter("iNo")));
		List<InfoVO> list = new ArrayList<InfoVO>();
		int n = dao.infoUpdate(vo);
		list = dao.infoSelectList();
		session.setAttribute("list", list);	
		
		String page = "";
		if(n != 0) {
			page = "info/infoSelect";
		} else {
			page = "info/infoMessage";
		}
		return page;
	}

}
