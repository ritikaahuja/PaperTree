<%--
    Document   : register
    Created on : Apr 26, 2014, 2:08:22 AM
    Author     : COLLEGE PROJECT
--%>


<%@page import="java.text.*" import=" java.util.*"  import="com.mongodb.*" import="org.bson.Document" language="java"%>
<%
   try
   {
    String name=request.getParameter("name");
    String email=request.getParameter("email");
    String password=request.getParameter("password");
    String interests=request.getParameter("interests");
    String org=request.getParameter("org");
    String job=request.getParameter("job");
    
    
MongoClient mongo1=new MongoClient();
    DB db1=mongo1.getDB("WebDB");
    DBCollection user1=db1.getCollection("User");
    Document d1=new Document();
    d1.put("Email",email);
    DBObject t1=new BasicDBObject(d1);    
    
    DBCursor cur1=user1.find(t1);    
    System.out.println(cur1.size()+"asfdsgggggggggggggggggggggggggggggggggggggggggggggggg");
    if(cur1.size()>0)
    {        response.sendRedirect("index.html?err=Email ID already registered with the application");
    
    }
    else
    {
         Date date = new Date();
SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
 MongoClient mongo = new MongoClient();	
  DB db = mongo.getDB("WebDB");

int id=100;
        DBCollection user = db.getCollection("User");
        DBCursor uid=user.find();
        id=id+uid.count()+1;
        
        Document d=new Document();
        d.put("UID",id);
        d.put("Name",name);
        d.put("Email",email);
        d.put("Password",password);
        d.put("Interests", interests);
        d.put("Org",org);
        d.put("Job",job);
        d.put("DOJ",sdf.format(date));
        DBObject ob=new BasicDBObject(d);
        user.insert(ob);
   d=new Document();
   d.put("UID",id);
   ob=new BasicDBObject(d);
   DBCursor confirm=user.find(ob);
if(confirm.hasNext())
  response.sendRedirect("index.html?err=Registration Successfull. Login to Continue");
    }
   }catch(Exception e)
   {
       e.printStackTrace();
   }
    
           
         
       
    
%>
