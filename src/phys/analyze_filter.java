package phys;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns= {"/analyze_for_sci"})
public class analyze_filter extends HttpFilter{

	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
			System.out.println("執行Filter");
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out =response.getWriter();
			String num1=request.getParameter("num1");
			String err1=request.getParameter("err1");
			String num2=request.getParameter("num2");
			String err2=request.getParameter("err2");	
			String s1 =request.getParameter("s1");
			String method =request.getParameter("method1");
			
		if(method!=null|| method.length()!=0) {
			if(method.equals("+")||method.equals("-")||method.equals("*")||method.equals("%")) {
				if(num1==null || num1.length()==0) {
					out.println("真值一請勿空白，請返回頁面"+"<p/>");
				}
				if(err1==null || err1.length()==0) {
					out.println("不確定度一請勿空白，請返回頁面"+"<p/>");
				}
				if(num2==null || num2.length()==0) {
					out.println("真值二請勿空白，請返回頁面"+"<p/>");
				}
				if(err2==null || err2.length()==0) {
					out.println("不確定度二請勿空白，請返回頁面"+"<p/>");
				}
				else {
					chain.doFilter(request, response);
				}
				
			}
			else if(method.equals("^")) {
				if(num1==null || num1.length()==0) {
					out.println("真值一請勿空白，請返回頁面"+"<p/>");
				}
				if(err1==null || err1.length()==0) {
					out.println("不確定度一請勿空白，請返回頁面"+"<p/>");
				}
				if(s1==null || s1.length()==0) {
					out.println("次方數請勿空白，請返回頁面"+"<p/>");
				}
				if(num2==null || num2.length()==0) {
					out.println("真值二請填0，請返回頁面"+"<p/>");
				}
				if(err2==null || err2.length()==0) {
					out.println("不確定度二請填0，請返回頁面"+"<p/>");
				}
				else {
					chain.doFilter(request, response);
				}
			}
		}
	}
	
}

