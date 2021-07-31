package co.jeju.jejuProject.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.jeju.jejuProject.common.Command;
import co.jeju.jejuProject.member.service.MemberService;
import co.jeju.jejuProject.member.serviceImpl.MemberServiceImpl;
import co.jeju.jejuProject.member.vo.MemberVO;

public class MemberDelete implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 회원탈퇴
		MemberService dao = new MemberServiceImpl();
		HttpSession session = request.getSession();
		MemberVO vo = new MemberVO();
		vo.setId(request.getParameter("id"));
		vo.setPassword(request.getParameter("password"));
		vo.setName(vo.getName());
		vo.setNickname(request.getParameter("nickname"));
		vo.setEmail(request.getParameter("email"));
		vo.setAuthor(request.getParameter("author"));
		vo.setState(request.getParameter("state"));
		int n = dao.memberDelete(vo);
		session.invalidate();
		
		String page = "";
		if(n != 0) {
			page = "home/home";
		} else {
			page = "member/memberMessage";
		}
		return page;
	}

}
