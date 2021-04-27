// Shorthand property names

{
    const ellie1 = {
        name: 'Ellie',
        age: '18',
    };

    const name = 'Ellie';
    const age = '18';

    const ellie2 = {
        name: name,
        age: age,
    };

    const ellie3 = {
        name,
        age,
    };

    console.log(ellie1, ellie2, ellie3); // 모두 잘 나옴

}


{
    // object
    const student = {
        name: 'Anna',
        level: 1,
    };

    // 기존의 복잡한 방법
    {
        const name = student.name;
        const level = student.level;
        console.log(name, level);
    }

    // Destructuring Assignment
    {
        const { name, level } = student;
        console.log(name, level);

        const { name: studentName, level: studentLevel} = student;
        console.log(studentName, studentLevel);
    }

    // array
    const animals = ['dog', 'cat'];

    // 기존의 복잡한 방법
    {
        const first = animals[0];
        const second = animals[1];
        console.log(first, second);
    }

    // 좋은 방법
    {
        const [first, second] = animals;
        console.log(first, second);
    }
}

// Spread Syntax
{
    const obj1= { key: 'key1' };
    const obj2= { key: 'key2' };
    const array = [obj1, obj2];

    // array copy
    const arrayCopy = [...array];
    const arrayCopy2 = [...array, { key: 'key3' }] // key3을 추가함
    console.log(array arrayCopy, arrayCopy2);

    // object copy
    const obj3 = { ...obj1 };
    console.log(obj3);

    // array concatenation
    const fruits1 = ['peach', 'strawberry'];
    const fruits2 = ['banana', 'kiwi'];
    const fruits = [...fruits1, ...fruits2];
    console.log(fruits); // 위 4개 과일 병합 됨

    // object merge
    const dog1 = { dog: '요크셔' };
    const dog2 = { dog: '말티즈' };
    const dog = { ...dog1, ...dog2 };
    console.log(dog); // 말티즈만 나옴. dog1의 key와 dog2의 key가 이름이 dog으로 같기 때문.
}

// Default parameters
{
    // 복잡한 방법
    {
        function printMessage(message) {
            if (message == null) {
                message = 'default message';
            }
            console.log(message);
        }

        printMessage('hello');
        printMessage();
    }

    // 더 간단한 좋은 방법
    {
        function printMessage(essage = 'default message') {
            console.log(message);
        }

        printMessage('hello');
        printMessage();
    }
}

// Ternary Operator
{
    const isCat = true;
    // 복잡
    {
        let component;
        if (isCat) {
            component = 'cat';
        } else {
            component = 'dog';
        }
        console.log(component)
    }

    // 좋음
    {
        const component = isCat ? 'cat' : 'dog';
        console.log(component);
        console.log(isCat ? 'cat' : 'dog');
    }
}

// Templage Literals
{
    const weather = 'sunny';
    const temparature = '16C';

    // 복잡
    console.log(
        'Today weather is ' + weather + ' and temparature is ' + temperature
    );

    // 좋음
    console.log('Today weather is ${weather} and temparature is ${temperature}');
}