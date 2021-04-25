// 1. 함수는 크게 두 가지 타입. 선언과 호출에 필기함.
// 2. 함수 안에서 함수를 호출하려면 doSomething(add());나 doSomething(add(1,2));처럼 괄호를 붙이고,
//    인자로 '전달'만 하려면 doSomething(add);라고만 해주기.

// 함수 선언
function doSomething(add) {
    console.log('add');
    const result = add (2, 3);
    console.log(result);
}

function add(a, b) {
    const sum = a + b;
    return sum;
}

// 함수 호출
doSomething(add);


