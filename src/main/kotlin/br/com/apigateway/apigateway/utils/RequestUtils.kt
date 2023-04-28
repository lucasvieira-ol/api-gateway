package br.com.apigateway.apigateway.utils

import jakarta.servlet.http.HttpServletRequest

class RequestUtils {
    companion object {
        fun getDefaultHeader(request: HttpServletRequest): Map<String, String> {
            return if (request.headerNames.hasMoreElements())
                request.headerNames.asSequence()
                    .associateBy<String, String, String>({ it }, { request.getHeader(it) })
            else
                HashMap<String, String>()
        }
    }

}
