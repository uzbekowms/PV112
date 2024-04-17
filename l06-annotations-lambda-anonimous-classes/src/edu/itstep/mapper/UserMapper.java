package edu.itstep.mapper;

import edu.itstep.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.function.Function;

public class UserMapper implements Function<ResultSet, User> {
    @Override
    public User apply(ResultSet resultSet) {
        try {
            return new User(resultSet.getString("name"), resultSet.getInt("age"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
