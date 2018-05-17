package board.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import board.model.BoardPanVO;
import board.model.BoardVO;
import board.model.MemberVO;

public interface BoardServiceInf {
	/**
	 * 
	 * Method : logInCheck
	 * 최초작성일 : 2018. 5. 11.
	 * 작성자 : "K.H.A"
	 * 변경이력 :
	 * @param boardvo
	 * @return
	 * Method 설명 : 로그인
	 */
	public MemberVO getUser(String mem_id);
	
	public boolean loginProcess(String mem_id ,String mem_pass);
	
	/**
	 * 
	 * Method : getBoardPanList
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
	public Map<String, Object> getBoardPageList(int page, int pageSize,int bp_seq);
	
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
