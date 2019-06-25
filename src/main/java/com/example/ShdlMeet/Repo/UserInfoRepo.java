package com.example.ShdlMeet.Repo;

import com.example.ShdlMeet.entity.Users;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserInfoRepo extends MongoRepository<Users,String> {

    Users findByEmailAndPassword(String email, String password);

    Users findBy_id(ObjectId id);

}
