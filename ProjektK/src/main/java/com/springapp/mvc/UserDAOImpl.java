package com.springapp.mvc;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by darsonss on 2015-01-03.
 */
public class UserDAOImpl implements UserDAO {

    private JdbcTemplate jdbcTemplate;
    public UserDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void saveOrUpdate(User user) {
        if (user.getId() != null) {
            // update
            String sql = "UPDATE user SET imie=?, nazwisko=?, email=?, parafia=?, wiek=?, haslo=? WHERE id=?";
            jdbcTemplate.update(sql, user.getImie(), user.getNazwisko(),
                    user.getEmail(), user.getParafia(), user.getWiek(), user.getHaslo());
        } else {
            // insert
            String sql = "INSERT INTO user (imie, nazwisko, email, parafia, wiek, haslo)"
                    + " VALUES (?, ?, ?, ?, ?, ?)";
            jdbcTemplate.update(sql, user.getImie(), user.getNazwisko(),
                    user.getEmail(), user.getParafia(), user.getWiek(), user.getHaslo());
        }
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM user WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public User get(Long id) {
        String sql = "SELECT * FROM users WHERE id=" + id;
        return jdbcTemplate.query(sql, new ResultSetExtractor<User>() {

            @Override
            public User extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                if (rs.next()) {
                    User user = new User();
                    user.setId(rs.getLong("id"));
                   // user.setFirstName(rs.getString("firstname"));
                   // user.setLastName(rs.getString("lastname"));
                    user.setEmail(rs.getString("email"));
                    return user;
                }

                return null;
            }

        });
    }

    @Override
    public List<User> list() {
        String sql = "SELECT * FROM user";
        List<User> listUsers= jdbcTemplate.query(sql, new RowMapper<User>() {

            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User aUser = new User();

                aUser.setId(rs.getLong("id"));
                aUser.setImie(rs.getString("imie"));
                aUser.setNazwisko(rs.getString("nazwisko"));
                aUser.setEmail(rs.getString("email"));
                aUser.setParafia(rs.getString("parafia"));
                aUser.setWiek(rs.getInt("wiek"));

                return aUser;
            }

        });

        return listUsers;
    }
}
