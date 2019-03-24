import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.io.*;
public class login extends HttpServlet
{
Connection con=null;
Statement st=null;
ResultSet rs;
public void init(ServletConfig conf) throws ServletException
{
try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
System.out.println("after class ");
con=DriverManager.getConnection("jdbc:odbc:moon1","scott","tiger");
System.out.println("after dsn ");
}
catch(Exception e){ System.out.println(e);}
}
public void doPost(HttpServletRequest req,HttpServletResponse res) throws 
ServletException,IOException
{
try
{
res.setContentType("text/html");
ServletOutputStream out=res.getOutputStream();
String username=req.getParameter("login");
String password=req.getParameter("passwd");
st=con.createStatement();
System.out.println("before execute ");
rs=st.executeQuery("select * from login where username='"+username+ "' and password='"+password+"'");
rs.next();
String st=rs.getString(1);
String st1=rs.getString(2);
System.out.println(st+st1);
if((st.equals(username)) && (st1.equals(password)))
{
out.println("<html>");
out.println("<head><title>login</title></head>");
out.println("<body>u r an authenticated user</body>");
out.println("<br>");
out.println("<pre>");
out.println("<A href=emploeedetails.html><font size=4 face=comic sans MS>Employeedetails</font><A>");
}
else{
out.println("u r not an authenticated user ");
}
}catch(Exception e)
{     
System.out.println(e);}
} 
 }
