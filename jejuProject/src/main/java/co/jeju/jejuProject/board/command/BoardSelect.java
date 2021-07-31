package co.jeju.jejuProject.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jeju.jejuProject.board.service.BoardService;
import co.jeju.jejuProject.board.serviceImpl.BoardServiceImpl;
import co.jeju.jejuProject.board.vo.BoardVO;
import co.jeju.jejuProject.common.Command;

public class BoardSelect implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 게시글상세조회
		BoardService dao = new BoardServiceImpl();
		BoardVO vo = new BoardVO();
		vo.setbNo(Integer.valueOf(request.getParameter("bNo")));
		vo = dao.boardSelect(vo);
		request.setAttribute("board", vo);
		
		return "board/boardSelect";
	}

}
