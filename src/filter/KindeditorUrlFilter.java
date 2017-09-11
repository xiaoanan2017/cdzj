package filter;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter;

/**
 * Servlet Filter implementation class KindeditorUrlFilter
 */
@WebFilter("/KindeditorUrlFilter")
public class KindeditorUrlFilter extends StrutsPrepareAndExecuteFilter{
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		HttpServletRequest request = (HttpServletRequest) req;    
        //不过滤的url    
        String url = request.getServletPath();  
        
        if ("/kindeditor-4.1.7/jsp/file_manager_json.jsp".equals(url)) {                
            chain.doFilter(req, res);
            System.out.println("11111");
        }else if("/kindeditor-4.1.7/jsp/upload_json.jsp".equals(url)){  
            chain.doFilter(req, res);  
            System.out.println("22222");
        }else{
        	super.doFilter(req, res, chain);
        	System.out.println("3333");
        }
        System.out.println(url);
	}
}
