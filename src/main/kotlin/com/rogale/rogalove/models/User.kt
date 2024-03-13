package com.rogale.rogalove.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "users")
data class User(

    @Id
    val id: String,
    val username: String,
    val email: String,
    var password: String,
    val role: String,

)
