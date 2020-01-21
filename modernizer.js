function foo() {
    console.log(this);
}

const bod = {
    log: function() {
        console.log(this);
    }
}

var x = undefined
function b(){}
x = 20
//b
function a(){}