/* 1. Function
- fundamental building block in the program
- sub-program can be used multiple times
- performs a task or calculates a value

- 하나의 함수는 하나의 동작만 해야 함.
- 함수는 '동사형태'로 네이밍 해야 함.
- function is object in JavaScript : 자바스크립트에서 함수는 오브젝트로 간주되므로
변수에 할당할 수 있고, 파라미터로 전달될 수도 있다. 리턴값으로도 리턴이 가능하다.

*/

function printHello(){
	console.log('Hello');
}

printHello();

function log(message){
	console.log(message);
}

log('Hello@');

/* 2. Parameters
premitive parameters: passed by value.
object parameters : passed by reference.
- premitive는 메모리에 값이 그대로 저장돼있어서 값 전달이 됨.
- object는 메모리에 reference가 저장됨. */

function changeName(obj){ // 무조건 coder로 이름을 바꾸는 함수
	obj.name = 'coder';
}

const ellie = {name: 'ellie'};
changeName(ellie);
console.log(ellie);

// 3. Default parameters (added in ES6)
// from에 원하는 디폴트값을 지정해놓으면 사용자가 파라미터를 전달하지 않을 때 이 값이 대체돼서 사용되어짐.

function showMessage(message, from = 'unknown'){
	console.log('${message} by ${from}');
}
showMessage('Hi');

// 4. Rest parameters (added in ES6)
// ... (온점 3개) : 레스트 파라미터스로 불리는 배열 형태.

function printAll(...args){
	for(let i = 0; i < args.length; i++){
		console.log(args[i]);
	}
	
	for(const arg of args) {
		console.log(arg);
	}
	
	args.forEach((arg) => console.log(arg));
}
printAll('dream', 'coding', 'ellie');

// 5. Local scope
// JS에서 scope란? 밖에서는 안이 보이지 않지만 안(지역변수)에서는 밖을 볼 수 있다.
let globalMessage = 'global'; // global variable, 전역변수
function printMessage(){
	let message = 'hello';
	console.log(message); // local variable, 지역변수
	console.log(globalMessage);
	function printAnother(){
		console.log(message);
		let childMessage = 'hello';
	}
	// console.log(childMessage); // error
}
printMessage();

// 6. Return a value
function sum(a, b){
	return a + b;
}
const result = sum(1, 2); // 3
console.log('sum: ${sum(1,2)}');

// 7. Early return, early exit
// bad
function upgradeUser(user){
	if (user.point > 10){
		// long upgrade logic..
	}
}
// good
function upgradeUser2(user){
	if (user.point <= 10) {
		return;
	}
	// long upgrade logic..
}



// 1-1. Function expression : 할당된 다음부터 호출 가능함.
const print = function (){ // function에 아무 이름이 없는 것 : anonymous function
	console.log('print');
}
print();
// 1-2. Function decoration : hoist가 가능함. 함수가 선언되기 이전에도 호출이 가능함. (이전 버전 var 처럼!)
const printAgain = print;
printAgain();
const sumAgain = sum;
console.log(sumAgain(1, 3));

// 2. Callback function using function expression
function randomQuiz(answer, printYes, printNo) {
	if (answer === 'love you') {
		printYes();
	} else {
		printNo();
	}
	}
	
const printYes = function (){
	console.log('yes!');
}

const printNo = function print(){
	console.log('no!');
	print(); // 함수 안에서 함수 자신을 호출하는 것 : recursions, 계속 하면 프로그램이 죽으므로 하면 안 됨
}
randomQuiz('wrong', printYes, printNo);
randomQuiz('love you', printYes, printNo);

// 3. Arrow Function : 함수를 간결하게 만들어줌.
// always anonymous
const simplePrint = function() {
	console.log('simplePrint!')
};

const simplePrint = () => console.log('simplePrint!')
const add = (a, b) => a + b;
const simpleMultiply = (a, b) => {
	// do something more
	return a * b;
};

// IIFE : Immediately Invoked Function Expression
// 선언함과 동시에 바로 호출. 최근 JS에서는 잘 사용하지 않음.
(function hello() {
	console.log('IIFE');
})();