package vc.rux.demo.kotlnitodo.webexceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(code = HttpStatus.FORBIDDEN, reason = "You don't have access to this todo")
class OwnerMismatchException(
        givenOwnerId: String, expectedOwnerId: String
) : RuntimeException("Invalid owner id, given: $givenOwnerId, expected: $expectedOwnerId")