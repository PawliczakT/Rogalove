<template>
  <div class="home">
    <h1>Witaj w aplikacji Oceny Rogali Świętomarcińskich!</h1>
    <p>Tutaj możesz oceniać rogale, dodawać nowe i przeglądać statystyki.</p>
    <div class="rogal-list-section">
      <h2>Najnowsze Rogale:</h2>
      <RogalList />
    </div>
  </div>
</template>

<script>
import RogalList from '../components/RogalList.vue';

export default {
  //eslint-disable-next-line
  name: 'Home',
  components: {
    RogalList
  }
};
</script>

<style scoped>
.home {
  text-align: center;
}

.rogal-list-section {
  margin-top: 20px;
}
</style>
