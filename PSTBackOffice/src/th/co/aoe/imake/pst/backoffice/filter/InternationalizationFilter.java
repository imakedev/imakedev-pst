package th.co.aoe.imake.pst.backoffice.filter;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.LocaleEditor;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.util.WebUtils;

public class InternationalizationFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		final String newLocale = request.getParameter("language");
		//System.out.println("into doFilter="+newLocale);
	    if (newLocale != null) {
	       /* final Locale locale = StringUtils.parseLocaleString(newLocale
	                .toLowerCase());
	    	System.out.println(" locale="+locale.getDisplayLanguage());
	        LocaleContextHolder.setLocale(locale,true);
	        
	        System.out.println(" locale2="+ LocaleContextHolder.getLocale().getDisplayLanguage());*/
	        
	        // work --> if in controller
	       /* LocaleEditor localeEditor = new LocaleEditor();
            localeEditor.setAsText(newLocale);

            // set the new locale
            LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
            localeResolver.setLocale(request, response,
                (Locale) localeEditor.getValue()); */

	    }
	    try {
	        filterChain.doFilter(request, response);
	    }catch (Exception e) {
			// TODO: handle exception
	    	e.printStackTrace();
		}finally {
	     //   LocaleContextHolder.resetLocaleContext();
	    }

	}


}
