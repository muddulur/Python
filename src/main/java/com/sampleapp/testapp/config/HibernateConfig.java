package com.sampleapp.testapp.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages={"com.sampleapp.model"})
@EnableTransactionManagement
public class HibernateConfig {
	private final static String DATABASE_URL="jdbc:h2:~/test";
	private final static String DATABASE_DRIVER = "org.h2.Driver";
	private final static String DATABASE_DIALECT = "org.hibernate.dialect.H2Dialect";
	private final static String DATABASE_USERNAME = "sa";
	private final static String DATABASE_PASSWORD = "";
	
	@Bean("DataSource")
	
	public DataSource getDataSource() {
		DriverManagerDataSource datasource=new DriverManagerDataSource();
		datasource.setUrl(DATABASE_URL);
		datasource.setDriverClassName(DATABASE_DRIVER);
		datasource.setUsername(DATABASE_USERNAME);
		datasource.setPassword(DATABASE_PASSWORD);
		
		return datasource;
		
	}

   @Bean

   public SessionFactory getSessionFactory() {
	   
	   LocalSessionFactoryBuilder builder=new LocalSessionFactoryBuilder(getDataSource());
	   Properties prop=new Properties();
	   prop.setProperty("hibernate.dialect",DATABASE_DIALECT);
	   prop.setProperty("hibernate.show_sql", "true");
	   prop.setProperty("hibernate.hbm2ddl.auto", "update");
	   builder.addProperties(prop);
	   builder.scanPackages("com.sampleapp.model");
	   
	   
	   
	return builder.buildSessionFactory();
	   
   }
   
   @Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
  }
}
