<template>
  <nav>
    <div>
      <router-link to="/">Strona główna</router-link>
      <router-link v-if="isLoggedIn" to="/profile">Profil</router-link>
      <router-link v-if="!isLoggedIn" to="/login">Zaloguj</router-link>
      <router-link v-if="!isLoggedIn" to="/register">Zarejestruj</router-link>
      <a v-if="isLoggedIn" href="#" @click.prevent="logout">Wyloguj</a>
    </div>
  </nav>
</template>

<script>
import { mapState } from 'vuex'

export default {
  // eslint-disable-next-line
  name: 'Navbar',
  computed: {
    ...mapState(['user']),
    isLoggedIn() {
      return this.user !== null
    }
  },
  methods: {
    logout() {
      this.$store.dispatch('logout')
          .then(() => {
            this.$router.push('/login')
          })
          .catch(error => {
            console.error(error)
            // obsługa błędów
          })
    }
  }
}
</script>