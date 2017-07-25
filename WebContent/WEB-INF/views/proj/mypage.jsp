<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" href="/favicon.ico" />
</head>
<body>
안녕하세요. ${loginUser.name}(${loginUser.userid})님;</br>
영화관 가서 돈 버린적이 한 두 번 아니죠?</br>
긴가민가 할 때는 한 번 검색하세요!</br>
<input type="button" value="회원정보변경"
	onclick="location.href='memberUpdate.do?userid=${loginUser.userid}'">

</body>
</html>