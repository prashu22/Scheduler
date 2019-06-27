package com.example.ShdlMeet.controller;

import com.example.ShdlMeet.entity.Meeting;
import com.example.ShdlMeet.entity.Timing;
import com.example.ShdlMeet.service.MeetingService;
import com.example.ShdlMeet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    @ResponseBody
    public String setMetting(@RequestBody Meeting meeting) throws ParseException, IOException {
        System.out.println("Entered");
        try {
            meetingService.setMeeting(meeting);
            userService.updateMeetings(meeting);
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

    @RequestMapping(value="/check/{email}",method = RequestMethod.POST)
    @ResponseBody
    public  boolean checkAvalibility(@RequestBody Timing timing, @PathVariable("email") String email)
    {
        //System.out.println(email);
        return userService.isAvailable(email,timing);
    }

    @GetMapping(value = "/addmeeting")
    public String add_meeting() {
        return "addmeeting";
    }
    @PostMapping(value = "/addmeeting")
    public String addmeeting(Model model) {
        return "index.html";
    }
}