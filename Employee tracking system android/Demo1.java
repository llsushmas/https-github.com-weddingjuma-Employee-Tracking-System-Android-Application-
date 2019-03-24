import java.sql.*;
import java.io.*;
//import java.lang.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Demo1 extends HttpServlet

{
    public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {
      Connection con=null;
      Statement stmt=null;
      ResultSet rs=null;
int a=0;
int k=0;
      
      PrintWriter out=res.getWriter();
      try
      {
	res.setContentType("text/html");
        out.println("Hello1");  
	int b=Integer.parseInt(req.getParameter("T1"));
	String c=req.getParameter("T2");
	out.println("Hello");
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        con=DriverManager.getConnection("jdbc:odbc:moon1","scott","tiger");
        out.println("Hello");	
        stmt=con.createStatement();
        rs=stmt.executeQuery("select * from demo");
          while(rs.next())
           {      
             a=rs.getInt("id");
           } 
             k=a+1;
             out.println(k);                   

      }
      catch(Exception e)
         {
           out.println("Exception is"+e);
         }
	
   }
 } 	