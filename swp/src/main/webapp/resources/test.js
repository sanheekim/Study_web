const BNO = 2,
      LIST_URL = "/replies/" + BNO + "/",
      REGIST_URL = "/replies/";

function listPage(page) {
	page = page || 1;
//	console.debug("======================== listPage");
	
	sendAjax(LIST_URL + page, (isSuccess, res) => {
		console.debug("listPage:res>>", res);
		if (isSuccess) {
			let data = res.list,
				pageMaker = res.pageMaker;
			
			let str = "";
			data.forEach(
			  (d) => {
			     str += `<li data-rno="${d.rno}" data-replyer="${d.replyer}" class="replyLi">
			               ${d.rno} <span>${d.replytext}</span>
			               <button onclick=modClicked(this) class="point">수정</button>
			             </li>`;
			  }
			); // end of loop
			
			$('#replies').html(str);
			
			printPage(pageMaker);
		}
	});
}

function printPage(pm) {
	console.debug(pm);
	let str = "",
		tmpPage = 0;
	if (pm.prev) {
		tmppage = pm.startPage - 1;
		str = `<li><a href="#" onclick="listPage(tmpPage)" data-pge="${tmpPage}">&lt;&lt;</a></li>`; 
	}
	
	let currentPage = pm.criteria.page;
	for (let i = pm.startPage; i <= pm.endPage; i++) {
		let activeCss = currentPage === i ? "active" : "";
		str += `<li><a href="#" onclick="listPage(${i})" class="${activeCss}" data-pge="${i}">${i}</a></li>`;
	}
	  
	if (pm.next) {
		tmpPage = pm.endPage + 1;
		str += `<li><a href="#" onclick="listPage(tmpPage)" data-pge="${tmpPage}">&gt;&gt;</a></li>`;
	} 
	
	$('ul.pagination').html(str);
}

function showData() {
	let resultJson = [];
	$('#replies li').each( (idx, li) => {
		let $li = $(li),
			rno = $li.data('rno'),
			replyer = $li.data('replyer'),
			replytext = truncSpace($li.find('span').text());
	    //console.log(`rno=${rno}, replyer=${replyer}, replytext=${replytext}`);
	    resultJson.push( {
	       rno: rno,
	       replyer: replyer,
	       replytext: replytext
	    });
	});

	console.log(JSON.stringify(resultJson, null, '  '));
}

var truncSpace = function(str) {
	if (!str) return "";
	
	return str.replace(/[\n\r\t]/g, '').trim();
};

function makeCenterModDiv() {
	let $mod = $('#modDiv');
	$mod.css('margin-top', $mod.height() / 2 * -1);
	$mod.css('margin-left', $mod.width() / 2 * -1);
}

let workingRno = 0,
	workingReplytext = "",
	$workingReply = null;
function modClicked(btn) {
	console.log("bbbbbbbbbtn>>", btn);
	let $btn = $(btn),
		$reply = $btn.parent(),
		rno = $reply.data('rno'),
		replytext = truncSpace($reply.find('span').text());
	console.log("QQQQQQQ>>", $btn, $reply, rno);
	$('#modDiv').show('slow');
	$('#replytext').val(replytext);
	$('#mod-rno').text(rno);
	workingRno = rno;
	workingReplytext = replytext;
	$workingReply = $reply;
}

function regist() {
	let jsonData = getValidData( $('#newReplyWriter'), $('#newReplyText') );
	if (!jsonData)
		return;
	
	jsonData.bno = BNO;
	
	sendAjax(REGIST_URL, (isSuccess, res) => {
		if (isSuccess) {
			alert("등록되었습니다.");
			listPage();
		}
	}, 'POST', jsonData);
}

function editReply() {
	let editedReplytext = $('#replytext').val();
	if (editedReplytext === workingReplytext) {
		alert("내용이 수정되지 않았습니다!!");
		return;
	}
	
	let jsonData = { replytext: editedReplytext };
	sendAjax("/replies/" + workingRno, (isSuccess, res) => {
		if (isSuccess) {
			alert(workingRno + " Edited.");
//			listPage();
			$workingReply.find('span').text(editedReplytext);
			closeMod();
		} else {
			console.debug("Error on editReply>>", res);
		}
	}, 'PATCH', jsonData);
}

function removeReply() {
	console.log("aaaaaaaaaaaaaaaaaa", workingRno)
	if (!confirm("Are u sure??")) return;
	
	sendAjax("/replies/" + workingRno, (isSuccess, res) => {
		if (isSuccess) {
			alert(workingRno + " Removed.");
			listPage();
			closeMod();
		} else {
			console.debug("Error on removeReply>>", res);
		}
	}, 'DELETE');
}

function closeMod() {
	workingRno = 0;
	$('#replytext').text('');
	$("#modDiv").hide('slow');
}

function getValidData($replyer, $replytext) {
	let $errorFocus = null,
		replyer = $replyer.val(),
		replytext = $replytext.val(),
		errorMsg = "";

	if (!replyer) {
		errorMsg = "작성자를 입력하세요!";
		$errorFocus = $replyer;
		
	} else if (!replytext) {
		errorMsg = "내용을 입력하세요!";
		$errorFocus = $replytext;
	}
	
	if (errorMsg) {
		alert(errorMsg);
		$errorFocus.focus();
		return;
	}
	
	return {replyer: replyer, replytext: replytext};
}

//listPage     sendAjax(url, fn)
//listPage     sendAjax(url, fn, null, {page:3})
// update    sendAjax(url, fn, 'PUT', {...})
//delete   sendAjax(url, (s, res) => {}, 'DELETE')

function sendAjax(url, fn, method, jsonData) {
	let options = {
					method: method || 'GET',
					url: url, 
					contentType: 'application/json'
				  };
	if (jsonData)
		options.data = JSON.stringify(jsonData);
	
	$.ajax(options).always((responseText, statusText, ajaxResult) => {
		console.log("aaa", responseText, statusText, ajaxResult);
		let isSuccess = statusText === 'success';
		fn(isSuccess, responseText);
		if (!isSuccess) {
			alert("오류가 발생하였습니다!! (errorMessgae:" + responseText + ")");
		}
	});
} 

// ------------------
listPage();