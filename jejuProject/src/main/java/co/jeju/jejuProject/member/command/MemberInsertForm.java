package co.jeju.jejuProject.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jeju.jejuProject.common.Command;

public class MemberInsertForm implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 회원가입 폼
		return "member/memberInsertForm";
	}

}
