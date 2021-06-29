<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<c:set var="id" value="hong" scope="page" />
<c:set var="pwd" value="1234" scope="page" />
<%-- <c:set var="name" value="${'홍길동' }" scope="page" /> --%>
<c:set var="age" value="${22 }" scope="page" />
<c:set var="height" value="${177 }" scope="page" />
<!DOCTYPE html>
<html>
<head>
<title>조건문 실습</title>
</head>
<body>
	<table border="1" align="center">
		<tr align="center" bgcolor="#99ccff">
			<td width="7%">아이디</td>
			<td width="7%">비밀번호</td>
			<td width="7%">이름</td>
			<td width="7%">나이</td>
			<td width="7%">키</td>
		</tr>
		<c:choose>
			<%-- <c:when test="${name==null"> --%>
			<c:when test="${empty name }">
				<tr align="center">
					<td colspan=5>이름을 입력하세요!</td>
				</tr>
			</c:when>
			<c:otherwise>
				<tr align="center">
					<td>${id }</td>
					<td>${pwd }</td>
					<td>${name }</td>
					<td>${age }</td>
					<td>${height }</td>
				</tr>
			</c:otherwise>
		</c:choose>
	</table>
</body>
</html>