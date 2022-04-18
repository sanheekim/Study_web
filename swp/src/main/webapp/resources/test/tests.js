QUnit.test( "헬로 월드", (assert) => {
  assert.equal( 1, 1, "1 >> 통과!" );
  
  assert.ok(1 == '1', "2 >> Pass == OK!")
  assert.ok(1 === '1', "3 >> Pass === OK!");
  
  assert.equal( 1, '1', "4 >> 통과!" );
  assert.strictEqual(1, '1', "5 >> Pass StrictEqual!");
  
  let arr1 = [1,2,3],
  	  arr2 = [1,2,3],
  	  arr3 = [1,3,2],
  	  arr4 = [3,4,5];
  
  assert.equal(arr1, arr2, "6 >> Pass1 = 2");
  assert.strictEqual(arr1, arr2, "7 >> Pass1 s= 2");
  assert.deepEqual(arr1, arr2, "8 >> Pass1 d= 2");
  
  assert.deepEqual(arr3, arr2, "9 >> Pass3 d= 2");
  
  let j1 = {id: 1, name: 'hong'},
  	  j2 = {id: 1, name: 'hong'},
  	  j3 = {id: 12, name: 'hong12'};
  
  assert.equal(j1,j2, "10 >> j1 = j2");
  assert.deepEqual(j1, j2, "11 >> j1 d= j2");
  assert.deepEqual(j1, j3, "12 >> j1 d= j3");
});