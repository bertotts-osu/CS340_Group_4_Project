package edu.oregonstate.engr.classwork.backend.context;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration  // informs Spring there are beans to build and manage
@ComponentScan("edu.oregonstate.engr.classwork.backend") //tells Spring to scan all files in the project root
public class DatabaseConfiguration {

    @Bean
    public DataSource createDataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl("jdbc:mysql://classmysql.engr.oregonstate.edu:3306/cs340_bertotts");
        dataSource.setUsername("cs340_bertotts");
        dataSource.setPassword("3935");
        dataSource.setConnectionTimeout(30000); // 30 seconds
        dataSource.setIdleTimeout(600000); // 10 minutes
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
