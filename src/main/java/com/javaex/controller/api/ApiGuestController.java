package com.javaex.controller.api	;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	//등록
	@ResponseBody
	@RequestMapping(value="/api/guestbooks", method= RequestMethod.POST)
	public GuestVo add(@RequestBody GuestVo guestVo) {
		System.out.println("ApiGuestController.add()");
		
		GuestVo gVo= guestService.exeAddandGuest(guestVo);
		System.out.println(gVo);
		return gVo;
	}
	
	//삭제
	@ResponseBody
	@RequestMapping(value="/api/guestbooks/delete/{no}", method = RequestMethod.DELETE)
	public int delete(@PathVariable("no") int no, @ModelAttribute GuestVo guestVo) {
		System.out.println("ApiGuestController.delete()");
		System.out.println(no);
		
		int count = guestService.exeGuestDelete(guestVo);
		System.out.println(count);
		return count;
	}
	
	
}
