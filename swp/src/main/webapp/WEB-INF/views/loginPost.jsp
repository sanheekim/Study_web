<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="header.jsp"%>
	<div>
		<div class="text-center text-danger mtb50">${ loginResult }</div>
		
		<div class="box-footer text-center">
		  <a href="/login" class="btn btn-primary">Retry Sign In</a>
		</div>

	</div>

<%@ include file="footer.jsp"%>

</html>