package com.example.ShdlMeet.entity;

import org.bson.types.ObjectId;

import java.util.Date;

public class Timing {
    private Date stDate;
    private Date edDate;

    public Timing(Date stDate, Date edDate) {
        this.stDate = stDate;
        this.edDate = edDate;
    }

    public Date getStDate() {
        return stDate;
    }

    public void setStDate(Date stDate) {
        this.stDate = stDate;
    }

    public Date getEdDate() {
        return edDate;
    }

    public void setEdDate(Date edDate) {
        this.edDate = edDate;
    }


}
