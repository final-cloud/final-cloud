package org.ifinalframework.cloud.dashboard.service;

import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.gateway.config.GatewayProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import org.ifinalframework.cloud.dashboard.model.Resource;

import java.util.List;
import java.util.stream.Collectors;

/**
 * GatewayResourcesProvider.
 *
 * @author likly
 * @version 1.0.0
 * @since 1.0.0
 */
@Primary
@Configuration
@ConditionalOnClass(GatewayProperties.class)
@AutoConfigureBefore(DefaultResourcesProvider.class)
public class GatewayResourcesProvider implements ResourcesProvider {

    @javax.annotation.Resource
    private DiscoveryClient discoveryClient;

    @Override
    public List<Resource> getResource() {

        return discoveryClient.getServices()
            .stream()
            .map(it -> new Resource(it, "/" + it))
            .collect(Collectors.toList());

    }

}
