package bg.softuni.workshop.service;

import bg.softuni.workshop.models.users.User;
import bg.softuni.workshop.models.users.LoginDTO;
import bg.softuni.workshop.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> login(LoginDTO loginDTO) {
        return this.userRepository
             .findByUsernameAndPassword(loginDTO.getUsername(), loginDTO.getPassword());

        // check password if hashed
        // marked user as logged if data is correct
    }

}
