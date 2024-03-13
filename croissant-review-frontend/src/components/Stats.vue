<template>
  <div class="stats">
    <h2>Statystyki Rogali</h2>
    <div class="chart">
      <rogal-count-by-user :chart-data="dataCollection" />
    </div>
    <div class="chart">
      <average-rating-by-rogal :chart-data="ratingDataCollection" />
    </div>
  </div>
</template>

<script>
import RogalCountByUser from '@/components/RogalCountByUser.vue';
import AverageRatingByRogal from '@/components/AverageRatingByRogal.vue';

export default {
  //eslint-disable-next-line
  name: 'Stats',
  components: {
    RogalCountByUser,
    AverageRatingByRogal
  },
  data() {
    return {
      dataCollection: {}, // Dane do wykresu liczby rogali
      ratingDataCollection: {} // Dane do wykresu średnich ocen
    };
  },
  mounted() {
    // Tutaj kod do pobierania danych statystycznych z API i przypisywanie ich do dataCollection i ratingDataCollection
  }
};
</script>

<style scoped>
.stats {
  max-width: 600px;
  margin: auto;
}
.chart {
  margin-bottom: 40px;
}
</style>
