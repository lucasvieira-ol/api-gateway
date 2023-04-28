package br.com.apigateway.apigateway.adapter.input.service.api

import br.com.apigateway.apigateway.adapter.output.client.RequestClient
import br.com.apigateway.apigateway.utils.RequestUtils
import feign.Feign
import feign.gson.GsonDecoder
import feign.gson.GsonEncoder
import jakarta.servlet.http.HttpServletRequest
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.net.URI

@Service
@Qualifier("defaultImpl")
class DefaultEndpointServiceImpl : DefaultService {

    private var requestClient: RequestClient = Feign.builder()
        .decoder(GsonDecoder())
        .encoder(GsonEncoder())
        .target(RequestClient::class.java, "")

    override fun processPostRequest(urlRequest: String, request: HttpServletRequest): ResponseEntity<Any> {
        val headers = RequestUtils.getDefaultHeader(request)
        return requestClient.postRequest(URI.create(urlRequest), HashMap<String, Any>(), request)
    }
}