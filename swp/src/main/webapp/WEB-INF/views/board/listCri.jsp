<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ include file="../header.jsp"%>

<c:set var="resultMsg" value="" />
<c:choose>
    <c:when test="${msg eq 'success'}">
        <c:set var="resultMsg" value="등록 되었습니다." />
    </c:when>
   
    <c:when test="${msg eq 'dummy10-ok'}">
        <c:set var="resultMsg" value="10개의 더미 데이터가 등록되었습니다." />
    </c:when>

    <c:otherwise>
        
    </c:otherwise>
</c:choose>

<c:if test="${ null ne msg }">
    <div class="alert alert-success alert-dismissible" role="alert">
	  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	  <strong>와우!</strong> ${ resultMsg }
	</div>
</c:if>



<section class="content">
	<div class="row">
		<div class="col-12 text-right">
			<button onclick="dummy10()" class="btn btn-danger">Dummy10</button>
			<a href="/board/register" class="btn btn-success">글쓰기</a>
		</div>
	</div>

	<div class="row">
		<div class="col-12">
			<table class="table table-bordered">
			
				<tr>
					<th style="width: 10px">#</th>
					<th>제목</th>
					<th>작성자</th>
					<th>등록일</th>
					<th>조회수</th>
				</tr>
				
			<c:forEach items="${list}" var="board">
				<tr>
					<td>${ board.bno }</td>
					<td><a href="/board/read?bno=${board.bno}">${ board.title }</a></td>
					<td><strong>${ board.writer }</strong></td>
					<td><fmt:formatDate pattern="YYYY-MM-dd HH:mm:ss" value="${ board.regdate }"/></td>
					<td><span class="badge bg-red">${ board.viewcnt }</span></td>
				</tr>
			</c:forEach>
				
			</table>
		</div>
	</div>

</section>

<script>
	function dummy10() {
		console.log("+++++++++++++++++++++++++")
		if ( confirm("Are u sure??") ) {
			window.location.href = "/board/dummy10";
		}
	}
</script>

<%@ include file="../footer.jsp"%>
</html>