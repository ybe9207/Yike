package yk.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import yk.bean.User;

/**
 * 问题：购买、个人账户、个人的购物车三个超链接都不能单击？因为不知道找哪一个用户的信息？

   解决方案：登录过滤器
   
   处理用户登录的过滤器
   
 *
 */
public class LoginFilter implements Filter {
	private FilterConfig filterConfig = null;
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

	   HttpServletRequest req = (HttpServletRequest)request;
	   HttpServletResponse res = (HttpServletResponse) response;
	   HttpSession session  = req.getSession(false);
	   String user = (String) session.getAttribute("user");
		   if(user == null){
			   String path = this.filterConfig.getServletContext().getContextPath()+"/backlogin.jsp";

			   res.sendRedirect(path);
		   }else{

			   chain.doFilter(req, res);
		   }
	   }
	   
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}
	public void destroy() {
	}


}
