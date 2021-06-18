package org.ifinalframework.cloud.dashboard.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.ifinalframework.cloud.dashboard.model.Resource;
import org.ifinalframework.cloud.dashboard.service.ResourcesProvider;

import java.util.List;

/**
 * ResourcesApiController.
 *
 * @author likly
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController
@RequestMapping("/resources")
public class ResourcesApiController {

    @Autowired
    public ResourcesApiController(final ResourcesProvider resourcesProvider) {
        this.resourcesProvider = resourcesProvider;
    }

    private final ResourcesProvider resourcesProvider;

    @GetMapping
    public List<Resource> resources() {
        return resourcesProvider.getResource();
    }

}
