<template>
  <div class="croissant-card">
    <img :src="croissant.imageUrl" :alt="croissant.name">
    <h3>{{ croissant.name }}</h3>
    <p>{{ croissant.description }}</p>
    <RatingForm :initialRating="croissant.rating" @rate="rateHandler" />
  </div>
</template>

<script>
import RatingForm from '@/views/RatingForm.vue'

export default {
  name: 'CroissantCard',
  components: {
    RatingForm
  },
  props: {
    croissant: {
      type: Object,
      required: true
    }
  },
  methods: {
    rateHandler(rating) {
      this.$emit('rate', this.croissant.id, rating)
    }
  }
}
</script>