package co.jeju.jejuProject.info.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jeju.jejuProject.common.Command;
import co.jeju.jejuProject.info.service.InfoService;
import co.jeju.jejuProject.info.serviceImpl.InfoServiceImpl;
import co.jeju.jejuProject.info.vo.InfoVO;

public class InfoDelete implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 글삭제
		InfoService dao = new InfoServiceImpl();
		InfoVO vo = new InfoVO();
		vo.setiNo(Integer.valueOf(request.getParameter("iNo")));
		int n = dao.infoDelete(vo);
		List<InfoVO> list = new ArrayList<InfoVO>();
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
