QUnit.test( "헬로 월드", (assert) => {
  assert.equal( 1, 1, "통과!" );
});


const pageMaker = {
 "displayPageNum": 10,
 "totalCount": 313,
 "startPage": 1,
 "endPage": 10,
 "prev": false,
 "next": true,
 "criteria": {
  "page": 1,
  "perPageNum": 10,
  "searchType": null,
  "keyword": null,
  "pageStart": 0
 }
};

const gTestMakePageResultExpect = {
  "prevPage": 0,
  "pages": [
    1,
    2,
    3,
    4,
    5,
    6,
    7,
    8,
    9,
    10
  ],
  delim: "|",
  "nextPage": 11
};

//QUnit.test( "Test makePageData() by PageMaker", (assert) => {
//	let resultReal = makePageData(pageMaker);
//	
//	assert.deepEqual( resultReal, gTestMakePageResultExpect, "makePageData() 통과!" );
//});

QUnit.test( "Test listPage() for First Page", (assert) => {
		let page = 1,
			url = "/replies/" + 222 + "/" + page;
//		console.debug("url>>>", url)
		
		const done = assert.async();
		
		sendAjax(url, (isSuccess, res) => {
//			console.debug("listPage:res>>", res);
			assert.ok(isSuccess, "AJAX 성공!");
			if (isSuccess) {
				res.currentPage = page;
				res.pageData = makePageData(res.pageMaker);

				assert.equal(res.list.length, 10, "Pass List Count 10!");
				assert.deepEqual( res.pageData, gTestMakePageResultExpect, "makePageData() 통과!" );

				let firstReply = res.list[0];
				readReply(firstReply.rno).then(
						success => {
							console.debug("SUCCESS>>", success);
							assert.deepEqual(firstReply, success, "Reply READ OK!!");
							done();
						},
						error => {
							console.error("ERROR on ReadReply>>", error);
							done();
						}
				);

			} else {
				throw new Error("list ajax fail!!");
			}
			
		});

	
});



























/*
 * 
 * QUnit.test("listPage test", assert => { assert.equal(1, 2, "TTT");
 * 
 * let url = "/replies/" + 2 + "/" + 1; console.log("url>>>", url)
 * 
 * const done = assert.async() sendAjax(url, (isSuccess, res) => {
 * console.debug("listPage:res>>", Object.keys(res)); assert.ok(isSuccess, "AJAX
 * 성공!"); if (isSuccess) { } done(); }); });
 */