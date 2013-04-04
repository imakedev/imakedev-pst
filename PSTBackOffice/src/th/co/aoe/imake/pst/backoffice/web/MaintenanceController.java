package th.co.aoe.imake.pst.backoffice.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value={"/maintenance"})
public class MaintenanceController {
	@RequestMapping(value={"/init"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
	 public String init(Model model)
	    {
	       // return "backoffice/template/maintenance_check_search";
		  return "backoffice/template/empty";
	    }
	@RequestMapping(value={"/page/{pagename}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
	 public String page(Model model,@PathVariable String pagename)
	    {
	       return "backoffice/template/"+pagename;
		 // return "backoffice/template/empty";
	    }
}
