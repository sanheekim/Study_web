/* Objects
- one of the JavaScript's data types.
- a collection of related data and/or functionality.
- Nearly all objects in JavaScript are instances of Object.
- ★ object = { key : value };

*/

// -------------- 1. Literals and properties --------------

// 하나하나 출력해야 해서 귀찮아짐.
const name = 'ellie';
const age = 4;
print(name, age);
function print(name, age) {
	console.log(name);
	console.log(age);
}

// 오브젝트를 사용하면 이렇게 간편하게 데이터 관리 가능.
const ellie = {name: 'ellie', age: 4};
print(ellie);

// object를 만드는 방법은 두 가지.
// 1. 'object literal' syntax
const obj1 = {};
// 2. 'object constructor' syntax
const obj2 = new Object();

// Runtime : 프로그램이 동작하는 때
// 아래처럼 동적으로 코딩하는 것은 바로바로 하면 좋지만 나중에 유지보수가 힘드므로 최대한 하지 않을 것.
ellie.hasJob = true;
console.log(ellie.hasJob);

// -------------- 2. Computed[개선된] properties --------------
console.log(ellie.name);
console.log(ellie['name']);
// 위 둘은 똑같은 ellie가 출력됨.
// 아래 콘솔로그에서 ''의 의미는 key를 String타입으로 받아온다는 것. key는 항상 String타입으로 받아올 것.
ellie['hasJob'] = true;
console.log(ellie.hasJob);

function printValue(obj, key) {
	// console.log(obj.key); 라고 하면 undefined 뜸.
	console.log(obj[key]);
}
printValue(ellie, 'name');
printValue(ellie, 'age');

// -------------- 3. Property value shorthand --------------
const person1 = {name: 'bob', age: 2};
const person2 = {name: 'steve', age: 3};
const person3 = {name: 'dave', age: 4};

// 4번째 사람을 똑같이 만들려면 번거로우므로
// 아래 함수를 만듦.
// -------------- 4. Constructor Function --------------
function Person(name, age){
	// this = {};
	this.name = name;
	this.age = age;
	// return this;
}
const person4 = new Person('elile', 30);
console.log(person4);

// -------------- 5. in operator : property existence check (key in obj) --------------
// 'in'이라는 키워드를 이용해서 해당하는 key가 오브젝트 안에 있는지 확인가능
console.log('name' in ellie);
console.log('age' in ellie);
console.log('random' in ellie);
console.log(ellie.random);

// -------------- 6. for..in vs for..of --------------
// for (key in obj)
console.clear();
for (key in ellie){
	console.log(key);
}
// for (value of iterable) 오브젝트를 쓰는 게 아니라 배열처럼 순차적으로 데이터가 담겨있는 것들을 사용함.
/*const array = {1, 2, 4, 5};
for(value of array) { //array에 있는 모든 값들이 value에 할당됨
	console.log(value);
}*/

// -------------- 7. Fun cloning --------------
// Object.assign(dest, [obj1, obj2, obj3...])
const user = {name: 'ellie', age: '20'};
const user2 = user;
user2.name = 'coder';
console.log(user);

// old way (예전에 쓰던 방식)
const user3 = {};
for (key in user) {
	user3[key] = user[key];
}
console.clear();
console.log(user3);

// another way
Object.assign(user4, user);
console.log(user4); // user4는 user를 복사해왔으므로 둘의 값은 같음.

// another example
const fruit1 = {color: 'red'};
const fruit2 = {color: 'blue', size:'big'};
const mixed = Object.assing({}, fruit1, fruit2);
console.log(mixed.color); // blue
console.log(mixed.size); // big
