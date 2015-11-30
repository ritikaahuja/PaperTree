<%-- 
    Document   : SignIn
    Created on : Nov 28, 2015, 9:29:32 PM
    Author     : Anjali
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.text.*" import=" java.util.*"  import="com.mongodb.*" import="org.bson.Document"language="java"%>
<%
     try
     {
    String email=request.getParameter("Email");
    String password=request.getParameter("Password");
    String username=null;
    MongoClient mongo=new MongoClient();
    DB db=mongo.getDB("WebDB");
    DBCollection user=db.getCollection("User");
    Document d=new Document();
    d.put("Email",email);
    DBObject t=new BasicDBObject(d);    
    DBCursor cur=user.find(t);
    
    if(cur.hasNext())
    {
    cur.next();
    DBObject ob=cur.curr();
    username=(String)ob.get("Name");
    username=username.substring(0,username.indexOf(" "));
    String pass=(String)ob.get("Password");
    
    if(pass.equals(password))
    {
    HttpSession session1=request.getSession();
                    session1.setAttribute("name", username); 
                    session1.setAttribute("email",email);
                    session1.setAttribute("UID",ob.get("UID").toString());
                    response.sendRedirect("backend.jsp");
                    
    }else
    {
        response.sendRedirect("index.html");
        //add msg box for error to be displayed on the main page
    }
    }
    else
    {
        response.sendRedirect("index.html");
        //add msg box for error to be displayed on the main page
    }
     }
     catch(Exception e){e.printStackTrace();}
    %>
