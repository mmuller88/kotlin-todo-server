package vc.rux.demo.kotlnitodo.vc.rux.demo.kotlnitodo.controller.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import vc.rux.demo.kotlnitodo.vc.rux.demo.kotlnitodo.model.TodoModel


data class TodoList(
    @Id
    var id: ObjectId? = null,

    var title: String,

    val todos: List<TodoModel>
)