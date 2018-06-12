package com.task.haulmont.mapper;

import com.task.haulmont.entity.Book;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper implements RowMapper<Book> {
    public Book mapRow(ResultSet resultSet, int i) throws SQLException {
        Book book = new Book();
        book.setId(resultSet.getLong("id"));
        book.setBookName(resultSet.getString("book_title"));
        book.setAuthor(resultSet.getInt("author_id"));
        book.setGenre_id( resultSet.getInt("genre_id"));
        book.setPublisher(resultSet.getString("publisher"));
        book.setYear(resultSet.getDate("year"));
        book.setCity(resultSet.getString("city"));

        return book;    }
}
