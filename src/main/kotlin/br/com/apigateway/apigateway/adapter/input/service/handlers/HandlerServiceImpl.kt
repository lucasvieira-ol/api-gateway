package br.com.apigateway.apigateway.adapter.input.service.handlers

import br.com.apigateway.apigateway.adapter.input.service.IHandlerService
import br.com.apigateway.apigateway.enumeration.endpoints.external.ExtEndpoints
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.ResponseEntity

class HandlerServiceImpl : IHandlerService {
    override fun processPost(urlRequest: String, request: HttpServletRequest): ResponseEntity<Any> {
        val route = ExtEndpoints.getByEndpoint(urlRequest).orElseThrow()
        return route.service.processPostRequest(urlRequest, request)
    }
}