package cn.phil.service.user;

import cn.phil.model.user.User;
import cn.phil.repo.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User getUserById(Long id) {
        Optional<User> userData = userRepository.findById(id);
        return userData.orElse(null);
    }
    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
