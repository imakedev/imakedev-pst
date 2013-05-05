package th.co.aoe.imake.pst.backoffice.ajax;

import java.util.List;

import javax.servlet.ServletContext;

import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import th.co.aoe.imake.pst.backoffice.service.PSTService;

public class PSTAjax {
	private final PSTService pstService; 
	public PSTAjax(){
		WebContext ctx = WebContextFactory.get(); 
		ServletContext servletContext = ctx.getServletContext();
    	WebApplicationContext wac = WebApplicationContextUtils.
    	getRequiredWebApplicationContext(servletContext);
    	pstService = (PSTService)wac.getBean("pstService"); 
	}   
	@SuppressWarnings("rawtypes")
	public List searchObject(String query){
		return pstService.searchObject(query);
	}
	public int executeQuery(String[] query){
		return pstService.executeQuery(query);
	} 
}
