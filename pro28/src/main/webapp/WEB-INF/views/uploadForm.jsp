<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드 하기</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script>
	var cnt=1;
	function fn_addFile(){
		$("#d_file").append("<br>"+"input type='file' name='file"+cnt+"'/>");
		cnt++;
	}
</script>
</head>
<body>
	<h1>파일 업로드 하기</h1>
	
</body>
</html>