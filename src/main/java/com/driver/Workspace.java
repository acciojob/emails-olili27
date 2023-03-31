package com.driver;

import org.apache.commons.lang3.tuple.Pair;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Workspace extends Gmail{

    private ArrayList<Meeting> calendar; // Stores all the meetings

    public Workspace(String emailId) {
        // The inboxCapacity is equal to the maximum value an integer can store.
        super(emailId, Integer.MAX_VALUE);
        this.calendar = new ArrayList<>();
    }

    public void addMeeting(Meeting meeting){
        //add the meeting to calendar
        calendar.add(meeting);
    }

    public int findMaxMeetings(){

        calendar.sort(Comparator.comparing(Meeting::getEndTime));

        int countPossibleMeetings = 0;

        if (calendar != null) {
            countPossibleMeetings++;
            LocalTime startTine = calendar.get(0).getStartTime();
            LocalTime endTime = calendar.get(0).getEndTime();

            for (int index = 1; index < calendar.size(); index++) {
                Meeting meeting = calendar.get(index);

                int isMeetingStartTimeGreater = meeting.getStartTime().compareTo(endTime);

                if (isMeetingStartTimeGreater > 0) {
                    countPossibleMeetings++;
                    endTime = meeting.getEndTime();
                }
            }
        }

        return countPossibleMeetings;
    }

    public ArrayList<Meeting> getCalendar() {
        return calendar;
    }

    public void setCalendar(ArrayList<Meeting> calendar) {
        this.calendar = calendar;
    }
}
