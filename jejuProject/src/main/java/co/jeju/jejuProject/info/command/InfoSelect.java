package co.jeju.jejuProject.info.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jeju.jejuProject.common.Command;
import co.jeju.jejuProject.info.service.InfoService;
import co.jeju.jejuProject.info.serviceImpl.InfoServiceImpl;
import co.jeju.jejuProject.info.vo.InfoVO;

public class InfoSelect implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 글조회
		InfoService dao = new InfoServiceImpl();
		InfoVO vo = new InfoVO();
		vo.setiNo(Integer.valueOf(request.getParameter("iNo")));
		vo = dao.infoSelect(vo);
		request.setAttribute("info", vo);
		
		return "info/infoSelect";
	}

}
