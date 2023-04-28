package br.com.apigateway.apigateway.adapter.input.service

import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.ResponseEntity

interface IEndpointService {

    fun processPostRequest(urlRequest: String, request: HttpServletRequest): ResponseEntity<Any>

}
