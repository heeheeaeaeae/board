package board.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardVO;

@WebServlet("/boardInsertServlet")
public class BoardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardInsertServlet() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mem_id =(String)request.getSession().getAttribute("logInId");
		String title = request.getParameter("title");
		String content =request.getParameter("content");
		Integer bp_seq = Integer.parseInt(request.getParameter("bp_seq"));
		BoardVO boardvo= new BoardVO(null, null,  bp_seq, null,
				 title,  content,  mem_id);
		
		RequestDispatcher rd = request.getRequestDispatcher("board/board.jsp");
		rd.forward(request,response);
		
	}

}
