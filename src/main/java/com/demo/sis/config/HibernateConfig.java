package com.demo.sis.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.cfg.Environment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
public class HibernateConfig {

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
		localSessionFactoryBean.setDataSource(dataSource());
		localSessionFactoryBean.setPackagesToScan("com.demo.sis");
		localSessionFactoryBean.setHibernateProperties(hibernateProperties());
		return localSessionFactoryBean;

	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource source = new DriverManagerDataSource();
		source.setDriverClassName("com.mysql.cj.jdbc.Driver");
		source.setUrl("jdbc:mysql://localhost:3306/sis-demo");
		source.setUsername("root");
		source.setPassword("Vinod@6891");
		return source;
	}

	private Properties hibernateProperties() {

		Properties prop = new Properties();
		prop.setProperty(Environment.HBM2DDL_AUTO, "update");
		prop.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
		prop.setProperty(Environment.SHOW_SQL, "true");
		prop.setProperty(Environment.FORMAT_SQL, "true");

		return prop;
	}

}
