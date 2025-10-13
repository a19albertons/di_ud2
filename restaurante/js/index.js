// Page-specific JS for index.html
// Handles "Mostrar mas" toggles present on the home page
document.addEventListener('DOMContentLoaded', function(){
  document.querySelectorAll('.toggle-more').forEach(function(btn){
    btn.addEventListener('click', function(){
      const block = btn.closest('.block');
      const more = block.querySelector('.more');
      if(!more) return;
      if(more.classList.contains('hidden')){
        more.classList.remove('hidden');
        btn.textContent = 'Mostrar menos';
      } else {
        more.classList.add('hidden');
        btn.textContent = 'Mostrar mas';
      }
    });
  });
});
