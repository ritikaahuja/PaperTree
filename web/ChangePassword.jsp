<%-- 
    Document   : SignIn
    Created on : Nov 28, 2015, 9:29:32 PM
    Author     : Anjali
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.text.*" import=" java.util.*"  import="com.mongodb.*" import="org.bson.Document" language="java"%>
<% 
    String username=(String)session.getAttribute("name");
                                                if(username==null)
                                                {
                                                 response.sendRedirect("index.html?err=Login to access Application");
                                                }
                                                else
                                                {
                                                 
   String email=(String)session.getAttribute("email");
   
                   String npass=(String)request.getParameter("npassword");
                   String opass=(String)request.getParameter("opassword");
                   
                   email=email.toLowerCase();
                   
    MongoClient mongo=new MongoClient();
    DB db=mongo.getDB("WebDB");
    DBCollection user=db.getCollection("User");
    Document d=new Document();
    d.put("Email",email);
    DBCursor cur=user.find(new BasicDBObject(d)); 
    cur.next();
    DBObject ob=cur.curr();
   if((ob.get("Password").toString()).equals(opass))
   {
       DBObject ob1=new BasicDBObject(new Document("$set", new Document("Password",npass)));
        user.update(ob,ob1);
        response.sendRedirect("Settings.jsp?err=Password Updated");
        //inform about succesfuull update
   }
                                                
   else
   {
       response.sendRedirect("Settings.jsp?err=Enter Correct Password");
       // inform about wrong password
   }
    
      
                                                }
    %>
