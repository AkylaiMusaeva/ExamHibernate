package peaksoft.service;

import peaksoft.entity.User;

public interface UserService {
    String saveUser(User user);

    User findUserById(Long id);

    String deleteUserById(Long userId);
}
