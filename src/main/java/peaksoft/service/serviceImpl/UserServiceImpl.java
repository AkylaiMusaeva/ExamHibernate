package peaksoft.service.serviceImpl;

import peaksoft.entity.User;
import peaksoft.repository.UserRepo;
import peaksoft.repository.repoImpl.UserRepoImpl;
import peaksoft.service.UserService;

public class UserServiceImpl implements UserService {
    UserRepo userRepo=new UserRepoImpl();
    @Override
    public String saveUser(User user) {
        userRepo.saveUser(user);
        return user.getUsername()+" is successfully saved!";
    }

    @Override
    public User findUserById(Long id) {
        return userRepo.findUserById(id);
    }

    @Override
    public String deleteUserById(Long userId) {
        userRepo.deleteUserById(userId);
        return "User with id = "+userId+" is successfully deleted!";
    }
}
