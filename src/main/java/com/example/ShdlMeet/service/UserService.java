package com.example.ShdlMeet.service;

import com.example.ShdlMeet.Repo.MeetingRepo;
import com.example.ShdlMeet.Repo.UserInfoRepo;
import com.example.ShdlMeet.entity.Meeting;
import com.example.ShdlMeet.entity.Timing;
import com.example.ShdlMeet.entity.Users;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        if(users==null)
            return false;
        List<ObjectId> meetings=users.getMeetings();
        if(meetings==null)
        {
            return true;
        }
        boolean available=false;
        for(int i=0;i<meetings.size();i++)
        {
            Meeting meeting=meetingRepo.findBy_id(meetings.get(i));
            if(curr_timing.getStDate().after(meeting.getTiming().getEdDate()) || curr_timing.getEdDate().before(meeting.getTiming().getStDate()))
            {
                available=true;
            }
        }
        return available;
    }

    public void updateMeetings(Meeting meeting)
    {
        List<String> member=meeting.getMembers();
        ObjectId id=meeting.get_id();
        System.out.println(member.size());
        for(int i=0;i<member.size();i++)
        {
            Users user=userInfo.findByEmail(member.get(i));
            System.out.println("s="+user.getName());
            List<ObjectId> meetings=user.getMeetings();
            if(meetings==null) {
                meetings=new ArrayList<>();
            }
            meetings.add(id);
            user.setMeetings(meetings);
            System.out.println(user.getMeetings().size());
            userInfo.save(user);
        }
    }

}
