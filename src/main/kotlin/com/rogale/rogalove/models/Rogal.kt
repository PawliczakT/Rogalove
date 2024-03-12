package com.rogale.rogalove.models

import lombok.Data
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document


@Document(collection = "rogals")
@Data
class Rogal {
        @Id
        private val id: String? = null
        private val name: String? = null
        private val description: String? = null
        private val photo: String? = null
}
