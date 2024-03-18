package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.GalleryService;
import com.javaex.vo.GalleryVo;

@Controller
public class GalleryController {
	
	@Autowired
	private GalleryService galleryService;
	
	@RequestMapping(value="/gallery/list", method = {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		System.out.println("GalleryController.list()");
		List<GalleryVo> galleryList = galleryService.exeList();
		model.addAttribute("galleryList", galleryList);
		
		return "/gallery/list";
	}
	
	@RequestMapping(value="/gallery/addlist", method = {RequestMethod.GET, RequestMethod.POST})
	public String addList(@ModelAttribute GalleryVo galleryVo) {
		System.out.println("GalleryController.addList()");
		
		galleryService.exeAddList(galleryVo);
		
		return "";
	}

}
