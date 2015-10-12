/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

public class matrix extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (ClassNotFoundException ce) {
            System.out.println(ce);
            System.out.println("Class not found");
        } catch (InstantiationException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {

            Map<Integer, List<Integer>> mapped = new HashMap<Integer, List<Integer>>();
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cloud_test", "root", "system");
            System.out.println("Connected!!!!" + conn);
            Statement stmt = conn.createStatement();
            PreparedStatement ps1 = conn.prepareStatement("select distinct uid from userpaper");
            ResultSet rs1 = ps1.executeQuery();
            while (rs1.next()) {
                List<Integer> papers = new ArrayList<Integer>();
                int user = rs1.getInt(1);
                        //int user= 1001;
                //int user= rs1.getInt(1);
                PreparedStatement ps2 = conn.prepareStatement("select pid from userpaper where uid=? ");
                ps2.setInt(1, user);

                ResultSet rs2 = ps2.executeQuery();
                System.out.println(user);

                System.out.println("yup");

                while (rs2.next()) {
                    //System.out.print(rs2.getString(1));
                    int a = rs2.getInt(1);
                    System.out.println(a);
                    papers.add(a);
                }
                mapped.put(user, papers);

            }
            Set<Integer> m1 = mapped.keySet();
            for (Integer key : m1) {
                System.out.println(((List) mapped.get(key)).size());
            }
            /*
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
             */

        } catch (SQLException ce) {
            System.out.println(ce);
        }

    }

}
