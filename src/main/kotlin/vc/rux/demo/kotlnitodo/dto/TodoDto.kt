package vc.rux.demo.kotlnitodo.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class TodoDto(
    @JsonProperty("id")
    val id: String? = null,

    @JsonProperty("text")
    val text: String,

    @JsonProperty("isDone")
    val isDone: Boolean
)