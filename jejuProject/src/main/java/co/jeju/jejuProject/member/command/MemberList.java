package co.jeju.jejuProject.member.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jeju.jejuProject.common.Command;
import co.jeju.jejuProject.member.service.MemberService;
import co.jeju.jejuProject.member.serviceImpl.MemberServiceImpl;
import co.jeju.jejuProject.member.vo.MemberVO;

public class MemberList implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 멤버전체조회(관리자)
		MemberService dao = new MemberServiceImpl();
		List<MemberVO> list = new ArrayList<MemberVO>();
		list = dao.memberSelectList();
		request.setAttribute("list", list);
		
		return "member/memberList";
	}

}
