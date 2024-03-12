<template>
  <div class="modal">
    <div class="modal-content">
      <span class="close" @click="$emit('close')">&times;</span>
      <h2>Dodaj Rogala</h2>
      <form @submit.prevent="addCroissant">
        <input v-model="name" placeholder="Nazwa" required>
        <textarea v-model="description" placeholder="Opis" required></textarea>
        <input v-model="imageUrl" placeholder="URL Zdjęcia">
        <button type="submit">Dodaj</button>
      </form>
    </div>
  </div>
</template>

<script>
export default {
  name: 'AddCroissantModal',
  data() {
    return {
      name: '',
      description: '',
      imageUrl: ''
    }
  },
  methods: {
    addCroissant() {
      const croissant = {
        name: this.name,
        description: this.description,
        imageUrl: this.imageUrl
      }
      this.$emit('add', croissant)
      this.resetForm()
    },
    resetForm() {
      this.name = ''
      this.description = ''
      this.imageUrl = ''
    }
  }
}
</script>

<style scoped>
.modal {
  /* Stylizacja modalu */
}
</style>