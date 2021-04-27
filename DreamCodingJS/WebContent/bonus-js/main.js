// primitive type : number, string, boolean, null, undefined, (symbol)
let number = 2;
// data가 복사됨
let number2 = number;
console.log(number); // 2
console.log(number2); // 2
number2 = 3;
console.log(number); // 2
console.log(number2); // 3

// object : 위의 데이터타입들을 제외한 나머지,
// 즉 한두 가지의 다양한 데이터를 한 군데에 묶어둔 것. ex) 배열, 리스트, 함수
let obj = {
    name: 'ellie',
    age: 5;
};
console.log(obj.name) // ellie
// data가 아니라 data 여러 개를 묶은 object의 주소값이 복사됨
let obj2 = obj;
console.log(obj2.name) // ellie
obj.name = 'james';
console.log(obj.name) // james
console.log(obj2.name) // james
/* obj = {
    name: 'james',
    age: 7;
} */
// obj 안에 있는 data는 위 21번째줄처럼 덮어씌우는 게 가능함
// 하지만 이미 선언된 자체적인 obj 위에 새로운 걸 덮어씌울 수 없음
// primitive type은 const(상수)를 제외한 나머지 data는 덮어씌울 수 있음

let a = 2;
a = 5; // 변수라서 변경 가능.
const num = 2;
// num = 4; // 에러남. 상수는 변경 불가능.
