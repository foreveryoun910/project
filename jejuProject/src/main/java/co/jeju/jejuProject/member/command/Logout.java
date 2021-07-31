package co.jeju.jejuProject.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.jeju.jejuProject.common.Command;

public class Logout implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 로그아웃
		HttpSession session = request.getSession();
		String message = session.getAttribute("nickname") + "님 정상 로그아웃";
		session.removeAttribute("nickname");
		session.removeAttribute("author");
		request.setAttribute("message", message);
		
		return "member/memberMessage";
	}

}
