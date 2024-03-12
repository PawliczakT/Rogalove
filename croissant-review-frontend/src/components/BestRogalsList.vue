<template>
  <div>
    <h2>Best Rogals</h2>
    <ul class="rogals-list">
      <li v-for="rogal in bestRogals" :key="rogal.id">
        <div class="rogal-name">{{ rogal.name }}</div>
        <div class="rogal-rating">Rating: {{ rogal.rating }}</div>
        <!-- Add other details you want to display -->
      </li>
    </ul>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: 'BestRogalsList',
  data() {
    return {
      bestRogals: [],
    };
  },
  created() {
    this.fetchTopRatedRogals();
  },
  methods: {
    async fetchTopRatedRogals() {
      try {
        const response = await axios.get('/api/rogals/top-rated');
        this.bestRogals = response.data;
      } catch (error) {
        console.error('Error fetching top-rated rogals:', error);
        // Handle the error properly in a real application
      }
    },
  },
};
</script>

<style>
/* Add styling specific to your rogals list here */

.rogals-list {
  list-style-type: none;
  padding: 0;
}

.rogal-name {
  font-weight: bold;
}

.rogal-rating {
  color: #666;
}
</style>
