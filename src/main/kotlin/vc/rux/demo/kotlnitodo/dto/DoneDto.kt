package vc.rux.demo.kotlnitodo.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class DoneDto(
    @JsonProperty("isDone")
    val isDone: Boolean
)