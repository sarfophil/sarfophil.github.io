window.onload = function() {
    "use strict";
    /**
     * 
     */
    const biggerBtn = document.getElementById("biggerBtn");
    let textArea = document.getElementById("textareaInput");
    let fontSize = document.getElementById("fontSize");
    let bling = this.document.getElementById("bling");

    biggerBtn.onclick = function() {
        if (bling.checked) {
            textArea.style.fontFamily = 'Lobster,cursive';
            textArea.style.fontStyle = 'italic';
            increaseFont();
        } else {
            textArea.style.fontFamily = '';
            textArea.style.fontStyle = '';
            increaseFont();
        }
    }


    function increaseFont() {
        let size = parseInt(textArea.style.fontSize == '' ? '0' : textArea.style.fontSize) + 20;
        textArea.style.fontSize = size + 'px';
        fontSize.innerHTML = size + 'px';
    }


}