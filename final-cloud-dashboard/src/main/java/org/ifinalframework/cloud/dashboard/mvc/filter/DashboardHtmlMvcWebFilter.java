package org.ifinalframework.cloud.dashboard.mvc.filter;

import org.springframework.util.StringUtils;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * DashboardHtmlMvcWebFilter.
 *
 * @author likly
 * @version 1.2.1
 * @since 1.2.1
 */
@WebFilter
public class DashboardHtmlMvcWebFilter implements javax.servlet.Filter {

    private static final String[] MODULES = new String[]{"devops"};

    @Override
    public void doFilter(final ServletRequest servletRequest, final ServletResponse servletResponse,
        final FilterChain filterChain)
        throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;

        String path = httpRequest.getRequestURI();

        for (final String module : MODULES) {

            if (path.contains("/" + module + "/") || path.endsWith("/" + module)) {

                path = StringUtils.trimTrailingCharacter(path, '/');

                httpRequest.getRequestDispatcher(path.endsWith(module) ? path + "/index.html" : path + ".html")
                    .forward(servletRequest, servletResponse);

            }
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

}
