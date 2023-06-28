package br.com.apigateway.apigateway.adapter.input.rest.v1

import br.com.apigateway.apigateway.adapter.input.service.IHandlerService
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.ResponseEntity
import org.springframework.util.AntPathMatcher
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.HandlerMapping

@RestController
@RequestMapping("/v1")
class GatewayController(val handler: IHandlerService) {

    @GetMapping("{generic_path}/**")
    fun getRequest(@PathVariable("generic_path") requestUrl: String,
                   request: HttpServletRequest): ResponseEntity<Any> {
        return handler.processGet("/" + AntPathMatcher().extractPathWithinPattern(
            request.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE).toString(), request.requestURI), request)
    }

    @PostMapping("{generic_path}")
    fun postRequest(
        @PathVariable("generic_path") requestUrl: String,
        request: HttpServletRequest
    ): ResponseEntity<Any> {
        return handler.processPost(requestUrl, request)
    }
}