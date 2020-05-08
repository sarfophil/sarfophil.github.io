(function() {
    "use strict"

    //Exercise 1
    String.prototype.filter = filter

    //Exercise 2
    Array.prototype.bubbleSort = bubbleSort

    /**
     *  The function accepts an array of strings that
     *   specifies a list of banned words
     * @param {String} keyword 
     */
    function filter(keyword) {
        // Split values in an array
        let word = this.split(" ")

        //Iterate through words
        word.forEach((w) => {

            //If w matches keyword
            if (w === keyword) {
                //Remove from array
                let index = word.indexOf(w)
                word.splice(index, 1)
            }

        })

        // join values and return as string
        return word.join(" ")
    }


    /**
     * Bubble sort for sorting array
     */
    function bubbleSort() {
        for (let i = 0; i < this.length; i++) {
            for (let x = 0; x < this.length; x++) {

                if (this[x] > this[x + 1]) {
                    // Swap values
                    let temp = this[x]
                    this[x] = this[x + 1]
                    this[x + 1] = temp
                }
            }
        }
        return this
    }


    //Exercise 3
    let Person = function() {};
    Person.prototype.initialize = function(name, age) {
        this.name = name;
        this.age = age;
    }

    Person.prototype.describe = function() {
        return this.name + ", " + this.age + " years old.";
    }


    let Teacher = function() {
        this.teach = function(subject) {
            return this.name + " is now teaching " + subject
        }
    }
    Teacher.prototype = new Person()





    describe("w2D6 Unit Testing", function() {
        it("Exercise 1: filter method", function() {
            assert.equal("This house is nice!".filter("not"), "This house is nice!")
        })

        it("Exercise 2: Bubble sort", function() {
            assert.equal([1, 4, 5, 0, 2].bubbleSort().toString(), [0, 1, 2, 4, 5].toString())
        })

        it("Exercise 3: Teacher Inheritance", function() {
            let teacher = new Teacher()
            teacher.initialize("Philip Sarfo", 30)
            assert.equal(teacher.teach("Biology"), "Philip Sarfo is now teaching Biology")
        })
    })
})()