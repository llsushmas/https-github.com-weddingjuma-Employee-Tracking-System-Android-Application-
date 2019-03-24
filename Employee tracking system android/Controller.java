import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class Controller extends HttpServlet
{
   public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException
   {
       try
       { 
        res.setContentType("text/html");
        PrintWriter out=res.getWriter();
        java.util.Date d=new java.util.Date();

        String uname=req.getParameter("t1");
        String password=req.getParameter("t2");

        int year=d.getYear();
        int month=d.getMonth();
        int date=d.getDate();
        int day=d.getDay();
        int hours=d.getHours();
        int minutes=d.getMinutes();
        int seconds=d.getSeconds();

        res.sendRedirect("/Model?t1="+uname+"&t2="+password+"&y="+year+"&month="+month+"&date="+date+"&day="+day+"&hours="+hours+"&minutes="+minutes+"&seconds="+seconds);
       }
       catch(Exception e)
       {
	  System.out.println(e);
       }
}
}
