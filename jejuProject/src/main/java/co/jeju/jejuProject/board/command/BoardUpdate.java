package co.jeju.jejuProject.board.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jeju.jejuProject.board.service.BoardService;
import co.jeju.jejuProject.board.serviceImpl.BoardServiceImpl;
import co.jeju.jejuProject.board.vo.BoardVO;
import co.jeju.jejuProject.common.Command;

public class BoardUpdate implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 게시글 수정
		BoardService dao = new BoardServiceImpl();
		BoardVO vo = new BoardVO();
		vo.setbNo(Integer.valueOf(request.getParameter("bNo")));
		vo.setbTitle(request.getParameter("bTitle"));
		vo.setbContent(request.getParameter("bContent"));
		List<BoardVO> list = new ArrayList<BoardVO>();
		int n = dao.boardUpdate(vo);
		list = dao.boardSelectList();
		request.setAttribute("list", list);		
		
		String page = "";
		if(n != 0) {
			page = "board/boardList";
		} else {
			page = "board/boardMessage";
		}
		return page;
	}

}
