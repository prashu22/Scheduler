package com.example.ShdlMeet.controller;

import com.example.ShdlMeet.entity.Meeting;
import com.example.ShdlMeet.entity.Timing;
import com.example.ShdlMeet.service.MeetingService;
import com.example.ShdlMeet.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.Console;
import java.io.IOException;
import java.text.ParseException;

@Controller
@RequestMapping
public class CalenderController {

    @Autowired
    MeetingService meetingService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/set_meeting", method = RequestMethod.POST)
    public String setMetting(@RequestBody Meeting meeting) throws ParseException, IOException {
        System.out.println("Entered");
        try {
            meetingService.setMeeting(meeting);
            return "Successfully added persons";
        } catch (Exception ex) {
            return "Error";
        }
    }
//    @RequestMapping(value = "", method=RequestMethod.POST)
//    public String dateTrigger(@RequestBody Timing timing, List<Integer> members )
//    {
//
//    }

    @RequestMapping(value="/check")
    public boolean checkAvalibility(@RequestBody Timing timing, String email)
    {
        return userService.isAvailable(email,timing);
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