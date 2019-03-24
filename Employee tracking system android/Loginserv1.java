	import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Loginserv1 extends HttpServlet

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

	//System.out.println("I am here");
        int n=Integer.parseInt(req.getParameter("T1"));
	String p=req.getParameter("T2");	
        try
        {	
          Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
          //out.println("Class loaded and con created "); 
	  con=DriverManager.getConnection("jdbc:odbc:moon1","scott","tiger");
       	//System.out.println("Class loaded and con created "); 
        }
        catch(Exception e)
        {
       	//System.out.println("I am here in class not found excpetion"); 
	 out.println("Exception is"+e);
        }
	//System.out.println("Class loaded and con created 2"); 
	stmt=con.createStatement();
        rs=stmt.executeQuery("select * from Login where Emp_id="+n);
	//out.println("Class loaded and con created 3"); 
	if(rs.next())
        {
	 
           //out.println("hello");
           str1=rs.getString(2);
	   //out.println(str1);
	   if(str1.equals(p))
	   {
              //out.println("appu");
              rs=stmt.executeQuery("select designation from registration where emp_id="+n);

              if(rs.next())
              {
                str=rs.getString("designation");               
                //out.println("appu");
                
                
                if(str.equals("manager"))  
                { 
                  
	          //res.sendRedirect("http://localhost:8081/hr.htm");

                  out.println("<html><head>");
		  out.println("<meta http-equiv=Content-Type content='text/html; charset=windows-1252'>");
		  out.println("<meta name=GENERATOR content='Microsoft FrontPage 4.0'>");
		  out.println("<meta name=ProgId content=FrontPage.Editor.Document>");
		  out.println("<title>New Page 1</title></head><frameset rows='72,*'>");
		  out.println("<frame name=f1 src=http://localhost:8081/hr_manager.htm scrolling=no target='_self'>");
		  out.println("<frameset cols='252,*'><frame name=f2 src=http://localhost:8081/servlet/Activity_list1_serv?id="+n+" target=f3>");
		  out.println("<frame name=f3 src=http://localhost:8081/servlet/View_activity_serv?id="+n+" target=_self></frameset>");
		  out.println("</frameset></html>");

                } 

                if(str.equals("projectmanager"))
                {
                   //res.sendRedirect("http://localhost:8081/proj_manager.htm");
                   out.println("<html><head><meta http-equiv=Content-Type content='text/html; charset=windows-1252'>");
                   out.println("<meta name=GENERATOR content='Microsoft FrontPage 4.0'>");
                   out.println("<meta name=ProgId content=FrontPage.Editor.Document><title>New Page 1</title></head>");
                   out.println("<frameset rows=71,98%><frame name=f1 src=http://localhost:8081/project_manager.htm scrolling=no target='_self'>");
                   out.println("<frameset cols='38,62'><frame name=f2 src=http://localhost:8081/servlet/Activity_list3_serv?id="+n+" scrolling=no target='_self'>");
                   out.println("<frame name=f3 target=_self scrolling=auto src=http://localhost:8081/servlet/View_activity_serv?id="+n+">");
                   out.println("</frameset></frameset></html>");

                   
                }
                if(str.equals("teamleader"))
                
                {
                  //res.sendRedirect("http://localhost:8081/teamleader.htm");
                  out.println("<html><head><meta http-equiv='Content-Type' content='text/html; charset=windows-1252'>");
                  out.println("<meta name=GENERATOR content='Microsoft FrontPage 4.0'>");
                  out.println("<meta name='ProgId' content='FrontPage.Editor.Document'><title>New Page 1</title></head>");
                  out.println("<frameset rows='85,*'><frame name=f1 src=http://localhost:8081/team_leader.htm target='_self' scrolling=no>");
                  out.println("<frameset cols='209,*'><frame name=f2 src=http://localhost:8081/servlet/Activity_list2_serv?id="+n+" target='_self'>");
                  out.println("<frame name=f3 src=http://localhost:8081/servlet/View_activity_serv?id="+n+" target='_self' scrolling='auto'></frameset></frameset></html>");

                }
                
                if(str.equals("Employee"))
                {
                  
		//res.sendRedirect("http://localhost:8081/employee1.htm");
                  out.println("<html><head><meta http-equiv='Content-Type' content='text/html; charset=windows-1252'>");
                  out.println("<meta name=GENERATOR content='Microsoft FrontPage 4.0'>");
                  out.println("<meta name='ProgId' content='FrontPage.Editor.Document'>");
                  out.println("<title>New Page 1</title></head><frameset rows='75,106%'>");
                  out.println("<frame name=f1 src=http://localhost:8081/employee2.htm scrolling=no target='_self'><frameset cols='36,64'>");
                  out.println("<frame name=f2 src=http://localhost:8081/servlet/Activity_liste_serv?id="+n+" scrolling=no target='_self'>");
                  out.println("<frame name=f3 src=http://localhost:8081/servlet/View_activity_serv?id="+n+" target='_self'></frameset></frameset></html>");

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