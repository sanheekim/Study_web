const $fileDrop = $('div.fileDrop');

let gUri = window.location.pathname,
	gIsRegister = gUri.indexOf('/register') !== -1,
	gIsUpdate = gUri.indexOf('/update') !== -1,
	gIsEditing = gIsRegister || gIsUpdate,
	gIsDirect = false;

$fileDrop.on('dragover dragenter', (evt) => {
    evt.preventDefault();
	$fileDrop.css("border", "2px dotted green");
});

$fileDrop.on('dragleave', (evt) => {
    evt.preventDefault();
    $fileDrop.css("border", "1px dotted gray");
});

$fileDrop.on('drop', (evt) => {
    evt.preventDefault();
	let files = evt.originalEvent.dataTransfer.files;
	console.debug("drop>>", files);
	$fileDrop.css("border", "1px dotted gray");
	$("#ajax-file").prop("files", evt.originalEvent.dataTransfer.files);
	$('#form_attach').submit();
});

const $percent = $('#percent'),
      $status = $('#status');
      
let gUpFiles = [];
$('#form_attach').ajaxForm({
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
    	console.debug("xhr>>", xhr)
    	let resJson = xhr.responseJSON; // array
    	if (xhr.status !== 201) {
    		alert("Error on Upload!! (" + resJson[0] + ")" )
    		return;
    	}
        console.debug("complete!!", resJson)
        resJson.forEach( rj => {
	        let jsonData = getFileInfo(rj);
	        gUpFiles.push(jsonData);
        });
        $status.html(resJson.length + ' files Uploaded');
        renderHbs('template', {upFiles: gUpFiles });
        
        $('#board-files').val(gUpFiles);
    }
});

function deleteFile(fullName, bno) {
	let fileInfo = getFileInfo(fullName);
	console.debug("bno>>>>>", bno)
	if (!confirm("삭제된 파일은 복구되지 않습니다. 그래도 삭제하시겠어요??"))
		return;
	
	let url = "/deleteFile?fileName=" + fullName;
	if (bno)
		url += "&bno=" + bno;
	
	sendAjax(url, (isSuccess, res) => {
        if (isSuccess) {
            alert(fileInfo.fileName + " Removed.");
            
            $('li#' + fileInfo.fileId).remove(); // dom removed
            
            let tmpIdx = -1;
            gUpFiles.forEach( (uf, idx) => {
                if (uf.fullName === fullName)
                	tmpIdx = idx;
            });
            gUpFiles.splice(tmpIdx, 1);
            
        } else {
            console.debug("Error on deleteFile>>", res);
        }
    }, 'DELETE');
}

function checkImageType(fileName) {
    let pattern = /jpg$|png$|gif$/i;
    return fileName.match(pattern);
}

function getFileInfo(fullName) {
	let fileName, imgsrc, getLink, fileLink;
	let $isdirect = $("#form_attach input#isdirect"),
	    isdirect = $isdirect && $isdirect.length && $isdirect.val() == "true";
  	
	console.debug("isdirect>>>>>>", isdirect)
	isdirect = isdirect ? true : gIsDirect;
	
	const uphost = window.location.protocol + "//" + window.location.hostname; 
	if (checkImageType(fullName)) {
		if (isdirect)
			imgsrc = uphost + "/uploads" + fullName;
		else
			imgsrc = "/displayFile?fileName=" + fullName;
		
		fileLink = fullName.substring(14); // 원본파일명/2018/09/00/s_
		let front = fullName.substring(0,12),
	        end = fullName.substring(14);
		getLink = "/displayFile?fileName=" + front + end; //원본파일보기용 URI
	
	} else {
		imgsrc = "/resources/dist/img/file_icon.jpeg";
		fileLink = fullName.substring(12); // 원본파일명/2018/09/00/
		getLink = "/displayFile?fileName=" + fullName;
	}
	
	if (isdirect)
		getLink += "&isdirect=true";
	
	// 실제파일명 (fileLink = asdfsafsdafdsaf_realname.ext)
	fileName = fileLink.substring(fileLink.indexOf('_') + 1);
	let fileId = fileLink.substring(0, fileLink.indexOf('_'));
//	console.debug("fileId>>", fileId)
	
	return {
	    fileName: fileName,
	    imgsrc: imgsrc,
	    getLink: getLink,
	    fullName: fullName,
	    fileId: fileId,
	    isEditing: gIsEditing
	};
}