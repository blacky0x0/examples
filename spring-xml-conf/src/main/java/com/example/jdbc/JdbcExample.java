package com.example.jdbc;

import com.example.entity.Book;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcExample {

    private BasicDataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource(BasicDataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    public Object getBook(int id) {
        String query = "select * from book where id = ?";
        return jdbcTemplateObject.queryForObject(query, new Object[]{id}, new BookMapper());
    }

    private static final class BookMapper implements RowMapper<Book> {

        public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
            Book book = new Book();
            book.setId(rs.getInt("id"));
            book.setTitle(rs.getString("title"));
            return book;
        }
    }
}
