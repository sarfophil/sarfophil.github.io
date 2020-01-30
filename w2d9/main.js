$(function() {
    const colors = ['yellow', 'red', 'voilet', 'brown', 'orange', 'blue', 'pink', 'green', '#AFB42B', '#FFC107', '#212121', '#616161', '#9E9E9E']

    let sizeInput = $('#width')
    let growthInput = $('#growthAmount')
    let growthRateInput = $('#growthRate')
    let numberOfCircleInput = $('#numberOfCircle')
    let main = $(".main")


    //Start Button
    const start = $('#start')

    //default Border Radius
    let defaultBorderRadius = 56;

    //Timer handler
    let timerInterval = null;

    //Default value for positioning circles on right
    let rightPosition = 50;

    //Default value for positioning circles on left
    let leftPosition = 49;

    //Circle
    let circles = $(".circle")


    //Event
    event.subscribe('sizeIncreasedEvent', function() {
        rightPosition += 5
        leftPosition += 5

    })


    //Css Design for circle
    let circleDesign = function(size, position, index) {

        let defaultCss = function() {
            return {
                'height': size,
                'width': size,
                'background': colors[index],
                'border-radius': defaultBorderRadius,
                'position': 'absolute',
                'top': '50%',
                'bottom': '50%',
                'left': position + '%',
                'right': position + '%'
            }
        }


        return {
            'design': defaultCss
        }

    }

    //Default Circle on page loads
    draw(1, 50)

    //Starts Time Interval
    start.on('click', function() {
        resetCircle()
        if (sizeInput.val() !== '' && growthInput.val() !== '' ||
            growthRateInput.val() !== '' || numberOfCircleInput.val() !== '') {
            grow(numberOfCircleInput.val(), growthRateInput.val(), growthInput.val())
        }
    })

    //Stop Time Interval
    main.on('click', function() {
        clearInterval(timerInterval)
        resetCircle()

        draw(1, 50)
    })


    /**
     * Resets Circle
     */
    function resetCircle() {
        $('.main div').remove()
    }


    /**
     * Function for growing circles
     * @param {number} numberOfCircle 
     * @param {number} growthRate 
     */
    function grow(numberOfCircle, growthRate, growthAmount) {
        let count = 1;

        timerInterval = setInterval(function() {

            draw(numberOfCircle, sizeInput.val() * growthAmount * count++)

            //Publish event to sizeIncreasedEvent listeners whenever there's sizeChanged
            event.publish('sizeIncreasedEvent')


        }, growthRate)
    }

    function draw(numberOfCircles, size) {

        let centerOfIndex = Math.round(numberOfCircles / 2)

        if (numberOfCircles > 0) {
            for (let i = 1; i <= numberOfCircles; i++) {

                //Increase Border radius
                defaultBorderRadius = 56 * (i == 0 ? 1 : i)

                //If iteration has reached middle of the loop
                //then we will position circles to our left
                if (centerOfIndex <= i) {
                    const $circle = $('<div>', {
                        css: circleDesign(size, leftPosition--, i).design(),
                        class: 'circle left'
                    })
                    main.append($circle)
                } else {
                    const $circle = $('<div>', {
                        css: circleDesign(size, rightPosition++, i).design(),
                        class: 'circle right'
                    })
                    main.append($circle)
                }


            }
        }
    }






})