// 1. String concatenation
console.log('my' + ' cat');
console.log('1'+2);
console.log('string literals : 1 + 2 = ${1 + 2}');

// 2. Numeric operators
console.log(2**3); // exponentiation, 거듭제곱

// 3. Increment and decrement operators
let counter = 2;
const preIncrement = ++counter;
const postIncrement = counter++;

// 4. Assignment operators
let x = 3;
let y = 6;
x += y; // x = x + y;

// 5. Comparison operators < <= > >=

// 6. Logical operators : ||(or), &&(and), !(not)

// 7. Equality
const stringFive = '5';
const numberFive = 5;

// == loose equality, with type conversion
console.log(stringFive == numberFive);
console.log(stringFive != numberFive);

// === strict equality, no type conversion 즉 타입이 같지 않으면 같지 않다고 보고 타입이 같아야 같다고 봄.
// 코딩할 때는 웬만하면 이걸 사용해서 검사하는 게 좋음.
console.log(stringFive === numberFive);
console.log(stringFive !== numberFive);

// object equality by reference
const sh1 = {name: 'sh'};
const sh2 = {name: 'sh'};
const sh3 = sh1;
console.log(sh1 == sh2); // 둘이 갖고 있는 reference가 다르므로 false.
console.log(sh1 === sh2); // 둘이 데이터타입이 같다고 하더라도 갖고 있는 reference가 다르므로 false.
console.log(sh1 === sh3); // true.

// 8. Conditional operators: if, else if, else

// 9. Ternary operator : condition ? value1 : value2;
// 조건이 참이면 value1, 거짓이면 value2를 출력.

// 10. Switch statement
// - use for multiple if checks
// - use for enum-like value check
// - use for multiple type checks in TS

// 11. Loops : while, do-while, for





