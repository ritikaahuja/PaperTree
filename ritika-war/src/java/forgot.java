
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class forgot extends HttpServlet {
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
       String u="";
       String email=request.getParameter("email");
       String org=request.getParameter("org");
       PrintWriter out=response.getWriter();
       if(email.equals(""))
       {
            out.print("<html><body><div style='background-color:MediumSeaGreen; text-align:center;'><font color='azure' size='4'>Please Enter The MANDATORY (*) Details</font></div></body></html>");
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
                catch(IllegalAccessException ex)
                {
                    Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
                }
                try
                {

                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cloud_test","root","system");
                    System.out.println("Connected!!!!"+conn);
                    Statement stmt = conn.createStatement ();
                    PreparedStatement ps=conn.prepareStatement("Select password from user where email=?");
			ps.setString(1,email);
			ps.executeUpdate();
                        ResultSet rs=ps.executeQuery();
				System.out.println("yup");
                                while(rs.next())
                                {
                                    u=rs.getString(1);
                                }

                          ps.executeUpdate();
                    if(u.equals(""))
                    {
                        out.print("<html><head><title>Invalid</title></head><body><div style='top: 30;left: 240;position: absolute; z-index: 1; visibility: show; background-color:MediumSeaGreen;font-size:20'><u>Sorry... Wrong Details Entered</u></div></br></br><div style='top: 70;left: 250; position: absolute;z-index: 1;visibility: show; color:azure;font-size:18'><center><a color='azure' href='wel.html'><b bgcolor='MediumSeaGreen'>Click To TRY AGAIN</b></a></center></body></html>");
       //                 out.print("<html><head><title>Invalid</title><body><center><b color='azure'>Sorry.. INVALID USER</b></center></body></html>");
                    }
                    else
                    {
                        out.print("<html><head><title>valid</title></head><body><div style='top: 30;left: 240;position: absolute; z-index: 1; visibility: show; background-color:MediumSeaGreen;font-size:20'><u>Your Password Is : "+u+"</u></div></br></br><div style='top: 70;left: 250; position: absolute;z-index: 1;visibility: show; color:azure;font-size:18'><center><a color='azure' href='wel.html'><b bgcolor='MediumSeaGreen'>Click To Continue...</b></a></center></body></html>");

			//out.print("<html><body bgcolor='pink'><center><iframe src='part2.html' width='780' height='125'></iframe><h2><b>Your Password Is :"+u+"</b></h2><h3>Do Remember this time...</h3></center></body></html>");
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
