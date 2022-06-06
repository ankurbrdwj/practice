package com.ankur.interview.algoexpert.arrays;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.ankur.interview.algoexpert.arrays.CalendarMatching.StringMeeting;

public class TestCalendarMatching {

    @Test
    public void testCalendarSharing() {
        CalendarMatching cs = new CalendarMatching();
        List<StringMeeting> sMeeting = new ArrayList<>();
        sMeeting.add(new StringMeeting("9:00", "10:30"));
        sMeeting.add(new StringMeeting("12:00", "13:00"));
        sMeeting.add(new StringMeeting("16:00", "18:00"));
        List<StringMeeting> sMeeting2 = new ArrayList<>();
        sMeeting2.add(new StringMeeting("10:00", "11:30"));
        sMeeting2.add(new StringMeeting("12:30", "14:30"));
        sMeeting2.add(new StringMeeting("14:30", "15:00"));
        sMeeting2.add(new StringMeeting("16:00", "17:00"));
        StringMeeting dailyBounds1 = (new StringMeeting("9:00", "20:00"));
        StringMeeting dailyBounds2 = (new StringMeeting("10:00", "18:30"));
        int meetingDuration = 30;
        List<StringMeeting> result = cs.calendarMatching(sMeeting, dailyBounds1, sMeeting2, dailyBounds2, meetingDuration);
        for (StringMeeting item : result) {
            System.out.println(item.start + "   " + item.end);
        }
    }
}
