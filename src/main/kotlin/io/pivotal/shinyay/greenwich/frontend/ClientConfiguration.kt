package io.pivotal.shinyay.greenwich.frontend

import org.springframework.cloud.loadbalancer.core.RoundRobinLoadBalancer
import org.springframework.cloud.loadbalancer.core.ServiceInstanceSupplier
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory
import org.springframework.context.annotation.Bean
import org.springframework.core.env.Environment

class ClientConfiguration {

    @Bean
    fun roundRobinLoadbalancer(clientFactory: LoadBalancerClientFactory,
                               environment: Environment): RoundRobinLoadBalancer {
        val serviceId = clientFactory.getName(environment)
        return RoundRobinLoadBalancer(
                serviceId,
                clientFactory.getLazyProvider(
                        serviceId,
                        ServiceInstanceSupplier::class.java), -1)
    }
}