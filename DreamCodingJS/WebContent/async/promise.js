'use strict';

// Promise is a JavaScript object for asynchronous operation.
// state (promise의 상태) : pending -> fulfilled or rejected
// Producer vs Consumer

// 1. Producer : 우리가 원하는 기능을 비동기적으로 실행함.
// when new Promise is created, the executor (함수 종류) runs automatically.
const promise = new Promise((resolve, reject) => {
    // doing some heavy work (network, read files)
    console.log('doing something');
    setTimeout(() => {
        resolve('ellie');
        // reject(new Error('no network'));
    }, 2000);
});

// 2. Consumer : then, catch, finally
promise
.then((value) => {
    console.log(value);
})
.catch(error => {
    console.log(error);
})
.finally(()=> {
    console.log('finally');
});

// 3. Promise chaining
const fetchNumber = new Promise((resolve, reject) => {
    setTimeout(()=> resolve(1), 1000);
});

fetchNumber
.then(num => num * 2)
.then(num => num * 3)
.then(num => {
    return new Promise((resolve, reject) => {
        setTimeout(() => resolve(num - 1), 1000);
    });
})
.then(num => console.log(num));

// 4 Error Handling
const getHen = () =>
    new Promise((resolve, reject) => {
        setTimeout(() => resolve('chicken', 1000);
    });
const getEgg = hen =>
    new Promise((resolve, reject) => {
        setTimeout(() => resect(new Error('error! ${hen} => egg')), 1000);
    });
const cook = egg =>
    new Promise((resolve, reject) => {
        setTimeout(() => resolve('${egg} => fried egg'), 1000);
    });

getHen()
    .then(getEgg)
    .catch(error => {
        return 'bread';
    })
    .then(cook)
    .then(console.log)
    .catch(console.log);