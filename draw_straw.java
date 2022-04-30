package draw_straw;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/draw_straw")
public class draw_straw extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out= resp.getWriter();
		String max= req.getParameter("max");
		String min= req.getParameter("min");
		String times= req.getParameter("times");
		int Max =Integer.parseInt(max);
		int Min =Integer.parseInt(min);
		int Times =Integer.parseInt(times);
		List<Integer> list= new ArrayList<Integer>();
		int i;
		for(i=Min-1;i<=Max;i++) {
			list.add(i);
		}
		System.out.println(list);
		int k,r;
		for(k=1;k<=Times;k++) {
			r=(int)(Math.random()*(list.size()-1))+Min;
			out.print("<html>");
			out.print("<head>");
			out.print("</head>");
			out.print("<body>");
			out.println("第"+k+"次抽獎結果為："+list.get(r)+"<br/>");
			out.print("</body>");
			out.print("</html>");
			list.remove(r);
			System.out.println(list);
		}
		
	}
}


