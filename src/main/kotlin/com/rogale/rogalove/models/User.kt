package com.rogale.rogalove.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "users")
data class User(

    @Id
    val id: String? = null,

    val username: String,

    val email: String,

    var password: String,

    @DBRef
    val ratings: MutableList<Rating> = mutableListOf()

)
