<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시험 점수 입력 페이지</title>
</head>
<body>
	<h1>시험 점수를 입력해 주세요</h1>
	<form action="scoreResult2.jsp" method="get">
		시험점수: <input type="text" name="score" /><br>
		<input type="submit" value="학점변환" />
	</form>
</body>
</html>