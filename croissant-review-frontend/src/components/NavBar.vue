<template>
  <nav class="navbar">
    <div class="container">
      <a class="navbar-brand" href="/">Rogale Świętomarcińskie</a>
      <div class="navbar-end">
        <router-link to="/" class="navbar-item">Home</router-link>
        <router-link to="/add" class="navbar-item">Dodaj Rogala</router-link>
        <router-link to="/stats" class="navbar-item">Statystyki</router-link>
        <router-link to="/login" class="navbar-item">Logowanie</router-link>
        <router-link to="/register" class="navbar-item">Rejestracja</router-link>
      </div>
    </div>
  </nav>
</template>

<script>
export default {
  name: 'NavBar'
};
</script>

<style scoped>
.navbar {
  background-color: #f5f5f5;
  padding: 1rem 0;
  border-bottom: 1px solid #e5e5e5;
}
.container {
  display: flex;
  justify-content: space-between;
  align-items: center;
  max-width: 1200px;
  margin: 0 auto;
}
.navbar-brand {
  font-size: 1.5rem;
  color: #333;
  text-decoration: none;
}
.navbar-item {
  margin-left: 1rem;
  color: #333;
  text-decoration: none;
}
.navbar-item:hover {
  text-decoration: underline;
}
</style>
