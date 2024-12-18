package org.telran.shop.de.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.telran.shop.de.entity.User;
import org.telran.shop.de.exception.UserNotFoundException;
import org.telran.shop.de.repository.UserJpaRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

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
        log.debug("User {}", userEntity);
        return userEntity;
    }

    @Override
    public User getByName(String name) {
        log.info("Method start");
        return jpaRepository.findByLogin(name);
    }

    @Override
    public List<User> getWithEqualsPasswords(String password) {
        return jpaRepository.findAllByPassword(password);
    }

    /**
     *
     * @param id
     */
    @Override
    public void delete(Long id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public String getCurrentUserName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            return authentication.getName();
        }
        return null;
    }

    @Override
    public Long getCurrentUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            String name = authentication.getName();
            User userEntity = getByName(name);
            return userEntity.getId();
        }
        return null;
    }
}
