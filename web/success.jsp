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
					<span class="user-details"> <h1>Hi,</h1> <h2>Username</h2></span>
					<div class="clearfix"></div>
					<span class="user-set"><a href="#">Settings</a>&nbsp;|&nbsp; <a href="#">Logout</a></span>
				</div>
			</div>
		</header>
    <div id="page-frame">

<%
String success=request.getParameter("success");
if(success=="yes")
{
    out.println("Your password has been sent to your registered Email ID<br>");
    
    out.println("<a href='index.html'>Sing In</a>");
}
    else
{
    out.println("You are not registered with us.<br>");
    out.println("<a href='SignUp.html'>Sign Up</a>");
}
       
    
%>
	</div>
</body>

</html>
