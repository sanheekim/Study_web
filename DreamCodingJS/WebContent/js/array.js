// Array : 자료구조 중 하나.
// 자료구조 : 비슷한 것들을 묶어서 한 곳에 담아놓는 것.

'use strict';

// 1. Declaration
const arr1 = new Array(); // object와 같이 이런 식으로 배열을 선언할 수도 있음.
const arr2 = [1, 2];

// 배열은 index를 기준으로 data가 저장됨.
// 2. Index position
const fruits = ['apple', 'banana'];
console.log(fruits); // index의 0번째는 apple, 1번째는 banana
console.log(fruits.length);
console.log(fruits[0]); // fruits의 0번째 index 즉 apple
console.log(fruits[2]); // undefined.
console.log(fruits[fruits.length-1]); // fruits의 마지막 index즉 1번째 index인 banana

// 3. Looping over an array
// print all fruits
// a. for
for(let i = 0; i < fruits.length; i++){
	console.log(fruits[i]);
}

// b. for of
for(let fruit of fruits) {
	console.log(fruit); // apple, banana 모두 출력됨.
}

// c. forEach : 정해진 액션을 수행하는 함수. 배열에 들어있는 값마다 call back 함수를 수행함.
fruits.forEach(function(fruit, index){ // 인자는 value, index, array 순서. 하지만 forEach에서는 보통 array를 가져오지 않음.
	console.log(fruit, index);
})

// 위와 같은 코드
fruits.forEach((fruit) => console.log(fruit));

// 4. Addition, deletion, copy
// ★ shift, unshift are slower than pop, push

// push : add an item to the end
fruits.push('strawberry', 'peach'); // apple, banana, strawberry, peach

// pop : remove an item from the end
fruits.pop();
console.log(fruits); // apple, banana, strawberry

// unshift : add an item th te beginning
fruits.unshift('lemon', 'watermelon'); // lemon, watermelon, apple, banana, strawberry

// shift : remove an item from the beginning
fruits.shift();
fruits.shift();
console.log(fruits); // apple, banana, strawberry

// splice : remove an item by index postition
fruit.push('peach', 'melon');
console.log(fruits); // apple, banana, strawberry, peach, melon
/*fruits.splice(1); // index 1에서부터 끝까지(=몇 개 지울지 지정 안 한 경우) 다 삭제 
console.log(fruits); // apple*/
fruits.splice(1, 1); // index 1에서부터 1개만 지울 것
console.log(fruits); // // apple, strawberry, peach, melon

// combine two arrays
/*const fruits2 = ['one', 'two'];
const newFruits = fruits.concat(fruits2);
console.(newFruits); // apple, strawberry, peach, melon, one, two*/

// 5. Searching
// find the index
console.clear();
console.log(fruits);
console.log(fruits.indexOf('apple')); // 0
console.log(fruits.indexOf('three')); // 없는 값의 index 번호를 출력하려고 하면 -1이 뜸.

// includes
console.log(fruits.includes('three')); // 없는 값 출력 false. 만약 있는 값이면 true가 출력됨.

// lastIndexOf
console.clear();
fruits.push('apple'); // apple, strawberry, peach, melon, one, two, apple
console.log(fruits.indexOf('apple')); // 0 가장 앞 apple의 index
console.log(fruits.lastIndexOf('apple')); // 6 가장 뒤 apple의 index





















