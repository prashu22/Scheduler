package com.example.ShdlMeet.Repo;

import com.example.ShdlMeet.entity.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


public interface UserInfoRepo extends MongoRepository<Users,String> {

    Users findByEmailAndPassword(String email, String password);

    @Query(value="{ eID : ?0}", fields="{ timings : 1 }")
    Users findByEID(Integer eid);

    void deleteByEID(Integer s);

}
