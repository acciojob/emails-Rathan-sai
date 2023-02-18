package com.driver;

import org.apache.commons.lang3.tuple.Pair;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Workspace extends Gmail {

    private ArrayList<Meeting> calendar = new ArrayList<>(); // Stores all the meetings

    public Workspace(String emailId) {
        super(emailId, Integer.MAX_VALUE);
        // The inboxCapacity is equal to the maximum value an integer can store.
    }

    public void addMeeting(Meeting meeting) {
        //add the meeting to calendar
        calendar.add(meeting);
    }

    public int findMaxMeetings() {
        // find the maximum number of meetings you can attend
        // 1. At a particular time, you can be present in at most one meeting
        // 2. If you want to attend a meeting, you must join it at its start time and leave at end time.
        // Example: If a meeting ends at 10:00 am, you cannot attend another meeting starting at 10:00 am
//        ArrayList<meeting> meet = new ArrayList<>();
//        for (int i = 0; i < calendar.size(); i++)
//            meet.add(new meeting(calendar.get(i).getStartTime(), calendar.get(i).getEndTime(), i));
//
//        // Function call
//        return maxMeeting(meet, meet.size());
        ArrayList<Pair<LocalTime, Integer>> endTimes = new ArrayList<>();

        for (int i = 0; i < this.calendar.size(); ++i) {
            endTimes.add(Pair.of(((Meeting) this.calendar.get(i)).getEndTime(), i));
        }

        Collections.sort(endTimes);
        LocalTime time_limit = (LocalTime) ((Pair<?, ?>) endTimes.get(0)).getLeft();
        int cnt = 0;
        if (!endTimes.isEmpty()) {
            ++cnt;
        }

        for (int i = 1; i < endTimes.size(); ++i) {
            if (((Meeting) this.calendar.get((Integer) ((Pair<?, ?>) endTimes.get(i)).getRight())).getStartTime().isAfter(time_limit)) {
                ++cnt;
                time_limit = (LocalTime) ((Pair<?, ?>) endTimes.get(i)).getLeft();
            }
        }

        return cnt;
    }
}
//    public static int maxMeeting(ArrayList<meeting> al, int s)
//    {
//        ArrayList<Integer> m = new ArrayList<>();
//        LocalTime time_limit = LocalTime.ofSecondOfDay(0);
//        mycomparator mc = new mycomparator();
//        Collections.sort(al, mc);
//        m.add(al.get(0).pos);
//        time_limit = al.get(0).end;
//        for (int i = 1; i < al.size(); i++) {
//            if (al.get(i).start.isAfter(time_limit)) {
//                m.add(al.get(i).pos);
//                time_limit = al.get(i).end;
//            }
//        }
//        return m.size();
//    }
//}
//
//class mycomparator implements Comparator<meeting> {
//    public int compare(meeting o1, meeting o2)
//    {
//        if (o1.end.isBefore(o2.end)) {
//            return -1;
//        }
//        else if (o1.end.isAfter(o2.end))
//            return 1;
//        return 0;
//    }
//}
//class meeting {
//    LocalTime start;
//    LocalTime end;
//    int pos;
//    meeting(LocalTime start, LocalTime end, int pos)
//    {
//        this.start = start;
//        this.end = end;
//        this.pos = pos;
//    }
//}
