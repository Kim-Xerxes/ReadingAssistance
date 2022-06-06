package com.demo.Service;

import com.demo.Entity.User;
import com.demo.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;

    public boolean existsByName(User user){
        return repository.existsByName(user.getName());
    }

    public User findUserByNameAndPassword(String name, String password){
        return repository.findUserByNameAndPassword(name, password);
    }

    public Iterable<User> findAll(){
        return repository.findAll();
    }

    public boolean insert(User user){
        repository.save(user);
        return true;
    }

    public boolean update(User user){
        if(repository.findById(user.getUid()).isEmpty()){
            return false;
        }
        repository.save(user);
        return true;
    }

    public boolean deleteByName(String name){
        if(!repository.existsByName(name)){
            return false;
        }
        repository.deleteByName(name);
        return true;
    }
}
