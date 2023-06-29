package br.com.apigateway.apigateway.adapter.input.service.api

import br.com.apigateway.apigateway.adapter.input.service.IEndpointService
import br.com.apigateway.apigateway.adapter.output.client.RequestClient
import br.com.apigateway.apigateway.utils.RequestUtils
import feign.Feign
import feign.gson.GsonDecoder
import feign.gson.GsonEncoder
import jakarta.servlet.http.HttpServletRequest
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.lang.Exception
import java.net.URI

@Service
@Qualifier("defaultImpl")
class CepEndpointServiceImpl : IEndpointService {

    override fun processPostRequest(urlRequest: String, request: HttpServletRequest, requestClient: RequestClient): ResponseEntity<Any> {
        val headers = RequestUtils.getDefaultHeader(request)
        return requestClient.postRequest(URI.create(urlRequest), headers, request)
    }

    override fun processGetRequest(urlRequest: String, request: HttpServletRequest, requestClient: RequestClient): ResponseEntity<Any> {
        try{
            val headers = RequestUtils.getDefaultHeader(request)
            val uri = URI.create("http://viacep.com.br/ws/" + urlRequest.split("/", )[2] + "/json")
            return requestClient.getRequest(uri, headers)
        } catch (ex: Exception){
            println(ex)
            throw ex
        }
    }
}