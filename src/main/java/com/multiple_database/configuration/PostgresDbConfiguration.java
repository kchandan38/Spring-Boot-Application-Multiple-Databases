package com.multiple_database.configuration;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		entityManagerFactoryRef = "postgresEntityManagerFactory",
		transactionManagerRef = "postgresTransactionManager",
		basePackages = {
		"com.multiple_database.service.postgres"})
public class PostgresDbConfiguration {

	@Bean(name = "postgresDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.postgres")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "postgresEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean postgresEntityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("postgresDataSource") DataSource dataSource) {
		return builder.dataSource(dataSource)
				.packages("com.multiple_database.entity.salary")
				.persistenceUnit("Salary")
				.build();
	}

	@Bean(name = "postgresTransactionManager")
	public PlatformTransactionManager postgresTransactionManager(
			@Qualifier("postgresEntityManagerFactory") EntityManagerFactory postgresEntityManagerFactory) {
		return new JpaTransactionManager(postgresEntityManagerFactory);
	}
}