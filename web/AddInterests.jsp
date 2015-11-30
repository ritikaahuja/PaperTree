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
                                                 response.sendRedirect("index.html?err=Login To Access Application");
                                                }
                                                else
                                                {
                                                 
   String email=(String)session.getAttribute("email");
   
                   String npass=(String)request.getParameter("interests");
          out.println(email)         ;
                   email=email.toLowerCase();
                   
    MongoClient mongo=new MongoClient();
    DB db=mongo.getDB("WebDB");
    DBCollection user=db.getCollection("User");
    Document d=new Document();
    d.put("Email",email);
    DBCursor cur=user.find(new BasicDBObject(d)); 
    cur.next();
    DBObject ob=cur.curr();
    String i=(String)ob.get("Interests");
   
   String fin= npass+","+i;
   DBObject k=new BasicDBObject(new Document("Email",email));
    DBObject ob1=new BasicDBObject(new Document("$set", new Document("Interests",fin)));
        user.update(k,ob1);
        response.sendRedirect("Settings.jsp?err=Interests%20Updated%20Successfully");
   
    
      
                                                }
    %>
