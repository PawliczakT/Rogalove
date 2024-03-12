package com.rogale.rogalove.models

import lombok.Data
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document


@Document(collection = "ratings")
@Data
class Rating {
        @Id
        private val id: String? = null
        private val userId: String? = null
        private val rogaleId: String? = null
        private val value: Int? = null
        private val comment: String? = null
}

