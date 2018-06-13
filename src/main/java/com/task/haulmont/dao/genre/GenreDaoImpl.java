package com.task.haulmont.dao.genre;

import com.task.haulmont.entity.Genre;
import com.task.haulmont.mapper.GenreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GenreDaoImpl implements GenreDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Genre> findAll() {
        String sql = "SELECT * FROM genre";
        return jdbcTemplate.query(sql, new GenreMapper());
    }

//    public Integer countBook(Genre genre) {
//
//        String sql = "SELECT count(book.genre_id) FROM book where id = (SELECT id FROM genre);
//        return jdbcTemplate.query(sql, new GenreMapper());
//    }

    public void save(Genre genre) {
        String sql = "INSERT INTO genre (genre) VALUE (?)";
        jdbcTemplate.update(sql, genre.getGenre());
    }

    public void update(Genre genre) {
        String sql = "UPDATE genre SET genre = ? WHERE id =?";
        jdbcTemplate.update(sql, genre.getGenre(), genre.getId());
    }

    public void delete(Long id) {
        String sql = "DELETE FROM genre where id=?";
        jdbcTemplate.update(sql, id);
    }

    public Genre getById(Long id) {
        String sql = "SELECT * FROM book WHERE id=?";
        return jdbcTemplate.queryForObject(sql,new GenreMapper(),id);
    }
}
