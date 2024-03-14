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
	
	//ajax 방명록 등록
	
	public int insertSelectKey(GuestVo guestVo) {
		System.out.println("GuestDao.insertSelectKey()");
		System.out.println(guestVo);
		
		int count = sqlSession.insert("guest.insertSelectKey",guestVo);
		System.out.println(guestVo);
		guestVo.getNo();
		
		GuestVo gVo = sqlSession.selectOne("guest.selectOne", guestVo.getNo());
		System.out.println(gVo);
		
		return count;
	}
	
	//데이터 1개 가져오기
	
	public GuestVo guestSelectOne(int no) {
		
		GuestVo guestVo = sqlSession.selectOne("guest.selectOne", no);
		System.out.println(guestVo);
		
		return guestVo;
	}
	
	//데이터 삭제하기
	
	public int ajaxGuestDelete(GuestVo guestVo) {
		System.out.println("GuestDao.ajaxGuestDelete()");
		int count = sqlSession.delete("guest.delete", guestVo);
		System.out.println(count);
		return count;
	}

}
