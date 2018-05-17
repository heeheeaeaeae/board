package board.dao;

import java.util.List;

import board.model.BoardPanVO;
import board.model.BoardVO;
import board.model.MemberVO;

public interface BoardDaoInf {
	
	public MemberVO getUser(String mem_id);
	
	/**
	 * 
	 * Method : getBoardName
	 * 최초작성일 : 2018. 5. 14.
	 * 작성자 : "K.H.A"
	 * 변경이력 :
	 * @return
	 * Method 설명 : 게시판 이름을 가져오는 메서드
	 */
	public List<BoardPanVO> getBoardPanList();
	
	/**
	 * 
	 * Method : getBoardPageList
	 * 최초작성일 : 2018. 5. 15.
	 * 작성자 : "K.H.A"
	 * 변경이력 :
	 * @return
	 * Method 설명 : page
	 */
	public List<BoardVO> getBoardPageList(int page, int pageSize,int bp_seq);

	/**
	 * 
	 * Method : getBoardCount
	 * 최초작성일 : 2018. 5. 15.
	 * 작성자 : "K.H.A"
	 * 변경이력 : 게시판 글수
	 * @return
	 * Method 설명 :
	 */
	public int getBoardCount();
	
	/**
	 * 
	 * Method : addBoard
	 * 최초작성일 : 2018. 5. 16.
	 * 작성자 : "K.H.A"
	 * 변경이력 :
	 * @return
	 * Method 설명 : 게시판추가
	 */
	public int addBoardPan(BoardPanVO boardPanVO);
	
	/**
	 * 
	 * Method : addBoard
	 * 최초작성일 : 2018. 5. 16.
	 * 작성자 : "K.H.A"
	 * 변경이력 :
	 * @param boardvo
	 * @return
	 * Method 설명 : 게시글추가
	 */
	public int addBoard(BoardVO boardvo);
}
