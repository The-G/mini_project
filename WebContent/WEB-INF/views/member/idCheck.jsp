<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath}"/> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>Bootstrap Example</title>
 <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- font awesome -->
    <link rel="stylesheet" href="css/member.font-awesome.min.css" media="screen" title="no title" charset="utf-8">
    <!-- Custom style -->
    <link rel="stylesheet" href="css/member.style.css" media="screen" title="no title" charset="utf-8">
<meta charset="UTF-8">
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
	margin-bottom: 50px;
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

.green_window {
	display: inline-block;
	width: 366px; height: 50px;
	border: 3px solid #FF9933;
	background: white;
}
.input_text {
	width: 149px; height: 40px;
	margin: 3px 0 0 9px;
	border: 0;
	line-height: 30px;
	font-weight: bold;
	font-size: 20px;
	outline: none;
}
.sch_smit {
	width: 54px; height: 50px;
	margin: 0; border: 0;
	vertical-align: top;
	background: #FF9933;
	color: white;
	font-weight: bold;
	border-radius: 1px;
	cursor: pointer;
}
.sch_smit:hover {
	background: #FF9933;
}
</style>
<script type="text/javascript" src='<c:url value="/resource/js/member.js"/>'></script>
</head>
<body>

          <h4>아이디 중복확인</h4>
        
	
	<form action="idCheck.do" method="get" name="frm">
	
	<b>아이디</b> <input type="text" class="input_text" name="userid"  value="${userid}" > 
	<input 	type="submit" class="btn btn-warning" value="중복체크" class="sch_smit"  align="center" > <br>
		    <c:if test="${result ==1 }">
			<script type="text/javascript">
				opener.document.frm.userid.value = "";
			</script>
           ${userid}는 이미 사용 중인 아이디 입니다.
        </c:if>
		<c:if test="${result ==-1 }">
        ${userid}는 사용 가능한 아이디입니다.
<input type="button" value="사용" class="btn btn-info"  onclick="idok()">
		</c:if>
	</form>
</body>
</html>