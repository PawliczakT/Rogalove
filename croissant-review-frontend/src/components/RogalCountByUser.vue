<template>
  <div class="rogal-count-by-user">
    <!-- Tutaj treść komponentu -->
    <p>Liczba rogali dodanych przez użytkowników będzie tutaj...</p>
  </div>
</template>

<script>
export default {
  name: 'RogalCountByUser',
  props: {
    chartData: Object
  },
  mounted() {
    // Tutaj logika dla wykresu liczby rogali na użytkownika
  }
}
</script>

<style scoped>
/* Styl komponentu */
</style>
