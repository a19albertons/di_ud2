// Form validation functionality
document.addEventListener('DOMContentLoaded', function() {
  const form = document.querySelector('form');
  const submitButton = form.querySelector('button[type="submit"]');

  // Validation rules
  const validators = {
    name: {
      validate: (value) => value.trim().length >= 2,
      message: 'El nombre debe tener al menos 2 caracteres.'
    },
    email: {
      validate: (value) => {
        const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        return emailRegex.test(value.trim());
      },
      message: 'Por favor, introduce un correo electrónico válido.'
    },
    subject: {
      validate: (value) => value.trim().length >= 3,
      message: 'El asunto debe tener al menos 3 caracteres.'
    },
    message: {
      validate: (value) => value.trim().length >= 10,
      message: 'El mensaje debe tener al menos 10 caracteres.'
    }
  };

  // Function to show error message
  function showError(input, message) {
    const errorElement = input.nextElementSibling;
    errorElement.textContent = message;
    errorElement.classList.remove('hidden');
    input.classList.add('border-red-500');
    input.classList.remove('border-border-light', 'dark:border-border-dark', 'focus:border-primary');
  }

  // Function to hide error message
  function hideError(input) {
    const errorElement = input.nextElementSibling;
    errorElement.classList.add('hidden');
    input.classList.remove('border-red-500');
    input.classList.add('border-border-light', 'dark:border-border-dark', 'focus:border-primary');
  }

  // Function to validate a single field
  function validateField(input) {
    const fieldName = input.name;
    const value = input.value;
    const validator = validators[fieldName];

    if (!validator) return true;

    if (!validator.validate(value)) {
      showError(input, validator.message);
      return false;
    } else {
      hideError(input);
      return true;
    }
  }

  // Function to validate all fields
  function validateForm() {
    let isValid = true;
    const inputs = form.querySelectorAll('input, textarea');

    inputs.forEach(input => {
      if (!validateField(input)) {
        isValid = false;
      }
    });

    return isValid;
  }

  // Add event listeners for real-time validation
  const inputs = form.querySelectorAll('input, textarea');
  inputs.forEach(input => {
    input.addEventListener('blur', function() {
      validateField(this);
    });

    input.addEventListener('input', function() {
      if (this.classList.contains('border-red-500')) {
        validateField(this);
      }
    });
  });

  // Form submission handler
  form.addEventListener('submit', function(e) {
    e.preventDefault();

    if (validateForm()) {
      // Show success message
      const successMessage = document.createElement('div');
      successMessage.className = 'mt-4 p-4 bg-green-100 border border-green-400 text-green-700 rounded-lg';
      successMessage.textContent = '¡Mensaje enviado correctamente! Nos pondremos en contacto contigo pronto.';

      // Disable submit button temporarily
      submitButton.disabled = true;
      submitButton.textContent = 'Enviando...';

      // Reset form after successful submission
      setTimeout(() => {
        form.reset();
        submitButton.disabled = false;
        submitButton.textContent = 'Enviar Mensaje';

        // Hide success message
        if (successMessage.parentNode) {
          successMessage.parentNode.removeChild(successMessage);
        }

        // Clear any remaining error states
        inputs.forEach(input => hideError(input));
      }, 2000);

      // Insert success message after the button
      submitButton.parentNode.insertBefore(successMessage, submitButton.nextSibling);
    } else {
      // Scroll to first error
      const firstError = form.querySelector('.border-red-500');
      if (firstError) {
        firstError.scrollIntoView({ behavior: 'smooth', block: 'center' });
      }
    }
  });

  // Add visual feedback for form interactions
  inputs.forEach(input => {
    input.addEventListener('focus', function() {
      this.classList.add('ring-2', 'ring-primary', 'ring-opacity-50');
    });

    input.addEventListener('blur', function() {
      this.classList.remove('ring-2', 'ring-primary', 'ring-opacity-50');
    });
  });
});
