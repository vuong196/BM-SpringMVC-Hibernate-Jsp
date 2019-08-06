
package com.bm.spring.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource("classpath:database.properties")
@EnableTransactionManagement
@ComponentScan(basePackages = { "com.bm.spring" })
public class AppContext {

	@Bean
	public DataSource dataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(_environment.getRequiredProperty("jdbc.driverClassName"));
		dataSource.setUrl(_environment.getRequiredProperty("jdbc.url"));
		dataSource.setUsername(_environment.getRequiredProperty("jdbc.username"));
		dataSource.setPassword(_environment.getRequiredProperty("jdbc.password"));
		return dataSource;
	}

	@Bean
	public HibernateTransactionManager getTransactionManager() {

		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		return transactionManager;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {

		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(new String[] { "com.bm.spring.entity" });
		sessionFactory.setHibernateProperties(_hibernateProperties());
		return sessionFactory;
	}

	@Autowired
	private Environment _environment;

	private Properties _hibernateProperties() {

		Properties properties = new Properties();
		properties.put("hibernate.dialect", _environment.getRequiredProperty("hibernate.dialect"));
		properties.put("hibernate.show_sql", _environment.getRequiredProperty("hibernate.show_sql"));
		properties.put("hibernate.format_sql", _environment.getRequiredProperty("hibernate.format_sql"));
		properties.put("hibernate.hbm2ddl.auto", _environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
		return properties;
	}
}
