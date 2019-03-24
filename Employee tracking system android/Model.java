import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Model extends HttpServlet

{
   public void init()
   {
     try
     {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     }
     catch(Exception e)
     {
        System.out.println("Exception is "+e);
     }
   }
   public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
   {
      
      res.setContentType("text/html");
      PrintWriter out=res.getWriter();

      java.util.Date d=new java.util.Date();

      String uname=req.getParameter("name");
      String password=req.getParameter("pass");

      int year=Integer.parseInt(req.getParameter("y"));
      int mon=Integer.parseInt(req.getParameter("month"));
      int date=Integer.parseInt(req.getParameter("date"));
      int day=Integer.parseInt(req.getParameter("day"));
      int hrs=Integer.parseInt(req.getParameter("hours"));
      int min=Integer.parseInt(req.getParameter("minutes"));
      int seconds=Integer.parseInt(req.getParameter("seconds"));

      try
      {
	Connection con=DriverManager.getConnection("jdbc:odbc:moon1","scott","tiger");
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery("select * from login where emp_id='"+uname+"' and password='"+password+"'");

        if(rs.next())
        {
	  out.println("U r a valid user and UR login date is "+date+" Month is "+mon+" year is "+year);
          out.println("and UR login day is "+day);
          out.println("and Ur login Time is "+hrs+": "+min+" :seconds");
        }
      }
      catch(Exception e)
      {
         System.out.println(e);
      }
}
}      