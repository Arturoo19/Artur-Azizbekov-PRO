package com.example.ordinarianl.model

import java.io.Serializable

data class Post (
    var title: String? = null,
    var body: String? = null,
    var tags: List<String>? = null
): Serializable
