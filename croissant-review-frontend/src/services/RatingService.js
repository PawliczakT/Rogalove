import axios from 'axios'

const API_URL = 'http://localhost:8080/api/ratings'

class RatingService {
    async getRatingsForCroissant(croissantId) {
        const response = await axios.get(`${API_URL}/croissant/${croissantId}`)
        return response.data
    }

    async getRatingsForUser(userId) {
        const response = await axios.get(`${API_URL}/user/${userId}`)
        return response.data
    }

    async rateOrUpdateCroissant(croissantId, userId, rating) {
        const existingRating = await this.getUserRatingForCroissant(croissantId, userId)
        if (existingRating) {
            await axios.put(`${API_URL}/${existingRating.id}`, { score: rating })
        } else {
            await axios.post(API_URL, { croissantId, userId, score: rating })
        }
    }

    async getUserRatingForCroissant(croissantId, userId) {
        const ratings = await this.getRatingsForUser(userId)
        return ratings.find(rating => rating.croissant.id === croissantId)
    }
}

export default new RatingService()