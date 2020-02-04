/**
 * JQuery Lab
 */
$(function() {

    $("input[type='radio']").on('change', function() {
        const petId = $(this)[0].id;
        $.ajax({
                'url': 'pet.json',
                'method': 'GET'
            })
            .done(function(data) {
                let resp = data;

                // Checks type if its still a string
                if (typeof data === 'string') {
                    resp = JSON.parse(data)
                }

                if (petId === 'kitties') {
                    displayPictures(resp.kitties)
                } else {
                    displayPictures(resp.puppies)
                }
            })
    })


    /**
     * .done handler to display images
     * @param {Json} data 
     */
    function displayPictures(data) {
        $("#pictures img").remove()
        data.forEach(element => {
            const $img = $('<img>', {
                src: element.pet,
                width: '200',
                height: '200'
            })
            $("#pictures").append($img)
        });

    }


})