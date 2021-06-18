package org.ifinalframework.cloud.core.api;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import javax.annotation.Resource;

/**
 * ServiceApiController.
 *
 * @author likly
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController
public class ServiceApiController {

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping
    public List<String> services(){
        return discoveryClient.getServices();
    }

}
