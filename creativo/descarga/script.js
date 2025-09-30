let enDescarga = false
let original = document.getElementById('descarga')
let textoOriginal = original.textContent
function sleep(ms) {
    return new Promise(resolve => setTimeout(resolve, ms));
}

async function ejecutarDescarga() {
    if (enDescarga) return
    enDescarga = true
    for (let i = 0; i < 100; i++) {
        document.getElementById('descarga').textContent = i;
        await sleep(60)
    }
    document.getElementById('descarga').textContent = "Completada";
    await sleep(1000)
    document.getElementById('descarga').textContent = textoOriginal
    enDescarga = false

}

document.getElementById('descarga').addEventListener('click', ejecutarDescarga);