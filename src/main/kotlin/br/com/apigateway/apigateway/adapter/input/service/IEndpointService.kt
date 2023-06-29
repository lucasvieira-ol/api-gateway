package br.com.apigateway.apigateway.adapter.input.service

import br.com.apigateway.apigateway.adapter.output.client.RequestClient
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.ResponseEntity

interface IEndpointService {

    fun processPostRequest(urlRequest: String, request: HttpServletRequest, requestClient: RequestClient): ResponseEntity<Any>
    fun processGetRequest(urlRequest: String, request: HttpServletRequest, requestClient: RequestClient): ResponseEntity<Any>

}
