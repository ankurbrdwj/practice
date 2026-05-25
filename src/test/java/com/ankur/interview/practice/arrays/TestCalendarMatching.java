package com.ankur.interview.practice.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TestCalendarMatching {
    public boolean arraysEqual(
            List<CalendarMatching.StringMeeting> arr1, List<CalendarMatching.StringMeeting> arr2
    ) {
        if (arr1.size() != arr2.size()) return false;

        for (int i = 0; i < arr1.size(); i++) {
            if (!arr1.get(i).start.equals(arr2.get(i).start)
                    || !arr1.get(i).end.equals(arr2.get(i).end)) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void TestCase1() {
        List<CalendarMatching.StringMeeting> calendar1 =
                new ArrayList<CalendarMatching.StringMeeting>();
        calendar1.add(new CalendarMatching.StringMeeting("9:00", "10:30"));
        calendar1.add(new CalendarMatching.StringMeeting("12:00", "13:00"));
        calendar1.add(new CalendarMatching.StringMeeting("16:00", "18:00"));

        CalendarMatching.StringMeeting dailyBounds1 =
                new CalendarMatching.StringMeeting("9:00", "20:00");

        List<CalendarMatching.StringMeeting> calendar2 =
                new ArrayList<CalendarMatching.StringMeeting>();
        calendar2.add(new CalendarMatching.StringMeeting("10:00", "11:30"));
        calendar2.add(new CalendarMatching.StringMeeting("12:30", "14:30"));
        calendar2.add(new CalendarMatching.StringMeeting("14:30", "15:00"));
        calendar2.add(new CalendarMatching.StringMeeting("16:00", "17:00"));

        CalendarMatching.StringMeeting dailyBounds2 =
                new CalendarMatching.StringMeeting("10:00", "18:30");

        int meetingDuration = 30;

        List<CalendarMatching.StringMeeting> expected =
                new ArrayList<CalendarMatching.StringMeeting>();
        expected.add(new CalendarMatching.StringMeeting("11:30", "12:00"));
        expected.add(new CalendarMatching.StringMeeting("15:00", "16:00"));
        expected.add(new CalendarMatching.StringMeeting("18:00", "18:30"));

        List<CalendarMatching.StringMeeting> actual = CalendarMatching.calendarMatching(
                calendar1, dailyBounds1, calendar2, dailyBounds2, meetingDuration
        );
        Assertions.assertTrue(arraysEqual(expected, actual));
    }
}
