function foo() {
    console.log(this);
}

const bod = {
    log: function() {
        console.log(this);
    }
}

bod.log();