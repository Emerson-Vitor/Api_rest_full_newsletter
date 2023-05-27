package edu.idp.newsletter.newsletter.service;

import edu.idp.newsletter.newsletter.models.UserModel;
import edu.idp.newsletter.newsletter.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserService {
    final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public Optional<UserModel> findByRa(Integer ra) {
        return userRepository.findByRa(ra);
    }

}
