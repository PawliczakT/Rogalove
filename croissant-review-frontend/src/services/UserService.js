import axios from 'axios'

const API_URL = 'http://localhost:8080/api/users'

class UserService {
    async getUserById(userId) {
        const response = await axios.get(`${API_URL}/${userId}`)
        return response.data
    }

    // inne metody dla operacji na użytkownikach
}

export default new UserService()