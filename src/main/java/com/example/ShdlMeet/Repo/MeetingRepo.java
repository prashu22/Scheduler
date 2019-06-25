package com.example.ShdlMeet.Repo;

import com.example.ShdlMeet.entity.Meeting;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface MeetingRepo extends MongoRepository<Meeting, String> {

    Meeting findBy_id(ObjectId id);

}
