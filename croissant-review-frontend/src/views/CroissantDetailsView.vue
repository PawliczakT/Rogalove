<template>
  <div v-if="isLoading">Ładowanie...</div>
  <div v-else-if="croissant">
    <h1>{{ croissant.name }}</h1>
    <img :src="croissant.imageUrl" :alt="croissant.name">
    <p>{{ croissant.description }}</p>

    <h2>Oceny</h2>
    <div v-for="rating in ratings" :key="rating.id">
      <p>{{ rating.user.username }} ocenił na {{ rating.score }}/5</p>
      <p v-if="rating.comment">Komentarz: {{ rating.comment }}</p>
    </div>

    <h2>Statystyki</h2>
    <p>Średnia ocena: {{ statistics.averageRating }}</p>
    <p>Liczba ocen: {{ statistics.ratingCount }}</p>
    <p v-for="(count, user) in statistics.userRatingCounts" :key="user.id">
      {{ user.username }} dodał {{ count }} ocen
    </p>

    <RatingForm :initialRating="userRating" @rate="rateHandler" />
  </div>
  <div v-else>Rogal nie został znaleziony</div>
</template>

<script>
import RatingForm from '@/views/RatingForm.vue'
import CroissantService from '@/services/CroissantService'
import RatingService from '@/services/RatingService'
import StatisticsService from '@/services/StatisticsService'

export default {
  name: 'CroissantDetailsView',
  components: {
    RatingForm
  },
  data() {
    return {
      croissant: null,
      ratings: [],
      statistics: null,
      userRating: 0,
      isLoading: false
    }
  },
  created() {
    this.fetchCroissantDetails()
  },
  methods: {
    async fetchCroissantDetails() {
      this.isLoading = true
      try {
        const croissantId = this.$route.params.id
        this.croissant = await CroissantService.getCroissantById(croissantId)
        this.ratings = await RatingService.getRatingsForCroissant(croissantId)
        this.statistics = await StatisticsService.getCroissantStatistics(croissantId)
        this.userRating = this.ratings.find(rating => rating.user.id === this.$store.state.user.id)?.score || 0
      } catch (error) {
        console.error(error)
      } finally {
        this.isLoading = false
      }
    },
    async rateHandler(rating) {
      try {
        const croissantId = this.$route.params.id
        const userId = this.$store.state.user.id
        await RatingService.rateOrUpdateCroissant(croissantId, userId, rating)
        await this.fetchCroissantDetails()
      } catch (error) {
        console.error(error)
      }
    }
  }
}
</script>