package org.ifinalframework.cloud.dashboard.model;

import org.springframework.lang.NonNull;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Resource.
 *
 * @author likly
 * @version 1.0.0
 * @since 1.0.0
 */
@Setter
@Getter
@AllArgsConstructor
public class Resource implements Serializable {

    @NonNull
    private String name;

    @NonNull
    private String path;

}
