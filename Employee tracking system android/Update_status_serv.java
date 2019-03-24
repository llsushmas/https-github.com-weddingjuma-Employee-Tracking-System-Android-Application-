import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Update_status_serv extends HttpServlet

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
        //rs=stmt.executeQuery("select * from activity_list where emp_id="+str3);<html>

        out.println("<html><head><meta http-equiv=Content-Language content=en-us>");
	out.println("<meta http-equiv=Content-Type content='text/html; charset=windows-1252'>");
	out.println("<meta name=GENERATOR content='Microsoft FrontPage 4.0'>");
	out.println("<meta name=ProgId content=FrontPage.Editor.Document><title>Update Status</title>");
	out.println("</head><body bgcolor=#666699><form method=POST action=http://localhost:8081/servlet/Updatestatus?id="+str3+">");
	out.println("<p align=center><b><i><font size=7 color=#FFFFFF>Update Status</font></i></b></p>");
	out.println("<p align=center>&nbsp;</p><p align=center><b><i><font size=5 color=#FFFFFF>Activity Name&nbsp;");
	out.println(":&nbsp; <input type=text name=T1 size=20></font></i></b></p>");
	out.println("<p align=center><b><i><font size=5 color=#FFFFFF>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
	out.println("Status&nbsp; :&nbsp; <input type=text name=T2 size=20></font></i></b></p>");
	out.println("<p align=center><b><i><font size=5 color=#FFFFFF><input type=submit value=Submit name=B1><input type=reset value=Reset name=B2></font></i></b></p>");
	out.println("</form></body></html>");
     }
      catch(Exception e)
      {
        out.println("Exception is"+e);
      }
      
      
    }
 } 	
