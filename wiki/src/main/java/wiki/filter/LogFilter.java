package wiki.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;

public class LogFilter implements Filter {
	
	private Logger logger = Logger.getLogger(this.getClass());

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{
		try 
		{
			chain.doFilter(request,response);
		}
		catch(Exception e)
		{
			logger.error("",e);
			throw new ServletException(e);
		}
	}

	public void destroy() {
		// TODO Auto-generated method stub

	}

}
