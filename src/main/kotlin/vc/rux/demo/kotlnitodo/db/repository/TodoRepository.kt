package vc.rux.demo.kotlnitodo.db.repository

import org.springframework.data.mongodb.repository.Query
import org.springframework.data.repository.CrudRepository
import vc.rux.demo.kotlnitodo.db.model.TodoModel

interface TodoRepository : CrudRepository<TodoModel, String> {
    @Query("{ownerId: ?0}")
    fun findByUserId(ownerId: String): List<TodoModel>
}