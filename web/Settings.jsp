
<!-- 

Project Codename: Papertree
Codding By Anjali Verma
Version 1.0

(In Development Phase)
-->

<!DOCTYPE html>
<html>


<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type">
<%@page import="java.text.*" import=" java.util.*"  import="com.mongodb.*" import="org.bson.Document" language="java"%>
<title>PaperTree - Settings</title>
<!---------------------------- CSS ------------------------------------------>

	<link rel="stylesheet" type="text/css" media="all" href="css/style.css">
        
	
<!---------------------------- CSS ------------------------------------------>

<!---------------------------- JS ------------------------------------------->

	<script src="js/jquery.js"></script>
	<script src="js/tabs.js"></script>
	
	

<!---------------------------- JS ------------------------------------------->

</head>

<body style="background:url('images/bg.jpg') 0px 150px no-repeat">
		<header>
			<div id="pre-header">
                            <div class="logo"><a href="backend.jsp"><img src="images/logo.png" class="" alt=""></a></div>
				<div class="user-sect">
					<span class="user-details"><h1>Hi,</h1><h2>  <%
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
                                        <span class="user-set"><a href="Settings.jsp">Settings</a>&nbsp;|&nbsp; <a href="SignOut.jsp">Logout</a></span>
				</div>
			</div>
		</header>
	
	<div id="page-frame">
		<div id="page">
			<div id="sidebar">
				<ul class="tabs" id="tabs">
					<li style="width:190px;"><a href="#change-Pass">Change Password</a></li>
					<li style="width:190px;"><a href="#change-mail">Change Email</a></li>
					<li style="width:190px;"><a href="#interests">Add Interest</a></li>
					
				</ul>
			</div>
			<div id="content">
			
			<div id="change-Pass" class="tab-section dashboard">
				
					<div class="recent-post-dashboard">
						<h1 class="main-heading">Change Password</h1>
					
						<div style="width:450px;margin:50px 0px 0px 30px;">	
                                                    <form method="post" action="ChangePassword.jsp">
			                <label for="opassword" class="log-label">Old Password:</label>
			                <input type="password" name="opassword" id="opassword" class="logtext">
			                
				                <div class="clearfix"></div>
			                
			                <label for="password" id="opasswordl"></label>
				            <label for="password" class="log-label">New Password:</label>
			                <input type="password" name="npassword" id="npassword" class="logtext">
			                
				                <div class="clearfix"></div>
			                
			                <label for="npassword" id="npasswordl"></label>
			                <label for="rnpassword" class="log-label">Re-Enter New Password:</label>
			                <input type="password" name="rnpassword" id="rnpassword" class="logtext">
			                
				                <div class="clearfix"></div>
			                
			                <label for="password" id="rnpasswordl"></label><br>
			                                
			                <input type="submit" name="ChangePass" value="UPDATE" class="button" style="margin:30px 0px 0px 350px;">
			                </form>
		                 </div>
			  		</div>						
			</div>
				
			<div id="change-mail" class="tab-section dashboard">
                    <div class="recent-post-dashboard">
						<h1 class="main-heading">Change Email</h1>
                                                                
						<div style="width:450px;margin:50px 0px 0px 30px;">	
                                                    <form method="post" action="ChangeEmail.jsp">
			                <label for="email" class="log-label">Current Email:</label>
			                <input type="email" name="oemail" id="oemail" class="logtext">
			                <label for="email" id="oemaill"></label>
				                <div class="clearfix"></div>
			                
			                <label for="nemail" class="log-label">New Email:</label>
			                <input type="email" name="nemail" id="nemail" class="logtext">
			                <label for="nemail" id="nemaill"></label>
			                
				                <div class="clearfix"></div>
			                
			                <label for="rnemail" class="log-label">Re-Enter New Email:</label>
			                <input type="email" name="rnemail" id="rnemail" class="logtext">
			                <label for="email" id="rnemaill"></label>
			                
				                <div class="clearfix"></div>
			                
			                <input type="submit" name="ChangeEmail" value="UPDATE" class="button" style="margin:50px 0px 0px 350px;">
			                </form>
		                 </div>
					</div>				            
				</div>

        	<div id="interests" class="tab-section dashboard">
				<div class="recent-post-dashboard">
					<h1 class="main-heading">Add Interest</h1>
							
					<div style="width:650px;margin:50px 0px 0px 30px;">	
                                            <form method="post" action="AddInterests.jsp">	
				         <label for="rnemail" class="log-label">Enter Interest :</label>
				         <textarea name="interests" id="interests" class="logtext"></textarea><br>
				         <label for="interests" id="interestsl"></label><br>
				                
				                <div class="clearfix"></div>
				                
				         <input type="submit" name="AddInterests" value="Add" class="button" style="margin:25px 0px 0px 580px;">    
				              </form>
	                </div>
				</div>				
			</div>
	
	
									    
				</div>
			</div>
			<div style="clear:both;"></div>
		</div>
	
	
	<script>
		$(document).ready(
		$('#srch-max').click(function(){
		
		        $('.srch-box').css({
		        'width':"auto", 
		        'height':"auto",
		        'min-height':"50px", 
		        'background':"transparent",
		        'margin':"0px",
		        'box-shadow':"0px 0px rgba(0,0,0,0)",
		        'border':"0px"
		        });
		        
		        $('.kwd-set').css({
		        'float':"right", 
		        'clear':"both",
		        'margin':"10px",
		        'width':"auto",
		        'height':"auto",
		        });
		        
		        $('.srch-box h3').css({
		        'display':"none" 
		        });
		        
		        $('.srch-results').css({
		        'display':"block",
		        'opacity':"1",
		        'height':"1000px"
		        });
		        
			})			
		)	
	</script>
	
</body>

</html>
