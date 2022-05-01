import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/OCE_NEW/analyze_for_sci.java")
public class analyze_for_sci extends HttpServlet{

	
	protected void doHandle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		Double num1=Double.parseDouble(req.getParameter("num1"));
		Double err1=Double.parseDouble(req.getParameter("err1"));
		Double num2=Double.parseDouble(req.getParameter("num2"));
		Double err2=Double.parseDouble(req.getParameter("err2"));
		Double method1=Double.parseDouble(req.getParameter("method1"));
		Double s1=Double.parseDouble(req.getParameter("s1"));
		Double ans1 = null,ans2=null;
		if(method1.equals("+")) {
			 ans1=num1+num2;
			 ans2=Math.sqrt((Math.pow(err1, 2)) + (Math.pow(err2, 2)));
		}
		if(method1.equals("-")) {
			 ans1=num1-num2;
			 ans2=Math.sqrt((Math.pow(err1, 2)) + (Math.pow(err2, 2)));
		}
		if(method1.equals("*")) {
			 ans1=num1*num2;
			double g=(err1/num1)*(err1/num1);
			double h=(err2/num2)*(err2/num2);
			 ans2= ans1 * Math.sqrt(g + h);
			
		}
		if(method1.equals("%")) {
			 ans1=num1+num2;
			double g=(err1/num1)*(err1/num1);
			double h=(err2/num2)*(err2/num2);
			 ans2= ans1 * Math.sqrt(g + h);
		}
		if(method1.equals("^")) {
			 ans1=Math.pow(num1, s1);
			 ans2=Math.pow(num1, s1)*(s1*(err1/num1));
		}
		PrintWriter out=resp.getWriter();
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
				+ "			<legend>不確定傳遞結果</legend>\r\n"
				+ "			真值:" + ans1 +"<br/>"+"<p/>"
				+ "			不確定度: " + ans2 + "<br />"
				+ "		</fieldset><p />"
				+ "     <button type=\"submit\" class=\"pure-button pure-button-primary\">返回</button>"
				+ "	</form>");
		out.println("</body>");
		out.println("</html>");
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doHandle(req,resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doHandle(req,resp);
	}
	
}
