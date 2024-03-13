<template>
  <div>
    <h1>Logowanie</h1>
    <form @submit.prevent="login">
      <div>
        <input v-model="form.username" placeholder="Nazwa użytkownika" :class="{ 'is-invalid': v$.username.$error }">
        <div class="invalid-feedback" v-if="!v$.username.required">Nazwa użytkownika jest wymagana.</div>
      </div>
      <div>
        <input v-model="form.password" type="password" placeholder="Hasło" :class="{ 'is-invalid': v$.password.$error }">
        <div class="invalid-feedback" v-if="!v$.password.required">Hasło jest wymagane.</div>
      </div>
      <button type="submit" :disabled="v$.$invalid">Zaloguj</button>
    </form>
  </div>
</template>

<script>
import { ref } from 'vue';
import { useVuelidate } from '@vuelidate/core';
import { required } from '@vuelidate/validators';

export default {
  name: 'LoginView',
  setup() {
    const form = ref({
      username: '',
      password: ''
    });

    const rules = {
      username: { required },
      password: { required }
    };

    const v$ = useVuelidate(rules, form);

    const login = () => {
      v$.value.$touch();
      if (!v$.value.$invalid) {
        // Tutaj używamy store i router z Composition API
        // Załóżmy, że mamy funkcję loginUser do obsługi logowania
        loginUser(form.value.username, form.value.password)
            .then(() => {
              // Przekierowanie po pomyślnym logowaniu
              this.$router.push('/');
            })
            .catch(error => {
              console.error(error);
              // obsługa błędów
            });
      }
    };

    // Eksportujemy form i v$ do szablonu, oraz metodę login
    return { form, v$, login };
  }
};

// Musisz dostosować tę funkcję do Twojego store
function loginUser(username, password) {
  // Tutaj logika logowania, np. wywołanie do API
}
</script>
