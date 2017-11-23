package maxb.facedating.service.impl;

import maxb.facedating.dao.UserRepository;
import maxb.facedating.dao.UserRolesRepository;
import maxb.facedating.domain.User;
import maxb.facedating.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by MaxB on 07/11/2017.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private static final int PAGE_SIZE = 10;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserRolesRepository rolesRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(rolesRepository.findAll()));
        userRepository.save(user);
    }

    @Override
    public User update(User user){
        return userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findByUserId(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public List<User> listUsers() {
        return userRepository.findAll();
    }

    public Page<User> getUser(Integer pageNumber) {
        PageRequest request = new PageRequest(pageNumber - 1, PAGE_SIZE);
        return userRepository.findAll(request);
    }
}
