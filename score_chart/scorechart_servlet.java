package score_for_jsp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/score_chart")
public class scorechart_servlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String name =req.getParameter("name");
		String num =req.getParameter("num");
		String classroom =req.getParameter("class");
		String list_name =req.getParameter("list_name");
		req.setAttribute("name", name);
		req.setAttribute("num", num);
		req.setAttribute("classroom", classroom);
		req.setAttribute("list_name", list_name);
		RequestDispatcher rd=req.getRequestDispatcher("/html/scorechart.jsp");
		rd.forward(req, resp);
	}
	
}
