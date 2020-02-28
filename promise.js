(function() {
    let promise1 = new Promise(function(resolve, reject) {
        let r = Math.ceil(Math.random() * 10);
        if (r % 2 === 0) {
            setTimeout(function() {
                resolve('even');
            }, 300);
        } else {
            setTimeout(function() {
                reject('odd');
            }, 300);
        }
    });

    promise1
        .then(function(value) { //append the resolve function
            console.log("Success: " + value);
        })
        .catch(function(err) { //append the reject function
            console.log("Error: " + err);
        });
    console.log(promise1);
})()