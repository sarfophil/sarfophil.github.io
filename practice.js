(function() {
    "use strict";

    function Employee(id) {
        let employerCode = id;
        let name = "Default";
        const employer = {
            'name': 'MUM',
            'getName': function() {
                return this.name
            }
        }

        return {
            'setName': function(employerName) {
                name = employerName
            },
            'getId': function() {
                return employerCode
            },
            'getName': function() {
                return name
            },
            'getEmployerName': function() {
                return employer.getName()
            },
            'toString': function() {
                return employerCode + " " + name + " " + employer.getName()
            }
        }
    }

    const john = Employee(98000);
    john.setName('John');
    console.log(john.toString());
});

const makegrade = (function(studentAnswers, markingScheme) {


    function grading(score) {
        if (score >= 50) {
            return 'A'
        } else if (score >= 40 && score < 50) {
            return 'B'
        } else if (score >= 30 && score < 40) {
            return 'C'
        } else if (score >= 20 && score < 30) {
            return 'D'
        } else {
            return 'F'
        }
    }

    let processGrades = function() {
        let grades = [];
        studentAnswers.forEach(function(student) {
            let studentAnswers = student.answers

            let score = studentAnswers.reduce(function(accumulator, currentValue, currentIndex) {
                if (currentValue === markingScheme[currentIndex]) {
                    //Correct Answer
                    return accumulator + 10;
                } else if (currentValue !== markingScheme[currentIndex]) {
                    //Wrong Answer
                    return accumulator;
                } else {
                    return accumulator - 5;
                }
            }, 0)

            let grade = grading(score);

            const studentResult = {
                'name': student.name,
                'grade': grade
            }

            grades.push(studentResult)

        })
        return grades;

    }

    return {
        'results': processGrades()
    }

})

let students = [{ name: "Jack", answers: ["a", "b", "c", "b", ""] },
    { name: "Lisa", answers: ["b", "b", "b", "b", "b"] },
    { name: "Rita", answers: ["a", "b", "c", "a", "d"] },
    { name: "Bob", answers: ["c", "d", "b", "a", "b"] }
];

let reduce = (function() {
    return function(array, reducer, initialValue) {
        let result = initialValue;
        for (index in array) {
            // current value 
            let currentValue = array[index]

            // adds result to the reducer's result
            result = reducer(result, currentValue, index)
        }

        return result;

    }
})();

(function() {
    "use strict";
    let animal = {
        'eat': true,
        'walk': function() {
            if (!this.isSleeping) {
                console.log("I walk!")
            }
        },
        'sleep': function() {
            this.isSleeping = true
        }
    }

    let rabbit = {
        'name': 'Adanko',
        isSleeping: true,
        __proto__: animal
    }

    console.log(rabbit.isSleeping)
    console.log(animal.isSleeping)

    let user = {
        name: 'Philip sarfo owusu',
        age: 45
    }

    function Account(balance) {
        this.accountBalance = balance
        this.__proto__ = user
        this.log = function() {
            console.log(this)
            console.log(this.__proto__.name + ' ' + this.accountBalance)
        }
    }

    let phil = new Account(45.0)
    phil.log()

    //Same Constructor
    function Car(name) {
        this.carName = name
        this.prototype = function(name) {
            return new Car(name)
        }
    }

    let a = new Car("Benz")
    a.prototype.constructor = "Benc"
    console.log(a.prototype("Benz").toString())

})();




const grades = makegrade(students, ["b", "b", "b", "b", "b"])
let reduceResult = reduce([1, 2, 3, 4, 5], function(accumulator, currentValue) {
    return accumulator + currentValue;
}, 1)
console.log(reduceResult)
console.log(new Phil())