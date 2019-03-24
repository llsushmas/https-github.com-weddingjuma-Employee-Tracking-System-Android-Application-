import java.sql.*;
import java.lang.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Updateserv extends HttpServlet

{
    public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {

      
      Connection con=null;
      Statement stmt=null;
      ResultSet rs=null;
      String str=null;
      PrintWriter out=res.getWriter();
      try
      {
	res.setContentType("text/html");
        int a=Integer.parseInt(req.getParameter("T1"));
        String b=req.getParameter("T2");
	String c=req.getParameter("T3");  
	/*int e=Integer.parseInt(req.getParameter("T5"));  
	int f=Integer.parseInt(req.getParameter("T6"));  
        int e=Integer.parseInt(req.getParameter("T5"));  
        int f=Integer.parseInt(req.getParameter("T6"));
	int g=Integer.parseInt(req.getParameter("T7"));  
	String h=req.getParameter("T8");*/  


      	
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        con=DriverManager.getConnection("jdbc:odbc:moon1","scott","tiger");
        stmt= con.createStatement();
        out.println("Hello");	
        stmt.executeUpdate("insert into activity_list values("+a+",'"+b+"','"+c+"')");
        res.sendRedirect("http://localhost:8081/update_activity(mgr).htm");
        out.println("inserted");
      }
      catch(Exception e)
      {
        out.println("Exception is"+e);
      }
      
      
    }
 } 	