import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Activity_list3_serv extends HttpServlet

{
    public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {
       PrintWriter out=res.getWriter();
      
         String s1=req.getParameter("id");
         out.println("<html><head><meta http-equiv=Content-Type content='text/html; charset=windows-1252'>");
         out.println("<meta name=GENERATOR content='Microsoft FrontPage 4.0'>");
         out.println("<meta name=ProgId content=FrontPage.Editor.Document><title>Activity list</title>");
         out.println("<base target=_self></head><body bgcolor=#993333 text=#FFFFFF><ul>");
         out.println("<li><b><i><font size=5><a href=http://localhost:8081/servlet/View_activity_serv?id="+s1+" target=f3>Activity list</a></font></i></b></li>");

         out.println("<li><b><i><font size=5><a href=http://localhost:8081/update_activity(mgr).htm target=f3>Update activity</a></font></i></b></li>");
         out.println("<li><b><i><font size=5><a href=http://localhost:8081/servlet/Update_status_serv?"+s1+" target=f3>Update status</a></font></i></b></li>");
         out.println("<li><b><i><font size=5><a href=http://localhost:8081/view_report.htm target=f3>View report</a></font></i></b></li>");



         
      }
}