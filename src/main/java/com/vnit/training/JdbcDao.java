package com.vnit.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Repository
public class JdbcDao {

    DataSource dataSource;
    JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDatasource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    int getCount() {
        String qry = "select count(*) from Students";
        return jdbcTemplate.queryForObject(qry, Integer.class);
    }

    User getUserDetails(String name, String city) {
        String qry = "Select * from Students where name = ? or city = ?";

        return jdbcTemplate.queryForObject(qry, new Object[]{name, city}, new UserMapper());
    }

    void addNewData(User user) {
        String qry = "insert into students (name,city) values(?, ?)";
        jdbcTemplate.update(qry, new Object[]{user.getName(), user.getCity()});
    }

    List<User> getALlUserDetails() {
        String qry = "Select * from Students";

        return jdbcTemplate.query(qry, new UserMapper());
    }
}

class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int i) throws SQLException {
        User user = new User();
        user.setName(rs.getString("name"));
        user.setCity(rs.getString("city"));
        return user;
    }
}