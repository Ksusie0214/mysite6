package com.javaex.controller.api	;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.GuestService;
import com.javaex.vo.GuestVo;

@Controller
public class ApiGuestController {
	@Autowired
	private GuestService guestService;
	
	@ResponseBody //return의 데이터를 json으로 변경해서 응답문서의 바디에 붙여보낸다
	@RequestMapping(value="/api/guestbooks", method = RequestMethod.GET)
	public List<GuestVo> list() {
			System.out.println("ApiGuestController.list()");
			
			List<GuestVo> guestList = guestService.exeList();
			System.out.println(guestList);
			
		return guestList;
	}
}
