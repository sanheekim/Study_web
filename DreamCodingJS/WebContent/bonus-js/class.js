class Counter {
    constructor(runEveryFiveTimes) { // class에서 함수를 선언할 때는 function을 앞에 적지 않아도 됨
        this.counter = 0;
        this.callback = runEveryFiveTimes;
    }

    increase() {
        this.counter++;
        console.log(this.counter);
        if (this.counter % 5 === 0) {
            if (this.callback ) {
                this.callback(this.counter);
            }
        }
    }
}

const coolCounter = new Counter();
function printSomething(num) {
    console.log('Wow! ${num}');
}
coolCounter.increase(); // 1. 0으로 초기화됐던 counter라는 값이 1 늘어난 것
coolCounter.increase(); // 2
coolCounter.increase(); // 3
coolCounter.increase(); // 4
coolCounter.increase(); // Wow! 5
