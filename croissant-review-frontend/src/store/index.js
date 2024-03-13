import { createStore } from 'vuex';
import axios from 'axios';


export default createStore({
    state: {
        isAuthenticated: false,
        user: null,
        rogale: []
    },
    mutations: {
        setAuthentication(state, status) {
            state.isAuthenticated = status;
        },
        setUser(state, user) {
            state.user = user;
        },
        setRogale(state, rogale) {
            state.rogale = rogale;
        }
    },
    actions: {
        login({ commit }, credentials) {
            // Przykład logowania, dostosuj URL i logikę zgodnie z API
            axios.post('/api/auth/login', credentials)
                .then(response => {
                    commit('setAuthentication', true);
                    commit('setUser', response.data.user);
                    // Można też tutaj zapisać token JWT do localStorage
                })
                .catch(error => {
                    console.error("Błąd logowania:", error);
                    commit('setAuthentication', false);
                    commit('setUser', null);
                });
        },
        fetchRogale({ commit }) {
            // Przykład pobierania rogali, dostosuj URL zgodnie z API
            axios.get('/api/rogale')
                .then(response => {
                    commit('setRogale', response.data.rogale);
                })
                .catch(error => {
                    console.error("Błąd pobierania rogali:", error);
                });
        }
        // Tutaj można dodać więcej akcji związanych z użytkownikami i rogale
    },
    getters: {
        isAuthenticated: state => state.isAuthenticated,
        user: state => state.user,
        rogale: state => state.rogale
    }
});
