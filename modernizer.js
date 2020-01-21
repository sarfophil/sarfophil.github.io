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
