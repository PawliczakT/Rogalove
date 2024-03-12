package com.rogale.rogalove.models

import com.nimbusds.oauth2.sdk.Role
import lombok.Data
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "users")
@Data
data class User(

    @Id
    val id: String,

    val username: String,

    val email: String,

    var password: String,

    val role: String,

)
