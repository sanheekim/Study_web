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