package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GalleryVo;

@Repository
public class GalleryDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<GalleryVo> List(){
		System.out.println("GalleryDao.List()");
		
		List<GalleryVo> galleryList = sqlSession.selectList("gallery.List");
		System.out.println(galleryList);
		
		return galleryList;
	}
	
	public int AddList(GalleryVo galleryVo) {
		System.out.println("GalleryDao.AddList()");
		
		int count = sqlSession.insert("gallery.AddList", galleryVo);
		return count;
	}

}
