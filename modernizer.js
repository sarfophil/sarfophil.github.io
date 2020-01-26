function foo() {
    console.log(this);
}

const bod = {
    log: function() {
        console.log(this);
    }
}

const me = {
    name: 'Phil Sarfo',
    getName: function() {
        return this.name;
    }
}

const log = function(height, weight) {
    console.log(this.getName() + '' + height, +'' + weight)
}

const logMe = log.bind(me);

logMe('180cm', '70kg');


(function() {
    x = 1;
    var a = 5;
    var b = 10;
    var c = function(a, b, c) {
        console.log("x1: " + x);
        console.log("a2: " + a);
        var f = function() {
            b = a;
            console.log("b3: " + b);
            b = c;
            var a = 3;
        }
        f();
        console.log("b4: " + b);
        x = 6;
    }
    c(8, 9, 7);
    console.log("b5: " + b);
    console.log("x6: " + x);
});


(function() {
    var x = 10;

    function main() {
        console
            .log("x1 is:" +
                x);
        x
            = 20;
        console
            .log("x2 is:" +
                x);
        if (x >
            0
        ) {
            var x = 30;
            console
                .log("x3 is:" +
                    x);
        }
        console
            .log("x4 is:" +
                x);
        var x = 40;
        var f = function(
            x
        ) {
            console
                .log("x5 is:" +
                    x);
        };
        f(50);
        console
            .log("x6 is:" +
                x);
    }
    main();
    console
        .log("x7 is:" +
            x);
})()