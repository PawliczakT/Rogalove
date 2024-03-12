import http from '@/utils/http'

const API_URL = 'http://localhost:8080/api/auth'

class AuthService {
    async login(username, password) {
        const response = await http.post(`${API_URL}/login`, { username, password })
        return response.data
    }

    async register(user) {
        const response = await http.post(`${API_URL}/register`, user)
        return response.data
    }

    async logout() {
        await http.post(`${API_URL}/logout`)
    }
}

export default new AuthService()