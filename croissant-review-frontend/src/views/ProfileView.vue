<template>
  <div v-if="isLoading">Ładowanie...</div>
  <div v-else-if="user">
    <h1>Profil użytkownika</h1>
    <p>Nazwa użytkownika: {{ user.username }}</p>
    <p>Email: {{ user.email }}</p>

    <h2>Twoje oceny</h2>
    <div v-for="rating in ratings" :key="rating.id">
      <p>{{ rating.croissant.name }} - {{ rating.score }}/5</p>
      <p v-if="rating.comment">Komentarz: {{ rating.comment }}</p>
    </div>

    <h2>Statystyki</h2>
    <p>Średnia ocena: {{ statistics.averageRating }}</p>
    <p>Liczba ocen: {{ statistics.ratingCount }}</p>
  </div>
  <div v-else>Użytkownik nie został znaleziony</div>
</template>

<script>
import UserService from '@/services/UserService'
import RatingService from '@/services/RatingService'
import StatisticsService from '@/services/StatisticsService'

export default {
  name: 'ProfileView',
  data() {
    return {
      user: null,
      ratings: [],
      statistics: null,
      isLoading: false
    }
  },
  created() {
    this.fetchUserProfile()
  },
  methods: {
    async fetchUserProfile() {
      this.isLoading = true
      try {
        const userId = this.$store.state.user.id
        this.user = await UserService.getUserById(userId)
        this.ratings = await RatingService.getRatingsForUser(userId)
        this.statistics = await StatisticsService.getUserStatistics(userId)
      } catch (error) {
        console.error(error)
      } finally {
        this.isLoading = false
      }
    }
  }
}
</script>