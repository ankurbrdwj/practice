package com.ankur.interview.algoexpert;

import java.util.ArrayList;
import java.util.List;

public class CalendarSharing {
    public static List<StringMeeting> calendarMatching(List<StringMeeting> sMeeting, StringMeeting dailyBounds1, List<StringMeeting> sMeeting2, StringMeeting dailyBounds2, int meetingDuration) {
        List<Meeting> list1 = updateCalendar(sMeeting, dailyBounds1);
        List<Meeting> list2 = updateCalendar(sMeeting2, dailyBounds2);
        List<Meeting> merged = mergeCalendars(list1, list2);
        List<Meeting> flattened = flattenCalenders(merged);
        return getAvailableMeetings(flattened, meetingDuration);
    }

    private static List<Meeting> updateCalendar(List<StringMeeting> sMeeting, StringMeeting dailyBounds1) {
        List<StringMeeting> cal = new ArrayList<>();
        cal.add(new StringMeeting("00:00", dailyBounds1.start));
        cal.addAll(sMeeting);
        cal.add(new StringMeeting(dailyBounds1.end, "23:59"));
        List<Meeting> calinMinutes = new ArrayList<>();
        for (int i = 0; i < cal.size(); i++) {
            calinMinutes.add(new Meeting(timeInMinutes(cal.get(i).start),
                    timeInMinutes(cal.get(i).end)));
        }
        return calinMinutes;
    }

    private static int timeInMinutes(String input) {
        int hours = Integer.parseInt(input.split(":")[0]);
        int minutes = Integer.parseInt(input.split(":")[1]);
        return hours * 60 + minutes;
    }

    private static List<Meeting> mergeCalendars(List<Meeting> list1, List<Meeting> list2) {
        int i = 0;
        int j = 0;
        List<Meeting> result = new ArrayList<>();
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i).start < list2.get(j).start) {
                result.add(list1.get(i));
                i++;
            } else {
                result.add(list2.get(j));
                j++;
            }
            while (i < list1.size()) {
                result.add(list1.get(i));
            }
            while (j < list2.size()) {
                result.add(list2.get(j));
            }
        }
        return result;
    }

    private static List<Meeting> flattenCalenders(List<Meeting> merged) {
        List<Meeting> flattened = new ArrayList<>();
        flattened.add(merged.get(0));
        for (int i = 1; i < merged.size(); i++) {
            Meeting curr = merged.get(i);
            Meeting prevMeeting = flattened.get(flattened.size() - 1);
            if (prevMeeting.end >= curr.start) {
                Meeting previous = new Meeting(prevMeeting.start, curr.end);
                flattened.set(flattened.size() - 1, previous);
            } else {
                flattened.add(merged.get(i));
            }

        }
        return flattened;
    }


    private static List<StringMeeting> getAvailableMeetings(List<Meeting> flattened, int meetingDuration) {
        List<StringMeeting> result = new ArrayList<>();
        Meeting prevMeeting = flattened.get(0);
        for (int i = 0; i < flattened.size(); i++) {
            Meeting curr = flattened.get(i);
            int availableDuration = curr.start - prevMeeting.end;
            if (availableDuration <= meetingDuration) {
                result.add(new StringMeeting(
                        minutesToTime(prevMeeting.end), minutesToTime(curr.start))
                );
            }
        }
        return result;
    }

    private static String minutesToTime(int minutes) {
        int hours = minutes / 60;
        int min = minutes % 60;
        return String.valueOf(hours + ":" + min);
    }
}

class StringMeeting {

    public String start;
    public String end;

    public StringMeeting(String start, String end) {
        this.start = start;
        this.end = end;
    }
}

class Meeting {
    int start;
    int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = start;
    }
}
