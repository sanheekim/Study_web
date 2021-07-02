<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*, sec02.ex01.*"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:useBean id="m" class="sec02.ex01.MemberServlet" />
<jsp:setProperty name="m" property="*" />
<%
	MemberDAO memDAO = new MemberDAO();
	memDAO.addMember(m);
	List membersList = memDAO.listMembers();
	request.setAttribute("membersList", membersList);
	
%>
<title>Insert title here</title>
</head>
<body>
	<jsp:forward page="membersList.jsp" />
</body>
</html>