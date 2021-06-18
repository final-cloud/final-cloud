package org.ifinalframework.cloud.dashboard.service;

import org.springframework.context.annotation.Configuration;

import org.ifinalframework.cloud.dashboard.model.Resource;

import java.util.Collections;
import java.util.List;

/**
 * DefaultResourcesProvider.
 *
 * @author likly
 * @version 1.0.0
 * @since 1.0.0
 */
@Configuration
//@ConditionalOnMissingBean(ResourcesProvider.class)
public class DefaultResourcesProvider implements ResourcesProvider {

    private static final Resource DEFAULT_RESOURCE = new Resource("default", "/");

    @Override
    public List<Resource> getResource() {
        return Collections.singletonList(DEFAULT_RESOURCE);
    }

}
