// false : 0, -0, null, undefined처럼 없는 data
// true : false의 예시들을 제외한 모든 data(숫자, 문자 등)

if (true) { // 인자가 false면 실행 안 됨. 되게 하고 싶으면 else 사용할 것.
    console.log('true!');
}

let num; // undefined
if (num) { // num에 데이터를 할당하지 않았으므로 false임. 그러므로 if문이 실행 안 됨.
    console.log('실행 안 돼!')
}

