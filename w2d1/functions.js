/**
 * 
 * @param {Function} fn 
 * @param {array} array 
 */
function map(array, fn) {
    let result = [];
    for (value of array) {
        result.push(fn(value));
    }
    return result;
}


/**
 * 
 * @param {Array} array 
 * @param {Function} predicate 
 */
function filter(array, predicate) {
    let result = [];
    for (value of array) {
        if (predicate(value))
            result.push(value);
    }
    return result;
}




let mapResult = map([1, 2, 3, 4], function(value) {
    return value * 3;
})

let filterResult = filter([1, 2, 3, 4, 5], function(value) {
    return value > 3;
})

console.log(mapResult);
console.log(filterResult);

describe("Map and Filter Test", function() {
    it("map function which multiplies 3 to each value in array [1, 2, 3, 4]. It should return [3, 6, 9, 12]", function() {
        assert.equal(mapResult.toString, [3, 6, 9, 12].toString)
    })

    it("filter result which filter values greater than 3 is [1, 2, 3, 4, 5] should return [4,5]", function() {
        assert.equal(filterResult.toString, [4, 5].toString)
    })
})