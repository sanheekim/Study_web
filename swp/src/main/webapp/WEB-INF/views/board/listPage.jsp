<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

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
		<button type="button" class="close" data-dismiss="alert"
			aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
		<strong>와우!</strong> ${ resultMsg }
	</div>
</c:if>



<section class="content">
	<div class="row">
	    <div class="col-md-8 bordered">
	       <div class="form-inline">
	           <select id="searchType" class="form-control">
	              <option value="" selected>검색조건</option>
	              <option value="t">제목</option>
	              <option value="c">내용</option>
	              <option value="w">작성자</option>
	              <option value="tc">제목+내용</option>
	              <option value="a">전체조건</option>
	           </select>
		       <input type="text" id="keyword" name="keyword" class="form-control"
		        value="${pageMaker.criteria.keyword}" placeholder="검색어를 입력하세요..." />
		       <button id="searchBtn" class="btn btn-primary">Search</button>
		       
		       <span class="ml10">${ loginTime } - ${ UNAME } logined (IP: ${ loginIP })</span>
		    </div>
	    </div>
	    
		<div class="col-md-4 text-right">
		    <select id="perPageSel">
		      <option value="10">10</option>
		      <option value="20">20</option>
		      <option value="50">50</option>
		    </select>
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
						<td>
						  <a href="/board/read${pageMaker.makeQuery(pageMaker.criteria.page)}&bno=${board.bno}">
						      ${ board.title }
						  </a>
						  <small class="text-muted">[${ board.replycnt }]</small>
						</td>
						<td><strong>${ board.writer }</strong></td>
						<td><fmt:formatDate pattern="YYYY-MM-dd HH:mm:ss"
								value="${ board.regdate }" /></td>
						<td><span class="badge bg-red">${ board.viewcnt }</span></td>
					</tr>
				</c:forEach>

			</table>

            <div class="text-center">
				<nav aria-label="Pagination">
					<ul class="pagination">
					
					   	<li id="page-prev">
							 <a href="listPage${ pageMaker.makeQuery(pageMaker.startPage - 1) }" onclickX="gogo(${ pageMaker.startPage - 1 })" aria-label="Previous">
							     <span aria-hidden="true">&laquo;</span>
							 </a>
						</li>
					   
						<!-- loop -->   
						<c:forEach begin="${ pageMaker.startPage }" end="${ pageMaker.endPage }" var="idx"> 
						  <li class="pagelist" id="page${idx}">
						      <a href="listPage${ pageMaker.makeQuery(idx) }" onclickX="gogo(${idx})">${ idx } <span class="sr-only">(current)</span></a>
						  </li>
						</c:forEach>
						
						<li id="page-next">
						    <a href="listPag${ pageMaker.makeQuery(pageMaker.endPage + 1) }" onclickX="gogo(${ pageMaker.endPage + 1 })" aria-label="Next">
						        <span aria-hidden="true">&raquo;</span>
						    </a>
						</li>
						
					</ul>
				</nav>
			</div>
			
		</div>
	</div>

</section>

<script>
	function dummy10() {
		console.log("+++++++++++++++++++++++++")
		if (confirm("Are u sure??")) {
			window.location.href = "/board/dummy10";
		}
	}
	
	function setSelect() {
		var perPageNum = "${pageMaker.criteria.perPageNum}";
		console.log(">>perPageNum=", perPageNum);
		
		var $perPageSel = $("#perPageSel");
		$perPageSel.val(perPageNum).prop("selected", true);
		
		var thisPage = '${pageMaker.criteria.page}';
		$perPageSel.on('change', function() {
			console.log(":::::", $perPageSel.val())
			gogo(thisPage, $perPageSel.val());
		});
	}
	
	function gogo(page, perPageNum) {
		perPageNum = perPageNum || $("#perPageSel").val();
		window.location.href = "listPage?page=" + page + "&perPageNum=" + perPageNum;
	}
	
	$(document).ready( function() {
		setSelect();
		
		var canPrev = "${pageMaker.prev}";
		console.log("canPrev>>", canPrev)
		if (canPrev !== 'true') {
			var $prev = $('#page-prev');
			$prev.addClass('disabled');
			$prev.find('a').attr('href', '#');
		}

		var canNext = "${pageMaker.next}";
		if (canNext !== 'true') {
            $('#page-next').addClass('disabled');
        }		
		
	    var thisPage = '${pageMaker.criteria.page}';        
	    $('#page' + thisPage).addClass('active');
	    
	    $('#searchBtn').on('click', function(event) {
	    	event.preventDefault();
	    	
	    	var $keyword = $('#keyword');
	    	var $searchType = $('#searchType');
	    	
	    	var searchTypeVal = $searchType.val();
	    	var keywordStr = $keyword.val();
	    	console.log("keyword>>", keywordStr);
	    	
	    	if (!searchTypeVal) {
	    		alert('검색조건을 선택하세요!');
	    		$searchType.focus();
	    		return;
	    	} else if (!keywordStr) {
	    		alert("검색어를 입력하세요!");
	    		$keyword.focus();
	    		return;
	    	}
	    	
	    	var url = "listPage${pageMaker.makeQuery(1, false)}"
	    	        + "&searchType=" + searchTypeVal
	    	        + "&keyword=" + encodeURIComponent(keywordStr);
	    	console.log(">>search.url=", url)
	    	window.location.href = url;
	    });
    });
</script>

<%@ include file="../footer.jsp"%>
</html>