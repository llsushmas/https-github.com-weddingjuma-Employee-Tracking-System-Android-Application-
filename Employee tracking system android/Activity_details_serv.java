import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Activity_details_serv extends HttpServlet

{
    public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {
      Connection con=null;
      Statement stmt=null;
      ResultSet rs=null;
      String str=null;
      String str1=null;
      String str2=null;
      PrintWriter out=res.getWriter();
      try
      {
	res.setContentType("text/html");
        String str3=req.getParameter("st");
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
        /*out.println("before select");
          rs=stmt.executeQuery("select * from activity_list where emp_id="+str3);
          out.println("after select");
	if(rs.next())
        { 
           str1=rs.getString("activity_name");*/
           out.println("<html><head><meta http-equiv=Content-Language content=en-us>");
           out.println("<meta name=GENERATOR content='Microsoft FrontPage 5.0'>");
           out.println("<meta name=ProgId content='FrontPage.Editor.Document>");
           out.println("<meta http-equiv=Content-Type content='text/html; charset=windows-1252'>");
           out.println("<title>Activity name</title></head><body bgcolor=#FF9999><p>&nbsp;</p>");
           out.println("<p><font size=5 color=#800000><i>Activity name : "+str3+"</i></font></p>");
           out.println("<p><i><font size=5 color=#800000>Details <b>: </b></font></i></p>");                                            out.println("<p>&nbsp;</p>");
           out.println("<p><i><font color=#800000><font size=5>Do you want to continue the work :</font>&nbsp;&nbsp;");
           out.println("<input type=button value=Yes name=B3></font><font color=#800000>&nbsp;&nbsp;");
           out.println("<input type=button value=No name=B4></font></i></p>");
           out.println("<p><i><font size=5 color=#800000>Project status :</font>");
           out.println("<font color=#800000><select size=1 name=D1>");
           out.println("<option value=completed>completed</option>");
           out.println("<option selected value=WIP>WIP</option>");
           out.println("<option value='Not yet started'>Not yet started</option>");
           out.println("</select></font></i></p>");
           out.println("<p><i><font size=5 color=#800000>If not give details</font></i></p>");
           out.println("<p><font color=#800000><textarea rows=2 name=S1 cols=20></textarea></font></p>");
           out.println("<p><input type=submit value=Submit name=B1></p></body></html>");
           out.println("appu");
        
      }
      catch(Exception j)
      {
        out.println("The exception second "+j);
      }
   }
}
