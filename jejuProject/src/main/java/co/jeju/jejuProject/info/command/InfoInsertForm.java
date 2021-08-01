package co.jeju.jejuProject.info.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jeju.jejuProject.common.Command;

public class InfoInsertForm implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 글작성 폼
		return "info/infoInsertForm";
	}

}
