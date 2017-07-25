<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 관리</title>
<script type="text/javascript" src='<c:url value="/resource/js/member.js"/>'></script>
</head>
<body>
	<h2>회원가입</h2>
	"*" 표시 항목은 필수 입력 항목입니다.
	<form method="post" action="join.do" name="frm">
		<table>
			<tr>
				<td>* 이름</td>
				<td><input type="text" name="name" size="20"></td>
			</tr>
			<tr>
				<td>* 아이디</td>
				<td><input type="text" name="userid" size="20" id="userid">
					<input type="hidden" name="reid" size="20"> <input
					type="button" value="중복체크" onclick="idCheck()"></td>
			</tr>
			
			<tr>
				<td>* 비밀번호</td>
				<td><input type="password" name="pwd" size="20"></td>
			</tr>
			<tr>	
				<td>* 비밀번호 확인</td>
				<td><input type="password" name="pwd_check" size="20"></td>
			</tr>
			
			<tr>
				<td>닉네임</td>
				<td><input type="text" name="nickname" size="20"></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" name="email" size="20"></td>
			</tr>
			<tr>
				<td>휴대폰번호</td>
				<td><input type="text" name="phone" size="20"></td>
			</tr>
			<tr>
				<td>당신의 최악의 영화는?</td>
				<td><input type="text" name="worstMovie" size="20"></td>
			</tr>
			<tr>
			<td>성별</td>
			<td><input type="radio" name="gender" value="0" checked="checked">남성
				<input type="radio" name="gender" value="1">여성
			</td>
			</tr>
			<tr>
			<td>이메일 수신 여부</td>
            <td>
            <input type="radio" name="receiveEmail" value="0" checked="checked">예
            <input type="radio" name="receiveEmail" value="1">아니요
            </td>
            </tr>
            <tr>
            <td>SNS수신여부</td>
            <td>
            <input type="radio" name="receiveSns" value="0" checked="checked">예
            <input type="radio" name="receiveSns" value="1">아니요
            </td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
				<input type="submit" value="확인" onclick= "return joinCheck()"> &nbsp;&nbsp;&nbsp;&nbsp; 
			    <input type="reset" value="취소"></td>
			</tr>
			<tr>
				<td colspan="2">${message}</td>
			</tr>
		</table>
	</form>
</body>
</html>