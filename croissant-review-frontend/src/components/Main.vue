/* eslint-disable */
<template>
  <div class="main-page">
    <div class="best-rogals">
      <best-rogals-list :rogals="bestRogals"></best-rogals-list>
    </div>
    <div class="side-panel">
      <add-rogal-form @addRogal="addRogal"></add-rogal-form>
      <last-rated-rogals :lastRated="lastRatedRogals"></last-rated-rogals>
    </div>
  </div>
</template>

<script>
import BestRogalsList from '../components/BestRogalsList.vue';
import AddRogalForm from '../components/AddRogalForm.vue';
import LastRatedRogals from '../components/LastRatedRogals.vue';

export default {
  // eslint-disable-next-line
  name: 'Main',
  components: {
    BestRogalsList,
    AddRogalForm,
    LastRatedRogals,
  },
  data() {
    return {
      bestRogals: [], // This would be fetched from an API or store
      lastRatedRogals: [], // This would also be fetched
    };
  },
  methods: {
    /* eslint-disable */
    addRogal(newRogal) {
      // This method would handle adding the new rogal to the list
      // Typically you'd send a POST request to your server here
    },
  },
};
</script>

<style>
.main-page {
  display: flex;
  justify-content: space-between;
}
.best-rogals {
  width: 60%;
}
.side-panel {
  width: 35%;
}
/* Add additional styles as needed */
</style>
