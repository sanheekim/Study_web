// Q1. make a string out of an Array : 배열을 String으로 전환.
{
    const fruits = ['apple', 'banana', 'orange'];
    const result = fruits.join();
    console.log(result);
}

// Q2. make an array out of a string : String을 배열로 전환.
{
    const fruits = 'apple, kiwi, banana, cherry';
    const result = fruits.split(',');
    console.log(result);
}

// Q3. make this array look like this: [5, 4, 3, 2, 1]
{
    const array = [1, 2, 3, 4, 5];
    const result = array.reverse();
    console.log(result);
    console.log(array); // 배열 자체가 변화된 걸 확인 가능
}

// Q4. make new array without the first two else : 주어진 배열에서 첫 번째와 두 번째 요소를 제외한 나머지 세 개만의 배열을 '새로' 만들 것
{
    const array = [1, 2, 3, 4, 5];
    
    // const result = array.splice(0, 2); // 0부터 2개를 삭제하겠다는 의미
    // console.log(result);
    // console.log(array); // 배열 자체가 변화된 걸 확인 가능. 즉, splice는 오답.

    const real = array.slice(2, 5);
    console.log(result);
    console.log(array);
}

class Student {
    constructor(name, age, enrolled, score){
        this.name = name;
        this.age = age;
        this.enrolled = enrolled;
        this.score = score;
    }
}
const students = [
    new Student['A', 29, true, 45],
    new Student['B', 28, false, 80],
    new Student['C', 30, true, 90],
    new Student['D', 40, false, 66],
    new Student['E', 18, true, 88],
]

// Q5. find a student with the score 90
{
    /* const result = students.find(function(student, index){
        console.log(student, index); // 5명의 학생이 출력 됨
        return student.score === 90;
    }); */

    // 아래는 air function이라는 것.
    const result = students.find((student) => student.score === 90);
    console.log(result);
}

// Q6. make an array of enrolled students
{
    const result = students.filter((student) => student.enrolled);
    console.log(result);
}

// Q7. make an array containing only the students' scores
// result should be : [45, 80, 90, 66, 88]
{
    const result = students.map((student) => student.score);
    console.log(result);
}

// Q8. check if there is a student with the score lower than 50
{
    const result = students.some((student) => student.score < 50);
    console.log(result); // 하나라도 조건 맞는 게 있다면 true가 리턴됨. 만약 some이 아니라 every라면 '모든' 게 조건이 맞아야 true가 리턴됨.

    const result2 = !students.every((student) => student.score >= 50);
    console.log(result2);
}

// Q9. compute students' average score
{
    // prev : 이전값, curr : 현재값
    const result = students.reduce((prev, curr) => prev + curr.score, 0);
    console.log(result / students.length); // result는 전부 더해진 369
}

// Q10. make a string containing all the scores
// result should be : '45, 80, 90, 66, 88'
{
    const result = students.map(studnt => student.score).join(); // map으로 점수만 들어있는 배열 만듦. 이후에 join으로 String으로 만들어줌.
    console.log(result);
}

// Bonus! do Q10 sorted in ascending orer
// result should be: '45, 66, 80, 88, 90'
{
    const result = students.map(student => student.score)
    .sort((a, b)=> a - b) // a-b로 했기에 점수가 낮은 게 먼저 나옴. 만약 b-a로 하면 점수가 높은 것이 먼저 나옴.
    .join();
    console.log(result);
}