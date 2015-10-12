/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Cloud Project
 */

public class login extends HttpServlet
{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String user=request.getParameter("user");
        String pass=request.getParameter("pass");
        PrintWriter out=response.getWriter();
        if((user.equals(""))&&(pass.equals("")))
        {
            out.print("<html><head><title>Invalid</title></head><body><div style='top: 30;left: 240;position: absolute; z-index: 1; visibility: show; background-color:MediumSeaGreen;font-size:20'><u>Sorry... INVALID USER</u></div></br></br><div style='top: 70;left: 250; position: absolute;z-index: 1;visibility: show; color:azure;font-size:18'><center><a color='azure' href='wel.html'><b bgcolor='MediumSeaGreen'>Click To Continue...</b></a></center></body></html>");
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
            catch (InstantiationException ex)
            {
                Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch (IllegalAccessException ex)
            {
                Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
            }
            try
            {
                    //Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","ritika");
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cloud_test","root","system");
                    System.out.println("Connected!!!!"+conn);
                    Statement stmt = conn.createStatement ();
		    PreparedStatement ps=conn.prepareStatement("select email, password from user where( email=? AND password=?)");
                    ps.setString(1,user);
                    ps.setString(2,pass);
                    int c=0;
                    ResultSet rs=ps.executeQuery();
                    System.out.println("yup");
                    while(rs.next())
                    {
                        String a="";
                        String b="";
                        a=rs.getString(1);
                        b=rs.getString(2);
                        System.out.println(a+b);
                        c=1;
                    }
                    if(c==1)
                    {
                        HttpSession session=request.getSession();
                        session.setAttribute("username", user);
                        response.sendRedirect("login.html");
                    }
                    else
                    {
                        out.print("<html><head><title>Invalid</title></head><body><div style='top: 30;left: 240;position: absolute; z-index: 1; visibility: show; background-color:MediumSeaGreen;font-size:20'><u>Sorry... INVALID USER</u></div></br></br><div style='top: 70;left: 250; position: absolute;z-index: 1;visibility: show; color:azure;font-size:18'><center><a color='azure' href='wel.html'><b bgcolor='MediumSeaGreen'>Click To Continue...</b></a></center></body></html>");
                    }
                    System.out.println("Done");

            }
            catch(SQLException ce)
            {
                System.out.println(ce);
            }

        }

    }
}

