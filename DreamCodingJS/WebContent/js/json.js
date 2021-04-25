// JSON
// JavaScript Object Notation

// 1. Object to JSON
// stringfy(obj)
let json = JSON.stringify(true);
console.log(json);

json = JSON.stringify(['apple', 'banana']);
console.log(json);

const rabbit = {
    name: 'tory',
    color: 'white',
    size: null,
    birthDate: new Date(),
    jump: () => {
        console.log('${name} can jump!');
    },
};

json = JSON.stringify(rabbit);
console.log(json);

json = JSON.stringify(rabbit, ['name', 'color', 'size']);
console.log(json);

json = JSON.stringify(rabbit, (key, value) => {
    console.log('key: ${key}, value: ${value}');
    return key === 'name' ? 'ellie' : value;
});
console.log(json);

// 2. JSON to Object
// parse(json)
console.clear();

json = JSON.stringify(rabbit);
const obj = JSON.parse(json, (key, value) => {
    console.log('key: ${key}, value: ${value}');
    return key === 'birthDate'? new Date(value) : value;
});
console.log(obj);
rabbit.jump(); // object가 json으로 변환할 때 data들만 갔다가,
// obj.jump(); // 다시 object로 돌아오면 jump라는 게 없기 때문에, error 발생

console.log(rabbit.birthDate.getDate()); // 29
// console.log(rabbit.birthDate.getDate()); // birthDate는 String이기 때문에, error 발생