import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Activity_list1_serv extends HttpServlet

{
    public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {
       PrintWriter out=res.getWriter();
      /*Connection con=null;
      Statement stmt=null;
      ResultSet rs=null;
      //ResultSet rs2=null;
      String str=null;
      String str1=null;
      PrintWriter out=res.getWriter();
      try
      {
	res.setContentType("text/html");
	try
        {	
          Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	  con=DriverManager.getConnection("jdbc:odbc:moon1","scott","tiger");
        }
        catch(Exception e)
        {
          out.println("Exception is"+e);
        }
	stmt=con.createStatement();
        //rs=stmt.executeQuery("select * from Login where Emp_id='"+n+"'");
	
	if(rs.next())
        {*/
         
int s1=Integer.parseInt(req.getParameter("id"));
         out.println("<html><head><meta http-equiv=Content-Language content=en-us>");
	 out.println("<meta http-equiv=Content-Type content=text/html; charset=windows-1252>");
	 out.println("<meta name=GENERATOR content=Microsoft FrontPage 4.0>");
         out.println("<meta name=ProgId content=FrontPage.Editor.Document>");
         out.println("<title>Activity list</title><base target=_self></head><body bgcolor=#996633 text=#FFFFFF>");
         out.println("<ul><li><i><b><a href=http://localhost:8081/servlet/View_activity_serv?id="+s1+" target=f3><font size=5>Activity list</font></a></b></i></li>");
         
         out.println("<li><i><b><a href=http://localhost:8081/update_activity(mgr).htm target=f3><font size=5>Update activity</font></a></b></i></li>");
         out.println("<li><i><b><a href=http://localhost:8081/servlet/Update_status_serv?id="+s1+" target=f3><font size=5>Update status</font></a></b></i></li>");
         out.println("<li><i><b><a href=http://localhost:8081/View_report.htm target=f3><font size=5>View report</font></a></b></i></li>");
         out.println("<li><i><b><a href=http://localhost:8081/registration.htm target=f3><font size=5>Registration</font></a></b></i></li>");
	 out.println("<li><i><b><font size=5><a href=http://localhost:8081/project_details.htm target=f3>Project details</a></font></b></i></li>");
         out.println("<form><input type=hidden name=id value="+s1+">");
         out.println("</ul></body></html>");
      }
}