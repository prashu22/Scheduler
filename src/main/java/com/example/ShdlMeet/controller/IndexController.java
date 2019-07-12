package com.example.ShdlMeet.controller;

import com.example.ShdlMeet.entity.Meeting;
import com.example.ShdlMeet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping
public class IndexController {

    @Autowired
    UserService userService;


    @RequestMapping(value = "/fillCalender", method = RequestMethod.POST)
    @ResponseBody
    public List<Integer> fillCalender(@RequestParam("email") String email,@RequestParam("month") Integer month,@RequestParam("year") Integer year) {
        return userService.getDates(email,month,year);
    }
    @RequestMapping(value = "/getMeeting", method = RequestMethod.POST)
    @ResponseBody
    public List<Meeting> getMeetings(@RequestParam("email") String email) {
        return userService.meetings(email);
    }

}