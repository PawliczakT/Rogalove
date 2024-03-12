import http from '@/utils/http'
import axios from 'axios'

const API_URL = '/croissants'

class CroissantService {
    async getAllCroissants() {
        const response = await http.get(API_URL)
        return response.data
    }

    async addCroissant(croissant) {
        const response = await axios.post(API_URL, croissant)
        return response.data
    }

    // inne metody dla operacji na rogalach
}

export default new CroissantService()