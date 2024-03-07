package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BoardController {
	
	@RequestMapping(value="/board/list", method= {RequestMethod.GET, RequestMethod.POST})
	public String List() {
		System.out.println("BoardController.list()");
		
		return "/board/list";
	}
	
	@RequestMapping(value="/board/read", method= {RequestMethod.GET, RequestMethod.POST})
	public String Read() {
		System.out.println("BoardController.read()");
		
		return "/board/read";
	}
	
	@RequestMapping(value="/board/modifyform", method= {RequestMethod.GET, RequestMethod.POST})
	public String modifyForm() {
		System.out.println("BoardController.modifyForm()");
		
		return "/board/modifyForm";
	}
	
	@RequestMapping(value="/board/writeform", method= {RequestMethod.GET, RequestMethod.POST})
	public String writeForm() {
		System.out.println("BoardController.writeForm()");
		
		return"/board/writeForm";
	}

}
