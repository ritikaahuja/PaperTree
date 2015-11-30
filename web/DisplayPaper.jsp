<html>

<head>


<%@page import="java.text.*" import=" java.util.*"  import="com.mongodb.*" import="org.bson.Document" language="java" %>
<meta content="text/html; charset=UTF-8" http-equiv="Content-Type">
<link rel="stylesheet" type="text/css" media="all" href="css/style.css">
<title>Title | Backend</title>
	

</head>

<body style="background:url('images/bg.jpg') 0px 150px no-repeat">
		<header>
			<div id="pre-header">
				<div class="logo"><a href="backend.jsp"><img src="images/logo.png" class="" alt=""></a></div>
				<div class="user-sect">
					<span class="user-details"> <h1>Hi,</h1> <h2><%
                                                String username=(String)session.getAttribute("name");
                                                if(username==null)
                                                {
                                                 response.sendRedirect("index.html?err=Login To Access Application");
                                                }
                                                else
                                                {
                                                    out.println(username);
                                                }
                                                %></h2></span>
					<div class="clearfix"></div>
					<span class="user-set"><a href="#">Settings</a>&nbsp;|&nbsp; <a href="#">Logout</a></span>
				</div>
			</div>
		</header>
	<div id="page-frame" class="post-page">
<h1 class="main-heading">	
<% 
   try{
    MongoClient mongo=new MongoClient();
    DB db=mongo.getDB("WebDB");
 String name=request.getParameter("id");
 
 int l=name.length();
DB db1=mongo.getDB("TFIDF");
out.println("PAPER NAME:"+"              "+name+"<br>");
DBCollection table=db1.getCollection(name);
DBCursor c=table.find();

Date date = new Date();
SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");


String uid=(String)session.getAttribute("UID");
//String uid="101";
DBCollection reading=db.getCollection("Readings");
Document d=new Document();
d.put("UID",uid);

DBObject ob=new BasicDBObject(d);
DBCursor c1=reading.find(ob);
String in=null;
DBCursor cur=reading.find(ob);
if(cur.hasNext())
{
    cur.next();
    DBObject k=cur.curr();
   in=k.get("History").toString();
     DBObject ob1=new BasicDBObject(new Document("UID",uid));
     String temp="["+name+" "+sdf.format(date)+"]"+in;
        DBObject ob2=new BasicDBObject(new Document("$set", new Document("History",temp)));
        reading.update(ob1,ob2);
}
else
{
    String temp="["+name+" "+sdf.format(date)+"]";
    Document tem=new Document();
    tem.put("UID", uid);
    tem.put("History",temp);
    reading.insert(new BasicDBObject(tem));
}

   out.println("<textarea style='width:500px; height:500px'>");
   
   while(c.hasNext())
{
    c.next();
    DBObject k=c.curr();
    
    String content = k.get("Word").toString();
    out.println(content);
}
   out.println("</TextArea>");    
   }catch(Exception e){e.printStackTrace();}
   
%>	</div>
</body>

</html>
