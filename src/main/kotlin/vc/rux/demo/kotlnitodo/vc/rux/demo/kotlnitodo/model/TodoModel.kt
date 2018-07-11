package vc.rux.demo.kotlnitodo.vc.rux.demo.kotlnitodo.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import java.util.*


data class TodoModel(
    @Id
    var id: String? = null,
    var ownerId: String,
    var text: String,
    var isDone: Boolean = false,

    var createdAt: Date = Date(),

    @LastModifiedDate
    var updatedAt: Date = Date()
)
