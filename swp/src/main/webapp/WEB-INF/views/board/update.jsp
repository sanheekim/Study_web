<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../header.jsp"%>

<script>
    var result = '${msg}';
    if (result === 'save-ok') {
        alert("OK");
    }
</script>

    <form role="form" action="/board/update${criteria.makeQuery()}" method="post">
        <input type="hidden" name="bno" value="${ board.bno }" />
        <div class="box-body">
            <div class="form-group">
                <label>글번호</label> <span>${ board.bno}</span>
            </div>
            
            <div class="form-group">
                <label for="title">제목</label> <input type="text" id="title"
                    name="title" value="${board.title}" class="form-control" placeholder="title..." />
            </div>

            <div class="form-group">
                <label for="content">내용</label>
                <textarea name="content" id="content" cols="30" rows="3"
                    class="form-control" placeholder="내용..">${ board.content }</textarea>
            </div>

        </div>
        
        <div class="form-group">
           <label for="">File Drop Here!</label>
           <div class="fileDrop text-right">
             <div id="percent">0 %</div>
             <div id="status">ready</div>
           </div>
        </div>
        
        <ul class="mailbox-attachments clearfix uploadedList">
            <%@ include file="uploadedFiles.jsp"%>  
        </ul>

        <div class="box-footer">
            <a href="/board/read${criteria.makeQuery()}&bno=${board.bno}" class="btn btn-default">Cancel</a>
            <button type="submit" class="btn btn-primary">Submit</button>
        </div>

    </form>
    
    <form action="/uploadAjaxes" id="form_attach" method="POST" enctype="multipart/form-data">
       <input type="hidden" name="isdirect" id="isdirect" value="true" />
       <input type="hidden" name="bno" value="${ board.bno }" />
       <input type="file" name="files" id="ajax-file" style="display: none;" />
       <!-- <input type="submit" value="ajax로 제출" /> -->
    </form>
        
<script>
showAttaches(${board.bno});
</script>

<%@ include file="../footer.jsp"%>
</html>