package org.telran.shop.de.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telran.shop.de.entity.User;
import org.telran.shop.de.exception.UserNotFoundException;
import org.telran.shop.de.repository.UserJpaRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserJpaRepository jpaRepository;

    @Override
    public List<User> getAll() {
        return jpaRepository.findAll();
    }

    @Override
    public User getById(Long id) {
        return jpaRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User with id " + id + " not found"));
    }

    @Override
    public User create(User user) {
        User userEntity = jpaRepository.save(user);
        return userEntity;
    }

    @Override
    public User getByName(String name) {
        return jpaRepository.findByLogin(name);
    }

    @Override
    public List<User> getWithEqualsPasswords(String password) {
        return jpaRepository.findAllByPassword(password);
    }

    @Override
    public void delete(Long id) {
        jpaRepository.deleteById(id);
    }
}
