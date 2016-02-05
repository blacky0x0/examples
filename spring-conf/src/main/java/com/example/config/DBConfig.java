package com.example.config;

import com.example.jdbc.JdbcExample;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:jdbc.properties")
public class DBConfig {

    @Value("${jdbc.mysql.driverClassName}")
    private String mysqlDriverClassName;
    @Value("${jdbc.mysql.url}")
    private String mysqlUrl;
    @Value("${jdbc.mysql.username}")
    private String mysqlUsername;
    @Value("${jdbc.mysql.password}")
    private String mysqlPassword;

    @Value("${jdbc.postgres.driverClassName}")
    private String postgresDriverClassName;
    @Value("${jdbc.postgres.url}")
    private String postgresUrl;
    @Value("${jdbc.postgres.username}")
    private String postgresUsername;
    @Value("${jdbc.postgres.password}")
    private String postgresPassword;

    @Bean(name = "mysqlDataSource")
    public DataSource mysqlDataSource() {
        BasicDataSource dataSource = new BasicDataSource();

        dataSource.addConnectionProperty("useUnicode", "true");
        dataSource.addConnectionProperty("characterEncoding", "UTF-8");
        dataSource.setDriverClassName(mysqlDriverClassName);
        dataSource.setUrl(mysqlUrl);
        dataSource.setUsername(mysqlUsername);
        dataSource.setPassword(mysqlPassword);
        dataSource.setDefaultAutoCommit(false);

        return dataSource;
    }

    @Bean(name = "postgresDataSource")
    public DataSource postgresDataSource() {
        BasicDataSource dataSource = new BasicDataSource();

        dataSource.addConnectionProperty("useUnicode", "true");
        dataSource.addConnectionProperty("characterEncoding", "UTF-8");
        dataSource.setDriverClassName(postgresDriverClassName);
        dataSource.setUrl(postgresUrl);
        dataSource.setUsername(postgresUsername);
        dataSource.setPassword(postgresPassword);
        dataSource.setDefaultAutoCommit(false);

        return dataSource;
    }

    @Bean
    public JdbcExample jdbcExample() {
        JdbcExample jdbcExample = new JdbcExample();

        jdbcExample.setMysqlDataSource(mysqlDataSource());
        jdbcExample.setPostgresDataSource(postgresDataSource());

        return jdbcExample;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer getPropertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
