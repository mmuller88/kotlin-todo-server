package vc.rux.demo.kotlnitodo.utils

import vc.rux.demo.kotlnitodo.dto.TodoDto
import vc.rux.demo.kotlnitodo.db.model.TodoModel


fun TodoModel.toDto() = TodoDto(id = id.orEmpty(), text = text, isDone = isDone)
fun TodoDto.toModel(ownerId: String) = TodoModel(id = id, text = text, ownerId = ownerId)