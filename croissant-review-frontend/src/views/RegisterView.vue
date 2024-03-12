<template>
  <div>
    <h1>Rejestracja</h1>
    <form @submit.prevent="register">
      <div>
        <input v-model="username" placeholder="Nazwa użytkownika" :class="{ 'is-invalid': $v.username.$error }">
        <div class="invalid-feedback" v-if="!$v.username.required">Nazwa użytkownika jest wymagana.</div>
      </div>
      <div>
        <input v-model="email" type="email" placeholder="Email" :class="{ 'is-invalid': $v.email.$error }">
        <div class="invalid-feedback" v-if="!$v.email.required">Email jest wymagany.</div>
        <div class="invalid-feedback" v-if="!$v.email.email">Nieprawidłowy format email.</div>
      </div>
      <div>
        <input v-model="password" type="password" placeholder="Hasło" :class="{ 'is-invalid': $v.password.$error }">
        <div class="invalid-feedback" v-if="!$v.password.required">Hasło jest wymagane.</div>
        <div class="invalid-feedback" v-if="!$v.password.minLength">Hasło musi mieć co najmniej 6 znaków.</div>
      </div>
      <div>
        <input v-model="confirmPassword" type="password" placeholder="Potwierdź hasło"
               :class="{ 'is-invalid': $v.confirmPassword.$error }">
        <div class="invalid-feedback" v-if="!$v.confirmPassword.required">Potwierdzenie hasła jest wymagane.</div>
        <div class="invalid-feedback" v-if="!$v.confirmPassword.sameAsPassword">Hasła nie są identyczne.</div>
      </div>
      <button type="submit" :disabled="$v.$invalid">Zarejestruj</button>
    </form>
  </div>
</template>

<script>
import { email, minLength, required, sameAs } from 'vuelidate/lib/validators'

export default {
  name: 'RegisterView',
  data() {
    return {
      username: '',
      email: '',
      password: '',
      confirmPassword: ''
    }
  },
  validations: {
    username: { required },
    email: { required, email },
    password: { required, minLength: minLength(6) },
    confirmPassword: { required, sameAsPassword: sameAs('password') }
  },
  methods: {
    register() {
      this.$v.$touch()
      if (!this.$v.$invalid) {
        const user = {
          username: this.username,
          email: this.email,
          password: this.password
        }
        this.$store.dispatch('register', user)
            .then(() => {
              this.$router.push('/')
            })
            .catch(error => {
              console.error(error)
              // obsługa błędów
            })
      }
    }
  }
}
</script>