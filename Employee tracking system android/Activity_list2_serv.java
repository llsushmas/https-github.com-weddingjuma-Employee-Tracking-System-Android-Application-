import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Activity_list2_serv extends HttpServlet

{
    public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {
       PrintWriter out=res.getWriter();
       int s1=Integer.parseInt(req.getParameter("id"));
       out.println("<html><head><meta http-equiv='Content-Language' content='en-us'>");
       out.println("<meta http-equiv='Content-Type' content='text/html; charset=windows-1252'>");
       out.println("<meta name='GENERATOR' content='Microsoft FrontPage 4.0'>");
       out.println("<meta name='ProgId' content='FrontPage.Editor.Document'>");
       out.println("<title>Activity list</title><base target='_self'></head><body bgcolor=#999966>");
       out.println("<ul><li><font size=5><b><a href=http://localhost:8081/servlet/View_activity_serv?id="+s1+" target=f3>Activity list</a></b></font></li>");

       out.println("<li><font size=5><b><a href=http://localhost:8081/update_activity(mgr).htm target=f3>Update activity</a></b></font></li>");
       out.println("<li><font size=5><b><a href=http://localhost:8081/servlet/Update_status_serv?id="+s1+" target=f3>Update status</a></b></font></li>");
       out.println("<li><font size=5><b><a href=file:///c:/aparajita/proj_design/view_report.htm target=f3>View report</a></b></font></li>");
       

         
      }
}