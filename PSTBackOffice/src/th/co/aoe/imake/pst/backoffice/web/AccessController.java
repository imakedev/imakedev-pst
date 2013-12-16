package th.co.aoe.imake.pst.backoffice.web;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.LocaleEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.support.RequestContextUtils;

import th.co.aoe.imake.pst.backoffice.service.PSTService;

@Controller
@RequestMapping
public class AccessController {
	@Autowired
	private PSTService pstService;
	@RequestMapping("/login")
	public String login(HttpServletRequest request,HttpServletResponse response,Model model, @RequestParam(required=false) String message) {
		String language=request.getParameter("language");
    	if(language!=null && language.length()>0){
    	 LocaleEditor localeEditor = new LocaleEditor();
         localeEditor.setAsText(language);

        /* Locale locale = StringUtils.parseLocaleString("th_TH"
                 .toLowerCase());*/
         // set the new locale
         LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
         localeResolver.setLocale(request, response,
             (Locale) localeEditor.getValue());
    	}
		return "access/login";
	}
	
	@RequestMapping(value = "/denied")
 	public String denied() {
		return "access/denied";
	}
	@RequestMapping(value = "/checking")
   public String checking(Model model,HttpServletRequest request) {
		//String userid=SecurityContextHolder.getContext().getAuthentication().getName();
		int result=0;//pstService.checkMissTestResult(missTest);
		//0=not yet test finish, 1=  test finish
		//String	useragent = request.getHeader("User-Agent");
	//	String user = useragent.toLowerCase();
		/*String band="";
		 if(user.indexOf("firefox") != -1) {
			band="Firefox"; 		
		} else if(user.indexOf("chrome") != -1) {
			band="Chrome";
		} else if(user.indexOf("opera") != -1) {
			band="Opera";
		} else if(user.indexOf("safari") != -1) {
			band="Safari";
		} else if(user.indexOf("msie") != -1) {
			band="IE";
		} */ 
		 
		 
		
		if(result==1){ 
			model.addAttribute("message", "You test finish"); 
			return "access/login";
		}else
			return "redirect:/";
	}
	
	@RequestMapping(value = "/login/failure")
 	public String loginFailure(Model model) {
		String message = "Login Failure!";
		model.addAttribute("message", message);
		return "access/login";
	}
	
	@RequestMapping(value = "/logout/success")
 	public String logoutSuccess() {
		String message = "Logout Success!";
		return "redirect:/login";
	}
}