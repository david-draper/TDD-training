package com.valtech.refactoring.preserveWholeObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class TimeTable {
	private List<Schedule> _schedules;
	
    public TimeTable(Schedule schedule1, Schedule schedule2)
    {
        _schedules = new ArrayList<Schedule>();
        _schedules.add(schedule1);
        _schedules.add(schedule2);
    }

    public List<String> createTimeTable()
    {
        List<String> timetable = new ArrayList<String>();

        Iterator<Schedule> iter = _schedules.iterator();
        while(iter.hasNext())
        {
        	Schedule schedule = iter.next();
            timetable.add(formatLine(schedule.getStart(), schedule.getEnd(), schedule.getTitle()));
        }

        return timetable;
    }

    private String formatLine(String start, String end, String title)
    {
        return title + ": " + start + " - " + end;
    }
}
