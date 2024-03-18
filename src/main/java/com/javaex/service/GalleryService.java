package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GalleryDao;
import com.javaex.vo.GalleryVo;

@Service
public class GalleryService {
	
	@Autowired
	private GalleryDao galleryDao;
	
	//리스트
	public List<GalleryVo> exeList() {
		System.out.println("GalleryService.List()");
		List<GalleryVo> galleryList = galleryDao.List();
		
		return galleryList;
	}
	
	//리스트 등록
	public void exeAddList(GalleryVo galleryVo) {
		System.out.println("GalleryService.exeAddList()");
		
		galleryDao.AddList(galleryVo);
	}
	

}
