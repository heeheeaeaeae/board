package board.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardPanVO;
import board.service.BoardService;
import board.service.BoardServiceInf;

/**
 * Servlet implementation class NewBoard
 */
@WebServlet("/newBoardServlet")
public class NewBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BoardServiceInf service;   
    
    
    public NewBoard() {
        super();
        service= new BoardService();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BoardPanVO boardpanvo = new BoardPanVO();
		String bp_name = request.getParameter("bp_name");//게시판이름
		boardpanvo.setBp_name(bp_name);
		boardpanvo.setDel_yn("Y");
		boardpanvo.setMem_id((String)request.getSession().getAttribute("logInId"));
		int cnt = service.addBoardPan(boardpanvo);
		
		if(cnt==1){
			//vo타입의 boardPanlist
			List<BoardPanVO> boardPanlist=service.getBoardPanList();
			request.setAttribute("boardPanlist", boardPanlist);
		
			
			RequestDispatcher rd = request.getRequestDispatcher("board/main.jsp");
			rd.forward(request,response);
		}
	}


}
