package co.jeju.jejuProject.info.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jeju.jejuProject.common.Command;
import co.jeju.jejuProject.info.service.InfoService;
import co.jeju.jejuProject.info.serviceImpl.InfoServiceImpl;
import co.jeju.jejuProject.info.vo.InfoVO;

public class InfoUpdateForm implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 글수정 폼
		InfoService dao = new InfoServiceImpl();
		List<InfoVO> list = new ArrayList<InfoVO>();
		int n = Integer.valueOf(request.getParameter("iNo"));
		list = dao.infoSelect(n);
		request.setAttribute("info", list);
		
		return "info/infoUpdateForm";
	}

}
