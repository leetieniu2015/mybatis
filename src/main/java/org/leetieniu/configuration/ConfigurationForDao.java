package org.leetieniu.configuration;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.leetieniu.mybatis.mapper.UserMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationForDao {
	
	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		final BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://115.28.219.63/qdm160915374_db");
		dataSource.setUsername("qdm160915374");
		dataSource.setPassword("19910325");
		dataSource.setTestWhileIdle(true);
		dataSource.setMaxIdle(2);
		dataSource.setInitialSize(1);
		dataSource.setValidationQuery("select 1 from dual");
		return dataSource;
	}
	
	@Bean
	public org.apache.ibatis.session.Configuration mybatisConfiguration() {
		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		Environment environment = new Environment("dev", transactionFactory, dataSource());
		org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration(environment);
		configuration.addMapper(UserMapper.class);
		return configuration;
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory () {
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(mybatisConfiguration());
		return sqlSessionFactory;
	}
}
