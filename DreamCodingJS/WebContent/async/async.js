// async & await
// clear style of using promise

// 1. async
async function fetchUser() {
    // do network request in 10 secs (실제로는 없지만 있다고 가정하는 코드)
    return 'ellie';
}

const user = fetchUser();
user.then(console.log);
console.log(user);

// 2. await
function delay(ms) {
    return new Promise(resolve => setTimeout(resolve, ms));
}

async function getApple() {
    await delay(1000);
    return 'apple';
}

async function getBanana() {
    await delay(1000);
    return 'banana';
}

/* 아래처럼 하면 callback 지옥
function pickFruits() {
    return getApple()
    .then(apple => {
        return getBanana().then(banana => '${apple + ${banana}');
    });
}*/

// 그러니 이렇게 하면 간편해짐
async function pickFruits() {
    const applePromise = getApple();
    const bananaPromise = getBanana();
    const apple = await getApple();
    const banana = await getBanana();
    return '${apple} + ${banana}';
}

pickFruits().then(console.log);

// 3. useful Promise APIs
function pickAllFruits() {
    return Promise.all([getApple(), getBanana()])
    .then(fruits => fruits.join(' + '));
}
pickAllFruits().then(console.log);

function pickOnlyOne() {
    return Promise.race([getApple(), getBanana()])
}

pickOnlyOne().then(console.log); // .race는 둘 중 먼저 출력되는 과일 1개만 출력함