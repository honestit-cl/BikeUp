const hamburger = document.querySelector(".hamburger");
const nav = document.querySelector(".navigation");

const handleClick = () => {
    hamburger.classList.toggle('hamburger--active');
    nav.classList.toggle('navigation--active');
}
hamburger.addEventListener("click",handleClick);

const today = new Date().toISOString().split('T')[0];
document.getElementById("txtDate").setAttribute('min', today);