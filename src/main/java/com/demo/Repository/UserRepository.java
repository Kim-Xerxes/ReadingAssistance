package com.demo.Repository;

import com.demo.Entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
    boolean existsByUid(Integer uid);
    boolean existsByName(String name);

    //@Query("select u from User u where u.name = ?1")
    User findUserByNameAndPassword(String name, String password);

    void deleteByName(String name);
}
