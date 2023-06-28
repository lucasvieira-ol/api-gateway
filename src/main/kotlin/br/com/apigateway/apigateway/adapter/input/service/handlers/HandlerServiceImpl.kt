package br.com.apigateway.apigateway.adapter.input.service.handlers

import br.com.apigateway.apigateway.adapter.input.service.IHandlerService
import br.com.apigateway.apigateway.adapter.output.client.RequestClient
import br.com.apigateway.apigateway.enumeration.endpoints.external.ExtEndpoints
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class HandlerServiceImpl(private val requestClient: RequestClient) : IHandlerService {
    override fun processPost(urlRequest: String, request: HttpServletRequest): ResponseEntity<Any> {
        val route = ExtEndpoints.getByEndpoint(urlRequest).orElseThrow()
        return route.service.processPostRequest(urlRequest, request, requestClient)
    }

    override fun processGet(urlRequest: String, request: HttpServletRequest): ResponseEntity<Any> {
        val route = ExtEndpoints.getByEndpoint(urlRequest.split("/", )[1]).orElseThrow()
        return route.service.processGetRequest(urlRequest, request, requestClient)
    }
}