<template>
  <div class="rogal-item">
    <img :src="rogal.photo" alt="Zdjęcie Rogala" class="rogal-photo"/>
    <h2>{{ rogal.name }}</h2>
    <p>{{ rogal.description }}</p>
    <!-- Przyciski lub linki do oceniania, edycji itp. -->
  </div>
</template>

<script>
export default {
  name: 'RogalItem',
  props: {
    rogal: Object
  }
};
</script>

<style scoped>
.rogal-item {
  width: 300px;
  border: 1px solid #eee;
  padding: 20px;
  margin: 10px;
  border-radius: 5px;
}
.rogal-photo {
  width: 100%;
  border-radius: 5px;
  margin-bottom: 15px;
}
</style>
