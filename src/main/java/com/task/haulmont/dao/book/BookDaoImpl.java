package com.task.haulmont.dao.book;

import com.task.haulmont.entity.Author;
import com.task.haulmont.entity.Book;
import com.task.haulmont.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

//    public List<Book> findAll() {
//        String sql = "SELECT book.book_title,author.first_name,author.last_name," +
//                "author.patronymic," +
//                "book.publisher,book.year,book.city " +
//                "FROM book INNER JOIN author on book.author_id=author.id";
//        return jdbcTemplate.query(sql, new BookMapper());
//    }

    public void save(Book book) {
        String sql = "INSERT INTO book (book_title, author_id, genre_id, publisher, year, city) VALUE (?,?,?,?,?,?)";
        jdbcTemplate.update(sql, book.getBookName(), book.getAuthor(), book.getGenre_id(),
                book.getPublisher(), book.getYear(), book.getCity());
    }

    public List<Book> findAll() {
        String sql = "SELECT * FROM book";
        return jdbcTemplate.query(sql,new BookMapper());
    }

    public List<Book> findBookByAuthor(Author author) {
        String sql = "SELECT book.book_title,book.author_id,book.genre_id, book.publisher,book.year,book.city " +
                "FROM book INNER JOIN author on book.author_id=author.id " +
                "WHERE author.id= ?";
        return jdbcTemplate.query(sql, new BookMapper(), author.getId());
    }

    public List<Book> findBookByName(String bookName) {
        String sql = "SELECT book.book_title,author.first_name,author.last_name," +
                "author.patronymic," +
                "book.publisher,book.year,book.city " +
                "FROM book INNER JOIN author on book.author_id=author.id " +
                "WHERE book.book_title=?";
        return jdbcTemplate.query(sql, new BookMapper(), bookName);
    }

    public List<Book> findBookByPublisher(String publisher) {
        String sql = "SELECT book.book_title,author.first_name,author.last_name," +
                "author.patronymic," +
                "book.publisher,book.year,book.city " +
                "FROM book INNER JOIN author on book.author_id=author.id " +
                "WHERE book.publisher=?";
        return jdbcTemplate.query(sql, new BookMapper(), publisher);
    }

    public void update(Book book) {
        String sql = "UPDATE book SET book_title = ?, author_id=?,genre_id=?, publisher=?,year=?,city=? WHERE id =?";
        jdbcTemplate.update(sql,book.getBookName(),book.getAuthor(),book.getGenre_id(),
                book.getPublisher(),book.getYear(),book.getCity(),book.getId());
    }

    public void delete(Long id) {
        String sql = "DELETE FROM book where id=?";
        jdbcTemplate.update(sql, id);
    }

    public Book getById(Long id) {
        String sql = "SELECT * FROM book WHERE id=?";
        return jdbcTemplate.queryForObject(sql, new BookMapper(), id);
    }
}