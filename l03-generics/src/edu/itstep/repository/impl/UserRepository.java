package edu.itstep.repository.impl;

import edu.itstep.model.user.User;
import edu.itstep.repository.JpaRepository;

import java.util.List;

public class UserRepository implements JpaRepository<Integer, User> {
    @Override
    public User findById(Integer integer) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User save(User user) {
        return null;
    }
}
