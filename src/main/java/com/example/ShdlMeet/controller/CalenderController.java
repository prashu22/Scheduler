package com.example.ShdlMeet.controller;

import com.example.ShdlMeet.entity.LoginCredential;
import com.example.ShdlMeet.entity.Meeting;
import com.example.ShdlMeet.entity.Timing;
import com.example.ShdlMeet.entity.Users;
import com.example.ShdlMeet.service.MeetingService;
import com.example.ShdlMeet.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping
public class CalenderController {

    @Autowired
    MeetingService meetingService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/set_meeting", method = RequestMethod.POST)
    public String setMetting(@RequestBody Meeting meeting) {
        meetingService.setMeeting(meeting);
        return "hello";
    }
//    @RequestMapping(value = "", method=RequestMethod.POST)
//    public String dateTrigger(@RequestBody Timing timing, List<Integer> members )
//    {
//
//    }

    @RequestMapping(value="/check")
    public boolean checkAvalibility(@RequestBody Timing timing, ObjectId eID)
    {
        return userService.isAvailable(eID,timing);
    }

    @GetMapping(value = "/addmeeting")
    public String add_meeting() {
        return "addmeeting.html";
    }
    @PostMapping(value = "/addmeeting")
    public String addmeeting(Model model) {
        return "index.html";
    }
}