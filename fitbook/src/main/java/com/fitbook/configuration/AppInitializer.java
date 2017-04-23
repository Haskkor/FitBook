package com.fitbook.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	/**
	 * Returns root config classes
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { AppConfig.class };
	}

	/**
	 * Returns servlet config classes
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	/**
	 * Returns servlet mappings
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}
