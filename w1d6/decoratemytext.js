window.onload = function() {
    "use strict";
    /**
     * Declaring global variables
     */
    let body = document.getElementById("decoratorBody");
    const biggerBtn = document.getElementById("biggerBtn");
    let textArea = document.getElementById("textareaInput");
    let bling = this.document.getElementById("bling");

    const piglatin = document.getElementById("piglatin");
    const malkovitch = document.getElementById("malkovitch");
    const vowels = ['a', 'i', 'o', 'e', 'u'];

    /** Sets initial font size to 12pt on window loads */
    textArea.style.fontSize = '12pt';



    /** Bigger Decoration button click event */
    biggerBtn.onclick = function() {
        setInterval(updateUI, 500);
        updateBackgroundImage();
    }


    /** updateUI perform changes to textArea */
    function updateUI() {
        if (bling.checked) {
            design('green', 'bold', 'underline');
        } else {
            design('#000', 'none', '100');
        }
    };

    /** Triggers alert whenever the checkbox is checked or unchecked */
    bling.onchange = function() {
        alert("Bling clicked !. Checked:" + bling.checked)
    }

    /** 
     * changeFontSize checks the current state of the page before manipulating the font size  
     * */
    function changeFontSize() {
        let computeFontSize = parseInt(textArea.style.fontSize) + 2;
        if (bling.checked) {
            textArea.style.fontSize = computeFontSize + 'pt';
        } else {
            textArea.style.fontSize = '12pt'
        }

    }

    /**
     * Update Background Image
     */
    function updateBackgroundImage() {
        body.style.background = " url('hundred-dollar-bill.jpg') repeat";
        body.style.backgroundCover = 'cover';
    }

    /**
     * Applying Css design to textArea element
     * @param {string} color 
     * @param {string} fontWeight 
     * @param {string} textDecoration 
     */
    let design = (color, fontWeight, textDecoration) => {
        textArea.style.fontWeight = fontWeight;
        textArea.style.textDecoration = textDecoration;
        textArea.style.color = color;
        changeFontSize();
    }

    const isConsonant = (char) => {
        vowels.forEach(vowel => {
            if (vowel === char) return false;
        })
        return true;
    }

    /** Pig Latin button */
    piglatin.onclick = function() {
        textArea.value = pigLatinizeWord(textArea.value);
    }

    /**
     * pigLatinizeWord for transforming word
     * @param {string} word 
     */
    function pigLatinizeWord(word) {
        let consonantClusterSize = 1;
        let vowelClusterSize = 1;
        let wordArray = word.split();
        wordArray.forEach(function(value, index) {
            let letter = word.substring(index, index + 1);
            if (isConsonant(letter)) {
                consonantClusterSize++;
            } else {
                // vowel
                vowelClusterSize++;
            }
        })

        if (vowelClusterSize > 1) return word + "ay";

        word = word.substring(consonantClusterSize, word.length).trim() + word.substring(0, consonantClusterSize);
        return word.trim() + "ay";

    }

    /**
     * Malkovitch Button
     */
    malkovitch.onclick = function() {
        if (textArea.value.length >= 5) {
            textArea.value = "Malkovich";
        }
    }


}