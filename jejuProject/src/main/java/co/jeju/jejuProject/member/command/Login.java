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
		if(vo.getNickname() != null) {
			session.setAttribute("nickname", vo.getNickname());
			session.setAttribute("author", vo.getAuthor());
			session.setAttribute("id", vo.getId());
			
			page = "home/home";
			
		} else {
			String message = "로그인 실패 메세지";
			request.setAttribute("message", message);
			
			page = "member/memberError";
		}
		
		return page;
	}

}
