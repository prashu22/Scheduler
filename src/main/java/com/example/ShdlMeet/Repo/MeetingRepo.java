package com.example.ShdlMeet.Repo;

import com.example.ShdlMeet.entity.Meetings;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MeetingRepo extends MongoRepository<Meetings, String> {


}
