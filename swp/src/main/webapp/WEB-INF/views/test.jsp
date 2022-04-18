<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!doctype html>
<html lang="ko">
<head>
	<meta charset="UTF-8" />
	<title>Home Test</title>
    <link rel="stylesheet" href="/resources/style.css" />
</head>
<body>

    <h2 id="h2-title" class="point">Ajax Test Page</h2>
    
    <div id="modDiv">
    	<div class="modal-title">
    	   <span id="mod-rno"></span>
    	   <div><textarea type="text" rows="2" cols="30" id="replytext"></textarea></div>
    	</div>
    	<div class="mt10 text-right">
    		<button onclick="editReply()" id="btnModReply">수정</button>
    		<button onclick="removeReply()" id="btnDelReply">삭제</button>
    		<button onclick="closeMod()" id="btnCloseReply">닫기</button>
    	</div>
    </div>
      
    <!-- reply list -->
    <ul id="replies">
    </ul>
    
    <ul class="pagination">
    </ul>
    
    <div>
        <div>
            작성자: <input type="text" name="replyer" id="newReplyWriter" value="" />
        </div>
        <div>
            내용: <textarea name="replytext" id="newReplyText" cols="30" rows="3"></textarea>
        </div>
        <button id="btnReplyAdd" class="btn btn-primary">등록</button>
    </div>
    
    
    <div><a href="#" id="defaultValueSetter">QQQ</a></div>
    <div><a href="#" id="btnShowData">QQQ:ShowData</a></div>

<script src="/resources/plugins/jQuery/jQuery-2.1.4.min.js"></script>
<script src="/resources/test.js?ver=1"></script>
<script>
$(document).ready(function() {
//  $('#h2-title').on('click', listAll);

    $('#btnReplyAdd').on('click', regist);
    $('#btnShowData').on('click', showData);
    
	$('#defaultValueSetter').on('click', () => { 
		$('#newReplyWriter').val("홍길동");
		$('#newReplyText').val("댓글내용입니다!!222");
		
		$('#btnReplyAdd').click();
	});
	
	makeCenterModDiv();
});
</script>
</body>
</html>
