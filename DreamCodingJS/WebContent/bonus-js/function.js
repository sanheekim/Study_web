const num = 1;
const num2 = 2;
const result = num + num2;
console.log(result); // 3

const num3 = 1;
const num4 = 2;
const result2 = num3 + num4; // 3

function add(a, b){
    return a + b;
}

const sum = add(3, 4);
console.log(sum); // 7

const doSomething = add;
const result = doSomething(2, 3);
console.log(result); // 5
const result2 = add(2, 3);
console.log(result2); // 5

function print(){
    console.log('print');
}

print(); // print
print(8, 33); // print. 아무리 많은 input을 전달해도 함수에서 인자를 받지 않기 때문에 지정한 문자인 print만 출력 됨.

function divide(num1, num2) {
    return num1 / num2;
}
function surprise(operator) {
    const result = operator(2, 3);
    console.log(result);
}

// surprise(); // error
surprise(add); // 5
surprise(divide); // 0.66666666