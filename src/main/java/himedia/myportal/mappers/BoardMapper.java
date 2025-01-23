package himedia.myportal.mappers;

import java.util.List;
import java.util.Map;

import himedia.myportal.repositories.vo.BoardVo;

public interface BoardMapper {
//	<select id="selectAll" resultType="boardVo">
	List<BoardVo> selectAll();

//	<insert id="insert" parameterType="boardVo">
	int insert(BoardVo boardVo);
	
//	<update id="increaseHitCount" parameterType="int">
	int increaseHitCount(int no);
	
//	<select id="getContent" parameterType="int" resultType="boardVo">
	BoardVo getContent(Integer no);
	
//	<update id="update" parameterType="boardVo">
	int update(BoardVo boardVo);
	
//	<delete id="delete" parameterType="map">
	int delete(Map<String, Integer> map);
}	
