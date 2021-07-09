const today = new Date().toISOString().split('T')[0];
document.getElementById("txtDate").setAttribute('min', today);

var limit = 1;
$('.checkboxy').on('change', function(evt) {
    if($(this).siblings(':checked').length >= limit) {
        this.checked = false;
    }
});


document.addEventListener('DOMContentLoaded', function () {
    const spans = document.querySelectorAll("form span");

    spans.forEach(span =>
    span.style.color = 'red'
    )


});
