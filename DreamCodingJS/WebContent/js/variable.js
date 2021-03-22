/* 1. Use strict
added in ES 5
use this for Vanila Javascript. */
'use strict';

/* 2. Variable : 변수. 변하는 값. mutable data type. rw(read/write) 즉, 메모리의 값을 읽고 쓰는 것이 가능함.
let (added in ES6)

이 전에는 var를 썼었음.
var는
- 변수를 선언하기도 전에 값을 넣을 수 있어서 비정상적이므로 ()=var hoisting),
- 그리고 block scope이 없으므로
되도록 사용하면 안 됨. */

let globalName = 'global name'; // global scope : 어느 곳에서나 접근 가능함. 처음부터 끝까지 메모리에 항상 탑재돼있기에 최소한으로 쓰는 게 좋음.

{
let name = 'Sanhee';
console.log(name);
name = 'hello'; // rw가 둘 다 가능하므로 이렇게 할 수 있음.
console.log(name);
console.log(globalName); // global scope는 블럭 밖에서 지정했고 어느 곳에서든 접근 가능하기에 블럭 안에서 콘솔 찍더라도 볼 수 있음.
}
console.log(name); // block scope : {} 안에 있는 변수의 값들은 {} 밖에서 보이지 않으므로 이 라인의 콘솔로그는 빈값으로 나오게 되는 것.
console.log(globalName); // 당연히 9번째 줄에 변수가 선언돼있으므로 보임.


/* 3. constants (= const, 상수) : 값이 변경되지 않음. 즉, immutable data type. r(read)만 가능하고 값을 쓰는 것이 불가능함.
- security. (다른 해커들이 값 변경하는 것 방지 가능.)
- thread safety.
- reduce human mistakes.

Note!
Immutable data types : premitive types, frozen objects (i.e. object.freeze())
Mutable data types : all objects by default are mutable in JS.

*/
const daysInWeek = 7;
const maxNumber = 5;


/* 4. Variable sypes
4-1. primitive type : single item (더 이상 작은 단위로 나눠질 수 없음) - number, string, boolean, null, undefined, symbol
- 값 자체가 메모리에 저장됨. 즉, value로 값이 저장됨.
4-2. object type : box container, 즉 single item을 여러 개 묶음.
- 너무 크기 때문에 메모리에 한 번에 올라갈 수 없음. 그래서 'reference'라는 것을 통해서 object가 담겨있는 메모리를 가리키게 됨. 즉, reference가 메모리에 저장됨.
4-3. function : first-class function, 즉 언어가 함수를 다른 함수에 인수로 전달하여 다른 함수의 값으로 반환하고 변수에 지정하거나 데이터 구조에 저장하는 것을 지원.

data types for number :
c언어나 java에서는 short, int, long 등 타입이 많은데 javascript에서는 number만 있음.
심지어 number라고 선언하지 않고 let으로만 선언해도 충분함.

*/

const infinity = 1 / 0; // 대부분의 언어에서 그렇듯이 js에서도 양수를 0으로 나누면 무한함.
console.log(infinity);
const negativeInfinity = -1 / 0;
console.log(negativeInfinity);
const nAn = 'not a number' / 2; // 숫자가 아닌 것을 0으로 나누면 NaN이라는 게 나옴.
console.log(nAn);


/* 5. Dynamic typing : dynamically typed language */
let text = 'hello';
console.log('value: ${text}, type: ${typeof text}');
text = 1;
console.log('value: ${text}, type: ${typeof text}');

