package vc.rux.demo.kotlnitodo.webexceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Required todo is not found")
class TodoNotFoundException(todoId: String) : RuntimeException("todo $todoId is not found")