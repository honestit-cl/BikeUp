document.addEventListener('DOMContentLoaded', function () {
    const spans = document.querySelectorAll("form span");

    spans.forEach(span =>
    span.style.color = 'red'
    )
});