package com.example.ShdlMeet.service;

import com.example.ShdlMeet.Repo.MeetingRepo;
import com.example.ShdlMeet.Repo.UserInfoRepo;
import com.example.ShdlMeet.entity.Meeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MeetingService {

    @Autowired
    MeetingRepo meetingRepo;

    @Autowired
    UserInfoRepo userInfoRepo;

    public void setMeeting(Meeting meeting)
    {

        meetingRepo.save(meeting);
    }
}
