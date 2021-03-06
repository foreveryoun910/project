package co.jeju.jejuProject.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jeju.jejuProject.common.Command;
import co.jeju.jejuProject.member.service.MemberService;
import co.jeju.jejuProject.member.serviceImpl.MemberServiceImpl;
import co.jeju.jejuProject.member.vo.MemberVO;

public class MemberUpdateForm implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 회원정보변경 폼
		MemberService dao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		vo.setId(request.getParameter("id"));
		vo = dao.memberSelect(vo);
		request.setAttribute("member", vo);
		
		return "member/memberUpdateForm";
	}

}
