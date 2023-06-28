package br.com.apigateway.apigateway.adapter.input.service

import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.ResponseEntity

interface IHandlerService {

    fun processPost(urlRequest: String, request: HttpServletRequest) : ResponseEntity<Any>

    fun processGet(urlRequest: String, request: HttpServletRequest) : ResponseEntity<Any>
}