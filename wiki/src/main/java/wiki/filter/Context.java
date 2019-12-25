package wiki.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Context 
{
    private static ThreadLocal<Context> instance = new ThreadLocal<Context>();  
    private HttpServletRequest request;
    private HttpServletResponse response;
    
    private Context(HttpServletRequest request,HttpServletResponse response) 
    {  
         this.request = request;
         this.response=response;
    }
    
    public static Context getCurrentInstance() 
    {  
         return instance.get();  
    }  
    
    public static Context newInstance(HttpServletRequest request,HttpServletResponse response) 
    {  
         Context context = new Context(request,response);  
         instance.set(context);  
         return context;  
    }
    
    public void release() 
    {  
         instance.remove();  
    }
    
    public HttpServletRequest getRequest() 
    {  
         return request;  
    }
    
    public HttpServletResponse getResponse()
    {
    	return response;
    }
}
