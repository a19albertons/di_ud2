let volumen = document.getElementById('volumenControl')
let img = document.querySelector('.tamanoMargenes')
volumen.addEventListener('input', function() {
    let porcentaje = volumen?.value;
    document.getElementById('volumen').textContent = "volumen: " + porcentaje;
    if (porcentaje == 0) {
        img.src = "img/sinsonido.png"; // Cambia a la imagen de sin sonido
        img.style.transform = "scale(1)"; // Tamaño normal
    } else {
        img.src = "img/sonido.png"; // Cambia a la imagen de sonido
        img.style.transform = `scale(${porcentaje / 100})`;
    }
})

