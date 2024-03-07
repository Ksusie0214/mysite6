package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestVo;

@Repository
public class GuestDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	//방명록 리스트
	public List<GuestVo> List(){
		System.out.println("GuestDao.List()");
		
		List<GuestVo> guestList = sqlSession.selectList("guest.list");
		System.out.println(guestList);
		return guestList;
	}
	
	//방명록 등록
	public int AddList(GuestVo guestVo) {
		System.out.println("GuestDao.AddList()");
		
		int count = sqlSession.insert("guest.AddList", guestVo);
		
		return count;
	}
	
	//방명록 삭제
	
	public int guestDelete(GuestVo guestVo) {
		System.out.println("GuestDao.guestDelete()");
		
		int count = sqlSession.delete("guest.delete", guestVo);
		return count;
	}

}
