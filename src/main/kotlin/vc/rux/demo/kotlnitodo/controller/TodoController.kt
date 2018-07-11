package vc.rux.demo.kotlnitodo.controller

import org.springframework.web.bind.annotation.*
import vc.rux.demo.kotlnitodo.db.repository.TodoRepository
import vc.rux.demo.kotlnitodo.dto.DoneDto
import vc.rux.demo.kotlnitodo.dto.TodoDto
import vc.rux.demo.kotlnitodo.utils.toDto
import vc.rux.demo.kotlnitodo.utils.toModel
import vc.rux.demo.kotlnitodo.webexceptions.OwnerMismatchException
import vc.rux.demo.kotlnitodo.webexceptions.TodoNotFoundException

@RestController
@RequestMapping("/api")
class TodoController(
    val todoRepository: TodoRepository
) {
    @GetMapping("/")
    fun list(@RequestParam("ownerId", required = true) ownerId: String): List<TodoDto> {
        return todoRepository
            .findByUserId(ownerId)
            .map { it.toDto() }
    }

    @PostMapping("/")
    fun create(
        @RequestParam("ownerId", required = true) ownerId: String,
        @RequestBody dto: TodoDto
    ): TodoDto {
        val todoModel = todoRepository.save(dto.toModel(ownerId))
        return todoModel.toDto()
    }

    @PatchMapping("/{id}/done")
    fun setDone(
        @RequestParam("ownerId", required = true) ownerId: String,
        @PathVariable("id", required = true) todoId: String,
        @RequestBody doneDto: DoneDto
    ): TodoDto {
        val model = todoRepository.findById(todoId)
                .orElseThrow { throw TodoNotFoundException(todoId) }
        model.isDone = doneDto.isDone
        return todoRepository.save(model).toDto()
    }

    @DeleteMapping("/{id}")
    fun delete(
        @RequestParam("ownerId", required = true) ownerId: String,
        @PathVariable("id", required = true) todoId: String
    ) {
        val model = todoRepository.findById(todoId)
                .orElseThrow { throw TodoNotFoundException(todoId) }

        if (model.ownerId != ownerId)
            throw OwnerMismatchException(ownerId, model.ownerId)

        todoRepository.deleteById(todoId)
    }

}