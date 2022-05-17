package score_for_jsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns= {"/score_chart"})
public class score_chart_filter extends HttpFilter{
	
	private List<Integer> verify =new ArrayList<>();
	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println(verify.size());
		if(verify.size()==0) {
		System.out.println("執行filter");
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out =res.getWriter();
		String name=req.getParameter("name");
		String num =req.getParameter("num");
		String classroom =req.getParameter("class");
		String list_name =req.getParameter("list_name");
		if(name==null||name.length()==0) {
			out.println("名字欄位不可空白,請返回頁面 <p/>");
		}
		if(num==null||num.length()==0) {
			out.println("學號欄位不可空白,請返回頁面<p/>");
		}
		if(classroom==null||classroom.length()==0) {
			out.println("班級欄位不可空白,請返回頁面<p/>");
		}
		if(list_name==null||list_name.length()==0) {
			out.println("表單名稱欄位不可空白,請返回頁面<p/>");
		}
		else {
			verify.add(0);
			System.out.println(verify);
			System.out.println(verify.size());
			chain.doFilter(req, res);
			
		}
		
	}
		else {
			chain.doFilter(req, res);
		}
}
	
}
