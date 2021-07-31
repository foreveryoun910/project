package co.jeju.jejuProject.board.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jeju.jejuProject.board.service.BoardService;
import co.jeju.jejuProject.board.serviceImpl.BoardServiceImpl;
import co.jeju.jejuProject.board.vo.BoardVO;
import co.jeju.jejuProject.common.Command;

public class BoardList implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 전체공지조회
		BoardService dao = new BoardServiceImpl();
		List<BoardVO> list = new ArrayList<BoardVO>();
		list = dao.boardSelectList();
		request.setAttribute("list", list);		
		
		return "board/boardList";
	}

}
