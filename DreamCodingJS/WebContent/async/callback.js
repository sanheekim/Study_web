'use strict';

// Synchronous callback : 즉각적, 동기적
function printImmmediately(print) {
    print();
}

// Asynchronous callback : 언제 실행될지 예측 불가능
function printWithDelay(print, timeout){
    setTimeout(print, timeout);
}

// JavaScript is synchronous.
// Execute the code block by order after hoisting.
// hoisting : var, function declaration
console.log('1'); // 동기
/* setTimeout(function(){
    console.log('2');
}, 1000); // 우리가 지정한 시간이 지나면 callback함수를 호출함. 1000(1초)가 지나면 console.log('2');를 출력함. */
setTimeout(() => console.log('2'), 1000); // 비동기
console.log('3'); // 동기

printImmmediately(()=> console.log('hello')); // 동기
printWithDelay(()=> console.log('async callback'), 2000); // 비동기

// Callback Hell example (콜백지옥 체험- 콜백함수는 잘 쓰면 좋지만 잘못 쓰면 지옥이 되기도 함.)
class UserStorage {
    loginUser(id, password, onSuccess, onError) {
        setTimeout(()=>{
            if (
                (id === 'ellie' && password === 'dream') ||
                (id === 'coder' && password === 'academy')
            ) {
                onSuccess(id);
            } else {
                onError(new Error('not found'));
            }
        }, 2000);
    }

    getRoles(user, onSuccess, onError) {
        setTimeout(()=>{
            if (user === 'ellie'){
                onSuccess({name: 'ellie', role: 'admin'});
            } else {
                onError(new Error('no access'));
            }
        },1000);
    }
}

const UserStorage = new UserStorage();
const id = prompt('enter your id');
const password = prompt('enter your password');
UserStorage.loginUser(
    id,
    password,
    user => {
        UserStorage.getRoles(
            user,
            (userWithRole) => {
                alert('Hello ${userWithRole.name}, you have a ${userWithRole.role} role');
            },
            error => {}
        );
    },
    error => {
        console.log(error);
    }
);