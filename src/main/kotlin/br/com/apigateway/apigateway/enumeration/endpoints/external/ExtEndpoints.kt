package br.com.apigateway.apigateway.enumeration.endpoints.external

import br.com.apigateway.apigateway.adapter.input.service.IEndpointService
import br.com.apigateway.apigateway.adapter.input.service.api.CepEndpointServiceImpl
import br.com.apigateway.apigateway.adapter.input.service.api.DefaultEndpointServiceImpl
import java.util.*

enum class ExtEndpoints(val endpoint: String, val service: IEndpointService) {
    TEST("test", DefaultEndpointServiceImpl()),
    DEFAULT("cep", CepEndpointServiceImpl());

    companion object {
        fun getByEndpoint(endpoint: String): Optional<ExtEndpoints> {
            return Arrays.stream(values()).filter { endpoint.contains(it.endpoint) }.findFirst()
        }
    }
}