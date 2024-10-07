package edu.oregonstate.engr.classwork.backend.model;

/*
 * Description: Model layer that is dedicated to handling database interactions.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class DiagnosticRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DiagnosticRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void dropTable() {
        jdbcTemplate.execute("DROP TABLE IF EXISTS diagnostic");
    }

    public void createTable() {
        jdbcTemplate.execute("""
            CREATE TABLE diagnostic (
                id INT PRIMARY KEY AUTO_INCREMENT,
                text VARCHAR(255) NOT NULL
            );
        """);
    }

    public void insertData() {
        jdbcTemplate.execute("INSERT INTO diagnostic (text) VALUES ('MySQL is working for bertotts!')");
    }

    public List<Map<String, Object>> fetchData() {
        return jdbcTemplate.queryForList("SELECT * FROM diagnostic");
    }
}

