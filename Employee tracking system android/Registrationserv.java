import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Registrationserv extends HttpServlet

{
    public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {
      Connection con=null;
      Statement stmt=null;
      ResultSet rs=null;
      String str=null;
      int a=0;
      int k=0;
      PrintWriter out=res.getWriter();
      try
      {
	res.setContentType("text/html");

	
	String b=req.getParameter("T2");
	String c=req.getParameter("T3");
	String d=req.getParameter("T4");
	int e=Integer.parseInt(req.getParameter("T5"));
	String f=req.getParameter("T6");
	int g=Integer.parseInt(req.getParameter("T7"));
	String h=req.getParameter("T8");
	String i=req.getParameter("T9");

        try
        {	
          Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	  con=DriverManager.getConnection("jdbc:odbc:moon1","scott","tiger");
        }
        catch(Exception z)
        {
          out.println("Exception is first"+z);
           z.printStackTrace();
        }
        stmt=con.createStatement();
        rs=stmt.executeQuery("select * from registration");
        while(rs.next())
        {      
           a=rs.getInt("emp_id");
        } 
        k=a+1;
        	
        stmt.executeUpdate("insert into registration values("+k+",'"+b+"','"+c+"','"+d+"',"+e+",'"+f+"',"+g+",'"+h+"','"+i+"')");
        out.println("<html><body font=white bgcolor=#99aa66><center><h1><b><i>ID of "+b+" is "+k+"</i></b></h1></center></body></html>");
      }
      catch(Exception j)
      {
        out.println("Exception is second "+j);
      } 	
    }
 } 	