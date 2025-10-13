// Page-specific JS for contacto.html
// (placeholder) - add contacto page interactions here
document.addEventListener('DOMContentLoaded', function(){
  const form = document.querySelector('.contact-form');
  if(!form) return;

  const showError = (el, msg) => {
    let err = el.parentNode.querySelector('.field-error');
    if(!err){
      err = document.createElement('div');
      err.className = 'field-error';
      el.parentNode.appendChild(err);
    }
    err.textContent = msg;
    el.classList.add('invalid');
  };

  const clearError = (el) => {
    const err = el.parentNode.querySelector('.field-error');
    if(err) err.textContent = '';
    el.classList.remove('invalid');
  };

  const validateEmail = (value) => {
    // simple email check (allows non-email if you removed type=email earlier)
    return /\S+@\S+\.\S+/.test(value);
  };

  form.addEventListener('submit', function(e){
    e.preventDefault();
    let valid = true;
    const name = form.querySelector('[name=name]');
    const email = form.querySelector('[name=email]');
    const message = form.querySelector('[name=message]');

    [name,email,message].forEach(el => clearError(el));

    if(!name.value.trim()){
      showError(name, 'Por favor introduce tu nombre');
      valid = false;
    }

    if(!email.value.trim()){
      showError(email, 'Por favor introduce tu email');
      valid = false;
    } else if(!validateEmail(email.value.trim())){
      showError(email, 'Formato de email no válido');
      valid = false;
    }

    if(!message.value.trim()){
      showError(message, 'Por favor introduce un mensaje');
      valid = false;
    }

    // If valid, show a temporary success message (no backend submission)
    let feedback = form.querySelector('.form-feedback');
    if(!feedback){
      feedback = document.createElement('div');
      feedback.className = 'form-feedback';
      form.appendChild(feedback);
    }

    if(valid){
      feedback.className = 'form-feedback success';
      feedback.textContent = 'Mensaje preparado (demo): listo para enviar.';
      // clear form (optional)
      form.reset();
      setTimeout(() => { feedback.textContent = ''; feedback.className = 'form-feedback'; }, 4000);
    } else {
      feedback.className = 'form-feedback error';
      feedback.textContent = 'Corrige los errores en el formulario.';
    }
  });
});
