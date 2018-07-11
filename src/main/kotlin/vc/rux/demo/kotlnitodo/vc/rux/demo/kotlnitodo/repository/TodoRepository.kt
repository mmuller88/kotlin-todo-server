package vc.rux.demo.kotlnitodo.vc.rux.demo.kotlnitodo.vc.rux.demo.kotlnitodo.repository

import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.Query
import org.springframework.data.repository.CrudRepository
import vc.rux.demo.kotlnitodo.vc.rux.demo.kotlnitodo.model.TodoModel


interface TodoRepository : CrudRepository<TodoModel, ObjectId> {
    @Query("\${ownerId: ?0}")
    fun findByUserId(ownerId: String): List<TodoModel>
}