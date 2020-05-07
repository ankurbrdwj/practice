package com.ankur.interview.algoexpert;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestCalendarSharing {

    @Test
    public void testCalendarSharing() {
        CalendarSharing cs = new CalendarSharing();
        List<StringMeeting> sMeeting = new ArrayList<>();
        sMeeting.add(new StringMeeting("9:00", "10:30"));
        sMeeting.add(new StringMeeting("12:00", "13:00"));
        sMeeting.add(new StringMeeting("16:00", "18:00"));
        List<StringMeeting> sMeeting2 = new ArrayList<>();
        sMeeting2.add(new StringMeeting("10:00", "11:30"));
        sMeeting2.add(new StringMeeting("12:30", "14:30"));
        sMeeting2.add(new StringMeeting("14:30", "15:00"));
        sMeeting2.add(new StringMeeting("16:00", "17:00"));
        StringMeeting dailyBounds1=(new StringMeeting("9:00", "20:00"));
        StringMeeting dailyBounds2=(new StringMeeting("10:00", "18:30"));
        int meetingDuration = 30;
        List<StringMeeting> result=CalendarSharing.calendarMatching(sMeeting,dailyBounds1,sMeeting2,dailyBounds2,meetingDuration);
        for (StringMeeting item:result ) {
            System.out.println(item.start+"   "+item.end);
        }
    }
}
