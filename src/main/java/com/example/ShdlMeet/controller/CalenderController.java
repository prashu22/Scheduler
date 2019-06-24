package com.example.ShdlMeet.controller;

import com.example.ShdlMeet.entity.Meetings;
import com.example.ShdlMeet.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/Calender")
public class CalenderController {

    @Autowired
    MeetingService meetingService;

    @RequestMapping(value = "/set_meeting", method = RequestMethod.POST)
    public String setMetting(@RequestBody Meetings meeting) {
        meetingService.setMeeting(meeting);

        return "hello";
    }
//    @RequestMapping(value = "", method=RequestMethod.POST)
//    public String dateTrigger(@RequestBody Meetings meetings)
//    {
//
//    }


}