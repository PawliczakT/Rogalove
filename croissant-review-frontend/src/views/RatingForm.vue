<template>
  <div>
    <div v-for="n in 5" :key="n">
      <span @click="setRating(n)">{{ n <= rating ? '★' : '☆' }}</span>
    </div>
    <button @click="submitRating">Oceń</button>
  </div>
</template>

<script>
export default {
  name: 'RatingForm',
  props: {
    initialRating: {
      type: Number,
      default: 0
    }
  },
  data() {
    return {
      rating: this.initialRating
    }
  },
  methods: {
    setRating(value) {
      this.rating = value
    },
    submitRating() {
      this.$emit('rate', this.rating)
    }
  }
}
</script>