package himedia.myportal.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import himedia.myportal.repositories.vo.GuestbookVo;
import himedia.myportal.services.GuestbookService;

@Controller
@RequestMapping("/guestbook")
public class GuestbookController {
	private static final Logger logger = LoggerFactory.getLogger(GuestbookController.class);
	
	@Autowired
	GuestbookService guestbookServiceImpl;
	
	@GetMapping({"", "/", "/list"})
	public String list(Model model) {
		List<GuestbookVo> list = guestbookServiceImpl.getMessageList();
		model.addAttribute("list", list);
		
		return "guestbook/list";
	}
	
	@PostMapping("/write")
	public String write(@ModelAttribute GuestbookVo guestbookVo) {
		logger.debug("FORM:" + guestbookVo);
		
		boolean success = guestbookServiceImpl.writeMessage(guestbookVo);
		logger.debug("Write Result:" + success);
		
		return "redirect:/guestbook";
	}
	
	@GetMapping("/delete/{no}")
	public String deleteForm(@PathVariable("no") Integer no,  Model model) {
		model.addAttribute("no", no);
		
		return "guestbook/deleteform";
	}
	
	@PostMapping("/delete")
	public String deleteAction(@ModelAttribute GuestbookVo guestbookVo) {
		boolean success = guestbookServiceImpl.deleteMessage(guestbookVo);
		logger.debug("Delete Result:" + success);
		
		return "redirect:/guestbook";
	}
}
