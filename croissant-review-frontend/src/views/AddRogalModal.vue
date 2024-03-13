<template>
  <div class="add-rogal-form">
    <h2>Dodaj nowego rogala</h2>
    <form @submit.prevent="submitForm">
      <div class="form-group">
        <label for="name">Nazwa Rogala</label>
        <input type="text" id="name" v-model="rogal.name" required>
      </div>
      <div class="form-group">
        <label for="description">Opis</label>
        <textarea id="description" v-model="rogal.description" required></textarea>
      </div>
      <div class="form-group">
        <label for="photo">Zdjęcie</label>
        <input type="file" id="photo" @change="handleFileUpload" required>
      </div>
      <button type="submit">Dodaj Rogala</button>
    </form>
  </div>
</template>

<script>
export default {
  name: 'AddRogalForm',
  data() {
    return {
      rogal: {
        name: '',
        description: '',
        photo: null
      }
    };
  },
  methods: {
    handleFileUpload(event) {
      this.rogal.photo = event.target.files[0];
    },
    submitForm() {
      // Tutaj logika do przesłania danych formularza, w tym pliku, do API
      console.log('Formularz wysłany', this.rogal);
      // Reset formularza po wysłaniu
      this.rogal = { name: '', description: '', photo: null };
    }
  }
};
</script>

<style scoped>
.add-rogal-form {
  max-width: 500px;
  margin: auto;
  padding: 20px;
}
.form-group {
  margin-bottom: 20px;
}
label {
  display: block;
  margin-bottom: 5px;
}
input[type="text"],
textarea {
  width: 100%;
  padding: 10px;
  margin-bottom: 10px;
  border: 1px solid #ccc;
  border-radius: 4px;
}
button {
  cursor: pointer;
  padding: 10px 20px;
  background-color: #3498db;
  color: white;
  border: none;
  border-radius: 4px;
}
button:hover {
  background-color: #2980b9;
}
</style>
