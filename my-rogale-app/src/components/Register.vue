/* eslint-disable */
<template>
  <div class="register">
    <h2>Rejestracja</h2>
    <form @submit.prevent="register">
      <div>
        <label for="username">Nazwa użytkownika</label>
        <input type="text" id="username" v-model="username" required />
      </div>
      <div>
        <label for="email">Email</label>
        <input type="email" id="email" v-model="email" required />
      </div>
      <div>
        <label for="password">Hasło</label>
        <input type="password" id="password" v-model="password" required />
      </div>
      <button type="submit">Zarejestruj</button>
    </form>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      username: "",
      password: "",
      email: "",
    };
  },
  methods: {
    async register() {
      try {
        const response = await axios.post("http://localhost:8080/register", {
          username: this.username,
          password: this.password,
          email: this.email,
        });

        // Check if the response status indicates success
        if (response.status === 200 || response.status === 201) {
          // Save the token to Vuex state if it exists in the response
          if (response.data?.token) {
            this.$store.dispatch("setToken", response.data.token);
          }

          // Show a success prompt
          window.alert("Registration successful!");

          // Redirect to home page after successful registration and showing the prompt
          this.$router.push("/");
        } else {
          // If status code doesn't indicate success, show the failed alert
          window.alert("Registration failed!");
        }
      } catch (error) {
        // Error handling
        console.error(error);
        window.alert("Registration failed!");
      }
    },
  },
};
</script>
