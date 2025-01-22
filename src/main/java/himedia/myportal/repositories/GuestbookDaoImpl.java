package himedia.myportal.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import himedia.myportal.exceptions.GuestbookDaoException;
import himedia.myportal.mappers.GuestbookMapper;
import himedia.myportal.repositories.vo.GuestbookVo;

@Repository
public class GuestbookDaoImpl implements GuestbookDao {
	@Autowired
	private GuestbookMapper guestbookMapper;
	
	@Override
	public List<GuestbookVo> selectAll() {
		List<GuestbookVo> list = guestbookMapper.selectAll();
		return list;
	}

	@Override
	public int insert(GuestbookVo vo) {
		int insertedCount = 0;
		
		try { 
			insertedCount = guestbookMapper.insert(vo);
		} catch (Exception e) {
			throw new GuestbookDaoException("방명록 기록 중 에러 발생", vo);
		}
		
		return insertedCount;
	}

	@Override
	public int delete(GuestbookVo vo) {
		int deletedCount = 0;
		
		try {
			deletedCount = guestbookMapper.delete(vo);
		} catch (Exception e) {
			throw new GuestbookDaoException("방명록 삭제 중 에러 발생", vo);
		}
		return deletedCount;
	}
	
}
