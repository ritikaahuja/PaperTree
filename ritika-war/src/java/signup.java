

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class signup extends HttpServlet {
   static int user= 1000;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        System.out.println("hi");
       String name=request.getParameter("name");
       String email=request.getParameter("email");
       String dob=request.getParameter("dob");
       String password=request.getParameter("password");
       String job=request.getParameter("job");
       String org=request.getParameter("org");
       String areas =request.getParameter("ins");
       
       PrintWriter out=response.getWriter();

    if((password.equals(""))||(name.equals(""))||(email.equals("")))
    {
        out.print("<html><head><title>Invalid</title></head><body><div style='top: 30;left: 240;position: absolute; z-index: 1; visibility: show;font-size:20; text-align:left'><u><font color='azure'>Please ENTER ALL THE DETAILS</font></u></div></br></br><div style='top: 70;left: 250; position: absolute;z-index: 1;visibility: show; color:azure;font-size:18'><center><a color='azure' href='signup.html'><b bgcolor='MediumSeaGreen'>Click To Try Again</b></a></center></body></html>");
    }
    else
    {
                try
                {
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                }
                catch(ClassNotFoundException ce)
                {
                    System.out.println(ce);
                    System.out.println("Class not found");
                }
                catch(InstantiationException ex)
                {
                    Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
                }
                catch (IllegalAccessException ex)
                {
                    Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
                }
                try
                {
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cloud_test","root","system");
                    System.out.println("Connected!!!!"+conn);
                    Statement stmt = conn.createStatement();
                    
                    //String str2="create table logindetails(fname varchar(30), lname varchar(30),age varchar(30),sex varchar(10), userid varchar(30), password varchar(30), primary key(userid,password))";
                    //        stmt.execute(str2);


                    PreparedStatement ps=conn.prepareStatement("insert into user values(?,?,?,?,?,?,?,?)");
                    ps.setInt(1,user+1);               
                    ps.setString(2,name);
                    ps.setString(3,email);
                    ps.setString(4,password);
                    ps.setString(5,dob);                      
                    ps.setString(6,job);
                    ps.setString(7,org);
                    ps.setString(8,areas);

                    ps.executeUpdate();
                    System.out.println("Done");


                        
                    out.print("<html><head><title>valid</title></head><body><div style='top: 30;left: 240;position: absolute; z-index: 1; visibility: show; background-color:MediumSeaGreen;font-size:20'><u>WELCOME "+name+" </u></div></br></br><div style='top: 70;left: 250; position: absolute;z-index: 1;visibility: show; color:azure;font-size:18'><center><a color='azure' href='index.html'><b bgcolor='MediumSeaGreen'>Click To Continue...</b></a></center></body></html>");                     
                }
                catch(SQLException ce)
                {
                    System.out.println(ce);
                }
        }
    }
}
