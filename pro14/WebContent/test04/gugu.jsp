<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단 출력 예제</title>
</head>
<body>
	<h1>출력할 구구단의 수를 지정해 주세요</h1>
	<form action="guguResult2.jsp" method="get">
		출력할 구구단: <input type="text" name="dan" /><br>
		<input type="submit" value="출력" />
	</form>
</body>
</html>