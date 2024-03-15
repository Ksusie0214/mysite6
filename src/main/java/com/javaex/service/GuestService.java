package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GuestDao;
import com.javaex.vo.GuestVo;

@Service
public class GuestService {
	@Autowired
	private GuestDao guestDao;
	
	//방명록 리스트
	public List<GuestVo> exeList() {
		System.out.println("GuestService.List()");
		List<GuestVo> guestList = guestDao.List();
		return guestList;
	}
	
	
	//방명록 등록
	public void exeAddList(GuestVo guestVo) {
		System.out.println("GuestService.addList()");	
		
		guestDao.AddList(guestVo);
	}
	
	//방명록 삭제
	public void exeDelete(GuestVo guestVo) {
		System.out.println("GuestService.exeDelete()");
		
		guestDao.guestDelete(guestVo);
	}
	
	//ajax 등록
	public GuestVo exeAddandGuest(GuestVo guestVo) {
		System.out.println("GuestService.exeAddandGuest()");
		
		guestDao.insertSelectKey(guestVo);
		System.out.println("후"+guestVo); //no있음
		
		GuestVo gVo = guestDao.guestSelectOne(guestVo.getNo());

		return gVo;
		
	}
	
	//ajax 삭제
	public int exeGuestDelete(GuestVo guestVo) {
		System.out.println("GuestService.exeGuestDelete()");
		System.out.println(guestVo);
		int count = guestDao.ajaxGuestDelete(guestVo);
		System.out.println(count);
		return count;
	}

}
