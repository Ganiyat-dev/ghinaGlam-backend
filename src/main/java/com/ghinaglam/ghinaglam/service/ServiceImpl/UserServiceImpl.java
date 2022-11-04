package com.ghinaglam.ghinaglam.service.ServiceImpl;

import com.ghinaglam.ghinaglam.model.User;
import com.ghinaglam.ghinaglam.repository.UserRepository;
import com.ghinaglam.ghinaglam.service.UserService;
import lombok.RequiredArgsConstructor;;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User createUser(User user) {
        Optional<User> userOptional = userRepository.findByEmail(user.getEmail());
        if (userOptional.isPresent()) {
            throw new IllegalStateException("Email Already Exist");
        }
        System.out.println(user);
        return userRepository.save(user);
    }
    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }


    @Override
    public Optional<User> getUser(String email) {
        Optional<User> userOptional = userRepository.findByEmail(email);

        if (userOptional.isPresent()) {
            return userOptional;
        }
        throw new IllegalStateException("User not found!");
    }

    @Override
    public void deleteUser(String email){

    }
}
