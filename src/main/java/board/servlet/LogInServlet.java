package board.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.model.BoardPanVO;
import board.model.BoardVO;
import board.model.MemberVO;
import board.service.BoardService;
import board.service.BoardServiceInf;

@WebServlet("/logInServlet")
public class LogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardServiceInf service;
	
	public LogInServlet() {
        super();
        service = new BoardService();
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset = utf-8");
		
		String userId = request.getParameter("userId");
		String password= request.getParameter("password");
		
		boolean loginResult = 
				service.loginProcess(userId,password);
//		
		if(loginResult==true){
			HttpSession session = request.getSession();
			
			
			//vo타입의 boardPanlist
			List<BoardPanVO> boardPanlist=service.getBoardPanList();
			request.setAttribute("boardPanlist", boardPanlist);
			
			//로그인한 아이디를 session에 저장
			String logInId = service.getUser(userId).getMem_id();
			session.setAttribute("logInId",logInId);
			
			RequestDispatcher rd = request.getRequestDispatcher("board/main.jsp");
			rd.forward(request,response);
		}

		
		
//		MemberVO memvo = new MemberVO(request.getParameter("mem_id"));
//		System.out.println(memvo.getMem_name());
		
		
//		 HashMap<String, String> map = new HashMap<String, String>();
//	        map.put("mem_id",request.getParameter("memId"));
//	        map.put("mem_pass",request.getParameter("memPass"));
////		String memId = request.getParameter("memId");
////		String memPass =request.getParameter("memPass");
//		
//		MemberVO memvo = new MemberVO(request.getParameter("mem_id"), request.getParameter("mem_pass"));
//		memvo.setMem_id(map.get("memId"));
//		memvo.setMem_pass(map.get("memPass"));
//		
//		String name=service.getName(map);
//		HttpSession session = request.getSession();
//		
//		boolean loginResult = service.loginProcess(new UserVO("brown",userId, password));
//		
//		if(name!=null){
//			session.setAttribute("memId",name);//"memId"를 main으로 가져간다
//		RequestDispatcher rd = request.getRequestDispatcher(
//				"main.jsp");
//		rd.forward(request,response);
//		}else{
//			request.setAttribute("memId",name);//"memId"를 main으로 가져간다
//			RequestDispatcher rd = request.getRequestDispatcher(
//					"login.jsp");
//			rd.forward(request,response);
//			
//			
//		}
//	
	}

}
