/* eslint-disable no-unused-vars */

<template>
  <div>
    <h1>Lista Rogali</h1>
    <div>
      <input v-model="filterText" placeholder="Filtruj po nazwie">
      <select v-model="filterRating">
        <option value="">Wszystkie oceny</option>
        <option v-for="n in 5" :key="n" :value="n">{{ n }} gwiazdki</option>
      </select>
      <select v-model="sortOption">
        <option value="">Sortuj...</option>
        <option value="name">Nazwa (A-Z)</option>
        <option value="rating">Ocena (rosnąco)</option>
      </select>
    </div>
    <div v-if="isLoading">Ładowanie...</div>
    <div v-else>
      <div v-for="croissant in paginatedCroissants" :key="croissant.id">
        <CroissantCard :croissant="croissant" @rate="rateHandler" />
      </div>
      <div class="pagination">
        <button :disabled="currentPage === 1" @click="currentPage--">Poprzednia</button>
        <span>Strona {{ currentPage }} z {{ totalPages }}</span>
        <button :disabled="currentPage === totalPages" @click="currentPage++">Następna</button>
      </div>
      <button @click="showAddCroissantModal = true">Dodaj Rogala</button>
    </div>

    <div v-if="showAddCroissantModal">
      <AddCroissantModal @close="showAddCroissantModal = false" @add="addCroissant" />
    </div>
  </div>
</template>

<script>
import CroissantCard from '@/views/CroissantCard.vue'
import AddCroissantModal from '@/views/AddRogalModal.vue'
import CroissantService from '@/services/CroissantService'

export default {
  name: 'CroissantListView',
  components: {
    CroissantCard,
    AddCroissantModal
  },
  data() {
    return {
      croissants: [],
      isLoading: false,
      showAddCroissantModal: false,
      filterText: '',
      filterRating: '',
      sortOption: '',
      currentPage: 1,
      itemsPerPage: 10
    }
  },
  computed: {
    filteredCroissants() {
      return this.croissants.filter(croissant => {
        const nameMatch = croissant.name.toLowerCase().includes(this.filterText.toLowerCase())
        const ratingMatch = this.filterRating === '' || croissant.rating === this.filterRating
        return nameMatch && ratingMatch
      })
    },
    sortedCroissants() {
      let sortedCroissants = [...this.filteredCroissants]
      if (this.sortOption === 'name') {
        sortedCroissants.sort((a, b) => a.name.localeCompare(b.name))
      } else if (this.sortOption === 'rating') {
        sortedCroissants.sort((a, b) => a.rating - b.rating)
      }
      return sortedCroissants
    },
    paginatedCroissants() {
      const startIndex = (this.currentPage - 1) * this.itemsPerPage
      const endIndex = startIndex + this.itemsPerPage
      return this.sortedCroissants.slice(startIndex, endIndex)
    },
    totalPages() {
      return Math.ceil(this.sortedCroissants.length / this.itemsPerPage)
    }
  },
  created() {
    this.fetchCroissants()
  },
  methods: {
    async fetchCroissants() {
      this.isLoading = true
      try {
        this.croissants = await CroissantService.getAllCroissants()
      } catch (error) {
        console.error(error)
      } finally {
        this.isLoading = false
      }
    },
    // eslint-disable-next-line
    rateHandler(croissantId, rating) {
      // logika oceniania rogala
    },
    // eslint-disable-next-line
    addCroissant(croissant) {
      // logika dodawania nowego rogala
    }
  }
}
</script>