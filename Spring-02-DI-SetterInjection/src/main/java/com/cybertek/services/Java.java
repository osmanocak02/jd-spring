package com.cybertek.services;

import com.cybertek.interfaces.Course;
import com.cybertek.interfaces.ExtraSessions;
import lombok.Data;

@Data
public class Java implements Course {

    private ExtraSessions extraSessions;
/*
    public ExtraSessions getExtraSessions() {
        return extraSessions;
    }

    public void setExtraSessions(ExtraSessions extraSessions) {
        this.extraSessions = extraSessions;
    }*/


    public void getTeachingHours() {
        System.out.println("Weekly Teaching Hours " + (20 + extraSessions.getHours()));
    }
}
