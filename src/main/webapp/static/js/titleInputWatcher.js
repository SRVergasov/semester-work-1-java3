let title = document.getElementsByClassName("w-25 mx-auto form-control")[0];
let log = document.getElementsByClassName("text-dark border-1 border-white")[0];
title.addEventListener('input', function (e) {
    log.innerText = title.value.length + "/20";
});
