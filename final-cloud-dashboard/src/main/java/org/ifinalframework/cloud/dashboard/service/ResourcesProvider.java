package org.ifinalframework.cloud.dashboard.service;

import org.ifinalframework.cloud.dashboard.model.Resource;

import java.util.List;

/**
 * ResourceProvider.
 *
 * @author likly
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ResourcesProvider {

    List<Resource> getResource();

}
