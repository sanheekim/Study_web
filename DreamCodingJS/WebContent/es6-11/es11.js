// Optional chaining
{
    const person1 = {
        name: 'Ellie',
        job : {
            title: 'S/W Engineer',
            manager: {
                name: 'Bob',
            },
        },
    };
    const person2 = {
        name: 'Bob',
    };

    // 안 좋음
    {
        function printManager(person) {
            console.log(person.job.manager.name);
        }
        printManager(person1); // Bob
        // printManager(person2); // error
    }

    // 좋음
    {
        function printManager(person) {
            console.log(person.job?.manager?.name); // job이 있으면, manager가 있으면
        }
        printManager(person1);
        printManager(person2);
    }
}




// Nullish coalescing operator
{
    // Logical OR operator
    // false : false, '', 0, null, undefined
    {
        const name = 'Ellie';
        const userName = name || 'Guest';
        console.log(userName); // Ellie
    }
    {
        // 안 좋음
        const name = null;
        const userName = name || 'Guest';
        console.log(userName); // Guest

        const num = 0;
        const message = num || 'undefined';
        console.log(message); // undefined. 0으로 하고 싶어도 인식이 안 돼서 undefined가 나옴.

        // 좋음
        {
            const name = '';
            const userName = name ?? 'Guest';
            console.log(userName);

            const num = 0;
            const message = num ?? 'undefined';
            console.log(message);
        }
    }
}