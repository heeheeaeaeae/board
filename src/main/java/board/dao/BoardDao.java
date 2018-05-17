package board.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import board.model.BoardPanVO;
import board.model.BoardVO;
import board.model.MemberVO;

public class BoardDao implements BoardDaoInf {
	private SqlSessionFactory sqlSessionFactory; 
	
	public BoardDao(){
		String resource = "db/mybatis/mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public MemberVO getUser(String mem_id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		MemberVO memvo = sqlSession.selectOne("user.getUser", mem_id);
		sqlSession.close();
		
		return memvo;
	}

	@Override
	public List<BoardPanVO> getBoardPanList() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<BoardPanVO> list = sqlSession.selectList("board.getBoardPanList");
		sqlSession.close();
		
		return list;
	}

	@Override
	public List<BoardVO> getBoardPageList(int page, int pageSize,int bp_seq) {
		Map<String, Integer> paramMap = new HashMap<String, Integer>(); 
		paramMap.put("page", page);
		paramMap.put("pageSize", pageSize);
		paramMap.put("bp_seq", bp_seq);
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<BoardVO> boardList = sqlSession.selectList("board.getBoardPageList", paramMap);
		sqlSession.close();
		
		return boardList;
	}

	@Override
	public int getBoardCount() {
		SqlSession sqlSession =sqlSessionFactory.openSession();
		int boardCount = sqlSession.selectOne("board.getBoardCount");
		sqlSession.close();
		return boardCount;
	}

	@Override
	public int addBoardPan(BoardPanVO boardPanVO) {
		SqlSession sqlSession =sqlSessionFactory.openSession();
		int addCont =sqlSession.insert("board.addBoard",boardPanVO);
		sqlSession.commit();
		sqlSession.close();
		return addCont;
	}

	@Override
	public int addBoard(BoardVO boardvo) {
		SqlSession sqlSession =sqlSessionFactory.openSession();
		int addCont =sqlSession.insert("board.addBoard",boardvo);
		sqlSession.commit();
		sqlSession.close();
		return addCont;
	}
}
