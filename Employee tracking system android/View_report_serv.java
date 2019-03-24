import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class View_report_serv extends HttpServlet

{
    public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {
      Connection con=null;
      Statement stmt=null;
      ResultSet rs=null;
      String str=null;
      String str1=null;
      String str2=null;
      String str3=null;
      String str4=null;
      String str5=null;
      String str6=null;
      String str7=null;
      String str8=null;
      PrintWriter out=res.getWriter();
      try
      {
	res.setContentType("text/html");
        //int str3=Integer.parseInt(req.getParameter("id"));
	try
        {	
          Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	  con=DriverManager.getConnection("jdbc:odbc:moon1","scott","tiger");

        }
        catch(Exception e)
        {
          out.println("Exception is "+e);
        }
	stmt=con.createStatement();
        //out.println("before select");
        rs=stmt.executeQuery("select * from activity_list1");
        //out.println("after select");
         
         out.println("<html><head><meta http-equiv=Content-Language content=en-us>");
         out.println("<meta name=GENERATOR content='Microsoft FrontPage 5.0'>");
          out.println("<meta name=ProgId content='FrontPage.Editor.Document'>");
          out.println("<meta http-equiv=Content-Typecontent='text/html;charset=windows-1252'>");
          out.println("<title>New Page 1</title></head><body bgcolor=#33CCCC>");
          out.println("<p align=center><i><b><font size=6>Activity details</font></b></i></p>");
          out.println("<table border=1 cellpadding=0 cellspacing=0 style='border-collapse:collapse' bordercolor=#111111 width=98% id=AutoNumber1>");
          out.println("<tr><td width=7% align=center bordercolorlight=#000000 bordercolordark=#FFFFFF>");
          out.println("<font size=4>Emp_Id</font></td>");
          out.println("<td width=18% align=center bordercolorlight=#000000 bordercolordark=#FFFFFF>");
          out.println("<font size=4>Activity_name</font></td>");
          out.println("<td width=10% align=center bordercolorlight=#000000 bordercolordark=#FFFFFF>");
          out.println("<font size=4>Budgeted_hrs</font></td>");
          out.println("<td width=10% align=center bordercolorlight=#000000 bordercolordark=#FFFFFF>");
          out.println("<font size=4>Posting_time</font></td>");
          out.println("<td width=12% align=center bordercolorlight=#000000 bordercolordark=#FFFFFF>");
          out.println("<font size=4>Starting_time</font></td>");
          out.println("<td width=11% align=center bordercolorlight=#000000 bordercolordark=#FFFFFF>");
          out.println("<font size=4>Finishing_time</font></td>");
          out.println("<td width=8% align=center bordercolorlight=#000000 bordercolordark=#FFFFFF>");
          out.println("<font size=4>Difference</font></td>");
          out.println("<td width=39% align=center bordercolorlight=#000000 bordercolordark=#FFFFFF>");
          out.println("<font size=4>Report</font></td></tr>");
          

        while(rs.next())
        { out.println("appu");
          str1=rs.getString("emp_id");                                     
          str2=rs.getString("activity_name");
          str3=rs.getString("budgeted_hrs");
          str4=rs.getString("posting_date");
          str5=rs.getString("starting_time");
          str6=rs.getString("finishing_time");
          str7=rs.getString("difference");
          str8=rs.getString("report");
          out.println("<tr><td width=7% bordercolorlight=#000000 bordercolordark=#FFFFFF>"+str1+"</td>");
          out.println("<td width=18% bordercolorlight=#000000 bordercolordark=#FFFFFF>"+str2+"</td>");
          out.println("<td width=10% bordercolorlight=#000000 bordercolordark=#FFFFFF>"+str3+"</td>");
          out.println("<td width=10% bordercolorlight=#000000 bordercolordark=#FFFFFF>"+str4+"</td>");
          out.println("<td width=12% bordercolorlight=#000000 bordercolordark=#FFFFFF>"+str5+"</td>");
          out.println("<td width=11% bordercolorlight=#000000 bordercolordark=#FFFFFF>"+str6+"</td>");
          out.println("<td width=8% bordercolorlight=#000000 bordercolordark=#FFFFFF>"+str7+"</td>");
          out.println("<td width=39% bordercolorlight=#000000 bordercolordark=#FFFFFF>"+str8+"</td>");
          out.println("</tr></table></body></html>");
      }
     }
     catch(Exception j)
     {
       out.println("The exception second "+j);
     }
   }
}