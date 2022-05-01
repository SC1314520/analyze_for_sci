package phys;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/login")
public class login  extends HttpServlet{
	
	protected void doHandle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			resp.setCharacterEncoding("utf-8");
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out =resp.getWriter();
			String account=req.getParameter("account");
			String password=req.getParameter("password");
			HashMap<String,String> member=new HashMap<>();
			member.put("41041118S","41041118S");
			member.put("41041122S", "41041122S");
			member.put("41041123S","41041123S");
			if(password.equals(member.get(account))){
				out.println("<html>");
				out.println("<head>");
				out.println("<link rel=\"stylesheet\""
						+ "	href=\"https://unpkg.com/purecss@2.1.0/build/pure-min.css\">"
						+ "<meta charset=\"UTF-8\">"
						+ "<title>不確定度傳遞程式</title>");
				out.println("</head>");
				out.println("<body style=\"padding: 20px\">");
				out.println("<form class=\"pure-form\" action=\"/OCE_NEW/html/analyze.html\"> "
						+ "		<fieldset>\r\n"
						+ "			<legend></legend>\r\n"
						+ "			登入成功！！"+"<br/>"+"<p/>"
						+ "		</fieldset><p />"
						+ "     <button type=\"submit\" class=\"pure-button pure-button-primary\">繼續</button>"
						+ "	</form>");
				out.println("</body>");
				out.println("</html>");
			}
			else {
				out.println("<html>");
				out.println("<head>");
				out.println("<link rel=\"stylesheet\""
						+ "	href=\"https://unpkg.com/purecss@2.1.0/build/pure-min.css\">"
						+ "<meta charset=\"UTF-8\">"
						+ "<title>不確定度傳遞程式</title>");
				out.println("</head>");
				out.println("<body style=\"padding: 20px\">");
				out.println("<form class=\"pure-form\" action=\"/OCE_NEW/html/login.html\"> "
						+ "		<fieldset>\r\n"
						+ "			<legend></legend>\r\n"
						+ "			帳號或密碼錯誤！"+"<br/>"+"<p/>"
						+ "			請按返回鍵重新嘗試。" +  "<br />"
						+ "		</fieldset><p />"
						+ "     <button type=\"submit\" class=\"pure-button pure-button-primary\">返回</button>"
						+ "	</form>");
				out.println("</body>");
				out.println("</html>");
			}
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandle(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandle(req, resp);
	}

}
