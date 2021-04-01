/*
오브젝트는 클래스를 이용해서 굉장히 많이 만들 수 있음.
클래스는 정의만 한 것이라서 실제로 메모리에 올라가지 않음. 하지만 클래스 안에 실제로 데이터를 넣으면, 즉 오브젝트는 메모리에 올라감.

class(template, declare once, no data in) : fields + methods
object
- instance of a class
- created many times
- data in

*/

// 1. Class declarations
class Person {
	// constructor
	constructor(name, age) {
		//fields
		this.name = name;
		this.age = age;
	}
	
	// methods
	speak(){
		console.log('${this.name}: hello!');
	}
}

const ellie = new Person('ellie', 20);
console.log(ellie.name);
console.log(ellie.age);

// 2. Getter and Setters
// (개발자는 사용자가 실수하는 것까지 다 생각해야 하므로) 사용자가 사람의 나이를 -0살이라고 (말도 안 되는) 설정 하더라도 우리는 setter를 써서 -0이 0으로 바뀔 수 있도록 함. 그래서 setter를 사용함.
class User {
	constructor(firstName, lastName, age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	
	get age(){
		return this._age;
	}
	
	set age(value){
		/* if (value < 0){
			throw Error('age can not be negative');
		} */
		
		this.age = value < 0 ? 0 : value;
	}
}

const user1 = new User('Steve', 'Job', -1);
console.log(user1.age); // age가 -1살이 되는 건 말이 안 됨. 그러므로 get을 이용해서 값을 return하고 set을 이용해서 값을 설정할 수 있음.

// 3. Fields (public, private) : 최근에 추가 됨. 생성자를 쓰지 않고 field를 정의할 수 있음. 그럼 외부에서 접근이 가능한 public임.
/*class Experiment {
	publicField = 2;
	#privateField = 0;
}
const experiment = new Experiment();
console.log(experiment.publicField);
console.log(experiment.rivateField);*/

// 4. Static properties and methods : 역시 최근에 추가 됨.
/*class Article {
	static publisher = 'Dream Coding';
	constructor(articleNumber) {
		this.articleNumber = articleNumber;
	}
	
	static printPublisher(){
		console.log(Article.publisher);
	}
}*/


const article1 = new Article(1);
const article2 = new Article(2);
console.log(Article.publisher);
Article.printPublisher();

// 5. Inheritance
class Shape {
	constructor(width, height, color){
		this.width = width;
		this.height = height;
		this.color = color;
	}
	
	draw(){
		console.log('drawing ${this.color} color of');
	}
	
	getArea(){
		return width * this.height;
	}
}

class Rectangle extends Shape {}
class Triangle extends Shape {
	
	// overriding : 필요한 함수만 재정의해서 쓸 수 있음.
	getArea(){
		return (this.width * this.height) / 2;
	}
}

const rectangle = new Rectangle(20, 20, 'blue');
rectangle.draw();
console.log(rectangle.getArea());
const triangle = new Triangle(20, 20, 'red');
triangle.draw();
console.log(triangle.getArea());

// 6. Class checking : instanceOf
console.log(rectangle instanceof Rectangle); // rectangle이라는 오브젝트가 Rectangle이란 클래스에 속하면 true, 아니면 false를 리턴함.

