import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Loginserv extends HttpServlet

{
    public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {
      Connection con=null;
      Statement stmt=null;
      ResultSet rs=null;
      //ResultSet rs2=null;
      String str=null;
      String str1=null;
      PrintWriter out=res.getWriter();
      try
      {
	res.setContentType("text/html");

	String n=req.getParameter("T1");
	String p=req.getParameter("T2");
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
        rs=stmt.executeQuery("select * from Login where Emp_id='"+n+"'");
	
	if(rs.next()){
	 
           out.println("hello");
           str1=rs.getString(2);
	out.println(str1);
	   if(str1.equals(p))
	   {
              out.println("appu");
              rs=stmt.executeQuery("select designation from registration where emp_id='"+n+"'");

              if(rs.next())
              {
                str=rs.getString("designation");               
                out.println("appu");
                if(str.equals("manager"))  
                { 
                  res.sendRedirect("http://localhost:8081/hr.htm");
                } 

                if(str.equals("projectmanager"))
                {
                   res.sendRedirect("http://localhost:8081/proj_manager.htm");
                }
                if(str.equals("teamleader"))
                {
                  res.sendRedirect("http://localhost:8081/teamleader.htm");
                }
                if(str.equals("employee"))
                {
                  res.sendRedirect("http://localhost:8081/employee1.htm");
                }
            }
          }
      }
      else
      {
          out.println("<html><body>Not a Valid user</body></html>");
	//System.out.println("False");
      }
	
   }
   catch(Exception e)
   {
      out.println(e);
   }

 }
}  