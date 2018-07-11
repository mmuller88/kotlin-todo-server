package vc.rux.demo.kotlnitodo.controller

import org.springframework.web.bind.annotation.*
import vc.rux.demo.kotlnitodo.vc.rux.demo.kotlnitodo.controller.dto.TodoDto
import vc.rux.demo.kotlnitodo.vc.rux.demo.kotlnitodo.vc.rux.demo.kotlnitodo.repository.TodoRepository

@RestController
class TodoController(
    val todoRepository: TodoRepository
) {
    @GetMapping("/")
    fun list(@RequestParam("ownerId") ownerId: String): List<TodoDto> {
        return todoRepository
            .findByUserId(ownerId)
            .map { TodoDto(id = it.id.orEmpty(), text = it.text) }
    }

    @PostMapping("/{id}")
    fun create(@RequestParam("ownerId") ownerId: String, @RequestBody dto: TodoDto) {

    }


}