
package com.bm.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.bm.spring.converter.BookAuthorToAuthor;
import com.bm.spring.converter.StringsToBookCategorySet;
import com.bm.spring.converter.StringToBookCategorySet;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.bm.spring.controller" })
public class WebMvcConfig implements WebMvcConfigurer {

	@Override
	public void addFormatters(FormatterRegistry registry) {

		registry.addConverter(_bookAuthorToAuthor);
		registry.addConverter(_stringsToBookCategorySet);
		registry.addConverter(_stringToBookCategorySet);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Bean
	public MessageSource messageSource() {

		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}

	@Bean
	public InternalResourceViewResolver resolver() {

		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	@Autowired
	private BookAuthorToAuthor _bookAuthorToAuthor;

	@Autowired
	private StringsToBookCategorySet _stringsToBookCategorySet;
	
	@Autowired
	private StringToBookCategorySet _stringToBookCategorySet;
}