package ua.techtask.usersservice.domain.utill;

import ua.techtask.usersservice.domain.entity.User;

public interface PatchMapper<T> {

    T patch(T toPatch, T fromDb);
}
