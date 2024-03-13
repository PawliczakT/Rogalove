<template>
  <div class="rogal-list">
    <RogalItem
        v-for="rogal in rogale"
        :key="rogal.id"
        :rogal="rogal"
    />
  </div>
</template>

<script>
import RogalItem from './RogalItem.vue';

export default {
  name: 'RogalList',
  components: {
    RogalItem
  },
  data() {
    return {
      rogale: [] // Przykładowe dane zostaną zastąpione pobieraniem z API
    };
  },
  mounted() {
    // Tutaj będzie kod do pobierania listy rogali z API
  }
};
</script>

<style scoped>
.rogal-list {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-around;
}
</style>
