package br.com.apigateway.apigateway.adapter.output.client

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import java.net.URI


@FeignClient(name = "requestClient", url = "NOT USED")
interface RequestClient {

    @RequestMapping(
        method = [RequestMethod.POST],
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun postRequest(uri: URI, @RequestHeader header: Map<String, Any>, @RequestBody request: Any): ResponseEntity<Any>

}