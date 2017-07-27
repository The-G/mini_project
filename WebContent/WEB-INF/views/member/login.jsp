<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath}"/> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
   <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- font awesome -->
    <link rel="stylesheet" href="css/member.font-awesome.min.css" media="screen" title="no title" charset="utf-8">
    <!-- Custom style -->
    <link rel="stylesheet" href="css/member.style.css" media="screen" title="no title" charset="utf-8">

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style>
/* Remove the navbar's default rounded borders and increase the bottom margin */
.navbar {
	margin-bottom: 0px;
	border-radius: 0;
}

/* Remove the jumbotron's default bottom margin */
.jumbotron {
	margin-bottom: 0;
}

/* Add a gray background color and some padding to the footer */
footer {
	background-color: #f2f2f2;
	padding: 25px;
}
</style>
<script type="text/javascript" src='<c:url value="/resource/js/member.js"/>'></script>
</head>
<body>

	<div class="container text-center">
		 <img src= "${context}/resource/img/title.png"><br>
		 
		
	</div>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="main">Home</a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
					<a class="navbar-brand" href="main">MoiveChart</a>
			
				</ul>
			<ul class="nav navbar-nav navbar-right">
       	

			</ul>
		</div>
	</div>
	</nav>

	<article class="container">
        <div class="page-header">
          <h1>로그인 <small>login</small></h1>
        </div>
    </article>
	<form method="post" action="login.do" name="frm">
		
		<div class="col-md-6 col-md-offset-3">
            <div class="form-group">
              <label for="username">아이디</label>
              <input type="text" class="form-control" name="userid" value="${userid}" placeholder="아이디를 입력해 주세요">
              <br/>
              <input type="checkbox" name="idsave" value="saveOk" onclick="sendit()">아이디 저장
              </div>
		
			
			 <div class="form-group">
              <label for="InputPassword1">비밀번호</label>
              <input type="password" name ="pwd" class="form-control" placeholder="비밀번호">
            </div>	
           <br><br>
            <div class="form-group text-center">
              <input type="submit" class="btn btn-info" value="로그인" onclick= "return loginCheck()" ><i class="fa fa-check spaceLeft"></i>
              <input type="button" class="btn btn-warning" value ="회원가입" onclick="location.href='join.do'"><i class="fa fa-times spaceLeft"></i>
              <td colspan="2"> ${message}</td>
            </div>


		</div>
	</form>
</body>
</html>