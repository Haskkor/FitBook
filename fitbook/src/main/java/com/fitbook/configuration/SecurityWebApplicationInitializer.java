package com.fitbook.configuration;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * Spring security for the war. Automatically register the
 * springSecurityFilterChain Filter for every URL in your application. Add a
 * ContextLoaderListener that loads the SecurityConfig
 */
public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {
}
