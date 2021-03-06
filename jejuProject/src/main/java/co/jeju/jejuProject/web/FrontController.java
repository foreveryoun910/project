package co.jeju.jejuProject.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jeju.jejuProject.board.command.BoardDelete;
import co.jeju.jejuProject.board.command.BoardInsert;
import co.jeju.jejuProject.board.command.BoardInsertForm;
import co.jeju.jejuProject.board.command.BoardList;
import co.jeju.jejuProject.board.command.BoardSelect;
import co.jeju.jejuProject.board.command.BoardUpdate;
import co.jeju.jejuProject.board.command.BoardUpdateForm;
import co.jeju.jejuProject.command.Home;
import co.jeju.jejuProject.common.Command;
import co.jeju.jejuProject.info.command.InfoCommentInsert;
import co.jeju.jejuProject.info.command.InfoDelete;
import co.jeju.jejuProject.info.command.InfoInsert;
import co.jeju.jejuProject.info.command.InfoInsertForm;
import co.jeju.jejuProject.info.command.InfoList;
import co.jeju.jejuProject.info.command.InfoRecOn;
import co.jeju.jejuProject.info.command.InfoSelect;
import co.jeju.jejuProject.info.command.InfoUpdate;
import co.jeju.jejuProject.info.command.InfoUpdateForm;
import co.jeju.jejuProject.member.command.Login;
import co.jeju.jejuProject.member.command.LoginForm;
import co.jeju.jejuProject.member.command.Logout;
import co.jeju.jejuProject.member.command.MemberDeleteAdmin;
import co.jeju.jejuProject.member.command.MemberDeleteUser;
import co.jeju.jejuProject.member.command.MemberInsert;
import co.jeju.jejuProject.member.command.MemberInsertForm;
import co.jeju.jejuProject.member.command.MemberList;
import co.jeju.jejuProject.member.command.MemberSelect;
import co.jeju.jejuProject.member.command.MemberUpdate;
import co.jeju.jejuProject.member.command.MemberUpdateForm;
import co.jeju.jejuProject.review.command.ReviewCommentDelete;
import co.jeju.jejuProject.review.command.ReviewCommentInsert;
import co.jeju.jejuProject.review.command.ReviewDelete;
import co.jeju.jejuProject.review.command.ReviewInsert;
import co.jeju.jejuProject.review.command.ReviewInsertForm;
import co.jeju.jejuProject.review.command.ReviewList;
import co.jeju.jejuProject.review.command.ReviewRecOff;
import co.jeju.jejuProject.review.command.ReviewRecOn;
import co.jeju.jejuProject.review.command.ReviewSelect;
import co.jeju.jejuProject.review.command.ReviewUpdate;
import co.jeju.jejuProject.review.command.ReviewUpdateForm;

public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<String, Command>();
       
    public FrontController() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		map.put("/home.do", new Home());
		// member
		map.put("/memberList.do", new MemberList()); // ??????????????????
		map.put("/memberSelect.do", new MemberSelect()); // ??????????????????
		map.put("/loginForm.do", new LoginForm()); // ????????? ???
		map.put("/login.do", new Login()); // ?????????
		map.put("/logout.do", new Logout()); // ????????????
		map.put("/memberInsertForm.do", new MemberInsertForm()); // ???????????? ???
		map.put("/memberInsert.do", new MemberInsert()); // ????????????
		map.put("/memberUpdateForm.do", new MemberUpdateForm()); // ?????????????????? ???
		map.put("/memberUpdate.do", new MemberUpdate()); // ??????????????????
		map.put("/memberDeleteAdmin.do", new MemberDeleteAdmin()); // ????????????(?????????)
		map.put("/memberDeleteUser.do", new MemberDeleteUser()); // ????????????(??????)
		// board
		map.put("/boardList.do", new BoardList()); // ??????????????????
		map.put("/boardSelect.do", new BoardSelect()); // ??????????????????
		map.put("/boardInsertForm.do", new BoardInsertForm()); // ?????? ?????? ???
		map.put("/boardInsert.do", new BoardInsert()); // ?????? ??????
		map.put("/boardUpdateForm.do", new BoardUpdateForm()); // ?????? ?????? ???
		map.put("/boardUpdate.do", new BoardUpdate()); // ?????? ??????
		map.put("/boardDelete.do", new BoardDelete()); // ?????? ??????
		// review
		map.put("/reviewList.do", new ReviewList()); // ??????????????? ?????????
		map.put("/reviewSelect.do", new ReviewSelect()); // ????????? , ????????? ????????? ?????????
		map.put("/reviewInsertForm.do", new ReviewInsertForm()); // ????????? ???
		map.put("/reviewInsert.do", new ReviewInsert()); // ?????????
		map.put("/reviewUpdateForm.do", new ReviewUpdateForm()); // ????????? ???
		map.put("/reviewUpdate.do", new ReviewUpdate()); // ?????????
		map.put("/reviewDelete.do", new ReviewDelete()); // ?????????
		// info
		map.put("/infoList.do", new InfoList()); // ??????????????? ?????????
		map.put("/infoSelect.do", new InfoSelect()); // ?????????
		map.put("/infoInsertForm.do", new InfoInsertForm()); // ????????? ???
		map.put("/infoInsert.do", new InfoInsert()); // ?????????
		map.put("/infoUpdateForm.do", new InfoUpdateForm()); // ????????? ???
		map.put("/infoUpdate.do", new InfoUpdate()); // ?????????
		map.put("/infoDelete.do", new InfoDelete()); // ?????????	
		
		// review comment
		map.put("/reviewCommentInsert.do", new ReviewCommentInsert()); // ????????????
//		map.put("/reviewCommentUpdate.do", new ReviewCommentUpdate()); // ????????????
		map.put("/reviewCommentDelete.do", new ReviewCommentDelete()); // ????????????
		map.put("/reviewRecOn.do", new ReviewRecOn()); // ??????on
		map.put("/reviewRecOff.do", new ReviewRecOff()); // ??????off
		// info comment
		map.put("/infoCommentInsert.do", new InfoCommentInsert()); // ????????????
//		map.put("/infoCommentUpdate.do", new InfoCommentUpdate()); // ????????????
//		map.put("/infoCommentDelete.do", new InfoCommentDelete()); // ????????????
		map.put("/infoRecOn.do", new InfoRecOn()); // ??????on
//		map.put("/infoRecOff.do", new InfoRecOff()); // ??????off
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
