package com.example.ShdlMeet.service;

import com.example.ShdlMeet.Repo.UserInfoRepo;
import com.example.ShdlMeet.entity.Timing;
import com.example.ShdlMeet.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserInfoRepo userInfo;

    public boolean register(Users user)
    {
        userInfo.insert(user);
        return true;
    }
    public Users login(String email, String password)
    {

        return userInfo.findByEmailAndPassword(email,password);
    }
    public boolean isAvailable(Integer eid,Timing curr_timing)
    {
        Users users = userInfo.findByEID(eid);
        List<Timing> timings=users.getTimings();
        boolean available=true;
        for(int i=0;i<timings.size();i++)
        {
            if(curr_timing.getStDate().after(timings.get(i).getEdDate()) || curr_timing.getEdDate().before(timings.get(i).getStDate()))
            {
                available=false;
            }
        }
        return available;
    }

}
