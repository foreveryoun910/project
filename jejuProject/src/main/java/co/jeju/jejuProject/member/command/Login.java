package co.jeju.jejuProject.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.jeju.jejuProject.common.Command;
import co.jeju.jejuProject.member.service.MemberService;
import co.jeju.jejuProject.member.serviceImpl.MemberServiceImpl;
import co.jeju.jejuProject.member.vo.MemberVO;

public class Login implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 로그인
		MemberService dao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		HttpSession session = request.getSession();
		vo.setId(request.getParameter("id"));
		vo.setPassword(request.getParameter("password"));
		vo = dao.memberLogin(vo);
		
		String page = "";
		if(vo.getId() != null) {
			session.setAttribute("id", vo.getId());
			session.setAttribute("name", vo.getName());
			session.setAttribute("nickname", vo.getNickname());
			session.setAttribute("email", vo.getEmail());
			session.setAttribute("author", vo.getAuthor());
			session.setAttribute("state", vo.getState());
			request.setAttribute("message", session.getAttribute("nickname") + "님 환영합니다!");
			page = "home/home";
			
		} else {
			String message = "로그인 실패 메세지";
			request.setAttribute("message", message);
			
			page = "member/memberMessage";
		}
		
		return page;
	}

}
