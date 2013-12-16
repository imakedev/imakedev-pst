package th.co.aoe.imake.pst.backoffice.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import th.co.aoe.imake.pst.backoffice.service.PSTService;
//import org.apache.log4j.Logger;

@Controller
@RequestMapping("/")
@SessionAttributes(value={"missExamForm","systemDate","timelimit"})
public class MediatorController {
	@Autowired
	private PSTService missExamService;
	@RequestMapping(value="/user")
	public String getUserPage() {
		return "user";
	}
	
	@RequestMapping(value="/admin")
	public String getAdminPage() {
		return "admin";
	}
	@RequestMapping(value="/miss")
	public String getMissPage() {
		return "exam/index";
	}
}
