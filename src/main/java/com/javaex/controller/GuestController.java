package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.GuestService;
import com.javaex.vo.GuestVo;

@Controller
public class GuestController {
	@Autowired
	private GuestService guestService;
	
	@RequestMapping(value="/guest/list", method = {RequestMethod.GET, RequestMethod.POST})
	public String List(Model model) {
		System.out.println("GuestController.List()");
		
		List<GuestVo> guestList = guestService.exeList();
		model.addAttribute("guestList", guestList);
		
		return "/guestbook/addList";
	}
	@RequestMapping(value="/guest/addlist", method= {RequestMethod.GET, RequestMethod.POST})
	public String addList(@ModelAttribute GuestVo guestVo) {
		System.out.println("GuestController.addList()");
		
		guestService.exeAddList(guestVo);
		
		return "redirect:/guest/list";
	}
	
	@RequestMapping(value="/guest/deleteform", method = {RequestMethod.GET, RequestMethod.POST})
	public String deleteForm() {
		System.out.println("GuestController.deleteForm()");
		
		return "/guestbook/deleteForm";
	}
	
	@RequestMapping(value="/guest/delete", method = {RequestMethod.GET, RequestMethod.POST})
	public String delete(@ModelAttribute GuestVo guestVo) {
		System.out.println("GuestController.delete()");
		
		guestService.exeDelete(guestVo);
		
		return "redirect:/guest/list";
	}

}
