package phys;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/analyze_for_sci")
public class analyze_for_sci extends HttpServlet{

	
	protected void doHandle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String num1=req.getParameter("num1");
		String err1=req.getParameter("err1");
		String num2=req.getParameter("num2");
		String err2=req.getParameter("err2");
		String method1=req.getParameter("method1");
		String s1=req.getParameter("s1");
		Double ans1 = null,ans2=null;
		if(method1.equals("+")) {
			 ans1=Double.parseDouble(num1)+Double.parseDouble(num2);
			 ans2=Math.sqrt((Math.pow(Double.parseDouble(err1), 2)) + (Math.pow(Double.parseDouble(err2), 2)));
		}
		if(method1.equals("-")) {
			 ans1=Double.parseDouble(num1)+Double.parseDouble(num2);
			 ans2=Math.sqrt((Math.pow(Double.parseDouble(err1), 2)) + (Math.pow(Double.parseDouble(err2), 2)));
		}
		if(method1.equals("*")) {
			ans1=Double.parseDouble(num1)*Double.parseDouble(num2);
			double g=(Double.parseDouble(err1)/Double.parseDouble(num1))*(Double.parseDouble(err1)/Double.parseDouble(num1));
			double h=(Double.parseDouble(err2)/Double.parseDouble(num2))*(Double.parseDouble(err2)/Double.parseDouble(num2));
			 ans2= ans1 * Math.sqrt(g + h);
			
		}
		if(method1.equals("%")) {
			ans1=Double.parseDouble(num1)/Double.parseDouble(num2);
			double g=(Double.parseDouble(err1)/Double.parseDouble(num1))*(Double.parseDouble(err1)/Double.parseDouble(num1));
			double h=(Double.parseDouble(err2)/Double.parseDouble(num2))*(Double.parseDouble(err2)/Double.parseDouble(num2));
			 ans2= ans1 * Math.sqrt(g + h);
		}
		if(method1.equals("^")) {
			 ans1=Math.pow(Double.parseDouble(num1), Double.parseDouble(s1));
			 ans2=Math.pow(Double.parseDouble(num1), Double.parseDouble(s1))*(Double.parseDouble(s1)*(Double.parseDouble(err1)/Double.parseDouble(num1)));
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
