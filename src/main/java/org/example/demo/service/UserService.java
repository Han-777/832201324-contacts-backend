package org.example.demo.service;

import org.example.demo.pojo.User;
import org.example.demo.pojo.dto.UserDto;
import org.example.demo.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // spring bean
public class UserService implements IUserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User add(UserDto user) {

        User userPojo = new User();
        BeanUtils.copyProperties(user, userPojo);
        // 调用数据访问类的方法
        return userRepository.save(userPojo);
    }

    @Override
    public User get(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("用户不存在，参数异常"));

    }

    @Override
    public User edit(UserDto user) {

        User userPojo = new User();
        BeanUtils.copyProperties(user, userPojo);
        return userRepository.save(userPojo);
    }

    @Override
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getAll() {
        return (List<User>) userRepository.findAll();
    }

}
