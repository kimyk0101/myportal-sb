package himedia.myportal.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import himedia.myportal.exceptions.BoardDaoException;
import himedia.myportal.mappers.BoardMapper;
import himedia.myportal.repositories.vo.BoardVo;

@Repository
public class BoardDaoImpl implements BoardDao {
	@Autowired 
	private BoardMapper boardMapper;
	
	@Override
	public List<BoardVo> selectAll() {
		List<BoardVo> list = boardMapper.selectAll();
		return list;
	}

	@Override
	public int insert(BoardVo boardVo) {
		try {
			return boardMapper.insert(boardVo);
		} catch (Exception e) {
			throw new BoardDaoException("게시물 입력 중 예외 발생", boardVo);
		}
	}

	@Override
	public BoardVo getContent(Integer no) {
		return boardMapper.getContent(no);
	}

	@Override
	public int update(BoardVo boardVo) {
		return boardMapper.update(boardVo);
	}

	@Override
	public int delete(Integer no, Integer userNo) {
		Map<String, Integer> map = new HashMap<>();
		map.put("no", no);
		map.put("userNo", userNo);
		
		return boardMapper.delete(map);
	}

}