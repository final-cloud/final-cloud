package org.ifinalframework.cloud.dashboard.flux.filter;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;

import org.ifinalframework.web.annotation.condition.ConditionalOnReactiveWebApplication;

import reactor.core.publisher.Mono;

/**
 * DashboardHtmlWebFilter.
 *
 * @author likly
 * @version 1.0.0
 * @since 1.0.0
 */
@Component
@ConditionalOnReactiveWebApplication
public class DashboardHtmlWebFilter implements WebFilter {

    private static final String[] MODULES = new String[]{"devops"};

    @Override
    public Mono<Void> filter(final ServerWebExchange exchange, final WebFilterChain chain) {
        String path = exchange.getRequest().getURI().getPath();

        for (final String module : MODULES) {

            if (path.contains("/" + module + "/") || path.endsWith("/" + module)) {

                path = StringUtils.trimTrailingCharacter(path, '/');

                return chain.filter(exchange.mutate().request(exchange.getRequest()
                    .mutate()
                    .path(path.endsWith(module) ? path + "/index.html" : path + ".html")
                    .build())
                    .build());
            }
        }

        return chain.filter(exchange);
    }

}
