const today = new Date().toISOString().split('T')[0];
document.getElementById("txtDate").setAttribute('min', today);