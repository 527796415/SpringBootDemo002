package com.offcn.service.impl;

import com.offcn.dao.UserRepository;
import com.offcn.entity.User;
import com.offcn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;


    @Override
    public List<User> getUserList() {
        return repository.findAll();
    }

    //增加一条对象
    @Override
    public void createUser(User user) {
        repository.save(user);
    }
     //根据ID查询一条对象
    @Override
    public User getUser(Long id) {
        return repository.getOne(id);
    }

    //根据ID修改一条对象
    @Override
    public void updateUser(Long id, User user) {
        user.setId(id);
     repository.saveAndFlush(user);
    }

    //根据ID删除一条对象
    @Override
    public void deleteUser(Long id) {
        repository.deleteById(id);
    }
}
