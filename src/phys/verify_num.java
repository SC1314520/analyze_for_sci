package phys;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/verify_num")
public class verify_num extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		String id=req.getParameter("id");
		String num=req.getParameter("verify");
		String[] str= (id.split(""));
		System.out.println(Arrays.deepToString(str));
		int k = (Integer.parseInt(str[1])*8+Integer.parseInt(str[2])*7+Integer.parseInt(str[3])*6+Integer.parseInt(str[4])*5+Integer.parseInt(str[5])*4+Integer.parseInt(str[6])*3+Integer.parseInt(str[7])*2+Integer.parseInt(str[8])*1+Integer.parseInt(str[9])*1);
		if(str[0].equals("A")) {
			k=k+1*1+0*9;
		}
		if(str[0].equals("B")) {
			k=k+1*1+1*9;
		}
		if(str[0].equals("C")) {
			k=k+1*1+2*9;
		}
		if(str[0].equals("D")) {
			k=k+1*1+3*9;
		}
		if(str[0].equals("E")) {
			k=k+1*1+4*9;
		}
		if(str[0].equals("F")) {
			k=k+1*1+5*9;
		}
		if(str[0].equals("G")) {
			k=k+1*1+6*9;
		}
		if(str[0].equals("H")) {
			k=k+1*1+7*9;
		}
		if(str[0].equals("J")) {
			k=k+1*1+8*9;
		}
		if(str[0].equals("K")) {
			k=k+1*1+9*9;
		}
		if(str[0].equals("L")) {
			k=k+2*1+0*9;
		}
		if(str[0].equals("M")) {
			k=k+2*1+1*9;
		}
		if(str[0].equals("N")) {
			k=k+2*1+2*9;
		}
		if(str[0].equals("P")) {
			k=k+2*1+3*9;
		}
		if(str[0].equals("Q")) {
			k=k+2*1+4*9;
		}
		if(str[0].equals("R")) {
			k=k+2*1+5*9;
		}
		if(str[0].equals("S")) {
			k=k+2*1+6*9;
		}
		if(str[0].equals("T")) {
			k=k+2*1+7*9;
		}
		if(str[0].equals("U")) {
			k=k+2*1+8*9;
		}
		if(str[0].equals("V")) {
			k=k+2*1+9*9;
		}
		if(str[0].equals("W")) {
			k=k+3*1+0*9;
		}
		if(str[0].equals("X")) {
			k=k+3*1+1*9;
		}
		if(str[0].equals("Y")) {
			k=k+3*1+2*9;
		}
		if(str[0].equals("Z")) {
			k=k+3*1+3*9;
		}
		if(str[0].equals("I")) {
			k=k+3*1+4*9;
		}
		if(str[0].equals("O")) {
			k=k+3*1+5*9;
		}
		if(str[0].equals("N")) {
			k=k+1*1+0*9;
		}
		int l= Integer.parseInt(num);
		if(l==k*123456) {
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
		
	}

}
