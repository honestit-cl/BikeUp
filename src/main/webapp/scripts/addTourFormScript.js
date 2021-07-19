const today = new Date().toISOString().split('T')[0];
document.getElementById("txtDate").setAttribute('min', today);

var limit = 1;
$('.checkboxy').on('change', function(evt) {
    if($(this).siblings(':checked').length >= limit) {
        this.checked = false;
    }
});