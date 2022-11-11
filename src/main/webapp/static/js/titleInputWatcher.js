let title = document.getElementsByClassName("w-25 mx-auto form-control")[0];
let log = document.getElementsByClassName("text-white border-1 border-white")[0];
//FIXME
title.addEventListener('input', function (e) {
    log.textContent = title.textContent.length + "/20";
});
