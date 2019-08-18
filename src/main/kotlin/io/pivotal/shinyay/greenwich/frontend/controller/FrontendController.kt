package io.pivotal.shinyay.greenwich.frontend.controller

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.cloud.loadbalancer.core.RoundRobinLoadBalancer
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory
import org.springframework.core.env.Environment
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

@RestController
@RequestMapping("/frontend")
class FrontendController(val environment: Environment,
                         val restTemplate: RestTemplate,
                         val clientFactory: LoadBalancerClientFactory) {

    val logger: Logger = LoggerFactory.getLogger(FrontendController::class.java)

    @GetMapping
    fun hello(): String {
        val lb: RoundRobinLoadBalancer =
                clientFactory.getInstance("backend-service", RoundRobinLoadBalancer::class.java)
        val serviceInstance = lb.choose().block()?.server
        val url = "http://${serviceInstance?.host}:${serviceInstance?.port}/backend"
        logger.info("Backend-URL: $url")
        val backendResponse = restTemplate.getForObject(url, String::class.java)
        logger.info(": {}")

        return "Hello, Frontend service on port: ${environment.getProperty("local.server.port")} Call-To-> $backendResponse"
    }
}