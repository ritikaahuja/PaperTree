/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.bson.Document;


/**
 *
 * @author Anjali
 */
public class mail extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int success=0;
        String id=request.getParameter("email");
        System.out.println(id);
        //String id="anjaliverma25792@gmail.com";
                        MongoClient mongo=new MongoClient();
                        DB db=mongo.getDB("WebDB");
                        DBCollection table=db.getCollection("User");
        Document d=new Document();
        d.put("Email",id);
        DBObject ob=new BasicDBObject(d);
        DBCursor cur=table.find(ob);
        System.out.println(cur.size());
        System.out.println("Above value");
String user = null;
        if(cur.hasNext())
        {
            success=1;
            cur.next();
        DBObject temp=cur.curr();
        String pass=(String) temp.get("Password");
        
        
        HttpSession session=request.getSession();                
        user=(String)temp.get("Name");
        

                final String username = "nature.lover.ritika@gmail.com";
		final String password = "ritika7vision";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session sess = Session.getInstance(props,
		new javax.mail.Authenticator()
                {
                @Override
                protected PasswordAuthentication getPasswordAuthentication()
                {
                    return new PasswordAuthentication(username, password);
                }
		});

		try 
                {
			Message message = new MimeMessage(sess);
			message.setFrom(new InternetAddress("papertree.official@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
			InternetAddress.parse(id)); //retrive email id from forgot your password form.
			message.setSubject("PaperTree: Password Reset");
			message.setText("Dear, "
				+user+ ". Your password is "
                                +pass+ ". \n\n Directly LOGIN And START READING..." );

			Transport.send(message);

			
                        
                        // Mongo DB connectivity LEFT 
                  
                        
//                        response.sendRedirect("success.jsp");
                    

                }
                catch (MessagingException e) {
			throw new RuntimeException(e);
		}
                
    }
        if(success==1)
        {    response.sendRedirect("success.jsp?success=yes");
        
        }
        else
        {  response.sendRedirect("success.jsp?success=no");
        
        }
      }
        
        
    }

