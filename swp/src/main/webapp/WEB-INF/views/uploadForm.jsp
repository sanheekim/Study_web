<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>upload test</title>
</head>
<body>
    <form action="uploadForm" id="form1" method="POST" enctype="multipart/form-data">
        <input type="file" name="file" />
        <input type="submit" />
    </form>
    SavedFileName: ${ savedFileName }
    
    <hr />
    <form action="uploadForm" id="form2" method="POST" enctype="multipart/form-data" target="ifr">
        <input type="hidden" name="type" value="ifr" />
        <input type="file" name="file" />
        <input type="submit" value="iframe으로 제출" />
    </form>
    IFR-SavedFileName: <span id="upfile"></span>
    <iframe frameborder="0" width="0" height="0" name="ifr"></iframe>
    
    <hr />
    <div class="fileDrop"><p>Drop Hear!!</p></div>
    <div class="uploadedList"></div>
    
    <form action="uploadAjaxes" id="form3" method="POST" enctype="multipart/form-data">
        <input type="hidden" name="type" value="ajax" />
        <!-- <input type="file" name="file[]" id="ajax-file" style="display:none;" /> -->
        <input type="file" name="files" id="ajax-file" style="display: none;" />
        <input type="submit" value="ajax로 제출" />
    </form>
    <div id="percent">0 %</div>
    <div id="status">ready</div>
    
<script src="/resources/plugins/jQuery/jQuery-2.1.4.min.js"></script>
<script src="/resources/plugins/jQuery/jQuery.form.min.js"></script>    
<script>
console.debug("00000")
window.setUploadedFile = (filename) => {
    document.getElementById('upfile').innerHTML = filename;
    document.getElementById("form2").reset();
};

const $fileDrop = $('div.fileDrop'),
      $uploadedList = $('div.uploadedList');
      
$fileDrop.on('dragover dragenter', (evt) => {
	evt.preventDefault();
	$fileDrop.css("border", "1px dotted green");
});
$fileDrop.on('dragleave', (evt) => {
    evt.preventDefault();
    $fileDrop.css("border", "none");
});
$fileDrop.on('drop', (evt) => {
    evt.preventDefault();
    let files = evt.originalEvent.dataTransfer.files;
    console.debug("drop>>", files);
    $fileDrop.css("border", "none");
    //$fileDrop.html(files[0].name);
    $("#ajax-file").prop("files", evt.originalEvent.dataTransfer.files);
    $('#form3').submit();
});

const $percent = $('#percent'),
      $status = $('#status'),
      $uplist = $('div.uploadedList');
      
$('#form3').ajaxForm({
    beforeSend: function() {
    	let f = $('#ajax-file').val();
    	console.debug("beforeSend!!", f);
    	if (!f) return false;
        $status.empty();
        $percent.html('0%');
    },
    uploadProgress: function(event, position, total, percentComplete) {
    	console.debug("progress...");
    	$status.html('uploading...');
        $percent.html(percentComplete + '%');
    },
    complete: function(xhr) {
    	console.debug("complete!!", xhr)
    	let originalName = getOriginalName(xhr.responseText);
    	console.debug("QQQ>>", originalName)
    	let uf = '<a href="/displayFile?fileName=' + xhr.responseText + '">' + originalName + '</a>';
    	let ocd = "deleteFile('" + xhr.responseText + "')";
    	uf += ' <a href="javascript:;" onclick="' + ocd + '">X</a>';
    	$uplist.append('<div>' + uf + '</div>')
        $status.html(uf + ' Uploaded');
    }
});

function deleteFile(fileName) {
	sendAjax("/deleteFile?fileName=" + fileName, (isSuccess, res) => {
        if (isSuccess) {
            alert(fileName + " Removed.");
            let a = $('div.uploadedList div a[href="/displayFile?fileName=' + fileName + '"]');
            console.debug("aaaaaaaaa>>", a);
            a.parent().remove();
        } else {
            console.debug("Error on deleteFile>>", res);
        }
    }, 'DELETE');
}

function getOriginalName(fileName) {
	let ret = fileName.substring(fileName.indexOf('_') + 1);
	console.debug("ori>>", ret)
	
	if (checkImageType(fileName)) {
		ret = ret.substring(ret.indexOf('_') + 1);
		console.debug("IMAGE!!")
		return '<img src="/displayFile?fileName=' + fileName + '" alt="' + ret + '">';
		
	} else {
	    return ret;
	}
	
}

function checkImageType(fileName) {
	let pattern = /jpg$|png$|gif$/i;
	return fileName.match(pattern);
}

function sendAjax(url, fn, method, jsonData) {
    let options = {
                    method: method || 'GET',
                    url: url, 
                    contentType: 'application/json'
                  };
    if (jsonData)
        options.data = JSON.stringify(jsonData);
    
    $.ajax(options).always((responseText, statusText, ajaxResult) => {
        // console.log("aaa", responseText, statusText, ajaxResult);
        let isSuccess = statusText === 'success';
        fn(isSuccess, responseText);
        if (!isSuccess) {
            alert("오류가 발생하였습니다!! (errorMessgae:" + responseText + ")");
        }
    });
}

</script>    

<c:if test="${ type eq 'ifr' }">
<script>
  console.debug("-------------ifr script!!")
  parent.setUploadedFile('${ savedFileName }');
</script>
</c:if>
</body>
</html>