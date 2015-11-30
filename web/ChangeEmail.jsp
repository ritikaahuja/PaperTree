<%-- 
    Document   : SignIn
    Created on : Nov 28, 2015, 9:29:32 PM
    Author     : Anjali
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.text.*" import=" java.util.*"  import="com.mongodb.*" import="org.bson.Document" language="java"%>
<% String username=(String)session.getAttribute("name");
                                                if(username==null)
                                                {
                                                 response.sendRedirect("index.html?err=Login to access application");
                                                }
                                                else
                                                {
                                                 
   String email=(String)session.getAttribute("email");
   String nmail=(String)request.getParameter("nemail");
                   String nemail=(String)request.getParameter("nemail");
                   email=email.toLowerCase();
                   nemail=nemail.toLowerCase();
    MongoClient mongo=new MongoClient();
    DB db=mongo.getDB("WebDB");
    DBCollection user=db.getCollection("User");
    Document d=new Document();
    d.put("Email", email);
    DBObject ob=new BasicDBObject(d);
      HttpSession session1=request.getSession();
    session1.setAttribute("email",nemail);
    
    
    
    
    DBObject ob1=new BasicDBObject(new Document("$set", new Document("Email",nemail)));
        user.update(ob,ob1);
                   response.sendRedirect("Settings.jsp?err=EmailID%20Successfully%20Updated");
      
                                                }
    %>
