function generarCodigo6Digitos() {
    let codigo = Math.floor(100000 + Math.random() * 900000);
    return String(codigo);
}
function sleep(ms) {
    return new Promise(resolve => setTimeout(resolve, ms));
}

let boton = document.getElementById("boton_verificacion");
boton.disabled = true;
let texto = document.getElementById("verificacion_code");

let codigo = generarCodigo6Digitos();
let comparar
let compararEntero

// En un sistema real, el codigo se enviaria por email
// Aqui solo mostramos un alert para simplificar la implementacion del verificado de codigo
alert("Su codigo de verificacion es: " + codigo); // Deberías tener una salida de 6 digitos
texto.addEventListener("input", function() {
    compararEntero = parseInt(texto.value);
    if (compararEntero ==  parseInt(codigo)) {
        boton.disabled = false;
    }
    else{
        boton.disabled = true;
    }
});

let resend = document.getElementById("resend_code");
resend.addEventListener("click", function() {
    codigo = generarCodigo6Digitos();
    alert("Su codigo de verificacion es: " + codigo);
});