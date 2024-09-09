package com.example.Hotel_Reservation_System.Service;

import com.example.Hotel_Reservation_System.Entity.User;
import com.example.Hotel_Reservation_System.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Optional;
@ResponseStatus(value = HttpStatus.NOT_FOUND)


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User updateUser(Long id, User updatedUser) {
        return userRepository.findById(id).map(user -> {
            user.setName(updatedUser.getName());

            user.setAddress(updatedUser.getAddress());
            user.setContactNo(updatedUser.getContactNo());
            user.setEmail(updatedUser.getEmail());
            user.setUserName(updatedUser.getUserName());
            user.setPassword(updatedUser.getPassword());
            return userRepository.save(user);
        }).orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User authenticate(String userName, String password) {
        Optional<User> user = userRepository.findByUserName(userName);
        if (user.isPresent() && user.get().getPassword().equals(password)) {
            return user.get();
        }
        throw new IllegalArgumentException("Invalid username or password");
    }
}

