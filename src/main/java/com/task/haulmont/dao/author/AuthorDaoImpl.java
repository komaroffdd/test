package com.task.haulmont.dao.author;

import com.task.haulmont.entity.Author;
import com.task.haulmont.mapper.AuthorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthorDaoImpl implements AuthorDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void save(Author author) {
        String sql = "INSERT INTO author (first_name, last_name, patronymic) VALUE (?,?,?)";
        jdbcTemplate.update(sql, author.getFirstName(), author.getLastName(), author.getPatronymic());
    }

    public List<Author> findAll() {
        String sql = "SELECT * FROM author";
        return jdbcTemplate.query(sql, new AuthorMapper());
    }

    public Author getById(Long id) {
        String sql = "SELECT * FROM author WHERE id=?";
        return jdbcTemplate.queryForObject(sql, new AuthorMapper(), id);
    }

    public void update(Author author) {
        String sql = "UPDATE author SET first_name = ?, last_name=?,patronymic=? WHERE id=?";
        jdbcTemplate.update(sql, author.getFirstName(), author.getLastName(), author.getPatronymic(), author.getId());
    }

    public void delete(Long id) {

        String sql = "DELETE FROM author where id=?";
        jdbcTemplate.update(sql, id);
    }
}
