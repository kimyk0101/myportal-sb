package himedia.myportal.repositories;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import himedia.myportal.exceptions.UserDaoException;
import himedia.myportal.mappers.UserMapper;
import himedia.myportal.repositories.vo.UserVo;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public int insert(UserVo userVo) {		
		try {
			return userMapper.insert(userVo);
		} catch (Exception e) {
			throw new UserDaoException("회원가입 중 오류", userVo);
		}
	}
	/*
	@Override
	public int insert(UserVo userVo) {		
		int count = 0;
		try {
			count = userMapper.insert(userVo);
		} catch (Exception e) {
			throw new UserDaoException("회원가입 중 오류", userVo);
		}
		return count;
	}
	*/

	//	중복 체크용
	@Override
	public UserVo selectUser(String email) {
		UserVo userVo = userMapper.selectUserByEmail(email);
		return userVo;
	}

	//	로그인용
	@Override
	public UserVo selectUser(String email, String password) {
		Map<String, String> userMap = new HashMap<>();
		userMap.put("email", email);
		userMap.put("password", password);
		
		UserVo userVo = userMapper.selectUserByEmailAndPassword(userMap);
		return userVo;
	}

}
