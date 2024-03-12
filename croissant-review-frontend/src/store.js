import { createStore } from 'vuex';
import AuthService from '@/services/AuthService';

const store = createStore({
    state() {
        return {
            user: null,
            croissants: [],
            ratings: [],
        };
    },
    mutations: {
        setUser(state, user) {
            state.user = user
        },
        setCroissants(state, croissants) {
            state.croissants = croissants
        },
        setRatings(state, ratings) {
            state.ratings = ratings
        },
        logout(state) {
            state.user = null
            state.croissants = []
            state.ratings = []
        }
    },
    actions: {
        async login({ commit }, { username, password }) {
            try {
                const user = await AuthService.login(username, password)
                commit('setUser', user)
            } catch (error) {
                console.error(error)
                // obsługa błędów
            }
        },
        async register({ commit }, user) {
            try {
                const registeredUser = await AuthService.register(user)
                commit('setUser', registeredUser)
            } catch (error) {
                console.error(error)
                // obsługa błędów
            }
        },
        async logout({ commit }) {
            try {
                await AuthService.logout()
                commit('logout')
            } catch (error) {
                console.error(error)
                // obsługa błędów
            }
        }
    }
})

export default store