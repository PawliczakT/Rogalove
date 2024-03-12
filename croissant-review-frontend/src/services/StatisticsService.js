import axios from 'axios'

const API_URL = 'http://localhost:8080/api/statistics'

class StatisticsService {
    async getCroissantStatistics(croissantId) {
        const response = await axios.get(`${API_URL}/croissant/${croissantId}`)
        return response.data
    }

    async getUserStatistics(userId) {
        const response = await axios.get(`${API_URL}/user/${userId}`)
        return response.data
    }
}

export default new StatisticsService()