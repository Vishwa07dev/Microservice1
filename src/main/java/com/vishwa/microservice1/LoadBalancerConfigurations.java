package com.vishwa.microservice1;

import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class LoadBalancerConfigurations {

  @Bean
  public ServiceInstanceListSupplier
  discoveryClientServiceInstanceListSupplier(
      ConfigurableApplicationContext context) {
    System.out.println("Configuring Load balancer to prefer same instance");
    return ServiceInstanceListSupplier.builder()
        .withBlockingDiscoveryClient()
        .withSameInstancePreference()
        .build(context);
  }
}
