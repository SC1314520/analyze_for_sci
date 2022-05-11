<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList, java.util.List, java.text.*"%>
<%!
	static List<form> score_list = new ArrayList<form>();
	static String name,num,classroom;
	static List<String> user_list = new ArrayList<String>();
	
	class form{
		String subject;
		double score;
		form(String subject, double score){
			this.subject=subject;
			this.score=score;
		}
	}
	List<form> getScore(){
		return score_list;
	}
	%>
<%
	String list_name = request.getParameter("list_name");
	String flag = request.getParameter("flag");
	if(flag!=null){
		request.setCharacterEncoding("utf-8"); 
		String subject=request.getParameter("subject");
		String score = request.getParameter("score");
		form sc = new form(subject,Double.parseDouble(score));
		
			score_list.add(sc);
		
	} 
%>
	<% double total=0,avg=0;
  		for(form sc : getScore()) { %>	
   			<% total+=sc.score; } %>
   <%
   			user_list.add(request.getAttribute("name")+"");
   			user_list.add(request.getAttribute("num")+"");
   			user_list.add(request.getAttribute("classroom")+"");
   			user_list.add(request.getAttribute("list_name")+"");
   			
   %>
<!DOCTYPE html>
<html>
  <head>
  	<meta charset="UTF-8">
	<title><% out.println(user_list.get(3)); %></title>
	<link rel="stylesheet" href="https://unpkg.com/purecss@2.1.0/build/pure-min.css">
	 <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['table','corechart']});
      google.charts.setOnLoadCallback(drawBegin);
      function drawBegin() {
    	  drawTable();
    	  drawChart();
      }
      function drawTable() {
        var data = new google.visualization.DataTable();
        data.addColumn('string', 'Subject');
        data.addColumn('number', 'Score');
        data.addRows([
          <% for(form sc : getScore()) { %>	
          		['<%=sc.subject %>', <%=sc.score %>],
          	<% } %>
        ]);

        var table = new google.visualization.Table(document.getElementById('table_div'));
        table.draw(data, {showRowNumber: true, width: '100%', height: '100%'});
      }
      function drawChart() {
          var data = google.visualization.arrayToDataTable([
            ['SUBJECT', 'SCORE'],
            <% for(form sc : getScore()) { %>	
      		['<%=sc.subject %>', <%=sc.score %>],
      		<% } %>
          ]);
          var options = {
            title: 'Score chart'
            	
          };
          
          var piechart = new google.visualization.PieChart(document.getElementById('piechart'));
          var barchart = new google.visualization.BarChart(document.getElementById('barchart'));
          
          piechart.draw(data, options);
          barchart.draw(data, options);
          
		}
      
    </script>
</head>
  <body style="padding: 15px">
  	<form class="pure-form" method="post">
  		<legend><% out.println(user_list.get(3)); %></legend>
  		<% out.println("學生："+user_list.get(0)+"、"); %>
  		<% out.println("學號："+user_list.get(1)+"、");%>
  		<% out.println("班級："+user_list.get(2)+"<br/><p/>");%>
  		<input type="text" placeholder="請輸入項目名稱" name="subject" /><p />
  		<input type="text" placeholder="請輸入數值" name="score" />
  		<input type="hidden" value="true" name="flag" />
  		<button type="submit" class="pure-button pure-button-primary">執行</button><p/>
  		<%DecimalFormat df=new DecimalFormat("##.##"); %>
  		<%out.println("  "+"總分為："+total+" "); %>
  		<%out.println("  "+"平均為："+df.format(total/(score_list.size()))); %>
  		
  	</form>
    <div id="table_div"></div>
		<table width="100%">
    		<td width="50%">
    			<div id="piechart" style="width: 450px; height: 250px;"></div>
    		</td>
    		<td width="50%">
    			<div id="barchart" style="width: 450px; height: 250px;"></div>
    		</td>
    </table>
  </body>
</html>