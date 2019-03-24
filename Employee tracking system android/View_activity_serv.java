import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class View_activity_serv extends HttpServlet

{
    public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {
      Connection con=null;
      Statement stmt=null;
      ResultSet rs=null;
      String str=null;
      String str1=null;
      String str2=null;
      int str3;
      PrintWriter out=res.getWriter();
      try
      {
	res.setContentType("text/html");
        str3=Integer.parseInt(req.getParameter("id"));
	try
        {	
          Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	  con=DriverManager.getConnection("jdbc:odbc:moon1","scott","tiger");

        }
        catch(Exception e)
        {
          out.println("Exception is first"+e);
        }
	stmt=con.createStatement();
        rs=stmt.executeQuery("select * from activity_list where emp_id="+str3);
        out.println("<html><head><meta http-equiv=Content-Language content=en-us>");
        out.println("<meta http-equiv=Content-Type content='text/html; charset=windows-1252'>");
        out.println("<meta name=GENERATOR content='Microsoft FrontPage 4.0'><meta name=ProgId content=FrontPage.Editor.Document>");
        out.println("<title>Activity</title><base target='_sel'f></head><body bgcolor=#999966 text=#000000>");
        out.println("<p align=center><b><font color=#000000 size=6><i>Activity List</i></font>");
        out.println("</b><p align=center>&nbsp;<table border=1 cellspacing=0 width=52% align=center bordercolordark=#000000>");
        out.println("<tr><td width=50%><p align=center><font color=#000000><b>Activity_Name</b></font></td>");
        out.println("<td width=50%><p align=center><font color=#000000><b>Budgeted Hrs</b></font></td></tr>");
        while(rs.next())
        {                                      
          str1=rs.getString("activity_name");
          str2=rs.getString("budgeted_hrs");
          out.println("<tr><a href=http://localhost:8081/servlet/Activity_details_serv?st="+str1+" target=f3><td width=50%><p align=center>"+str1+"</td><td width=50%><p align=center>"+str2+"</td></tr>");

        }     
      }         
      catch(Exception j)
      {
        out.println("The exception second "+j);
      }
   }
}