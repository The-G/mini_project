<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원관리</title>
<script type="text/javascript"
	src='<c:url value="/resource/js/member.js"/>'></script>
</head>
<body>
	<h2>회원수정</h2>
	<form action="memberUpdate.do" method="post" name="frm">
		<table>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" size="20"
					value="${mVo.name}" readonly></td>
			</tr>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="userid" size="20"
					value="${mVo.userid}" readonly></td>
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
				<td><input type="text" name="email" size="20"
					value="${mVo.nickname}"></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" name="email" size="20"
					value="${mVo.email}"></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" name="phone" size="20"
					value="${mVo.phone}"></td>
			</tr>
			<tr>
				<td>당신의 최악의 영화는?</td>
				<td><input type="text" name="bestmovie" size="20"
				     value="${mVo.worstMovie}"></td>
			</tr>
			<tr>
				<td>성별</td>
				<td><c:choose>
						<c:when test="${mVo.gender==0}">
							<input type="radio" name="gender" value="0" checked="checked">남성
				            <input type="radio" name="gender" value="1">여성
                    </c:when>
						<c:otherwise>
							<input type="radio" name="gender" value="0" >남성
				            <input type="radio" name="gender" value="1" checked="checked">여성
                       </c:otherwise>
					</c:choose></td>
			</tr>
			
				<tr>
				<td>이메일 수신여부</td>
				<td><c:choose>
						<c:when test="${mVo.receiveEmail==0}">
							<input type="radio" name="receiveEmail" value="0" checked="checked">예
				            <input type="radio" name="receiveEmail" value="1">아니요
                        </c:when>
						<c:otherwise>
							<input type="radio" name="receiveEmail" value="0" >예
				            <input type="radio" name="receiveEmail" value="1" checked="checked">아니요
                      </c:otherwise>
					</c:choose></td>
			</tr>
			
				<tr>
				<td>SNS 수신여부</td>
				<td><c:choose>
						<c:when test="${mVo.receiveSns==0}">
							<input type="radio" name="receiveSns" value="0" checked="checked">예
				            <input type="radio" name="receiveSns" value="1">아니요
                        </c:when>
						<c:otherwise>
							<input type="radio" name="receiveSns" value="0" >예
				            <input type="radio" name="receiveSns" value="1" checked="checked">아니요
                      </c:otherwise>
					</c:choose></td>
			</tr>
			
			<tr>
				<td colspan="2" align="center"><input type="submit" value="확인"
					onclick="return joinCheck()">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="reset" value="초기화">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>