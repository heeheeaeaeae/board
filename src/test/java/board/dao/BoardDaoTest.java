package board.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import board.model.BoardPanVO;
import board.model.BoardVO;
import board.model.MemberVO;

public class BoardDaoTest {

	

	@Test
	public void getUserTest() {
		/***Given***/
		BoardDaoInf dao = new BoardDao();
		MemberVO memvo = new MemberVO();
		
		/***When***/
		
		memvo=dao.getUser("sally");
		
		

		/***Then***/
		
		assertNotNull(memvo);
		assertEquals("1234456", memvo.getMem_pass());
	}
	
	@Test
	public void getBoardPanListTest(){
		/***Given***/
		BoardDaoInf dao = new BoardDao();
		/***When***/
		List<BoardPanVO> list = dao.getBoardPanList();
		/***Then***/
		assertEquals("공지사항", list.get(0).getBp_name());
		assertEquals(4, list.size());
	}
	
	
	@Test
	public void addBoardPanTest(){
		/***Given***/
		BoardDaoInf dao = new BoardDao();
		BoardPanVO boardpanvo = new BoardPanVO();
		/***When***/
		
		boardpanvo.setBp_name("경조게시판");
		boardpanvo.setDel_yn("Y");
		boardpanvo.setMem_id("sally");
		
		int cnt = dao.addBoardPan(boardpanvo);
		
		/***Then***/
		
		assertEquals(1, cnt);

	}
	@Test
	public void addBoard(){
		/***Given***/
		BoardDaoInf dao = new BoardDao();
		BoardVO boardvo = new BoardVO();
		
		//boardvo.setBoard_seq(12);
		boardvo.setBp_seq(1);
//		boardvo.setPboard_seq();
//		boardvo.setGroup_seq(12);
		boardvo.setTitle("12번글입니다.");
		boardvo.setContent("나는야 12번쨩");
		boardvo.setDel_yn("N");
		boardvo.setMem_id("sally");
		/***When***/
		
		int cnt =dao.addBoard(boardvo);

		/***Then***/
		assertEquals(1, cnt);

	}
}
