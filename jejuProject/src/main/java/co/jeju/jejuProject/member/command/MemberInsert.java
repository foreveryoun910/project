package co.jeju.jejuProject.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.jeju.jejuProject.common.Command;
import co.jeju.jejuProject.member.service.MemberService;
import co.jeju.jejuProject.member.serviceImpl.MemberServiceImpl;
import co.jeju.jejuProject.member.vo.MemberVO;

public class MemberInsert implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 회원가입
		MemberService dao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		vo.setId(request.getParameter("id"));
		vo.setPassword(request.getParameter("password"));
		vo.setName(request.getParameter("name"));
		vo.setNickname(request.getParameter("nickname"));
		vo.setEmail(request.getParameter("email"));
		int n = dao.memberInsert(vo);

		String view;
		if(n != 0) {
			request.setAttribute("message", vo.getId() + "님 회원가입을 축하합니다.");
			view = "home/home";
		} else {
			request.setAttribute("message", "입력 실패!");
			view = "member/memberMessage";
		}
		
		return view;
	}

}
