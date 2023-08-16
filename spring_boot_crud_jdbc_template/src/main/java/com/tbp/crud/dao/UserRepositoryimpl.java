package com.tbp.crud.dao;

import com.tbp.crud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;

@Repository
public class UserRepositoryimpl implements   UserRepository{

    private final static String INSERT_USER_QUERY="INSERT INTO USER(id,first_name,last_name,age,email_ID) values(?,?,?,?,?)";
    private final static String UPDATE_USER_BY_ID_QUERY="UPDATE USER SET first_name=?, email_ID=? WHERE ID=?";

    private final static String GET_USER_BY_ID_QUERY="SELECT * FROM USER WHERE ID=?";

    private final static String DELETE_USER_BY_ID_QUERY="DELETE FROM USER WHERE ID=?";

    private final static String GET_USERS_QUERY="SELECT * FROM USER";
    @Autowired
     private JdbcTemplate jdbcTemplate;

    @Override
    public User saveUser(User user) {
        jdbcTemplate.update(INSERT_USER_QUERY,user.getId(),user.getFirst_name(),user.getLast_name(),user.getAge(),user.getEmail_ID());
        return user;
    }

    @Override
    public User updateUser(User user) {
        jdbcTemplate.update(UPDATE_USER_BY_ID_QUERY,user.getFirst_name(),user.getEmail_ID(),user.getId());
        return user;
    }

    @Override
    public User getById(int id) {
       return  jdbcTemplate.queryForObject(GET_USER_BY_ID_QUERY, (rs, rowNum) -> {
            return new User(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"), rs.getInt("age"), rs.getString("email_ID"));
        },id);
    }

    @Override
    public String deleteById(int id) {
        jdbcTemplate.update(DELETE_USER_BY_ID_QUERY,id );
        return "User got deleted with id "+id;
    }

    @Override
    public List<User> allUsers() {
        return jdbcTemplate.query(GET_USERS_QUERY,(rs, rowNum) -> {
            return new User(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"), rs.getInt("age"), rs.getString("email_ID"));
        });
    }
}

