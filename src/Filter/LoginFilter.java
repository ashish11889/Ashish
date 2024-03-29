package Filter;

import java.io.IOException;

import javax.jms.Session;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter{
	public void destroy() {
		
	}
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		HttpSession session=req.getSession();
		if(session.getAttribute("user")!=null)
		{
			chain.doFilter(req, res);
		}
		else
		{
			req.setAttribute("message", " oops the session has been Expired");
			RequestDispatcher dispatcher=request.getRequestDispatcher("Login.jsp");
    		dispatcher.forward(request,response);
        	 
		}
		
	}
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

}
