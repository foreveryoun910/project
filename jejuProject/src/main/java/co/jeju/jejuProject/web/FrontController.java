package co.jeju.jejuProject.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jeju.jejuProject.board.command.BoardInsert;
import co.jeju.jejuProject.board.command.BoardInsertForm;
import co.jeju.jejuProject.board.command.BoardList;
import co.jeju.jejuProject.board.command.BoardSelect;
import co.jeju.jejuProject.command.Home;
import co.jeju.jejuProject.common.Command;
import co.jeju.jejuProject.member.command.Login;
import co.jeju.jejuProject.member.command.LoginForm;
import co.jeju.jejuProject.member.command.Logout;
import co.jeju.jejuProject.member.command.MemberDelete;
import co.jeju.jejuProject.member.command.MemberInsert;
import co.jeju.jejuProject.member.command.MemberInsertForm;
import co.jeju.jejuProject.member.command.MemberList;
import co.jeju.jejuProject.member.command.MemberSelect;
import co.jeju.jejuProject.member.command.MemberUpdate;
import co.jeju.jejuProject.member.command.MemberUpdateForm;

public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<String, Command>();
       
    public FrontController() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		map.put("/home.do", new Home());
		// member
		map.put("/memberList.do", new MemberList()); // 전체회원조회
		map.put("/memberSelect.do", new MemberSelect()); // 회원정보조회
		map.put("/loginForm.do", new LoginForm()); // 로그인 폼
		map.put("/login.do", new Login()); // 로그인
		map.put("/logout.do", new Logout()); // 로그아웃
		map.put("/memberInsertForm.do", new MemberInsertForm()); // 회원가입 폼
		map.put("/memberInsert.do", new MemberInsert()); // 회원가입
		map.put("/memberUpdateForm.do", new MemberUpdateForm()); // 회원정보변경 폼
		map.put("/memberUpdate.do", new MemberUpdate()); // 회원정보변경
		map.put("/memberDelete.do", new MemberDelete()); // 회원탈퇴
		// board
		map.put("/boardList.do", new BoardList()); // 전체공지조회
		map.put("/boardSelect.do", new BoardSelect()); // 게시글상세조회
		map.put("/boardInsertForm.do", new BoardInsertForm()); // 게시글 작성 폼
		map.put("/boardInsert.do", new BoardInsert()); // 게시글 작성
//		map.put("/boardUpdateForm.do", new BoardUpdateForm()); // 게시글 수정 폼
//		map.put("/boardUpdate.do", new BoardUpdate()); // 게시글 수정
//		map.put("/boardDelete.do", new BoardDelete()); // 게시글 삭제		
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String page = uri.substring(contextPath.length());
		
		Command command = map.get(page);
		String viewPage = command.execute(request, response);
		
		if(!viewPage.endsWith(".do")) { // "home.do"
			if(!viewPage.endsWith(".jsp")) {				
				viewPage = viewPage + ".tiles"; // "home/home"
			}
		} else {
			viewPage = "/WEB-INF/views/" + viewPage; // "home/home.jsp"
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
