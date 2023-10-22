package com.example.mogoDB.repository;

import com.example.mogoDB.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMongoRepository extends MongoRepository<User, String> {
    @Query("{'name':?0}")
    List<User> findByName(String name);
}
