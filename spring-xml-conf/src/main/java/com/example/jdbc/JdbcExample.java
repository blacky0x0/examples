package com.example.jdbc;

import com.example.entity.Author;
import com.example.entity.Book;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcExample {

    private BasicDataSource mysqlDataSource;
    private JdbcTemplate jdbcMysqlTemplate;
    private BasicDataSource postgresDataSource;
    private JdbcTemplate jdbcPostgresTemplate;

    public void setMysqlDataSource(BasicDataSource mysqlDataSource) {
        this.mysqlDataSource = mysqlDataSource;
        this.jdbcMysqlTemplate = new JdbcTemplate(mysqlDataSource);
    }

    public void setPostgresDataSource(BasicDataSource postgresDataSource) {
        this.postgresDataSource = postgresDataSource;
        this.jdbcPostgresTemplate = new JdbcTemplate(postgresDataSource);
    }

    public Object getBook(int id) {
        String query = "select * from book where id = ?";
        return jdbcMysqlTemplate.queryForObject(query, new Object[]{id}, new BookMapper());
    }

    public Object getAuthor(int id) {
        String query = "select * from author where id = ?";
        return jdbcPostgresTemplate.queryForObject(query, new Object[]{id}, new AuthorMapper());
    }


    private static final class BookMapper implements RowMapper<Book> {

        public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
            Book book = new Book();
            book.setId(rs.getInt("id"));
            book.setTitle(rs.getString("title"));
            return book;
        }
    }

    private static final class AuthorMapper implements RowMapper<Author> {

        public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
            Author author = new Author();
            author.setId(rs.getInt("id"));
            author.setName(rs.getString("name"));
            return author;
        }
    }
}
