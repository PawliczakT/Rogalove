<template>
  <div>
    <h1>Logowanie</h1>
    <form @submit.prevent="login">
      <div>
        <input v-model="username" placeholder="Nazwa użytkownika" :class="{ 'is-invalid': $v.username.$error }">
        <div class="invalid-feedback" v-if="!$v.username.required">Nazwa użytkownika jest wymagana.</div>
      </div>
      <div>
        <input v-model="password" type="password" placeholder="Hasło" :class="{ 'is-invalid': $v.password.$error }">
        <div class="invalid-feedback" v-if="!$v.password.required">Hasło jest wymagane.</div>
      </div>
      <button type="submit" :disabled="$v.$invalid">Zaloguj</button>
    </form>
  </div>
</template>

<script>
import { required } from 'vuelidate/lib/validators'

export default {
  name: 'LoginView',
  data() {
    return {
      username: '',
      password: ''
    }
  },
  validations: {
    username: { required },
    password: { required }
  },
  methods: {
    login() {
      this.$v.$touch()
      if (!this.$v.$invalid) {
        this.$store.dispatch('login', {
          username: this.username,
          password: this.password
        })
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