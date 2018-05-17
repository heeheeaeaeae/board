package board.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardPanVO;
import board.model.BoardVO;
import board.service.BoardService;
import board.service.BoardServiceInf;

@WebServlet("/boardServlet")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<BoardVO> boardlist;
	private BoardServiceInf service;

	public BoardServlet() {
		super();
		boardlist = new ArrayList<BoardVO>();
		service = new BoardService();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int bp_seq = Integer.parseInt(request.getParameter("bp_seq"));
		
		String pageString = request.getParameter("page");
		int page = pageString == null ? 1 : Integer.parseInt(pageString);

		String pageSizeString = request.getParameter("pageSize");
		int pageSize = pageSizeString == null ? 10 : Integer
				.parseInt(pageSizeString);

		
		Map<String, Object> resultMap = service.getBoardPageList(page,
				pageSize,bp_seq);
		
		
		//vo타입의 boardPanlist
		List<BoardPanVO> boardPanlist=service.getBoardPanList();
		request.setAttribute("boardPanlist", boardPanlist);
		
		request.setAttribute("boardList", resultMap.get("boardList"));
		request.setAttribute("pageNav", resultMap.get("pageNav"));
		request.setAttribute("bp_seq", bp_seq);

		// forword
		RequestDispatcher rd = request
				.getRequestDispatcher("/board/board.jsp");
		rd.forward(request, response);
		// request.setAttribute( , boardvo.getBp_seq());

	}

}
