package com.example.ShdlMeet.service;

import com.example.ShdlMeet.Repo.MeetingRepo;
import com.example.ShdlMeet.Repo.UserInfoRepo;
import com.example.ShdlMeet.entity.Meeting;
import com.example.ShdlMeet.entity.Timing;
import com.example.ShdlMeet.entity.Users;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserInfoRepo userInfo;

    @Autowired
    MeetingRepo meetingRepo;
    public boolean register(Users user)
    {
        userInfo.insert(user);
        return true;
    }

    public Users login(String email, String password)
    {
        return userInfo.findByEmailAndPassword(email,password);
    }

    public boolean isAvailable(String email, Timing curr_timing)
    {
        Users users = userInfo.findByEmail(email);
        List<ObjectId> meetings=users.getMeetings();
        boolean available=true;
        for(int i=0;i<meetings.size();i++)
        {
            Meeting meeting=meetingRepo.findBy_id(meetings.get(i));
            if(curr_timing.getStDate().after(meeting.getTiming().getEdDate()) || curr_timing.getEdDate().before(meeting.getTiming().getStDate()))
            {
                available=false;
            }
        }
        return available;
    }

    void updateMeetings(Meeting meeting)
    {
        List<String> member=meeting.getMembers();
        for(int i=0;i<member.size();i++)
        {
            Users user=userInfo.findByEmail(member.get(i));
            user.getMeetings().add(meeting.get_id());
            userInfo.save(user);
        }
    }

}
