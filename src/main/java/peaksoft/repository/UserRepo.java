package peaksoft.repository;

import peaksoft.entity.User;

public interface UserRepo {
    void saveUser(User user);

    User findUserById(Long id);

    void deleteUserById(Long userId);
}
