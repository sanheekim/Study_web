<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%
	session.setAttribute("address", "수원시 팔달구");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 출력창</title>
</head>
<body>
	<table border="1" align="center">
		<tr align="center" bgcolor="#99ccff">
			<td width="20%">아이디</td>
			<td width="20%">비밀번호</td>
			<td width="20%">이름</td>
			<td width="20%">이메일</td>
			<td width="20%">주소</td>
		</tr>
		<tr align="center">
			<td>${ id }</td>
			<td>${ pwd }</td>
			<td>${ name }</td>
			<td>${ email }</td>
			<td>${ address }</td>
		</tr>
	</table>
</body>
</html>