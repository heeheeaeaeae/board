package board.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import board.dao.BoardDao;
import board.dao.BoardDaoInf;
import board.model.BoardPanVO;
import board.model.BoardVO;
import board.model.MemberVO;

public class BoardService implements BoardServiceInf {
	private BoardDaoInf dao;

	public BoardService() {
		dao = new BoardDao();

	}

	@Override
	public MemberVO getUser(String mem_id) {
		return dao.getUser(mem_id);
	}

	@Override
	public boolean loginProcess(String mem_id, String mem_pass) {
		boolean result = false;
		MemberVO memvo = dao.getUser(mem_id);
		if (memvo.getMem_id().equals(mem_id)
				&& memvo.getMem_pass().equals(mem_pass)) {
			result = true;
		}

		return result;
	}

	@Override
	public List<BoardPanVO> getBoardPanList() {
		return dao.getBoardPanList();
	}

	@Override
	public Map<String, Object> getBoardPageList(int page, int pageSize,
			int bp_seq) {

		Map<String, Object> resultMap = new HashMap<String, Object>();

		List<BoardVO> boardList = dao.getBoardPageList(page, pageSize, bp_seq);
		String pageNav = makePageNav(page, dao.getBoardCount(),bp_seq);

		resultMap.put("boardList", boardList);
		resultMap.put("pageNav", pageNav);

		return resultMap;
	}

	private String makePageNav(int page, int userTotalCnt,int bp_seq) {
		// userTotalCnt = 26
		// pageSize 10
		// totalPage : 3건

		// 26/10
		int pageTotalCnt = (int) Math.ceil((double) userTotalCnt / 10);

		StringBuffer pageNav = new StringBuffer();
		pageNav.append("<nav>");
		pageNav.append("	<ul class=\"pagination\">");
		pageNav.append("		<li>");
		pageNav.append("			<a href='boardServlet?bp_seq="+bp_seq+"&page=1&pageSize=10' aria-label='Previous'>");
		pageNav.append("				<span aria-hidden='true'>&laquo;</span>");
		pageNav.append("			</a>");
		pageNav.append("		</li>");

		// pageTotalCnt
		// pageTotalCnt만큼 루프를 돌리고 싶을때
		for (int i = 1; i <= pageTotalCnt; i++) {
			if (i == page)
				pageNav.append("		<li class='active'><a href='boardServlet?bp_seq="+
						bp_seq+"&page="
						+ i + "&pageSize=10'>" + i + "</a></li>");
			else
				pageNav.append("		<li><a href='boardServlet?bp_seq="+bp_seq+"&page=" + i
						+ "&pageSize=10'>" + i + "</a></li>");
		}

		pageNav.append("		<li>");
		pageNav.append("			<a href='boardServlet?bp_seq="+bp_seq+"&page=" + pageTotalCnt
				+ "&pageSize=10' aria-label='Next'>");
		pageNav.append("				<span aria-hidden='true'>&raquo;</span>");
		pageNav.append("			</a>");
		pageNav.append("		</li>");
		pageNav.append("	</ul>");
		pageNav.append("</nav>");
		return pageNav.toString();
	}

	/**
	 * 
	 * Method : getBoardCount 최초작성일 : 2018. 5. 15. 작성자 : "K.H.A" 변경이력 :
	 * 
	 * @return Method 설명 : 게시판의 전체 게시글의 수
	 */
	@Override
	public int getBoardCount() {
		return dao.getBoardCount();
	}

	@Override
	public int addBoardPan(BoardPanVO boardPanVO) {
		return dao.addBoardPan(boardPanVO);
	}

	@Override
	public int addBoard(BoardVO boardvo) {
		return dao.addBoard(boardvo);
	}
	
//	@Override
//	public Map<String, Object> getBoardPageList(int page, int pageSize,
//			int bp_seq) {
//
//		Map<String, Object> resultMap = new HashMap<String, Object>();
//
//		List<BoardVO> boardList = dao.getBoardPageList(page, pageSize, bp_seq);
//		String pageNav = makePageNav(page, dao.getBoardCount(),bp_seq);
//
//		resultMap.put("boardList", boardList);
//		resultMap.put("pageNav", pageNav);
//
//		return resultMap;
//	}
	
	
	
}
