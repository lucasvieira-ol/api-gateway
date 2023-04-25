package br.com.apigateway.apigateway.adapter.input.rest

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1")
class GatewayController {

    @GetMapping("{generic_path}/**")
    fun getRequest(@PathVariable("generic_path") requestUrl: String): String{
        return "Ok"
    }
}