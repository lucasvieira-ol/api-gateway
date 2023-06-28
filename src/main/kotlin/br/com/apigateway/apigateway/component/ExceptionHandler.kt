package br.com.apigateway.apigateway.component

import br.com.apigateway.apigateway.core.domain.dto.exception.BusinessExceptionDTO
import feign.FeignException
import org.apache.catalina.connector.Response
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.lang.Exception
import java.nio.ByteBuffer
import java.util.*

@ControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(FeignException.NotFound::class)
    fun processException(exception: FeignException.NotFound): ResponseEntity<Any> {
        return ResponseEntity.status(Response.SC_NOT_FOUND).body(exception.responseBody().get().toString())
    }

    @ExceptionHandler(FeignException.BadRequest::class)
    fun processException(exception: FeignException.BadRequest): ResponseEntity<Any> {
        return ResponseEntity.status(Response.SC_BAD_REQUEST).body(BusinessExceptionDTO("Error while doing the request, try again later"))
    }
}