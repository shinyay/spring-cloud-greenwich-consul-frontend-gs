package io.pivotal.shinyay.greenwich.frontend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate

@SpringBootApplication
@LoadBalancerClient(name = "backend-service", configuration = [ClientConfiguration::class])
@EnableCaching
class FrontendApplication {
	@Bean
	fun restTemplate() = RestTemplate()
}

fun main(args: Array<String>) {
	runApplication<FrontendApplication>(*args)
}