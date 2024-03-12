import axios from 'axios'
import store from '@/store'
import router from "@/router";

const http = axios.create({
    baseURL: 'http://localhost:8081/'
})

http.interceptors.response.use(
    response => response,
    error => {
        if (error.response.status === 401) {
            store.dispatch('logout').then(r => console.log(r))
            router.push('/login')
        }
        return Promise.reject(error)
    }
)

export default http