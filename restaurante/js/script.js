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
        btn.textContent = 'Mostrar más';
      }
    });
  });
});

// --- Ayuda de navegación: marcar enlace activo ---
document.addEventListener('DOMContentLoaded', function(){
  var nav = document.getElementById('main-navigation');
  if(!nav) return;
  var links = nav.querySelectorAll('a[href]');
  var path = window.location.pathname.split('/').pop();
  if(!path) path = 'index.html';

  links.forEach(function(a){
    var href = a.getAttribute('href');
    if(!href) return;
    var hrefFile = href.split('/').pop();
    if(hrefFile === path || (hrefFile === 'index.html' && (path === '' || path === 'index.html'))){
      a.classList.add('active');
      a.setAttribute('aria-current','page');
    }
  });
});

